package dev.serge.moowee.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.serge.moowee.BuildConfig
import dev.serge.moowee.repository.Repository
import dev.serge.moowee.retrofit.Movie
import kotlinx.coroutines.launch

class MovieViewModel(repository: Repository): ViewModel() {

    var movies by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromApi by mutableStateOf<List<Movie>>(emptyList())
        private set

    var moviesFromRoomDB by mutableStateOf<List<Movie>>(emptyList())
        private set




    init {
        viewModelScope.launch {
            try {
                moviesFromApi = repository.getPopularMoviesOnline(BuildConfig.apiKey)

                repository.insertMoviesIntoDB(moviesFromApi)


                movies = moviesFromApi
            } catch (e: Exception) {
                moviesFromRoomDB = repository.getMoviesFromDB()

                movies = moviesFromRoomDB
            }
        }
    }
}