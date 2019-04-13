package com.youngtard.yatl.tasks

class TasksPresenter(val tasksView: TasksContract.View): TasksContract.UserActionsListener {

    override fun onNavBarClick() {
        tasksView.showNavBar()
    }

    override fun onFilterOptionClicked() {
        tasksView.showFilterPopUpMenu()
    }

    override fun addTask() {
        tasksView.openAddTasksFragment()
    }

}