package ingsis.tricolor.permission.service.interfaces

import ingsis.tricolor.permission.entity.User

interface UserService {
    fun findOrCreate(id: String): User
}
