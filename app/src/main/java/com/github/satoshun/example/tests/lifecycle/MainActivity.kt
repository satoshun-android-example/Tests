package com.github.satoshun.example.tests.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_act.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_act)

    button.setOnClickListener {
      startActivityForResult(
        Intent(this, Sub2Activity::class.java).apply {
          putExtra("fuga", "hoge")
        },
        1
      )
    }
  }

  override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
  ) {
    super.onActivityResult(requestCode, resultCode, data)
    if (requestCode == 1) {
      if (resultCode == Activity.RESULT_OK) {
        val value = data!!.getIntExtra("test", -1)
        button.text = value.toString()
      }
    }
  }
}
