package com.example.uniactivos.model

data class UserLoginInput(
    var email: String,
    var password: String,
)

data class UserDetails(
    var id: Long? = null,
    var email: String? = null,
    var firstName: String? = null,
    var lastName: String? = null,
    var roleList: List<RoleDetails>? = null,
    var enabled: Boolean? = null,
    /*
    var username: String,
    var password: String,
    var authorities: List<Authority>,
    var accountNonExpired: Boolean,
    var accountNonLocked: Boolean,
    var credentialsNonExpired: Boolean,
    var enabled: Boolean,
     */

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
data class PriorityDetails(
    var id: Long? = null,
    var label: String? = null,
)

/**
 * Data validation state of the login form.
 */
data class LoginFormState(

    val emailError: Int? = null,
    val passwordError: Int? = null,
    val isDataValid: Boolean = false,
    val usernameError: Int? = null,
)

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)

/**
 * User details post authentication that is exposed to the UI
 */
data class LoggedInUserView(
    val username: String,
    //... other data fields that may be accessible to the UI
)

data class UserLoginResponse(
    var username: String,
    var password: String,
    var authorities: List<Authority>,
    var accountNonExpired: Boolean,
    var accountNonLocked: Boolean,
    var credentialsNonExpired: Boolean,
    var enabled: Boolean,
)

data class Authority(
    var authority: String,
)