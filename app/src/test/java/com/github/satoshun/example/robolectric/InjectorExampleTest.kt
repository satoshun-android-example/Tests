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
      .bind(String::class.java, "test")
      .build()

    val target = injector.getInstance(TestTarget::class.java)
    target.hello()
  }

  @Test
  fun test2() {
    test(10)
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

class A {
  val foo: () -> Unit = {
    println("Hello world!")
  }
}

fun test(foo: Int) {
  with(A()) {
    foo   // parameter
    foo() // property + invoke
  }
}
