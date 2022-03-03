package com.salman.mvvmcleanclean.presentation.article_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.salman.mvvmcleanclean.R
import com.salman.mvvmcleanclean.presentation.common.components.Error
import com.salman.mvvmcleanclean.presentation.util.loadPicture
import com.salman.mvvmcleanclean.ui.ColorPrimary

@Composable
fun ArticleDetailScreen(
    viewModel: ArticleDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxWidth().padding(
                    bottom = 20.dp
                )
            ) {
                item {
                    state.article?.imageUrl?.let { url ->
                        val image = loadPicture(url = url, defaultImage = R.drawable.test).value
                        image?.let {
                            Image(
                                bitmap = image.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(300.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    state.article?.title?.let { title ->
                        Text(
                            text = title,
                            color = ColorPrimary,
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    state.article?.publishedAt?.let { publishedAt ->
                        Text(
                            text = publishedAt,
                            color = ColorPrimary,
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )

                        )
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    state.article?.summary?.let { summary ->
                        Text(
                            text = summary,
                            color = ColorPrimary,
                            fontStyle = FontStyle.Normal,
                            modifier = Modifier.padding(
                                start = 10.dp,
                                end = 10.dp
                            )
                        )
                    }
                }
            }
        }

        if(state.error.isNotBlank()) {
            Error(error = state.error, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.Center))
        }
    }
}