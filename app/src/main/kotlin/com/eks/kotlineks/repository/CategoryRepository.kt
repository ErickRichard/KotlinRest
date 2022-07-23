package com.eks.kotlineks.repository

import com.eks.kotlineks.model.CategoryRule
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<CategoryRule, String?>{

    @Query("SELECT c FROM CategoryRule c WHERE c.categoryId =:categoryId")
    fun findCategory(@Param("categoryId") categoryId: String): Optional<CategoryRule>
}
