package com.eks.kotlineks.constant

enum class StatusType(val value: String) {
    All("TODS"),
    ACTIVE("AT"),
    APPROVED("A"),
    CANCELED("C"),
    EXPIRED("E"),
    PENDING("PA"),
    REPROVED("R");
}