package com.example.primeiroprojeto.com.example.primeiroprojeto.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primeiroprojeto.R


@Composable
fun chatScreen(){
    Scaffold(
    topBar = { Header("Chat") },
    bottomBar = {  },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(innerPadding)
        ) {

        }
    }
}






@Composable
fun Header(Title: String){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(0.dp, 10.dp, 0.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xfffffff))
        ) {
            Text("Back", color = Color(0xff5DB075), fontSize = 16.sp, fontFamily = interMedium)
        }

        Text(text = Title, fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, fontSize = 30.sp )

        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xfffffff))
        ) {
            Text(text = "Filter", color = Color(0xff5DB075), fontSize = 16.sp, fontFamily = interMedium)
        }
    }
}

@Preview
@Composable
fun asdasd(){
    chatScreen()
}