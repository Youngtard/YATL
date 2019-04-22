package com.youngtard.yatl.data.source.local

import androidx.room.*
import com.youngtard.yatl.data.Task

@Dao
interface TasksDao {

    @Insert
    fun addTask(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTasks(): List<Task>

//    fun getTask()
//
//    @Query("SELECT * FROM tasks WHERE task_id = :taskId")
//    fun getTaskById(taskId: Int): Task

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTaskById(taskId: Int)

//    @Query
//    fun deleteCompletedTasks(): Int

    @Query("DELETE FROM tasks")
    fun deleteAllTasks(): Int




}