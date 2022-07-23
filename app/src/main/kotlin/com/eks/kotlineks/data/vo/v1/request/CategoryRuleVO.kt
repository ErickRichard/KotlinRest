package com.eks.kotlineks.data.vo.v1.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping

@JsonPropertyOrder(
    "categoryId",
    "name",
    "description"
)
data class CategoryRuleVO(
    @Mapping("categoryId")
    @field:JsonProperty("categoryId")
    var key: Long = 0,
    var name: String = "",
    var description: String = ""
)