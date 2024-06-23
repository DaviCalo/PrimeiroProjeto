package com.example.primeiroprojeto

import ViewModelClass
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.grayPrimary
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBackgroundColor
import com.example.primeiroprojeto.ui.theme.inputBorderColor


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClassesScreen( onScreenChat: () -> Unit, onScreenProfile: () -> Unit, onScreenConclude: () -> Unit){
    val scrollState = rememberScrollState()
    val viewModel: ViewModelClass = viewModel()
    val checkboxStates = viewModel.checkedClassBox.observeAsState(initial = emptyMap<Int, Boolean>())
    val allChecked = viewModel.areAllCkeckBoxesChecked()
    Scaffold(
        topBar = { Header("Aulas") },
        bottomBar = { ClassesScreenBottomBarCursos(onScreenChat, onScreenProfile) },
        modifier = Modifier.systemBarsPadding()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState) //Quando adiciona, o app fecha
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp, 0.dp)
        ) {
            CustomClassesSearchInput(string = "Search")
            Post(classTitle = "Configurando o ambiente Java", classDescription = "Baixando e instalando as ferramentas necessarias", classTime = "51m ago", classId = 1, isChecked = checkboxStates.value[1] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(1, isChecked)})
//            Post(classTitle = "Variaveis em Java", classDescription = "Conheça as variaveis que iremos usar", classTime = "39m ago", classId = 2, isChecked = checkboxStates.value[2] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(2, isChecked)})
//            Post(classTitle = "Funcoes em Java", classDescription = "Aprenda a usar funcoes em Java", classTime = "4m ago", classId = 3, isChecked = checkboxStates.value[3] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(3, isChecked)})
            Spacer(modifier = Modifier.height(12.dp))

//            if (allChecked){
//                FinishCourseButton(onScreenConclude)
//            }else{
//                Text(text = "Conclua todas as aulas para ganhar o certificado", fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.inter_medium)))
//            }
        }
    }
}

//POSTS TODO: viewModel das check box e adicionar o botao final de conclusao do curso
@Composable
fun Post(classTitle: String, classDescription: String, classTime: String, classId: Int, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit){
    val title = classTitle
    val description = classDescription
    val time = classTime
    val id = classId


    val checkboxColors = CheckboxDefaults.colors(
        checkedColor = greenPrimary,
        uncheckedColor = Color.Black,
        checkmarkColor = Color.Black,
        disabledIndeterminateColor = Color.Transparent,
    )


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, start = 0.dp, end = 0.dp, bottom = 8.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.Gray)

        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = title,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = description,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            fontSize = 16.sp
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            //check button
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { onCheckedChange(it) },
                    colors = checkboxColors,
                )
                Text(
                    text = stringResource(id = R.string.classes_screen_class_check),
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    fontSize = 16.sp
                )
            }
            Text(
                text = time,
                color = grayPrimary,
                fontFamily = FontFamily(Font(R.font.inter_semibold)),
                fontSize = 14.sp
            )
        }
//        Spacer(modifier = Modifier.height(8.dp))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomClassesSearchInput(string: String) {
    val inputViewModelClass = viewModel<ViewModelClass>()

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 16.dp, start = 0.dp, end = 0.dp),
        shape = RoundedCornerShape(50.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
        value = inputViewModelClass.inputStringClass.value,
        onValueChange = { inputViewModelClass.inputStringClass.value = it },
        label = {
            Text(
                text = string,
                color = grayPrimary
            )
        },
        singleLine = true
    )
}

@Composable
fun FinishCourseButton(onScreenConclude: () -> Unit){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(colors = ButtonDefaults.buttonColors(greenPrimary),
            onClick = { onScreenConclude() },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Concluir curso")
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ClassesScreenPreview() {
    PrimeiroProjetoTheme {
        ClassesScreen({}, {}, {})
    }
}