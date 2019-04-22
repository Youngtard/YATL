package com.youngtard.yatl.addedittask

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.youngtard.yatl.R
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        setSupportActionBar(tb_add_tasks)
        val appBar = supportActionBar
        appBar?.setDisplayHomeAsUpEnabled(true)
        appBar?.title = "Add a Task"


    }


}
