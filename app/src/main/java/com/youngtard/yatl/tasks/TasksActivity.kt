package com.youngtard.yatl.tasks

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
//import android.support.v4.view.GravityCompat
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.youngtard.yatl.R
import kotlinx.android.synthetic.main.activity_tasks.*
import kotlinx.android.synthetic.main.fragment_tasks.*

class TasksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

//        val toolbar = tb_tasks
        setSupportActionBar(tb_tasks)
        val appbar = supportActionBar
        appbar?.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp)
        appbar?.setDisplayHomeAsUpEnabled(true)

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.app_menu_fragment_tasks, menu)
//
////        return super.onCreateOptionsMenu(menu)
//        return true
//    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId) {
            // is true having any effect?
            android.R.id.home -> drawer_layout.openDrawer(GravityCompat.START, true)
        }

        return super.onOptionsItemSelected(item)


    }
}
