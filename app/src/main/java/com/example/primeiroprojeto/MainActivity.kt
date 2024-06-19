package com.example.primeiroprojeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeiroProjetoTheme {
                val viewModel: ViewModelPP by viewModels()
                App(viewModel = viewModel)
            }
        }
    }
}

//val viewModel: TesteViewModel by viewModels()
//test(viewModel = viewModel)
@Composable
fun App(viewModel: ViewModelPP) {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface
    ){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "LogScreen") {
            composable("LogScreen") {
                LogScreen(
                    onScreenCursos = {
                        navController.navigate("CursoScreen")
                    }, viewModel
                )
            }

            composable("SignScreen") {
                SignScreen()
            }

            composable("CursoScreen"){
                CursosScreem(viewModel)
            }

            composable("ChatScreen"){
                ChatScreen()
            }

            composable("CongratulationsScreen"){
                CongratulationsScreen()
            }
        }
    }
}
