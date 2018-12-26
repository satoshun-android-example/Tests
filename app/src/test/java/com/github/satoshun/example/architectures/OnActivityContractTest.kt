package com.github.satoshun.example.architectures

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class OnActivityContractTest {
  @Test
  fun onActivityContract() {
//    val scenario = ActivityScenario.launch(Activity::class.java)
//    val activity: Activity
//    scenario.onActivity2 {
//      activity = it
//    }
//    println(activity)
//  }
  }
}

//@UseExperimental(ExperimentalContracts::class)
//fun <T : Activity> ActivityScenario<T>.onActivity2(block: (T) -> Unit) {
//  contract {
//    callsInPlace(block, InvocationKind.EXACTLY_ONCE)
//  }
//  onActivity {
//    block(it)
//  }
//}
