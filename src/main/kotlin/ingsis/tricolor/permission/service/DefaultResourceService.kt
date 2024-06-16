package ingsis.tricolor.permission.service

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.dto.resource.ResourceUserPermission
import ingsis.tricolor.permission.entity.Resources
import ingsis.tricolor.permission.repository.ResourceRepository
import ingsis.tricolor.permission.service.interfaces.ResourceService
import ingsis.tricolor.permission.service.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultResourceService(
    @Autowired
    private val repository: ResourceRepository,
    @Autowired
    private val userService: UserService,
) : ResourceService {
    override fun addResource(addResource: AddResource): Resources {
        userService.findOrCreate(addResource.userId)
        return repository.save(Resources(addResource))
    }

    override fun findUserSnippets(id: String): List<ResourceUserPermission> {
        val returnableResources = mutableListOf<ResourceUserPermission>()
        repository.findAllByUsersId(id).map {
            returnableResources.add(ResourceUserPermission(it.resourceId, it.permissions))
        }
        return returnableResources
    }
}
