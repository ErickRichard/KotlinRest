package com.eks.kotlineks.services

import com.eks.kotlineks.constant.StatusType
import com.eks.kotlineks.data.vo.v1.request.RuleRequestVO
import com.eks.kotlineks.data.vo.v1.response.RuleResponseVO
import com.eks.kotlineks.data.vo.v1.response.RuleVO
import com.eks.kotlineks.exceptions.ResourceNotFoundException
import com.eks.kotlineks.hateoas.RuleHateoasLink
import com.eks.kotlineks.mapper.DozerMapper
import com.eks.kotlineks.model.Rule
import com.eks.kotlineks.model.StatusRule
import com.eks.kotlineks.repository.CategoryRepository
import com.eks.kotlineks.repository.RuleRepository
import com.eks.kotlineks.repository.StatusRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger


@Service
class RuleService : RuleHateoasLink() {

    @Autowired
    private lateinit var ruleRepository: RuleRepository

    @Autowired
    private lateinit var statusRepository: StatusRepository

    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    private val logger = Logger.getLogger(RuleService::class.java.name)

    fun findAllRuleResponse(): RuleVO {
        val rules = ruleRepository.findAll()
        val listRules = rules.map { rul -> DozerMapper.parseObject(rul, RuleResponseVO::class.java) }
        val rulesResponse = RuleVO(
            pendingRule = listRules.any { st -> (st.statusRule?.name == StatusType.PENDING.value) },
            ruleResponse = listRules as MutableList<RuleResponseVO>,
        )
        val pendingStatus = statusChange(StatusType.PENDING.value)
        createListLinkRulesToPending(rulesResponse, pendingStatus)
        return rulesResponse
    }

    fun findAllRuleByStatusResponse(status: String): List<RuleResponseVO> {
        val rules = ruleRepository.findAll()
        val listRules = rules.map { rul -> DozerMapper.parseObject(rul, RuleResponseVO::class.java) }
        val rulesResponse = RuleVO(
            pendingRule = listRules.any { st -> (st.statusRule?.name == StatusType.PENDING.value) },
            ruleResponse = listRules as MutableList<RuleResponseVO>,
        )
        val pendingStatus = statusChange(StatusType.PENDING.value)
        createListLinkRulesToPending(rulesResponse, pendingStatus)
        return rulesResponse.ruleResponse
    }

    fun createNewRule(rule: RuleRequestVO): RuleRequestVO {
        val rules = ruleRepository.findAllRuleActive()
        val expired = statusChange(StatusType.EXPIRED.value)
        if (rules.isNotEmpty()) {
            rules.forEach { rul ->
                rul.get().endDate = Date();
                rul.get().statusRule = expired
                ruleRepository.save(rul.get())
            }
        }
        val entityRule: Rule = DozerMapper.parseObject(rule, Rule::class.java)
        entityRule.dataCreation = Date()
        entityRule.statusRule = statusChange(StatusType.PENDING.value)
        entityRule.categoryRule = categoryRepository.findCategory(rule.categoryId).get();
        entityRule.createBy = userAuthorization()
        val ruleCreated: RuleRequestVO =
            DozerMapper.parseObject(ruleRepository.save(entityRule), RuleRequestVO::class.java)
        ruleCreated.categoryId = entityRule.categoryRule.categoryId
        ruleCreated.add(createLinkRequest(ruleCreated))
        return ruleCreated
    }

    fun updateStatus(id: Long, status: String) {
        val entityRule = ruleRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Não foram encontrados registros para esse ID!") }
        val newStatus = statusRepository.findStatusByName(status).get();
        entityRule.approvedBy = userAuthorization()
        entityRule.approvalDate = Date()
        if (status == StatusType.APPROVED.value) {
            entityRule.statusRule = newStatus
            entityRule.initialDate = Date()
        } else if (status == StatusType.REPROVED.value) {
            entityRule.statusRule = newStatus
        }
        val ruleUpdated: RuleRequestVO =
            DozerMapper.parseObject(ruleRepository.save(entityRule), RuleRequestVO::class.java)
        ruleUpdated.add(createLinkRequest(ruleUpdated))
    }

    private fun userAuthorization(): String {
        val userDetails = SecurityContextHolder.getContext().authentication.principal as UserDetails
        return userDetails.username
    }

    fun deleteRule(id: Long) {
        val entityRule = ruleRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Não foram encontrados registros para esse ID!") }
        ruleRepository.delete(entityRule)
    }

    fun statusChange(situation: String): StatusRule {
        return statusRepository.findStatusByName(situation).get()
    }
}