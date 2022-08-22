package micronaut.data.demo.data

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface TaskRepository : CrudRepository<TaskEntity, Long> {
}