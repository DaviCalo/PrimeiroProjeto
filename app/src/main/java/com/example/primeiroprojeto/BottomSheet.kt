package com.example.primeiroprojeto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primeiroprojeto.viewModels.ViewModelSheet
import androidx.lifecycle.viewmodel.compose.viewModel

//class BottomSheetClass : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PrimeiroProjetoTheme{
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = Color.White
//                ) {
//                    BottomSheet()
//                }
//            }
//        }
//    }
//}

@Composable
fun BottomSheet(){
    val loginViewModel = viewModel<ViewModelSheet>()

    if (loginViewModel.sheet.value) {
        BottomSheet {
            loginViewModel.sheet.value = false
        }
    }

    Column(
        Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { loginViewModel.sheet.value = true }) {
            Text(text = "Show BottomSheet")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        CountryList()
    }
}

@Composable
fun CountryList(){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))

    Column(
        Modifier
            .padding(25.dp, 10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Drawer Header", fontSize = 24.sp, fontFamily = interMedium, color = Color.Black)

            Text(text = "Consequat velit qui adipisicing sunt do reprehenderit ad laborum tempor ullamco exercitation.",fontSize = 16.sp, fontFamily = interMedium, color = Color(0xff666666), textAlign = TextAlign.Center)
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(15.dp, 0.dp), colors = ButtonDefaults.buttonColors(
                    Color(0xFF5DB075)
                )) {
                Text(text = "Click Me", fontFamily = interSemiBlod, color = Color.White)
            }
            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(15.dp, 0.dp), colors = ButtonDefaults.buttonColors(
                    Color.Transparent
                )) {
                Text(text = "Secondary Action", fontFamily = interSemiBlod, color = Color(0xff5DB075))
            }
        }
    }
}

@Preview
@Composable
fun Asd(){
    BottomSheet()
}