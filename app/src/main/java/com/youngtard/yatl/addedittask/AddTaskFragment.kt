package com.youngtard.yatl.addedittask


import android.os.Bundle
//import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import com.youngtard.yatl.R
import com.youngtard.yatl.data.source.TasksRepository
import com.youngtard.yatl.data.source.local.TasksLocalDataSource
import kotlinx.android.synthetic.main.fragment_add_task.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
// TODO FILE VS CLASS. FRAGMENT IS A .KT FILE NOT CLASS??
class AddTaskFragment : Fragment(), AddTaskContract.View {
    lateinit var userActions: AddTaskContract.UserActionsListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userActions = AddTaskPresenter(this, TasksRepository.getInstance(TasksLocalDataSource.getInstance()))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onStart() {
        super.onStart()

        fab_save_task.setOnClickListener {
            userActions.saveTask()
        }
    }


    override fun showTaskSaved() {

    }
}
