package com.example.primeiroprojeto

<<<<<<< HEAD
import com.example.primeiroprojeto.ViewModels.ViewModelClass
=======
>>>>>>> c718a34 (rebase joao)
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
<<<<<<< HEAD
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
=======
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
>>>>>>> c718a34 (rebase joao)
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
<<<<<<< HEAD
import androidx.compose.runtime.livedata.observeAsState
=======
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
>>>>>>> c718a34 (rebase joao)
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
<<<<<<< HEAD
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
=======
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
>>>>>>> c718a34 (rebase joao)
import com.example.primeiroprojeto.ui.theme.PrimeiroProjetoTheme
import com.example.primeiroprojeto.ui.theme.grayPrimary
import com.example.primeiroprojeto.ui.theme.greenPrimary
import com.example.primeiroprojeto.ui.theme.inputBackgroundColor
import com.example.primeiroprojeto.ui.theme.inputBorderColor


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClassesScreen(){
<<<<<<< HEAD
    val scrollState = rememberScrollState()
    val viewModel: ViewModelClass = viewModel()
    val checkboxStates = viewModel.checkedClassBox.observeAsState(initial = emptyMap<Int, Boolean>())
    val allChecked = viewModel.areAllCkeckBoxesChecked()
=======
>>>>>>> c718a34 (rebase joao)
    Scaffold(
        topBar = { ClassesScreenTopAppBar() },
        bottomBar = { ClassesScreenBottomBar()},
    ) { innerPadding ->
        Column(
            modifier = Modifier
<<<<<<< HEAD
                .verticalScroll(scrollState) //Quando adiciona, o app fecha
                .fillMaxSize()
                .padding(innerPadding)

        ) {
            CustomClassesSearchInput(string = "Search")
            Post(classTitle = "Configurando o ambiente Java", classDescription = "Baixando e instalando as ferramentas necessarias", classTime = "51m ago", classId = 1, isChecked = checkboxStates.value[1] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(1, isChecked)})
            Post(classTitle = "Variaveis em Java", classDescription = "Conheça as variaveis que iremos usar", classTime = "39m ago", classId = 2, isChecked = checkboxStates.value[2] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(2, isChecked)})
            Post(classTitle = "Funcoes em Java", classDescription = "Aprenda a usar funcoes em Java", classTime = "4m ago", classId = 3, isChecked = checkboxStates.value[3] ?: false, onCheckedChange = {isChecked -> viewModel.onCheckBoxClicked(3, isChecked)})
            Spacer(modifier = Modifier.height(12.dp))
            finishCourseButton()
            /*
            if (allChecked){
            }else{
                Text(text = "Conclua todas as aulas primeiro")
            }

             */
=======
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            CustomClassesSearchInput(string = "Search")
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(3){
                    Post()
                }
            }
>>>>>>> c718a34 (rebase joao)
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
<<<<<<< HEAD
        finishCourseButton()
=======
        ClassesScreen()
>>>>>>> c718a34 (rebase joao)
    }
}

@Composable
fun ClassesScreenTopAppBar() {
<<<<<<< HEAD
    val customFontFamily500 = FontFamily(Font(R.font.inter_semibold))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .systemBarsPadding()
                .padding(top = 15.dp, start = 8.dp, end = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ClickableText(
                text = AnnotatedString(
                    text = stringResource(id = R.string.classes_screen_topbar_back),
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            item = SpanStyle(
                                color = greenPrimary
                            ),
                            start = 0,
                            end = 4,
                        )
                    )
                )
            ) {
            }

            Text(
                text = stringResource(id = R.string.classes_screen_topbar_name),
                color = Color.Black,
                fontFamily = customFontFamily500,
                fontSize = 24.sp
            )

            ClickableText(
                text = AnnotatedString(
                    text = stringResource(id = R.string.classes_screen_topbar_filter),
                    spanStyles = listOf(
                        AnnotatedString.Range(
                            item = SpanStyle(
                                color = greenPrimary
                            ),
                            start = 0,
                            end = 6,
                        )
                    )
                )
            ) {

            }
=======
    val CustomFontFamily500 = FontFamily(Font(R.font.inter_semibold))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding()
            .padding(top = 15.dp, start = 8.dp, end = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        ClickableText(
            text = AnnotatedString(
                text = stringResource(id = R.string.classes_screen_topbar_back),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        item = SpanStyle(
                            color = greenPrimary
                        ),
                        start = 0,
                        end = 4,
                    )
                )
            )
        ) {
        }

        Text(
            text = stringResource(id = R.string.classes_screen_topbar_name),
            color = Color.Black,
            fontFamily = CustomFontFamily500,
            fontSize = 24.sp
        )

        ClickableText(
            text = AnnotatedString(
                text = stringResource(id = R.string.classes_screen_topbar_filter),
                spanStyles = listOf(
                    AnnotatedString.Range(
                        item = SpanStyle(
                            color = greenPrimary
                        ),
                        start = 0,
                        end = 6,
                    )
                )
            )
        ) {

>>>>>>> c718a34 (rebase joao)
        }
    }
}

@Composable
fun ClassesScreenBottomBar(){
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
            CircularBottomButton(greenPrimary)
            repeat(4){
                CircularBottomButton(inputBorderColor)
            } //pode usar isso para repetir algo varias vezes


        }
    }
}

@Composable
fun CircularBottomButton(color: Color){
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

<<<<<<< HEAD
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


=======
@Composable
fun Post(){
>>>>>>> c718a34 (rebase joao)
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
<<<<<<< HEAD
            text = title,
=======
            text = stringResource(id = R.string.classes_screen_class_title),
>>>>>>> c718a34 (rebase joao)
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
<<<<<<< HEAD
            text = description,
=======
            text = stringResource(id = R.string.classes_screen_class_description),
>>>>>>> c718a34 (rebase joao)
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
<<<<<<< HEAD
            text = time,
=======
            text = stringResource(id = R.string.classes_screen_class_time),
>>>>>>> c718a34 (rebase joao)
            color = grayPrimary,
            fontFamily = FontFamily(Font(R.font.inter_semibold)),
            fontSize = 14.sp
        )
<<<<<<< HEAD
        Spacer(modifier = Modifier.height(8.dp))

        //check button
        Row(
            modifier = Modifier.padding(top = 5.dp, bottom = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { onCheckedChange(it) },
                colors = checkboxColors,
            )
            Text(
                text = stringResource(
                    id = R.string.classes_screen_class_check
                ),
                color = Color.Black,
            )
        }
=======
>>>>>>> c718a34 (rebase joao)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomClassesSearchInput(string: String) {
<<<<<<< HEAD
    val inputViewModelClass = viewModel<ViewModelClass>()
=======
    var texto by remember {
        mutableStateOf("")
    }
    var novoTexto = remember {
        mutableStateOf(TextFieldValue())
    }
>>>>>>> c718a34 (rebase joao)

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 16.dp, start = 8.dp, end = 8.dp),
        shape = RoundedCornerShape(50.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = inputBorderColor,
            focusedBorderColor = inputBorderColor,
            containerColor = inputBackgroundColor
        ),
<<<<<<< HEAD
        value = inputViewModelClass.inputStringClass.value,
        onValueChange = { inputViewModelClass.inputStringClass.value = it },
=======
        value = novoTexto.value,
        onValueChange = { novoTexto.value = it },
>>>>>>> c718a34 (rebase joao)
        label = {
            Text(
                text = string,
                color = grayPrimary
            )
        },
        singleLine = true
    )
<<<<<<< HEAD
}

@Composable
fun finishCourseButton(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(colors = ButtonDefaults.buttonColors(greenPrimary),
            onClick = { /*TODO: AÇAO PARA CONCLUIR O CURSO*/ },
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(text = "Concluir curso")
        }
    }
=======
>>>>>>> c718a34 (rebase joao)
}