package com.eks.kotlineks.data.vo.v1.response

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.math.BigDecimal

@JsonPropertyOrder(
    "ruleId",
    "name",
    "createBy",
    "segment",
    "dataCreation",
    "cpp",
    "approvedBy",
    "approvalDate",
    "initialDate",
    "endDate",
    "categoryRule",
    "statusRule"
)
class RuleResponseVO(
    @Mapping("ruleId")
    @field:JsonProperty("ruleId")
    var key: Long = 0,
    var name: String = "",
    var createBy: String = "",
    var dataCreation: String = "",
    var cpp: BigDecimal = BigDecimal.ZERO,
    var approvedBy: String? = null,
    var approvalDate: String? = null,
    var initialDate: String? = null,
    var endDate: String? = null,
    var statusRule: StatusRuleResponseVO? = null,
    var categoryRule: CategoryRuleResponseVO? = null
) : RepresentationModel<RuleResponseVO>()