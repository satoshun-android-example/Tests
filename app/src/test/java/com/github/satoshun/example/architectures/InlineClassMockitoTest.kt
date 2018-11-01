package com.github.satoshun.example.architectures

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

internal class InlineClassMockitoTest {
  @Test
  fun `spy Inline class mockito with inline class`() {
    val hoge = Hoge("test")
    val mapper = spy(HogeMapper())
    mapper.mapper(hoge)

    verify(mapper).mapper(hoge)
  }

  // fail!
  @Test
  fun `mock mockito with inline class`() {
    val hoge: Hoge = mock {}
    val caller = HogeCaller()

    // fail!
    caller.call(hoge)

    verify(hoge).call()
  }

  // fail!
  @Test
  fun `spy mockito with inline class`() {
    val hoge: Hoge = spy(Hoge("test"))
    val caller = HogeCaller()
    caller.call(hoge)

    // fail!
    verify(hoge).call()
  }
}
