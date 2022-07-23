package com.eks.kotlineks.data.vo.v1.response

data class RuleVO(
    val pendingRule: Boolean,
    val ruleResponse: MutableList<RuleResponseVO>,
)