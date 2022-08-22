package micronaut.data.demo.domain

import io.micronaut.core.annotation.Introspected
import jakarta.inject.Singleton
import micronaut.data.demo.data.UserEntity
import micronaut.data.demo.data.UserRepository

@Singleton
class UserService(
    private val userRepository: UserRepository
) {
    fun create(name: String): User {
        val entity = this.userRepository.save(UserEntity(name = name))
        return User(entity)
    }

    fun find(id: Long): User? {
        val entity = this.userRepository.findById(id)
        return if (entity.isPresent) {
            User(entity.get())
        } else {
            null
        }
    }
}

@Introspected
data class User(val id: Long, val name: String) {
    constructor(entity: UserEntity) : this(entity.id!!, entity.name)
}