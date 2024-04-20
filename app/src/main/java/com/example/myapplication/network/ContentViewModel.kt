package com.example.myapplication.network

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(private val getImagesUseCase: GetImagesUseCase) : ViewModel() {

    val imageList: StateFlow<ContentState>
        get() = _imageList
    private val _imageList = MutableStateFlow<ContentState>(ContentState.Content(emptyList()))

    init {
        getImages()
    }

    private fun getImages() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val result = getImagesUseCase.getImages()
                _imageList.value = ContentState.Content(result)
            } catch (e: Exception) {
                _imageList.value = ContentState.Error(e.localizedMessage.orEmpty())
            }
        }
    }
}