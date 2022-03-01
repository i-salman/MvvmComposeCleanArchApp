package com.salman.mvvm.presentation.article.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.salman.mvvm.domain.model.Article
import com.salman.mvvm.presentation.util.loadPicture
import com.salman.mvvm.R

@Composable
fun ArticleItem(
    article: Article?,
    onClick: (Article) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                bottom = 6.dp,
                top = 6.dp
            )
            .fillMaxWidth()
            .clickable(onClick = { onClick(article!!) }),
        elevation = 8.dp
    ) {
        Column (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {

        article?.imageUrl?.let { url ->
            val image = loadPicture(url = url, defaultImage = R.drawable.test).value
            image?.let { image ->
                Image(
                    bitmap = image.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth().height(getScreenHeight().dp),
                    contentScale = ContentScale.Crop
                )
            }
        }

            Spacer(modifier = Modifier.height(4.dp))

            Column (
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = "${article?.title}"
                )
            }
        }
    }
}

fun getScreenHeight() : Int {
    return 200
}

@Preview
@Composable
fun TestArticleItem() {
    ArticleItem(article = null, onClick = {})
}