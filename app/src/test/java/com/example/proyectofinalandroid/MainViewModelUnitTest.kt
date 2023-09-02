package com.example.proyectofinalandroid

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.proyectofinalandroid.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule =InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val et1 = viewModel.comparacion.value?.texto1
        assertEquals("", et1)
        val et2 = viewModel.comparacion.value?.texto2
        assertEquals("", et2)
        val res = viewModel.comparacion.value?.resultado
        assertEquals("", res)

    }

}