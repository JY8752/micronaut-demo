package micronaut.data.demo.application

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.kotest.annotation.MicronautTest

@MicronautTest
internal class UserControllerTest(
    @Client("/") private val client: HttpClient
) : StringSpec({
    "test" {
        val request: HttpRequest<Any> = HttpRequest.GET("/user/1")
        val response = client.toBlocking().retrieve(request)

        response shouldBe """{"id":1,"name":"user"}"""
    }
})