package com.eks.kotlineks.repository

import com.eks.kotlineks.model.StatusRule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StatusRepository : JpaRepository<StatusRule, String?> {

    @Query("SELECT s FROM StatusRule s WHERE s.statusId =:status")
    fun findStatusByName(@Param("status") status: String): Optional<StatusRule>

}