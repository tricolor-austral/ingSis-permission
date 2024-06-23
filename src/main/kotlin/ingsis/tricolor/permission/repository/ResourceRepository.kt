package ingsis.tricolor.permission.repository

import ingsis.tricolor.permission.entity.Resources
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ResourceRepository : JpaRepository<Resources, String> {
    fun findAllByUsersId(userId: String): List<Resources>

    fun findByOutsideResourceIdAndUsersId(
        outsideResourceId: String,
        userId: String,
    ): Optional<Resources>

    fun findByOutsideResourceId(outsideResourceId: String): Optional<Resources>
}
