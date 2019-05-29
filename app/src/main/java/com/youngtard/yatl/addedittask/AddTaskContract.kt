package com.youngtard.yatl.addedittask

import com.youngtard.yatl.data.Task

interface AddTaskContract {

    interface View {
        // TODO Since we are saving locally or could any error occur?
        fun showTaskSaved()
    }

    interface UserActionsListener {
        fun saveTask(task: Task)
    }
}