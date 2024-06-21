package com.example.primeiroprojeto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                App()
            }
        }
    }
}

@Composable
fun App() {
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onSurface
    ){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "LogScreen") {
            composable("LogScreen") {
                LogScreen(
                    onScreenCurso = { navController.navigate("CursoScreen") },
                    onScreenSign = { navController.navigate("SignScreen") }
                )
            }

            composable("SignScreen") {
                SignScreen(  onScreenCurso = { navController.navigate("CursoScreen")} )
            }

            composable("CursoScreen"){
                CursosScreem(
                    onScreenChat =  {navController.navigate(("ChatScreen"))},
                    onScreenProfile = {navController.navigate(("ProfilScreene"))},
                    onScreenClass = {navController.navigate(("ClasseScreen"))}
                )
            }
//            onScreenSheet: () -> Unit, onScreenChat: () -> Unit, onScreenProfile: () -> Unit
            composable("ChatScreen"){
                ChatScreen(
                    onScreenCurso = {navController.navigate(("CursoScreen"))},
                    onScreenProfile = {navController.navigate(("ProfileScreen"))}
                )
            }

            composable("CongratulationsScreen"){
                CongratulationsScreen()
            }

            composable("ClasseScreen"){
               ClassesScreen()
            }

            composable("ProfileScreen"){
                ProfileScreen(
                    onScreenCurso = {navController.navigate(("CursoScreen"))},
                    onScreenChat =  {navController.navigate(("ChatScreen"))},
                )
            }
        }
    }
}
