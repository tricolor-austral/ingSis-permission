@file:Suppress("ktlint:standard:no-wildcard-imports")

package ingsis.tricolor.permission.entity

import ingsis.tricolor.permission.dto.resource.AddResource
import jakarta.persistence.*
import lombok.NoArgsConstructor
import lombok.Setter
import java.util.UUID

@Entity
@NoArgsConstructor
@Setter
class Resources(
    val outsideResourceId: String,
    @ManyToMany
    @JoinTable(
        name = "resource_user",
        joinColumns = [JoinColumn(name = "resource_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")],
    )
    val users: MutableList<User>,
    @Enumerated(EnumType.STRING) @ElementCollection
    val permissions: MutableSet<Permission>,
) {
    @Id
    val id: String = UUID.randomUUID().toString()

    constructor(resource: AddResource) : this(
        outsideResourceId = resource.resourceId,
        users = mutableListOf(User(resource.userId)),
        permissions = resource.permissions.toMutableSet(),
    ) {}

    constructor() : this(
        outsideResourceId = "",
        users = mutableListOf(),
        permissions = mutableSetOf(),
    ) {}
}
