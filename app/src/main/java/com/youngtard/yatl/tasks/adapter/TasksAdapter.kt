package com.youngtard.yatl.tasks.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.youngtard.yatl.R
import com.youngtard.yatl.data.Task
import kotlinx.android.synthetic.main.task_list_item.view.*

class TasksAdapter(tasksData: List<Task>): RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val vh = LayoutInflater.from(parent.context).inflate(R.layout.task_list_item, parent, false)

        return TasksViewHolder(vh)
    }

    override fun getItemCount() = tasksData.size


    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.bind(tasksData[position])
    }


    class TasksViewHolder(var listItem: View): RecyclerView.ViewHolder(listItem) {

        fun bind(task: Task) {
            listItem.tv_task_title.text = task.taskTitle
        }

    }

    var tasksData: List<Task> = tasksData
        set(tasks) {
            field = tasks
            notifyDataSetChanged()
        }

}