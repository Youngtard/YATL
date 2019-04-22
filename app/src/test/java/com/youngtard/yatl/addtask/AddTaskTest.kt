package com.youngtard.yatl.addtask

import com.youngtard.yatl.addedittask.AddTaskContract
import com.youngtard.yatl.addedittask.AddTaskPresenter
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

class AddTaskTest {

    @Rule @JvmField
    val rule: MockitoRule = MockitoJUnit.rule()

    private val addTaskView = mock(AddTaskContract.View::class.java)

    private lateinit var addTaskPresenter: AddTaskPresenter


    @Before
    fun setup() {
        addTaskPresenter = AddTaskPresenter(addTaskView)
    }

    @Test
    fun `click on save task shows task saved`() {
        addTaskPresenter.saveTask()

        verify(addTaskView).showTaskSaved()
    }

    @Test
    fun `click on save task adds to list of saved task`() {

    }

    @After
    fun clearMocks() {
        framework().clearInlineMocks()
    }
}