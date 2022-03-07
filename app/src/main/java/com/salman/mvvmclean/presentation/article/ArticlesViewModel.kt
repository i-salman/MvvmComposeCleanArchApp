package com.salman.mvvmclean.presentation.article

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salman.mvvmclean.common.Response
import com.salman.mvvmclean.domain.use_case.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor (
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<ArticleState>(ArticleState.Empty)
    val state: StateFlow<ArticleState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {

        viewModelScope.launch {
            getArticlesUseCase.getData()
                .collect { response ->
                when (response) {
                    is Response.Success -> {
                        _state.value = ArticleState.Success(response.data ?: emptyList())
                    }

                    is Response.Loading -> {
                        _state.value = ArticleState.Loading
                    }

                    is Response.Error -> {
                        _state.value = ArticleState.Error(response.message ?: "An Unexpected error occurred")
                    }

                }
            }
        }
    }
}