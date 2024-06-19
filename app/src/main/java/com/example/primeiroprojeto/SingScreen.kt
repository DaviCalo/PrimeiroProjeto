package com.example.primeiroprojeto

import com.example.primeiroprojeto.ViewModels.ViewModelSign
import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.grayPrimary
import com.example.primeiroprojeto.ui.theme.grayStringGCheckBox
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBackgroundColor
import com.example.primeiroprojeto.ui.theme.inputBorderColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignScreen() {
    val viewModel: ViewModelSign = viewModel()
    val isEmailValid by viewModel.isEmailValid.collectAsState()
    val context = LocalContext.current

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .systemBarsPadding()
                .padding(8.dp)
        ) {
            TopAppBar(title = { SignScreenTopAppBar() })
            CustomSignInputName()
            CustomSignInputEmail(viewModel)
            CustomSignInputPassword()
            CustomCheckBox()
            SignUpButton(onClick = { viewModel.validateEmail()})

            LaunchedEffect(isEmailValid) {
                if (!isEmailValid) {
                    Toast.makeText(context, "Email is invalid", Toast.LENGTH_SHORT).show()
                }
            }
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
    val customFontFamily500 = FontFamily(Font(R.font.inter_semibold))
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
            fontFamily = customFontFamily500,
            fontSize = 24.sp,
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
fun CustomSignInputName() {
    val stayInput = viewModel<ViewModelSign>()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = stayInput.inputStringName.value,
        onValueChange = { stayInput.inputStringName.value = it },
        label = {
            Text(
                text = "Name",
                color = grayPrimary
            )
        },
        singleLine = true
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSignInputEmail(viewModelSign: ViewModelSign) {
    val stayInput by viewModelSign.inputStringEmail.collectAsState()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = stayInput,
        onValueChange = { viewModelSign.onEmailChanged(it) },
        label = {
            Text(
                text = "Email",
                color = grayPrimary
            )
        },
        singleLine = true
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSignInputPassword() {
    val textFieldValue = viewModel<ViewModelSign>()
    val passwordVisible = viewModel<ViewModelSign>()

    OutlinedTextField(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp, bottom = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = textFieldValue.inputStringPassword.value,
        onValueChange = { textFieldValue.inputStringPassword.value = it },
        label = {
            Text(
                text = "Password",
                color = grayPrimary
            )
        },
        singleLine = true,
        trailingIcon = {
            if(!passwordVisible.passwordVisibleCheck.value){
                ClickableText(
                    modifier = Modifier.padding(end = 15.dp),
                    text = AnnotatedString("Show"),
                    onClick = { passwordVisible.passwordVisibleCheck.value = !passwordVisible.passwordVisibleCheck.value },
                    style = LocalTextStyle.current.copy(color = greenPrimary)
                )
            }else{
                ClickableText(
                    modifier = Modifier.padding(end = 15.dp),
                    text = AnnotatedString("Hide"),
                    onClick = { passwordVisible.passwordVisibleCheck.value = !passwordVisible.passwordVisibleCheck.value },
                    style = LocalTextStyle.current.copy(color = greenPrimary)
                )
            }
        },
        visualTransformation = if (passwordVisible.passwordVisibleCheck.value) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@Composable
fun CustomCheckBox() {
    val check = viewModel<ViewModelSign>()

    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = greenPrimary,
        uncheckedColor = inputBackgroundColor,
        checkmarkColor = inputBorderColor,
        disabledIndeterminateColor = Color.Transparent,
    )

    Row(
        modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
    ) {
        Checkbox(
            checked = check.checked.value,
            onCheckedChange = { check.checked.value = it },
            colors = checkboxColors,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = stringResource(
                id = R.string.sign_screen_check_box
            ),
            color = grayStringGCheckBox,
        )
    }
}

@Composable
fun SignUpButton(onClick: () -> Unit) {
    val viewModel: ViewModelSign = viewModel()
    Column (
        modifier = Modifier.padding(top = 20.dp, bottom = 10.dp)
    ) {
        Button(
            modifier = Modifier
                .height(51.dp)
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            onClick = { onClick },
            colors = ButtonDefaults.buttonColors(
                containerColor = greenPrimary,
                contentColor = Color.White
            ),
        ) {
            Text(text = stringResource(id = R.string.sign_screen_topbar_name))
        }
    }
}