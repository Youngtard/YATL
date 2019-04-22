package com.youngtard.yatl.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class Task (
        @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "task_id") val taskId: Int,
        @ColumnInfo(name = "task_title") var taskTitle: String,
        @ColumnInfo(name = "task_body") var taskBody: String,
        @ColumnInfo(name = "task_completed") val taskCompleted: Boolean,
        @ColumnInfo(name = "task_active") val taskActive: Boolean

) {
    constructor(taskTitle: String, taskBody: String): this(0, taskTitle, taskBody, false, true)
}
