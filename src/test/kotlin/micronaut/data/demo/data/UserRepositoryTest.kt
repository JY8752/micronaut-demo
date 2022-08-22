package micronaut.data.demo.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
internal class UserRepositoryTest(
    private val userRepository: UserRepository
) : StringSpec({
    "test" {
        val user = UserEntity(name = "user")
        val saved = userRepository.save(user)
        val find = userRepository.findById(saved.id!!).orElseThrow { RuntimeException() }

        find shouldBe saved
    }
})