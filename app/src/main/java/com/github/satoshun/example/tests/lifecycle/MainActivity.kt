package com.github.satoshun.example.tests.lifecycle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(),
  CoroutineScope {

  private val job = Job()
  override val coroutineContext: CoroutineContext get() = job + Dispatchers.Main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }
}

class MainFragment : Fragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?, savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.main_frag, container, false)
  }
}
