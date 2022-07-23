package com.eks.kotlineks.data.vo.v1.response

import com.fasterxml.jackson.annotation.JsonPropertyOrder

@JsonPropertyOrder(
    "statusId",
    "name"
)
data class StatusRuleResponseVO(
    var statusId: String = "",
    var name: String = ""
)