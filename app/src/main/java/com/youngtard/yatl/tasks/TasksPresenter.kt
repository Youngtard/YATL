package com.youngtard.yatl.tasks

class TasksPresenter(private val tasksView: TasksContract.View): TasksContract.UserActionsListener {

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