package ingsis.tricolor.permission.dto.resource

import ingsis.tricolor.permission.entity.Permission

class ShareResource(
    val selfId: String,
    val otherId: String,
    val resourceId: String,
    val permissions: MutableList<Permission>,
)
