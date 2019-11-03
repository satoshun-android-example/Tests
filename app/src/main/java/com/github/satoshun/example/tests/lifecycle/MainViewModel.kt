package com.github.satoshun.example.tests.lifecycle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

  private val _name = MutableLiveData<String>()
  val name: LiveData<String> = _name

  init {
    viewModelScope.launch {
      _name.value = "test"
    }
  }
}
