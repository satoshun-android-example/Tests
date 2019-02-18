package com.github.satoshun.example.robolectric

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.util.inject.Injector

@RunWith(AndroidJUnit4::class)
internal class InjectorExampleTest {
  @Test
  fun test1() {
    val injector = Injector.Builder()
      .build()

    val target = injector.getInstance(TestTarget::class.java)
    target.hello()
  }
}

class TestTarget(
  private val target: TestDepsTarget
) {
  fun hello() {
    println(target)
  }
}

class TestDepsTarget(
  private val str: String
)
