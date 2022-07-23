package com.eks.kotlineks.hateoas

import com.eks.kotlineks.constant.StatusType
import com.eks.kotlineks.controller.RuleController
import com.eks.kotlineks.data.vo.v1.request.RuleRequestVO
import com.eks.kotlineks.data.vo.v1.response.RuleResponseVO
import com.eks.kotlineks.data.vo.v1.response.RuleVO
import com.eks.kotlineks.model.StatusRule
import com.eks.kotlineks.util.format.DateFormatUtil
import org.springframework.hateoas.Link
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo
import org.springframework.stereotype.Component

@Component
class RuleHateoasLink {

    fun createLinkRequest(rule: RuleRequestVO): Link {
        return linkTo(RuleController::class.java).slash(rule.key).withSelfRel()
    }

    fun createListLinkRulesToPending(listRulesResponse: RuleVO, pendingStatus: StatusRule): List<RuleResponseVO> {
        listRulesResponse.ruleResponse.filter { st -> st.statusRule?.statusId == pendingStatus.statusId }
            .map { status ->
                status.add(
                    linkTo(RuleController::class.java).slash(status.key).slash(StatusType.APPROVED.value)
                        .withRel("Approve")
                )
            }

        listRulesResponse.ruleResponse.filter { st -> st.statusRule?.statusId == pendingStatus.statusId }
            .map { status ->
                status.add(
                    linkTo(RuleController::class.java).slash(status.key).slash(StatusType.REPROVED.value)
                        .withRel("Reject")
                )
            }

        listRulesResponse.ruleResponse.forEach { rul ->
            rul.dataCreation = formatDate(rul.dataCreation);
            rul.initialDate = rul.initialDate?.let { formatDate(it) };
            rul.endDate = rul.endDate?.let { formatDate(it) };
            rul.approvalDate = rul.approvalDate?.let { formatDate(it) }
        }
        return listRulesResponse.ruleResponse
    }

    fun createListLinkRulesAllStatus(listRulesResponse: List<RuleResponseVO>, pendingStatus: StatusRule): List<RuleResponseVO> {
        listRulesResponse.filter { st -> st.statusRule?.statusId == pendingStatus.statusId }
            .map { status ->
                status.add(
                    linkTo(RuleController::class.java).slash(status.key).slash(StatusType.APPROVED.value)
                        .withRel("Approve")
                )
            }

        listRulesResponse.filter { st -> st.statusRule?.statusId == pendingStatus.statusId }
            .map { status ->
                status.add(
                    linkTo(RuleController::class.java).slash(status.key).slash(StatusType.REPROVED.value)
                        .withRel("Reject")
                )
            }

        listRulesResponse.forEach { rul ->
            rul.dataCreation = formatDate(rul.dataCreation);
            rul.initialDate = rul.initialDate?.let { formatDate(it) };
            rul.endDate = rul.endDate?.let { formatDate(it) };
            rul.approvalDate = rul.approvalDate?.let { formatDate(it) }
        }
        return listRulesResponse
    }

    fun formatDate(data: String): String {
        return DateFormatUtil.formatDateList(data)
    }

}