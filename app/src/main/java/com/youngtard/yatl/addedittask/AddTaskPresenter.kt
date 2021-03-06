package com.youngtard.yatl.addedittask

import com.youngtard.yatl.data.Task
import com.youngtard.yatl.data.source.TasksDataSource

//TODO Implement TasksDataSource interfaces
class AddTaskPresenter(val addTaskView: AddTaskContract.View, val tasksRepository: TasksDataSource): AddTaskContract.UserActionsListener {

    override fun saveTask(task: Task) {
        tasksRepository.addTask(task)
        addTaskView.showTaskSaved()
    }

}