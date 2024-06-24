package ingsis.tricolor.permission.error

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

open class PermissionExceptions(override val message: String, val status: HttpStatus) : RuntimeException(message)
