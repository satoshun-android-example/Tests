package com.github.satoshun.example.tests.lifecycle

import androidx.fragment.app.Fragment
import androidx.fragment.app.testing.launchFragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {
  private lateinit var viewModel: MainViewModel

  @Before
  fun setUp() {
    launchFragment { Fragment() }.onFragment {
      viewModel = ViewModelProvider(it, ViewModelProvider.NewInstanceFactory()).get()
    }
  }

  @Test
  fun name() {
    assertThat(viewModel.name).isEqualTo("test")
  }
}
