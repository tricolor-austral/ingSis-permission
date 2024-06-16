package ingsis.tricolor.permission.error

import org.springframework.http.HttpStatus

class UnauthorizedShareException(message: String) : PermissionExceptions(message, HttpStatus.BAD_REQUEST)
