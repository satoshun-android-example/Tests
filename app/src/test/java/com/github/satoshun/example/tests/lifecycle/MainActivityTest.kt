package com.github.satoshun.example.tests.lifecycle

import android.app.Activity
import android.app.Application
import android.content.ComponentName
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.ext.truth.content.IntentSubject
import com.google.common.truth.Truth.assertThat
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
  @get:Rule val intentsTestRule = IntentsTestRule(MainActivity::class.java)

  @Test
  fun onActivityResultTest() {
    val expectCode = 10

    // assertion setResult
    val scenario = ActivityScenario.launch(Sub2Activity::class.java)
    scenario.onActivity {
      //      Espresso
//        .onView(ViewMatchers.withId(R.id.button))
//        .perform(click())
      it.findViewById<View>(R.id.button).performClick()
    }

    // assertion resultCode
    val result = scenario.result
    assertThat(result.resultCode).isEqualTo(Activity.RESULT_OK)

    // assertion intent params
    val bundleSubject = IntentSubject.assertThat(result.resultData).extras()
    bundleSubject.integer("test").isEqualTo(expectCode)

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

      // assertion intent for startActivity(ForResult)
      val name = ComponentName(
        ApplicationProvider.getApplicationContext<Application>(),
        Sub2Activity::class.java
      )
      Intents.intended(IntentMatchers.hasComponent(name))
      Intents.intended(IntentMatchers.hasExtra("fuga", "hoge"))

      // assertion onActivityResult behaves
      Espresso
        .onView(ViewMatchers.withId(R.id.button))
        .check(ViewAssertions.matches(ViewMatchers.withText(expectCode.toString())))
    }
  }
}
