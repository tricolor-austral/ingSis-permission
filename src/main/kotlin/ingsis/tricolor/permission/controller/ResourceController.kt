package ingsis.tricolor.permission.controller

import ingsis.tricolor.permission.dto.resource.AddResource
import ingsis.tricolor.permission.entity.Resources
import ingsis.tricolor.permission.service.interfaces.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

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
}
