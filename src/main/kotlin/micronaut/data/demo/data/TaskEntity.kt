package micronaut.data.demo.data

import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "task")
data class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: UserEntity = UserEntity(),

    val details: String = "",

    val createdAt: LocalDateTime = LocalDateTime.now()
)
