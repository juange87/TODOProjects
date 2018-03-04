package com.juange.todoprojects.presentation

import com.juange.todoprojects.domain.project.model.Project
import com.juange.todoprojects.domain.project.usecase.GetLocalProjectsUseCase
import com.juange.todoprojects.domain.project.usecase.GetProjectsUseCase
import com.juange.todoprojects.domain.task.usecase.GetLocalTaskByProjectUseCase
import com.juange.todoprojects.domain.task.usecase.GetTasksUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private lateinit var getProjectsUseCase: GetProjectsUseCase
    private lateinit var getLocalProjectsUseCase: GetLocalProjectsUseCase
    private lateinit var getLocalTaskByProjectUseCase: GetLocalTaskByProjectUseCase
    private lateinit var getTasksUseCase: GetTasksUseCase

    private lateinit var presenter: MainPresenter
    private lateinit var ui: MainPresenter.MainPresenterContractView

    @Before
    fun setUp() {
        getProjectsUseCase = mockk<GetProjectsUseCase>()

        getLocalProjectsUseCase = mockk<GetLocalProjectsUseCase>()
        every { getLocalProjectsUseCase.execute(any()) } answers { emptyList<Project>()}

        getLocalTaskByProjectUseCase = mockk<GetLocalTaskByProjectUseCase>()
        getTasksUseCase = mockk<GetTasksUseCase>()
        ui = mockk<MainPresenter.MainPresenterContractView>(relaxed = true)

        presenter = MainPresenter(getProjectsUseCase, getLocalProjectsUseCase, getLocalTaskByProjectUseCase, getTasksUseCase)
        presenter.attachView(ui)
    }

    @Test
    fun testInit() {
        presenter.init()

        verify { ui.showMessage() }
    }
}
