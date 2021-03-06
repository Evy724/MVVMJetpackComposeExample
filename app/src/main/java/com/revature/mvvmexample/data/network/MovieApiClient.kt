package com.revature.mvvmexample.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object MovieApiClient {

    private const val BASE_URL ="https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())

    val  service:MovieFetchApi by lazy {

        retrofit.build()
            .create(MovieFetchApi::class.java)

    }

}