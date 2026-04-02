package dev.serge.moowee.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.serge.moowee.retrofit.Movie

@Dao
interface MovieDao {

    @Insert
    suspend fun insert(movie: Movie)

    @Insert
    suspend fun insertMoviesList(movies: List<Movie>)

    @Query("SELECT * FROM movies_table")
    suspend fun getAllMovies(): List<Movie>
}