package com.github.satoshun.example.tests.lifecycle

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.sub_act.*

class Sub2Activity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.sub_act)

    button.setOnClickListener {
      val intent = Intent()
      intent.putExtra("test", 10)
      setResult(Activity.RESULT_OK, intent)
      finish()
    }
  }
}
