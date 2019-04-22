package com.youngtard.yatl.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.youngtard.yatl.data.Task

@Database(entities = [Task::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {

    abstract fun tasksDao(): TasksDao

    companion object {

        private var INSTANCE: TodoDatabase? = null

        private val lock = Any()

        fun getInstance(context: Context): TodoDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, TodoDatabase::class.java, "Todo.db").build()
                }

                return INSTANCE!!
            }
        }

    }
}