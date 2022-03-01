package com.salman.mvvm.presentation.article

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.material.Text
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import com.salman.mvvm.presentation.article.components.ArticleItem
import com.salman.mvvm.presentation.common.components.Error
import com.salman.mvvm.ui.screens.Screen

@Composable
fun ArticlesScreen(
    navController: NavController,
    viewModel: ArticlesViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column (
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Space Flight Articles",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(10.dp)
        )

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.articles!!) { article ->
                    ArticleItem(article = article, onClick = { article ->
                        navController.navigate(Screen.ArticleDetailScreen.route +"/${article.id}")
                    })
                }
            }
        }
    }

    Box (
        modifier = Modifier.fillMaxSize()
    ) {
        if(state.error.isNotBlank()) {
            Error(error = state.error, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center))
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }
    }
}