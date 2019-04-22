package com.youngtard.yatl.data.source

import com.youngtard.yatl.data.Task

//TODO No need to add remoteDataSource to constructor
//LocalDataSource is only the source for now
class TasksRepository private constructor(val tasksLocalDataSource: TasksDataSource): TasksDataSource {
    override fun getAllTasks() {

    }

    override fun getTask(taskId: Int) {
    }

    override fun addTask(task: Task) {
        tasksLocalDataSource.addTask(task)
    }

    override fun deleteTask(taskId: Int) {
    }

//    TODO or use Dependency Injection to achieve Singleton
    companion object {
        private var INSTANCE: TasksRepository? = null

        @JvmStatic fun getInstance(tasksLocalDataSource: TasksDataSource): TasksRepository {
            return INSTANCE ?: TasksRepository(tasksLocalDataSource).apply {
                INSTANCE = this
            }
        }

        /**
         * Used to force [getInstance] to create a new instance
         * next time it's called.
         */

        @JvmStatic fun destroyInstance() {
            INSTANCE = null
        }
    }

}