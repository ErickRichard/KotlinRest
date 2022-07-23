package com.eks.kotlineks.constant

enum class UserPermissionType(val value: String) {
    ADMIN("ADMIN"),
    MANAGER("MANAGER"),
    COMMON_USER("COMMON_USER"),
    APPROVER("APPROVER"),
    RECORDER("RECORDER")
}