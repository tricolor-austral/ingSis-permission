package ingsis.tricolor.permission.controller

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.dto.resource.ResourceUserPermission
import ingsis.tricolor.permission.entity.Resources
import ingsis.tricolor.permission.service.interfaces.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller()
@RequestMapping("/resource")
class ResourceController(
    @Autowired
    private val service: ResourceService,
) {
    @PostMapping("/create-resource")
    fun addResource(
        @RequestBody addResource: AddResource,
    ): ResponseEntity<Resources> {
        return ResponseEntity(service.addResource(addResource), HttpStatus.CREATED)
    }

    @GetMapping("/by-userId")
    fun getPermissionsForUser(
        @RequestParam id: String,
    ): ResponseEntity<List<ResourceUserPermission>> {
        return ResponseEntity(service.findUserSnippets(id), HttpStatus.OK)
    }
}
