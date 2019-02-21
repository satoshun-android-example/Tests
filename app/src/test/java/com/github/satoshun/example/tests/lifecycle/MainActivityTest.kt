package com.github.satoshun.example.tests.lifecycle

import android.app.Application
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.truth.content.IntentSubject
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {
  @Test
  fun hoge() {
    val source = ActivityScenario.launch(MainActivity::class.java)
    source.onActivity {
      it.findViewById<View>(R.id.button).performClick()
    }

//    val actual = Shadows
//      .shadowOf(
//        ApplicationProvider.getApplicationContext<Application>()
//      )
//      .nextStartedActivity
//
//    val destination = ActivityScenario.launch<Sub2Activity>(actual)
//    destination.onActivity {
//      it.findViewById<View>(R.id.button).performClick()
//
//      Shadows.shadowOf(it).receiveResult()
//    }
  }

  @Test
  fun sendTest() {
    val scenario = ActivityScenario.launch(Sub2Activity::class.java)
    scenario.onActivity {
      it.findViewById<View>(R.id.button).performClick()

      val shadowActivity = Shadows.shadowOf(it)
      assertThat(shadowActivity.resultCode)
        .isEqualTo(1)
      val subject = IntentSubject.assertThat(shadowActivity.resultIntent)
      val bundleSubject = subject.extras()
      bundleSubject.integer("test").isEqualTo(10)
    }
  }

  @Test
  fun receiveTest() {
    // call startActivityForResult and check valid requestCode
    val scenario = ActivityScenario.launch(MainActivity::class.java)
    scenario.onActivity {
      it.findViewById<View>(R.id.button).performClick()

      val shadowActivity = Shadows.shadowOf(it)

      val intent = Shadows
        .shadowOf(
          ApplicationProvider.getApplicationContext<Application>()
        )
        .nextStartedActivity
      val subject = IntentSubject.assertThat(intent)
      subject.hasComponentClass(MainActivity::class.java)
    }
  }
}
