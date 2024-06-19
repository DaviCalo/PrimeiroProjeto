package com.example.primeiroprojeto

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.grayPrimary
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBackgroundColor
import com.example.primeiroprojeto.ui.theme.inputBorderColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(){
    Scaffold(
        topBar = { ProfileScreenTopAppBar() },
        bottomBar = { ProfileScreenBottomBar() },
    ) {  innerPadding ->
        Column (modifier = Modifier){
            CustomComponent()
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview(){
    PrimeiroProjetoTheme {
        ProfileScreen()
    }
}

@Composable
fun ProfileScreenTopAppBar() {
    val customFontFamily500 = FontFamily(Font(R.font.inter_semibold))
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .background(greenPrimary)
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
                fontFamily = customFontFamily500,
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


@Composable
fun CustomComponent() {
    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(greenPrimary)
        ) {
            // White box
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(Color.White)
                    .align(Alignment.BottomCenter)
            )

            Image(
                painter = painterResource(id = R.drawable.profileimage),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.BottomCenter)
            )
        }
        Text(fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            text = stringResource(
                id = R.string.profile_screen_image_name
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()

        )
        Text(fontFamily = FontFamily(Font(R.font.inter_semibold)),
            textAlign = TextAlign.Center,
            text = stringResource(
                id = R.string.profile_screen_image_mantra
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
        )
        //switch button
        DoubleSwitchButton()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(3){
                PostProfile()
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun PostProfile(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.classes_screen_class_title),
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.classes_screen_class_description),
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(id = R.string.classes_screen_class_time),
            color = grayPrimary,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 14.sp
        )
    }
}

//TENTATIVAS DE SWITCH ---------------------------------------------------------------------------------------------------
@Composable
fun DoubleSwitchButton(){
    var selectedIndex by remember {
        mutableStateOf(0)
    }

    Row(
        modifier = Modifier
            .padding(16.dp)
            .border(1.dp, color = inputBorderColor, RoundedCornerShape(50)),
    ){
        Button(
            onClick = {selectedIndex = 0},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedIndex == 0) MaterialTheme.colorScheme.surface else inputBackgroundColor,
                contentColor = if (selectedIndex == 0) greenPrimary else grayPrimary,
            ),
            shape = RoundedCornerShape(50)
        ){
            Text(text = "Cursos")
        }

        Button(
            onClick = {selectedIndex = 1},
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (selectedIndex == 1) MaterialTheme.colorScheme.surface else inputBackgroundColor,
                contentColor = if (selectedIndex == 1) greenPrimary else grayPrimary,
            ),
            shape = RoundedCornerShape(50)
        ){
            Text(text = "Aulas")
        }
    }

}
