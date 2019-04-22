package com.youngtard.yatl.data.source

import com.youngtard.yatl.data.Task

//TODO
/**
 * Main entry point for accessing tasks data.
 *
 *
 * For simplicity, only getTasks() and getTask() have callbacks. Consider adding callbacks to other
 * methods to inform the user of network/database errors or successful operations.
 * For example, when a new task is created, it's synchronously stored in cache but usually every
 * operation on database or network should be executed in a different thread.
 */

interface TasksDataSource {

    interface GetAllTasksCallback {
        fun onTasksLoaded()
        fun onDataNotAvailable()
    }

    interface GetTaskCallback {
        fun onTaskLoaded()
        fun onDataNotAvailable()

    }

//    TODO Why no return types

//    Callback needed for purely remote database access?
//    fun getAllTasks(callback: GetAllTasksCallback): List<Task>
    fun getAllTasks()


//    fun getTask(taskId: Int, callback: GetTaskCallback)
    fun getTask(taskId: Int)


    fun addTask(task: Task)

    fun deleteTask(taskId: Int)


}