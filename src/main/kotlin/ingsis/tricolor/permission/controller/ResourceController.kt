package ingsis.tricolor.permission.controller

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.dto.resource.ResourceUser
import ingsis.tricolor.permission.dto.resource.ResourceUserPermission
import ingsis.tricolor.permission.dto.resource.ShareResource
import ingsis.tricolor.permission.error.PermissionExceptions
import ingsis.tricolor.permission.service.interfaces.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.context.request.WebRequest

@Controller()
@RequestMapping("/resource")
class ResourceController(
    @Autowired
    private val service: ResourceService,
) {
    @ExceptionHandler(PermissionExceptions::class)
    fun handleExceptions(
        ex: PermissionExceptions,
        request: WebRequest,
    ): ResponseEntity<String> {
        return ResponseEntity(ex.message, ex.status)
    }

    @PostMapping("/create-resource")
    fun addResource(
        @RequestBody addResource: AddResource,
    ): ResponseEntity<ResourceUserPermission> {
        return ResponseEntity(service.addResource(addResource), HttpStatus.CREATED)
    }

    @GetMapping("/all-by-userId")
    fun getPermissionsForUser(
        @RequestParam id: String,
    ): ResponseEntity<List<ResourceUserPermission>> {
        return ResponseEntity(service.findUserResources(id), HttpStatus.OK)
    }

    @GetMapping("/user-resource")
    fun getSpecificPermission(
        @RequestBody ids: ResourceUser,
    ): ResponseEntity<ResourceUserPermission> {
        return ResponseEntity(service.findByUsersIdAndResourceId(ids.userId, ids.resourceId), HttpStatus.OK)
    }

    @PostMapping("/share-resource")
    fun shareResource(
        @RequestBody params: ShareResource,
    ): ResponseEntity<ResourceUserPermission> {
        val resource = service.shareResource(params.selfId, params.otherId, params.resourceId, params.permissions)
        return ResponseEntity(resource, HttpStatus.CREATED)
    }

    @GetMapping("/can-write")
    fun checkCanWrite(
        @RequestBody params: ResourceUser,
    ): ResponseEntity<Boolean> {
        val response = service.checkCanWrite(params.resourceId, params.userId)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @GetMapping("/all-write-by-userId")
    fun getAllWriteableResourcesById(
        @RequestParam id: String,
    ): ResponseEntity<List<ResourceUserPermission>> {
        val response = service.getAllWriteableResources(id)
        return ResponseEntity(response, HttpStatus.OK)
    }
}
