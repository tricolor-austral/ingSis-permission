package ingsis.tricolor.Permission

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class PermissionApplication {
    @GetMapping("/")
    fun noAuth(): String {
        return "No need for auth"
    }

    @GetMapping("/jwt")
    fun getAuth(
        @AuthenticationPrincipal jwt: Jwt,
    ): String {
        return jwt.tokenValue
    }

    @GetMapping("/needs-auth")
    fun needsAuth(): String {
        return "Great! you are authenticated"
    }
}

fun main(args: Array<String>) {
    runApplication<PermissionApplication>(*args)
}
