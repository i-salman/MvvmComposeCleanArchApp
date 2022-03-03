package com.salman.mvvmclean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.salman.mvvmclean.presentation.article.ArticlesScreen
import com.salman.mvvmclean.presentation.article_detail.ArticleDetailScreen
import com.salman.mvvmclean.ui.AppTheme
import com.salman.mvvmclean.ui.screens.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme (darkTheme = false) {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ArticleScreen.route
                    ) {
                        composable(
                            route = Screen.ArticleScreen.route
                        ) {
                            ArticlesScreen(navController = navController)
                        }

                        composable(
                            route = Screen.ArticleDetailScreen.route +"/{articleId}"
                        ) {
                            ArticleDetailScreen()
                        }
                    }
                }
            }
        }
    }
}