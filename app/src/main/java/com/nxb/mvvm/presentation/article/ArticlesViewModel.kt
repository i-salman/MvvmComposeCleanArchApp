package com.nxb.mvvm.presentation.article

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nxb.mvvm.common.Response
import com.nxb.mvvm.domain.use_case.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticlesViewModel @Inject constructor (
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ArticleState())
    val state: State<ArticleState> = _state

    init {
        getArticles()
    }

    private fun getArticles() {
        getArticlesUseCase().onEach { response ->
            when (response) {
                is Response.Success -> {
                    _state.value = ArticleState(articles = response.data ?: emptyList())
                }

                is Response.Loading -> {
                    _state.value = ArticleState(isLoading = true)
                }

                is Response.Error -> {
                    _state.value = ArticleState(error = response.message ?: "An Unexpected error occured")
                }
            }
        }.launchIn(viewModelScope)
    }

}