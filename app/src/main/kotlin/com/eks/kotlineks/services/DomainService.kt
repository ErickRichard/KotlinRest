package com.eks.kotlineks.services

import com.eks.kotlineks.data.vo.v1.response.CategoryRuleResponseVO
import com.eks.kotlineks.mapper.DozerMapper
import com.eks.kotlineks.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class DomainService {

    @Autowired
    private lateinit var repository: CategoryRepository

    @Autowired
    lateinit var authService: AuthService

    private val logger = Logger.getLogger(DomainService::class.java.name)

    fun findAllCategory(): List<CategoryRuleResponseVO> {
        val category = repository.findAll()
        return category.map { cat -> DozerMapper.parseObject(cat, CategoryRuleResponseVO::class.java) }
    }
}