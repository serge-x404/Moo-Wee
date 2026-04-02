package dev.serge.moowee.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import dev.serge.moowee.retrofit.Movie

@Composable
fun MovieList(movies: List<Movie>) {

    LazyColumn {
        items(movies) {
            MovieItem(it)
        }
    }

}