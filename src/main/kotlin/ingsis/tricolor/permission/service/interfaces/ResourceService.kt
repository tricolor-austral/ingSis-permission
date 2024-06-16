package ingsis.tricolor.permission.service.interfaces

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.entity.Resources

interface ResourceService {
    fun addResource(addResource: AddResource): Resources
}
