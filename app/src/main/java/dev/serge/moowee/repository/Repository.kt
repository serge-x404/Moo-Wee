package dev.serge.moowee.repository

import dev.serge.moowee.retrofit.Movie
import dev.serge.moowee.retrofit.RetrofitInstance

class Repository {

    suspend fun getPopularMoviesOnline(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }
}