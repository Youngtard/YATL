package com.youngtard.yatl.tasks


import android.content.Intent
import android.os.Bundle
//import android.support.v4.app.Fragment
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.youngtard.yatl.R
import com.youngtard.yatl.Utils.AppExecutors
import com.youngtard.yatl.addedittask.AddTaskActivity
import com.youngtard.yatl.data.Task
import com.youngtard.yatl.data.source.TasksRepository
import com.youngtard.yatl.data.source.local.TasksLocalDataSource
import com.youngtard.yatl.data.source.local.TodoDatabase
import com.youngtard.yatl.tasks.adapter.TasksAdapter
import kotlinx.android.synthetic.main.fragment_tasks.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TasksFragment : Fragment(), TasksContract.View {

    private lateinit var userActions: TasksContract.UserActionsListener

    private lateinit var tasksRepository: TasksRepository
    private lateinit var tasksLayoutManager: RecyclerView.LayoutManager
    lateinit var tasksAdapter: TasksAdapter


//    For hard testing purposes, local database already does it
    lateinit var appExecutors: AppExecutors

//    Swipe to delete task
//    TODO Design landscape - Towards end of completing app, settings - night mode etc
//    See how options menu would be altered or not by activty or fragment
//    Snackbar
//    Add more features
//    Content provider, shared preferences
//    Add user authentication, cloud/remote storage to implement network calls or Github Profiles - do mvvm first?

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

        userActions = TasksPresenter(this)


//        TODO context!!??
//        TODo never used?
        tasksRepository = TasksRepository.getInstance(TasksLocalDataSource.getInstance(AppExecutors(), TodoDatabase.getInstance(context!!.applicationContext).tasksDao()))
        tasksLayoutManager = LinearLayoutManager(context)
        tasksAdapter = TasksAdapter(ArrayList(0))


        appExecutors = AppExecutors()


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv_tasks.apply {
            setHasFixedSize(true)

            layoutManager = tasksLayoutManager

            adapter = tasksAdapter
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {





        // Inflate the layout for this fragment
        // TODO Meaning of attachtoroot
        return inflater.inflate(R.layout.fragment_tasks, container, false)



    }

    override fun onStart() {
        super.onStart()

        fab_add_task.setOnClickListener {
//todo            presenter.addTask
            userActions.addTask()
        }



    }

    override fun onResume() {
        super.onResume()

//        TODO How does this shit workk with the code block and all. check definition
        appExecutors.diskIO.execute{        tasksAdapter.tasksData = TodoDatabase.getInstance(context!!.applicationContext).tasksDao().getAllTasks()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.app_menu_fragment_tasks, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.app_menu_fragment_tasks_filter -> userActions.onFilterOptionClicked()
        }


        return super.onOptionsItemSelected(item)
    }

    //TODO Already implemented in relevant? activity class using android framework. Actual view is fragment not activity
    override fun showNavBar() {

    }

    override fun showFilterPopUpMenu() {
        // Or use synthetic properties? antoniolevia blog
        val popUpMenu = PopupMenu(context, activity?.findViewById(R.id.app_menu_fragment_tasks_filter))
        popUpMenu.menuInflater.inflate(R.menu.filter_tasks_menu, popUpMenu.menu)

        popUpMenu.setOnMenuItemClickListener {
            when (it.itemId) {
            }
        }

        popUpMenu.show()
    }

    override fun openAddTasksFragment() {
        val intent = Intent(context, AddTaskActivity::class.java)
        startActivity(intent)

    }

    override fun loadTasks() {

    }



}
