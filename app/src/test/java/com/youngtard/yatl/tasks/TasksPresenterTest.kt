package com.youngtard.yatl.tasks

import android.app.Activity
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.Spy
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

// Can also run with AndroidJUnit used for running test with the android framework
//@RunWith(MockitoJUnitRunner::class, JUnit4::class, AndroidJUnit4::class)
//@RunWith(MockitoJUnitRunner::class)
class TasksPresenterTest {
//    @get:Rule
    @Rule @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()


//    An interface is mocked. It's not worth spying "a" real behavior?
//    @Mock
//    lateinit var tasksView: TasksContract.View

    private var tasksView: TasksContract.View = mock(TasksContract.View::class.java)// Why not reference TasksFragment

    private lateinit var tasksPresenter: TasksPresenter

    @Before
    fun setUpTasksPresenter() {
//        MockitoAnnotations.initMocks(this)

        tasksPresenter = TasksPresenter(tasksView)

    }


//    make an espresso/integrated test? because the android activity shows the drawer not the fragment or mock the activity?
    @Test
    fun `click on nav bar opens nav drawer`() {

        // when
        tasksPresenter.onNavBarClick()

        // then
        verify(tasksView).showNavBar()
//        framework().clearInlineMocks()

    }

    @Test
    fun `click on filter icon brings up filter pop up menu`() {
        tasksPresenter.onFilterOptionClicked()

        verify(tasksView).showFilterPopUpMenu()
    }

    @Test
    fun `click on add task fab icon opens add tasks fragment`() {

        tasksPresenter.addTask()

        verify(tasksView).openAddTasksFragment()
    }

    /**
     * See [Memory leak in mockito-inline...](https://github.com/mockito/mockito/issues/1614)
     */

    @After
    fun clearMocks() {
                framework().clearInlineMocks()
    }


//    companion object {
//        @AfterClass @JvmStatic
//        fun clearMocks() {
//
//        }
//    }

}