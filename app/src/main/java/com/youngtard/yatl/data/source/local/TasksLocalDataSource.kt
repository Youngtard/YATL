package com.youngtard.yatl.data.source.local

import androidx.annotation.VisibleForTesting
import com.youngtard.yatl.Utils.AppExecutors
import com.youngtard.yatl.data.Task
import com.youngtard.yatl.data.source.TasksDataSource

class TasksLocalDataSource private constructor(val appExecutors: AppExecutors, val tasksDao: TasksDao): TasksDataSource {
    override fun getAllTasks() {

    }

    override fun getTask(taskId: Int) {
    }

    override fun addTask(task: Task) {
//        tasksDao.addTask(task)
        appExecutors.diskIO.execute {
            tasksDao.addTask(task)
        }
    }

    override fun deleteTask(taskId: Int) {
    }

    companion object {
        private var INSTANCE: TasksLocalDataSource? = null

        @JvmStatic
        fun getInstance(appExecutors: AppExecutors, tasksDao: TasksDao): TasksLocalDataSource {
            if(INSTANCE == null) {
                synchronized(TasksLocalDataSource::javaClass) {
                    INSTANCE = TasksLocalDataSource(appExecutors, tasksDao)
                }
            }
            return INSTANCE!!
        }

        @VisibleForTesting
        fun clearInstance() {
            INSTANCE = null
        }

    }
}