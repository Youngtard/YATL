package com.youngtard.yatl.tasks

interface TasksContract {

//    Actions callbacks on view
    interface View {
        fun showNavBar()
        fun showFilterPopUpMenu()
        fun openAddTasksFragment()

    }

//    User actions
    interface UserActionsListener {
        fun onNavBarClick()
        fun onFilterOptionClicked()
        fun addTask()
    }
}