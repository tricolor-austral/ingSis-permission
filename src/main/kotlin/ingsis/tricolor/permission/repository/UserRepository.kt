package ingsis.tricolor.permission.repository

import ingsis.tricolor.permission.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
}
