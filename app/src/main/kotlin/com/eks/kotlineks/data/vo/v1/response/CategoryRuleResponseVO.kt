package com.eks.kotlineks.data.vo.v1.response

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "categoryId",
    "name",
    "description"
)
data class CategoryRuleResponseVO(
    var categoryId: String = "",
    var name: String = ""
)