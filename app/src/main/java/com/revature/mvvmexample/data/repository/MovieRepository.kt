package com.revature.mvvmexample.data.repository

import android.util.Log
import com.revature.mvvmexample.data.model.MovieItem
import com.revature.mvvmexample.data.network.MovieFetchApi

class MovieRepository (private val movieFetchApi: MovieFetchApi) {

    sealed class Result {

        data class Success(val movieList : List<MovieItem>): Result()
        data class Failure(val throwable: Throwable): Result()
    }
    suspend fun fetchTrendingMovies():Result{

        return try {

            val movieList = movieFetchApi.fetchTrendingMovieList().results
            Log.d("MOVIELIST","success "+movieList.size)
            Result.Success(movieList = movieList)

        } catch (exception:Exception) {

            Log.d("MOVIELIST","failure ")

            Result.Failure(exception)

        }
    }
}