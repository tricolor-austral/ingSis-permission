package ingsis.tricolor.permission.controller

import ingsis.tricolor.permission.entity.User
import ingsis.tricolor.permission.service.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller()
@RequestMapping("/user")
class UserController(
    @Autowired
    private val service: UserService,
) {
    @PostMapping("/create")
    fun createUser(
        @RequestParam id: String,
    ): ResponseEntity<User> {
        return ResponseEntity(service.findOrCreate(id), HttpStatus.CREATED)
    }
}
