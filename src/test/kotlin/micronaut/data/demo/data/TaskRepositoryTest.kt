package micronaut.data.demo.data

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
internal class TaskRepositoryTest(
    private val taskRepository: TaskRepository,
    private val userRepository: UserRepository
) : StringSpec({
    "test" {
        val user = userRepository.save(UserEntity(name = "user"))
        val saved = taskRepository.save(TaskEntity(user = user, details = "details"))
        val find = taskRepository.findById(saved.id!!).orElseThrow { RuntimeException() }

        find shouldBe saved
    }
})