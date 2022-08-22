package micronaut.data.demo.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
internal class UserServiceTest(
    private val userService: UserService
) : StringSpec({
    "test" {
        val saved = userService.create("test")
        val user = userService.find(saved.id)

        user shouldBe saved
    }
})