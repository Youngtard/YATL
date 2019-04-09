package com.youngtard.yatl.tasks


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast

import com.youngtard.yatl.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class TasksFragment : Fragment(), TasksContract.View {


//    Swipe to delete task
//    Design landscape
//    See how options menu would be altered or not by activty or fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tasks, container, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.app_menu_fragment_tasks, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.app_menu_fragment_tasks_filter -> showFilterPopUpMenu()
        }


        return super.onOptionsItemSelected(item)
    }

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



}
