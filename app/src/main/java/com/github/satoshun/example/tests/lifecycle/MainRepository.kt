package com.github.satoshun.example.tests.lifecycle

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class MainRepository {
  suspend fun getUserName(): String = suspendCoroutine {
    it.resume("test")
  }
}
