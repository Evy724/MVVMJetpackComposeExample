package com.revature.mvvmexample.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revature.mvvmexample.data.model.MovieItem
import com.revature.mvvmexample.data.network.MovieApiClient
import com.revature.mvvmexample.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val apiService = MovieApiClient.service
    private lateinit var repository: MovieRepository
    var trendingMovies: List<MovieItem> by mutableStateOf(listOf())

    lateinit var clickedItem: MovieItem

    init {

        fetchTrendingMovies()

    }

    private fun fetchTrendingMovies() {

        repository = MovieRepository(apiService)
        viewModelScope.launch {

            when (val response = repository.fetchTrendingMovies()) {

                is MovieRepository.Result.Success -> {

                    Log.d("MainViewModel", "Success")
                    trendingMovies = response.movieList

                }
                is MovieRepository.Result.Failure -> {

                    Log.d("MainViewModel", "FAILURE")

                }
            }
        }
    }

    fun itemClicked(item: MovieItem) {

        clickedItem = item

    }
}