package com.example.todoproject.task



import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {

    private val _tasks = MutableStateFlow(
        listOf(
            Task(1, "Buy groceries", false),
            Task(2, "Finish the project", true),
            Task(3, "Call mom", false)
        )
    )
    val tasks: StateFlow<List<Task>> = _tasks

    fun toggleTaskCompletion(taskId: Int) {
        _tasks.value = _tasks.value.map { task ->
            if (task.id == taskId) task.copy(isCompleted = !task.isCompleted) else task
        }
    }

    fun addTask(title: String) {
        val newTask = Task(
            id = (_tasks.value.maxOfOrNull { it.id } ?: 0) + 1,
            title = title,
            isCompleted = false
        )
        _tasks.value = _tasks.value + newTask
    }

    fun deleteTask(taskId: Int) {
        _tasks.value = _tasks.value.filterNot { it.id == taskId }
    }
}
