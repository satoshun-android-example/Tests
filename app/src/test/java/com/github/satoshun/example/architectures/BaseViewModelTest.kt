package com.github.satoshun.example.architectures

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.github.satoshun.example.tests.lifecycle.BaseViewModel
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Job
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

@RunWith(AndroidJUnit4::class)
internal class BaseViewModelTest {
  @get:Rule val activityRule = ActivityTestRule(FragmentActivity::class.java)
  @get:Rule val mockitoRule = MockitoJUnit.rule()!!

  private lateinit var viewModel: BaseViewModel

  @Mock private lateinit var job: Job

  @Suppress("UNCHECKED_CAST")
  @Before
  fun setUp() {
    viewModel = ViewModelProviders
      .of(
        activityRule.activity,
        object : ViewModelProvider.Factory {
          override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return object : BaseViewModel(job) {} as T
          }
        }
      ).get()
  }

  // ViewModelのライフサイクルが終わったら、Coroutineがdisposeされる
  @Test
  fun `dispose a coroutine when finished lifecycle of ViewModel`() {
    verify(job, never()).cancel()

    activityRule.activity.viewModelStore.clear()

    verify(job).cancel()
  }

  // ViewModelのライフサイクルが終わったら、Coroutineがdisposeされる
  @Test
  fun `dispose a coroutine when finished lifecycle of ViewModel 2`() {
    verify(job, never()).cancel()

    InstrumentationRegistry.getInstrumentation().callActivityOnDestroy(activityRule.activity)

    verify(job).cancel()
  }
}
