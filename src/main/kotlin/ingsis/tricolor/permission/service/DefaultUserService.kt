package ingsis.tricolor.permission.service

import ingsis.tricolor.permission.entity.User
import ingsis.tricolor.permission.repository.UserRepository
import ingsis.tricolor.permission.service.interfaces.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DefaultUserService(
    @Autowired
    val repository: UserRepository,
) : UserService {
    override fun findOrCreate(id: String): User {
        println("Searching for user with id: $id")
        val user =
            repository.findById(id).orElseGet {
                println("User not found, creating new user")
                createUser(id)
            }
        println("User found or created: $user")
        return user
    }

    override fun getAll(): List<String> {
        return repository.findAll().map { it.id }
    }

    private fun createUser(id: String): User {
        println("Creating user ...")
        return repository.saveAndFlush(User(id))
    }
}
