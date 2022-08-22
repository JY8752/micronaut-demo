package micronaut.data.demo.application

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import micronaut.data.demo.domain.UserService
import javax.ws.rs.Consumes
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Controller("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class UserController(
    private val userService: UserService
) {
    @Get("/{id}")
    fun find(@PathVariable id: Long): Response {
        val user = this.userService.find(id)
        return Response.ok(user).build()
    }

    @Post
    fun create(@Body request: CreateUserRequest): Response {
        val user = this.userService.create(request.name)
        return Response.ok(user).build()
    }
}

@Introspected
data class CreateUserRequest(val name: String)