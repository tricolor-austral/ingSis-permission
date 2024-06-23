package ingsis.tricolor.permission.dto.resource

import ingsis.tricolor.permission.entity.Permission

class ResourceUserPermission(
    val resourceId: String,
    val permissions: Set<Permission>,
)
