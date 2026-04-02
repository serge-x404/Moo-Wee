package dev.serge.moowee.repository

import android.content.Context
import dev.serge.moowee.retrofit.Movie
import dev.serge.moowee.retrofit.RetrofitInstance
import dev.serge.moowee.room.MovieDao
import dev.serge.moowee.room.MoviesDB

class Repository(context: Context) {

    suspend fun getPopularMoviesOnline(apiKey: String): List<Movie> {
        return RetrofitInstance.api.getPopularMovies(apiKey).results
    }

    private val db = MoviesDB.getInstance(context)
    private val movieDao: MovieDao = db.moviesDao

    suspend fun getMoviesFromDB(): List<Movie> {
        return movieDao.getAllMovies()
    }

    suspend fun insertMoviesIntoDB(movies: List<Movie>) {
        return movieDao.insertMoviesList(movies)
    }

    suspend fun insertMovieIntoDB(movie: Movie) {
        return movieDao.insert(movie)
    }
}