package dev.serge.moowee

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import dev.serge.moowee.repository.Repository
import dev.serge.moowee.screens.MovieScreen
import dev.serge.moowee.ui.theme.MooWeeTheme
import dev.serge.moowee.viewmodel.MovieViewModel
import dev.serge.moowee.viewmodel.MovieViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val repository = Repository(applicationContext)

        val viewModelFactory = MovieViewModelFactory(repository)

        val movieViewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[MovieViewModel::class.java]

        setContent {
            MooWeeTheme {
                Column {
                    HeaderComposable()
                    MovieScreen(movieViewModel)
                }

            }
        }
    }
}


@Composable
fun HeaderComposable() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, bottom = 8.dp)
    ) {
        Text(
            "MooWee",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Popular Movies",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }
}