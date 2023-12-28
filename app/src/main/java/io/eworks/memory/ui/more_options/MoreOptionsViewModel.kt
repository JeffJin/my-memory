package io.eworks.memory.ui.more_options

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoreOptionsViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is more options Fragment"
    }
    val text: LiveData<String> = _text
}