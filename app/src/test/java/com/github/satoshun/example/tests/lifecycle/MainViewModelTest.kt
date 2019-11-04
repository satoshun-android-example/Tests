package com.github.satoshun.example.tests.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class MainViewModelTest {
  @get:Rule val mainCoroutineRule = MainCoroutineRule()
  @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

  private lateinit var viewModel: MainViewModel

  @Before
  fun setUp() {
    launchFragment { Fragment() }.onFragment {
      viewModel = ViewModelProvider(it, object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
          @Suppress("UNCHECKED_CAST")
          return MainViewModel(
            repository = mock {
              onBlocking { getUserName() } doReturn "test"
            }
          ) as T
        }
      })
        .get(MainViewModel::class.java)
    }
  }

  @Test
  fun name() = mainCoroutineRule.runBlocking {
    assertThat(viewModel.name.value).isEqualTo("test")
  }
}
