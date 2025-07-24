package service

import com.example.testing.spock_lab.model.Task
import com.example.testing.spock_lab.repository.TaskRepository
import com.example.testing.spock_lab.service.TaskService
import spock.lang.Specification

class TaskServiceSpec extends Specification{

    def repository = Mock(TaskRepository)
    def service = new TaskService(repository)

    def "Should create a task and assign an id"() {
        given:
        def task = new Task(null, "Test title", "Test desc", "Active", "HIGH")

        // Mock the save method to return a task with an id set
        repository.save(task) >> new Task(1L, task.title, task.description, task.status, task.priority)

        when:
        def results = service.createTask(task)

        then:
        results.id != null
        results.title == "Test title"
        results.description == "Test desc"
    }
}
