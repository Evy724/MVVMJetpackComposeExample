package com.revature.mvvmexample.ui.app.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.revature.mvvmexample.data.model.MovieItem
import com.revature.mvvmexample.ui.viewmodel.MainViewModel

@ExperimentalFoundationApi
@Composable
fun MainList(navController: NavController, mainViewModel: MainViewModel) {

    MovieList(
        navController = navController,
        movieList = mainViewModel.trendingMovies,
        onItemClicked = mainViewModel::itemClicked
    )

}

@ExperimentalFoundationApi
@Composable
fun MovieList(
    navController: NavController,
    movieList:List<MovieItem>,
    onItemClicked:(item:MovieItem) ->Unit
) {

    val listState = rememberLazyListState()
    Color(red = 35, green = 61, blue = 83)

    LazyColumn(state = listState) {

        stickyHeader {

            MainHeader()

        }
        itemsIndexed(movieList){ _, item ->
            ListViewItem(navController = navController,movieItem = item,onItemClicked)

        }
    }
}


@Composable
fun MainHeader(){

    Surface(
        Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {

        Text(
            text = "Trending Movies",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )

    }
}