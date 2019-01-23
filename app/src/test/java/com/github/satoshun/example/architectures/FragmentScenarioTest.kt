package com.github.satoshun.example.architectures

import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.testing.launchFragment
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.satoshun.example.tests.lifecycle.MainFragment
import com.github.satoshun.example.tests.lifecycle.R
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class FragmentScenarioTest {
  @Test
  fun `check container view exists`() {
    val scenario = launchFragment<MainFragment>()
    scenario.onFragment { fragment ->
      val container = fragment.view?.findViewById<View>(R.id.container)
      assertThat(container)
        .isInstanceOf(LinearLayout::class.java)
    }
  }
}
