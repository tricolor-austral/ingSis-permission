package ingsis.tricolor.permission.error

import org.springframework.http.HttpStatus

class UnauthorizedDeleteException : PermissionExceptions(message = "User cannot delete this resource", HttpStatus.UNAUTHORIZED)
