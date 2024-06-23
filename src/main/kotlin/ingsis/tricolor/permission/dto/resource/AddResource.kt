package ingsis.tricolor.permission.dto.resource

import ingsis.tricolor.permission.entity.Permission

class AddResource(
    val userId: String,
    val resourceId: String,
    val permissions: MutableList<Permission>,
)
