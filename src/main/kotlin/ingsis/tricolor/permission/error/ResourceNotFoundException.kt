package ingsis.tricolor.permission.error

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class ResourceNotFoundException(message: String) : PermissionExceptions(message, HttpStatus.BAD_REQUEST)
