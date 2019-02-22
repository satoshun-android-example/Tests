package com.github.satoshun.example.tests.lifecycle

import android.app.Activity
import android.app.Application
import android.content.ComponentName
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.truth.content.IntentSubject
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows

@RunWith(AndroidJUnit4::class)
internal class MainActivityTest {
  @get:Rule val intentsTestRule = IntentsTestRule(MainActivity::class.java)

  @Test
  fun startActivityTest() {
    // call startActivityForResult and check valid requestCode
    val scenario = ActivityScenario.launch(MainActivity::class.java)
    scenario.onActivity {
      // Expresso not working
//      Espresso
//        .onView(ViewMatchers.withId(R.id.button))
//        .perform(ViewActions.click())
      it.findViewById<View>(R.id.button).performClick()

      // todo check request code
      val shadowActivity = Shadows.shadowOf(it)
//      val intent = Shadows
//        .shadowOf(
//          ApplicationProvider.getApplicationContext<Application>()
//        )
//        .nextStartedActivity
//      val subject = IntentSubject.assertThat(intent)
//      subject.hasComponentClass(Sub2Activity::class.java)

      // check intent for startActivity(ForResult)
      val name = ComponentName(
        ApplicationProvider.getApplicationContext<Application>(),
        Sub2Activity::class.java
      )
      Intents.intended(IntentMatchers.hasComponent(name))
      Intents.intended(IntentMatchers.hasExtra("fuga", "hoge"))
    }
  }

  @Test
  fun onActivityResultTest() {
    val scenario = ActivityScenario.launch(Sub2Activity::class.java)
    scenario.onActivity {
      it.findViewById<View>(R.id.button).performClick()
    }

    // resultCode test
    val result = scenario.result
    assertThat(result.resultCode).isEqualTo(1)

    // intent params test
    val bundleSubject = IntentSubject.assertThat(result.resultData).extras()
    bundleSubject.integer("test").isEqualTo(10)

//    val receive = ActivityScenario.launch(MainActivity::class.java)
//    receive.onActivity {
//      it.onActivityResult(
//        1, // todo request code
//        result.resultCode,
//        result.resultData
//      )
//    }
  }

  @Test
  fun startActivityTest2() {
    // finish test
    val scenario = ActivityScenario.launch(Sub2Activity::class.java)
    scenario.onActivity {
      it.findViewById<View>(R.id.button).performClick()
    }

    // resultCode test
    val result = scenario.result
    assertThat(result.resultCode).isEqualTo(Activity.RESULT_OK)

    // intent params test
    val bundleSubject = IntentSubject.assertThat(result.resultData).extras()
    bundleSubject.integer("test").isEqualTo(10)

    scenario.close()

    Intents
      .intending(
        IntentMatchers.hasComponent(
          ComponentName(
            ApplicationProvider.getApplicationContext<Application>(),
            Sub2Activity::class.java
          )
        )
      )
      .respondWith(result)

    val main = ActivityScenario.launch(MainActivity::class.java)
    main.onActivity {
      it.findViewById<View>(R.id.button).performClick()

      // check intent for startActivity(ForResult)
      val name = ComponentName(
        ApplicationProvider.getApplicationContext<Application>(),
        Sub2Activity::class.java
      )
      Intents.intended(IntentMatchers.hasComponent(name))
      Intents.intended(IntentMatchers.hasExtra("fuga", "hoge"))

      // todo check onActivityResult behaves
    }
  }
}
