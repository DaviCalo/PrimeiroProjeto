package com.example.primeiroprojeto


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.BottomAppBar
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.primeiroprojeto.ViewModels.ViewModelCurso
import com.example.primeiroprojeto.ViewModels.ViewModelSheet

@Composable
fun CursosScreem(onScreenChat: () -> Unit, onScreenProfile: () -> Unit){
    Scaffold(
        topBar = { Header("Cursos") },
        bottomBar = { ClassesScreenBottomBarCursos(onScreenChat, onScreenProfile) },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            InputSearch()
            ContainerCursos()
            MiniCards()
        }
    }
}

@Composable
fun Header(title: String){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))
    Row(
        Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(0.dp, 25.dp, 0.dp, 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xffffffff))
        ) {
            Text(text = "Back", color = Color(0xff5DB075), fontSize = 16.sp, fontFamily = interMedium)
        }

        Text(text = title, fontFamily = interSemiBlod, fontWeight = FontWeight.SemiBold, fontSize = 30.sp, color = Color.Black )

        Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color(0xffffffff))
        ) {
            Text(text = "Filter", color = Color(0xff5DB075), fontSize = 16.sp, fontFamily = interMedium)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputSearch(){
    val viewModelCursos = viewModel<ViewModelCurso>()
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))

    Row(
        Modifier
            .fillMaxWidth()
            .padding(0.dp, 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            shape = RoundedCornerShape(50),
            value =  viewModelCursos.search.value,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color(0xffE8E8E8),
                focusedBorderColor = Color(0xff5DB075),
                containerColor = Color(0xffF6F6F6),
            ),
            onValueChange = { viewModelCursos.search.value = it },
            singleLine = true,
            label = { Text("Search",fontFamily = interMedium, fontSize = 16.sp, fontWeight = FontWeight.Medium,color = Color(0xffBDBDBD))}
        )
    }
}

@Composable
fun ContainerCursos(){
    val nameCursos = arrayOf("Java", "kotlin", "Python", "Go")
    Column(
        Modifier.fillMaxWidth()
    ) {
        for (name in nameCursos){
            CardCursos(name)
        }
    }
}

@Composable
fun CardCursos(nameCurso: String){
    val interSemiBlod = FontFamily(Font(R.font.inter_semibold, FontWeight.SemiBold))
    val interMedium = FontFamily(Font(R.font.inter_medium, FontWeight.SemiBold))
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray)
                .width(50.dp)
                .height(50.dp)
        )
        Column(
            Modifier.width(300.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = nameCurso, fontFamily = interSemiBlod, fontSize = 16.sp, color = Color.Black)
                Text(text = "8m ago", fontFamily = interMedium, fontSize = 16.sp, color = Color(0xffBDBDBD))
            }
            Text(text = "Pellentesque eget urna sit amet lacus rutrum placerat ac vel mi.", fontFamily = interMedium, fontSize = 14.sp, color = Color.Gray)
//          HorizontalDivider(color = Color.Blue, thickness = 2.dp)
        }
    }
}

@Composable
fun MiniCards(){
    Column(
        Modifier.fillMaxWidth().padding(15.dp,0.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(4){
            Box(
                modifier = with (Modifier){
                    height(227.dp)
                    .padding(0.dp, 15.dp)
                    .width(357.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .background(Color.Green)
                }
            ) {}
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCursp(){
    CursosScreem( {}, {} )
}

@Composable
fun ClassesScreenBottomBarCursos(onScreenChat: () -> Unit, onScreenProfile: () -> Unit){
    val loginViewModel = viewModel<ViewModelSheet>()
    if (loginViewModel.Sheet.value) {
        BottomSheet {
            loginViewModel.Sheet.value = false
        }
    }
    fun asd(){loginViewModel.Sheet.value = true}
    BottomAppBar (
        modifier = Modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = Color.White),
        containerColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CircularBottomButton(Color.Green) {}
            CircularBottomButton(Color.Gray) { asd() }
            CircularBottomButton(Color.Gray, onScreenChat)
            CircularBottomButton(Color.Gray,onScreenProfile)
        }
    }
}

@Composable
fun CircularBottomButton(color: Color, onScreen: () -> Unit){
    Button(
        onClick = { onScreen() },
        modifier = Modifier.size(50.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = color)
    ){
        /* Pode adicionar text no button por aqui*/
    }
}