package com.youngtard.yatl.tasks

interface TasksContract {

//    Actions callbacks on view
    interface View {
        fun showNavBar()
        fun showFilterPopUpMenu()
    }

//    User actions
    interface UserActionsListener {
        fun onNavBarClick()
        fun onFilterOptionClicked()
    }
}