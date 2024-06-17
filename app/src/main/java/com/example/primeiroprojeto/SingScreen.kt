package com.example.primeiroprojeto

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.grayPrimary
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBackgroundColor
import com.example.primeiroprojeto.ui.theme.inputBorderColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignScreen() {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .padding(8.dp)
        ) {
            TopAppBar(title = { SignScreenTopAppBar() })
            CustomSignInput("Name")
            CustomSignInput("Email")
            CustomSignInputPassword("Password")
            CustomCheckBox()
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SignScreenPreview() {
    PrimeiroProjetoTheme {
        SignScreen()

    }
}

@Composable
fun SignScreenTopAppBar() {
    val CustomFontFamily500 = FontFamily(Font(R.font.inter_semibold))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = null,
            tint = grayPrimary
        )

        Text(
            text = stringResource(id = R.string.sign_screen_topbar_name),
            color = Color.Black,
            fontFamily = CustomFontFamily500
        )

        ClickableText(
            text = AnnotatedString(
                text = stringResource(id = R.string.sign_screen_topbar_login),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        item = SpanStyle(
                            color = greenPrimary
                        ),
                        start = 0,
                        end = 5,
                    )
                )
            )
        ) {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSignInput(string: String) {
    var texto by remember {
        mutableStateOf("")
    }
    var novoTexto = remember {
        mutableStateOf(TextFieldValue())
    }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = novoTexto.value,
        onValueChange = { novoTexto.value = it },
        label = {
            Text(
                text = string,
                color = grayPrimary
            )
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSignInputPassword(string: String) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = {
            Text(
                text = string,
                color = grayPrimary
            )
        },
        trailingIcon = {
            ClickableText(
                modifier = Modifier.padding(end = 15.dp),
                text = AnnotatedString("Show"),
                onClick = { passwordVisible = !passwordVisible },
                style = LocalTextStyle.current.copy(color = greenPrimary)
            )

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),

        )
}

@Composable
fun CustomCheckBox() {
    var checked by remember {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
    ) {
        Checkbox(checked = !checked,
            onCheckedChange = { checked = it },
            )
        /*colors = CheckboxColors(
            //TODO
        )
        */
        Text(modifier = Modifier,
            text = stringResource(id = R.string.sign_screen_check_box),)
    }
}




//TODO: FAZER CHECKBOX STYLE AND FINISH sign screen, fazer aulas screen