package com.example.primeiroprojeto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.ViewModels.ViewModelCurso
import com.example.primeiroprojeto.ViewModels.ViewModelLogin
import com.example.primeiroprojeto.ViewModels.ViewModelSheet

@Composable
fun  LogScreen(onScreenCursos: () -> Unit){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .systemBarsPadding()
            .background(Color.White)
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Log in", fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, fontSize = 30.sp)
        Forms(onScreenCursos)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Forms(onScreenCursos: () -> Unit){

    val loginViewModel = viewModel<ViewModelLogin>()

    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp, 25.dp, 20.dp, 0.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10),
                value = loginViewModel.logEmail.value,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xffE8E8E8),
                    focusedBorderColor = Color(0xff5DB075),
                    containerColor = Color(0xffF6F6F6),
                ),
                singleLine = true,
                onValueChange = { loginViewModel.changeEmail(it) },
                label = { Text("Email",fontFamily = interMedium, fontSize = 16.sp, fontWeight = FontWeight.Medium,color = Color(0xffBDBDBD)) }
            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10),
                trailingIcon = {
                    ClickableText(
                        modifier = Modifier.padding(end = 15.dp),
                        text = AnnotatedString("Show"),
                        onClick = {  }
                    )
//                    Text(text = "Show", color = Color(0xFF5DB075), fontSize = 16.sp, fontFamily = interMedium)
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xffE8E8E8),
                    focusedBorderColor = Color(0xff5DB075),
                    containerColor = Color(0xffF6F6F6),
                ),
                value = loginViewModel.logPassword.value,
                singleLine = true,
                onValueChange = { loginViewModel.changePassword(it) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                label = { Text("Passoword", fontFamily = interMedium, fontSize = 16.sp, color = Color(0xffBDBDBD))
                }
            )
        }

        Column(
            Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onScreenCursos() },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(15.dp, 0.dp), colors = ButtonDefaults.buttonColors(
                    Color(0xFF5DB075)
                )) {
                Text(text = "Log In",  fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.White)
            }
            Button(onClick = { /*TODO*/ },
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(15.dp, 5.dp), colors = ButtonDefaults.buttonColors(
                    Color(0xFF5DB075)
                )) {
                Text(text = "Sign Up",  fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.White)
            }
            Text(text = "Forgot your password?", fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, color = Color(0xFF5DB075), fontSize = 16.sp)
        }
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun asd(){
//    LogScreen(Unit)
//}