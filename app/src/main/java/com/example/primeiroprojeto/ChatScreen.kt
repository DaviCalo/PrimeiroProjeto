package com.example.primeiroprojeto


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.ViewModels.ViewModelSup

@Composable
fun ChatScreen(){
    Scaffold(
    topBar = { Header("Suporte") },
    bottomBar = { InputScreenBottomBar() },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            MessagesComposable()
        }
    }
}

@Composable
fun MessagesComposable(){
    Column(
        Modifier.padding(20.dp)
    ) {
        repeat(2){
            MessageCard("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        }
        repeat(2){
            MessageCardAnother("Lorem ipsum dolor sit amet, consectetur adipiscing elit.")
        }
    }
}

@Composable
fun MessageCard(message: String){
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.Medium))
    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 5.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    ) {
        Row(modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 48f,
                    topEnd = 48f,
                    bottomStart = 48f,
                    bottomEnd = 0f
                )
            )
            .background(Color(0xff5db075))
            .width(265.dp)
            .padding(15.dp)
        ) {
            Text(text = message, fontSize = 15.sp, fontFamily = interMedium, color = Color(0xFFFFFFFF))
        }
    }
}

@Composable
fun MessageCardAnother(message: String){
        val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.Medium))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(0.dp, 5.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
        Row(modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 48f,
                    topEnd = 48f,
                    bottomStart = 0f,
                    bottomEnd = 48f
                )
            )
            .border(
                2.dp,
                Color(0xffeeeeee),
                RoundedCornerShape(topStart = 48f, topEnd = 48f, bottomStart = 0f, bottomEnd = 48f)
            )
            .background(Color(0xfff6f6f6))
            .width(265.dp)
            .padding(15.dp)
        ) {
            Text(text = message, fontSize = 15.sp, fontFamily = interMedium, color = Color(0xFF000000))
        }
}}

@Composable
fun InputScreenBottomBar(){
    val viewModelSup = viewModel<ViewModelSup>()

    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))

    Row {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp, start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(50.dp),
            value = viewModelSup.InputSeach.value,
            onValueChange = { viewModelSup.InputSeach.value = it },
            label = {
                Text(
                    text = "Message here...",
                    fontFamily = interMedium,
                    fontSize = 16.sp,
                    color = Color(0xffBDBDBD)
                )
            },
            trailingIcon = {
//                   IconButton(onClick = { /*TODO*/ }) {}
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.ArrowForward,
                        contentDescription = null,
                        tint = Color(0xff5DB075))
                }
            },
            singleLine = true
        )
    }
}


@Preview
@Composable
fun Asdasd(){
    ChatScreen()
}