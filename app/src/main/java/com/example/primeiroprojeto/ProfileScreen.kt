package com.example.primeiroprojeto

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBorderColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(){
    Scaffold(
        topBar = { ProfileScreenTopAppBar() },
        bottomBar = { ProfileScreenBottomBar() },
    ) {  innerPadding ->

    }
}



@Preview(showBackground = true,
    showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    PrimeiroProjetoTheme {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreenTopAppBar() {
    val CustomFontFamily500 = FontFamily(Font(R.font.inter_semibold))
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .background(greenPrimary)
            .height(200.dp)
        

    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = greenPrimary)
                .padding(top = 15.dp, bottom = 15.dp, start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ClickableText(
                text = AnnotatedString(
                    text = stringResource(id = R.string.profile_screen_topbar_settings),
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            item = SpanStyle(
                                color = Color.White
                            ),
                            start = 0,
                            end = 8,
                        )
                    )
                )
            ) {
            }

            Text(
                text = stringResource(id = R.string.profile_screen_topbar_name),
                color = Color.White,
                fontFamily = CustomFontFamily500,
                fontSize = 24.sp
            )

            ClickableText(
                text = AnnotatedString(
                    text = stringResource(id = R.string.profile_screen_topbar_logout),
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            item = SpanStyle(
                                color = Color.White
                            ),
                            start = 0,
                            end = 6,
                        )
                    )
                )
            ) {

            }
        }
        ProfileScreenImage()
    }
}


@Composable
fun ProfileScreenImage(){
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Card(shape = CircleShape,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp),
        ) {
           Image(
               painter = painterResource(
                   id = R.drawable.profileimage
               ),
               contentDescription = null,
               modifier = Modifier
                   .fillMaxSize()

                   .clickable {  },

               contentScale = ContentScale.Fit
           )
        }

    }
}



@Composable
fun ProfileScreenBottomBar(){
    BottomAppBar (
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = inputBorderColor),
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileCircularBottomButton(greenPrimary)
            repeat(4){
                ProfileCircularBottomButton(inputBorderColor)
            } //pode usar isso para repetir algo varias vezes
        }
    }
}

@Composable
fun ProfileCircularBottomButton(color: Color){
    Button(
        onClick = {/*TODO*/},
        modifier = Modifier
            .size(50.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ){
        /* Pode adicionar text no button por aqui*/
    }
}

