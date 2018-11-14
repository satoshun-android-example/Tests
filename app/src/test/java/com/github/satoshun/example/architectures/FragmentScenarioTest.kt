package com.github.satoshun.example.architectures

import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.satoshun.example.tests.lifecycle.MainFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class FragmentScenarioTest {
  @Test
  fun testtest() {
    val scenario = launchFragment<MainFragment>()
    scenario.onFragment {
    }
  }
}
