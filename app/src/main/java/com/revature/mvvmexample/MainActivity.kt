package com.revature.mvvmexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revature.mvvmexample.ui.app.details.MovieDetails
import com.revature.mvvmexample.ui.app.list.MainList
import com.revature.mvvmexample.ui.theme.MVVMJetpackComposeExampleTheme
import com.revature.mvvmexample.ui.viewmodel.MainViewModel

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val mainViewModel by viewModels<MainViewModel>()

        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            MVVMJetpackComposeExampleTheme {

                NavHost(navController = navController, startDestination = "trendingMovieList") {

                    composable("trendingMovieList") {

                        Surface(color = MaterialTheme.colors.background) {

                            MainList(navController = navController, mainViewModel = mainViewModel)

                        }
                    }
                    composable("movieDetails") {

                        MovieDetails(mainViewModel.clickedItem)

                    }
                }
                // A surface container using the 'background' color from the theme

            }
        }
    }
}

