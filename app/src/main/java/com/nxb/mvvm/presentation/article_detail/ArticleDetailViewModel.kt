package com.nxb.mvvm.presentation.article_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nxb.mvvm.common.Response
import com.nxb.mvvm.domain.repository.ArticleRepository
import com.nxb.mvvm.domain.use_case.GetArticleDetailUseCase
import com.nxb.mvvm.presentation.article.ArticleState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(
    private val getArticleDetailUseCase: GetArticleDetailUseCase,
    savedStateHandle: SavedStateHandle

): ViewModel() {

    private val _state = mutableStateOf(ArticleDetailState())
    val state: State<ArticleDetailState> = _state

    init {
        savedStateHandle.get<String>("articleId")?.let {
            getArticleDetail(it)
        }
    }

    private fun getArticleDetail(articleId: String) {
        getArticleDetailUseCase(articleId = articleId).onEach { result ->

            when(result) {
                is Response.Loading -> {
                    _state.value = ArticleDetailState(isLoading = true)
                }

                is Response.Success -> {
                    _state.value = ArticleDetailState(article = result.data!!)
                }

                is Response.Error -> {
                    _state.value = ArticleDetailState(error = result.message ?: "An Unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}