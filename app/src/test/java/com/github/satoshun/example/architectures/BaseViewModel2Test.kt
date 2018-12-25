package com.github.satoshun.example.architectures

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.satoshun.example.tests.lifecycle.BaseViewModel
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.Job
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit

@RunWith(AndroidJUnit4::class)
internal class BaseViewModel2Test {
  @get:Rule val mockitoRule = MockitoJUnit.rule()!!

  @Mock private lateinit var job: Job

  // ViewModelのライフサイクルが終わったら、Coroutineがdisposeされる
  @Test
  fun `dispose a coroutine when finished lifecycle of ViewModel`() {
    verify(job, never()).cancel()

    val scenario = ActivityScenario.launch(FragmentActivity::class.java)
    scenario.onActivity {
      ViewModelProviders
        .of(
          it,
          object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
              return object : BaseViewModel(job) {} as T
            }
          }
        ).get(BaseViewModel::class.java)
    }
    scenario.moveToState(Lifecycle.State.DESTROYED)

    verify(job).cancel()
  }
}
