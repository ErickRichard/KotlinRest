package com.eks.kotlineks.repository

import com.eks.kotlineks.model.Rule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface RuleRepository : JpaRepository<Rule, Long?> {

    @Query("SELECT r FROM Rule r WHERE 1=1")
    fun findAllRules(): List<Rule>

    @Query("SELECT r FROM Rule r INNER JOIN r.statusRule sr WHERE sr.statusId = 'CF'")
    fun findStatusByType(erick: Long): List<Rule>

    @Query("SELECT r FROM Rule r WHERE r.statusRule.statusId = 'A'")
    fun findAllRuleActive(): List<Optional<Rule>>
}


