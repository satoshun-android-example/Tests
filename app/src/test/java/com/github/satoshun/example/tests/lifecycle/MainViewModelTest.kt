package com.github.satoshun.example.tests.lifecycle

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class MainViewModelTest {
  @get:Rule val mainCoroutineRule = MainCoroutineRule()
  @get:Rule val instantTaskExecutorRule = InstantTaskExecutorRule()

  private lateinit var viewModel: MainViewModel

  @Before
  fun setUp() {
    launchFragment { Fragment() }.onFragment {
      viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory()).get()
    }
  }

  @Test
  fun name() {
    assertThat(viewModel.name.value).isEqualTo("test")
  }
}
