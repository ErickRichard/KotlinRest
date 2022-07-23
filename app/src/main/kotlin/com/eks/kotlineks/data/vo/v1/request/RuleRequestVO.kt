package com.eks.kotlineks.data.vo.v1.request


import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.math.BigDecimal

@JsonPropertyOrder(
    "ruleId",
    "name",
    "cpp",
    "categoryId",
)
data class RuleRequestVO(
    @Mapping("ruleId")
    @field:JsonProperty("ruleId")
    var key: Long = 0,
    var name: String? = null,
    var cpp: BigDecimal = BigDecimal.ZERO,
    var categoryId: String = "",
) : RepresentationModel<RuleRequestVO>()