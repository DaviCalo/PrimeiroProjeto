package com.example.primeiroprojeto


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.viewModels.ViewModelSheet
import com.example.primeiroprojeto.viewModels.ViewModelSup

@Composable
fun ChatScreen(onScreenCurso: () -> Unit, onScreenProfile: () -> Unit){
    Scaffold(
    topBar = { Header("Suporte") },
    bottomBar = { ClassesScreenBottomBarChat(onScreenCurso, onScreenProfile) },
    modifier = Modifier.systemBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            MessagesComposable()
            InputScreenBottomBar()
        }
    }
}

@Composable
fun MessagesComposable(){
    Column(
        Modifier.padding(16.dp).verticalScroll(rememberScrollState()),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputScreenBottomBar(){
    val viewModelSup = viewModel<ViewModelSup>()

    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))

    Row {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(50.dp),
            value = viewModelSup.inputSeach.value,
            onValueChange = { viewModelSup.inputSeach.value = it },
            label = {
                Text(
                    text = "Message here...",
                    fontFamily = interMedium,
                    fontSize = 16.sp,
                    color = Color(0xffBDBDBD)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xffE8E8E8),
                focusedBorderColor = Color(0xff5DB075),
                containerColor = Color(0xffF6F6F6),
            ),
            trailingIcon = {
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


@Composable
fun ClassesScreenBottomBarChat(onScreenCurso: () -> Unit, onScreenProfile: () -> Unit){
    val loginViewModel = viewModel<ViewModelSheet>()
    if (loginViewModel.sheet.value) {
        BottomSheet {
            loginViewModel.sheet.value = false
        }
    }
    fun asd(){loginViewModel.sheet.value = true}
    BottomAppBar (
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.White),
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularBottomButton(Color.Gray,onScreenCurso)
            CircularBottomButton(Color.Gray) {asd()}
            CircularBottomButton(Color(0xff5DB075)){}
            CircularBottomButton(Color.Gray,onScreenProfile)
        }
    }
}

@Preview
@Composable
fun PreviewChat(){
    ChatScreen({}, {})
}