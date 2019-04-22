package com.youngtard.yatl.addedittask

interface AddTaskContract {

    interface View {
        // TODO Since we are saving locally or could any error occur?
        fun showTaskSaved()
    }

    interface UserActionsListener {
        fun saveTask()
    }
}