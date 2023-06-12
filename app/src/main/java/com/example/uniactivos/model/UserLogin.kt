package com.example.uniactivos.model

data class UserLoginInput(
    var email: String = "",
    var password: String = "",
)

data class UserDetails(
    var id: Long? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var roleList: List<RoleDetails>? = null,

)

data class UserChangePasswordInput(
    var email: String = "",
    var oldPassword: String = "",
    var newPassword: String = "",
)
data class RoleDetails(
    var id: Long? = null,
    var name: String? = null,
    var privileges: List<PrivilegeDetails>? = null,
)
data class PrivilegeDetails(
    var id: Long? = null,
    var name: String? = null,
)
