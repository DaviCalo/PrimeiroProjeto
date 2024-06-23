package com.example.primeiroprojeto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@Composable
fun CongratulationsScreen(onScreenCurso: () -> Unit){
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xff5DB075))
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Message(onScreenCurso)
        }
    }
}

@Composable
fun Message(onScreenCurso: () -> Unit){
    Column(
        Modifier
            .size(350.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MessageText()
        MessageButtons(onScreenCurso)
    }
}

@Composable
fun MessageText(){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))
    Column(
        Modifier.padding(25.dp, 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Parabéns!", fontFamily = interSemiBlod, fontSize = 30.sp)
        Text(text = "Consequat velit qui adipisicing sunt do reprehenderit ad laborum tempor ullamco exercitation. Ullamco tempor adipisicing et voluptate duis sit esse aliqua esse ex dolore esse. Consequat velit qui adipisicing sunt.",  textAlign = TextAlign.Center, fontFamily = interMedium, color = Color(0xff666666), fontSize = 14.sp)
    }
}

@Composable
fun  MessageButtons(onScreenCurso: () -> Unit){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    Column(
        Modifier.padding(25.dp, 10.dp).fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onScreenCurso() },
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(15.dp, 0.dp), colors = ButtonDefaults.buttonColors(
                Color(0xFF5DB075)
            )) {
            Text(text = "Certificado", fontFamily = interSemiBlod, color = Color.White)
        }
        Button(onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(15.dp, 0.dp), colors = ButtonDefaults.buttonColors(
                Color.Transparent
            )) {
            Text(text = "Voltar", fontFamily = interSemiBlod, color = Color(0xff5DB075))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Previer(){
    CongratulationsScreen({})
}