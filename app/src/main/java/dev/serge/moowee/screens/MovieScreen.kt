package dev.serge.moowee.screens

import androidx.compose.runtime.Composable
import dev.serge.moowee.viewmodel.MovieViewModel

@Composable
fun MovieScreen(viewModel: MovieViewModel) {

    val moviesList = viewModel.movies

    MovieList(moviesList)

}