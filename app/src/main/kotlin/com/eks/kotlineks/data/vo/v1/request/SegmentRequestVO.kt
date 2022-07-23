package com.eks.kotlineks.data.vo.v1.request

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel

@JsonPropertyOrder("segmentId", "name", "active")
data class SegmentRequestVO(

    @Mapping("segmentId")
    @field:JsonProperty("segmentId")
    var key: Long = 0,
    var name: String = "",
    var active: Boolean? = null

) : RepresentationModel<SegmentRequestVO>()