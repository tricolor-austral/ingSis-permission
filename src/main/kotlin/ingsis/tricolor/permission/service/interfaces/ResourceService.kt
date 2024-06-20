package ingsis.tricolor.permission.service.interfaces

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.dto.resource.ResourceUserPermission
import ingsis.tricolor.permission.entity.Permission

interface ResourceService {
    fun addResource(addResource: AddResource): ResourceUserPermission

    fun findUserResources(id: String): List<ResourceUserPermission>

    fun findByUsersIdAndResourceId(
        userId: String,
        resourceId: String,
    ): ResourceUserPermission

    fun shareResource(
        selfId: String,
        otherId: String,
        resourceId: String,
        permissions: MutableList<Permission>,
    ): ResourceUserPermission

    fun checkCanWrite(
        resourceId: String,
        userId: String,
    ): Boolean

    fun getAllWriteableResources(userId: String): List<ResourceUserPermission>

    fun deleteResource(
        userId: String,
        resourceId: String,
    )
}
