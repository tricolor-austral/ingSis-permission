import ingsis.tricolor.permission.entity.Permission

data class ResourceUsers(
    val resourceId: String,
    val permissions: List<Permission>,
)
