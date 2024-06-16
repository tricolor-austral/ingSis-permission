package ingsis.tricolor.permission.repository

import ingsis.tricolor.permission.entity.Resources
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceRepository : JpaRepository<Resources, String> {
    fun findAllByUsersId(userId: String): List<Resources>
}
