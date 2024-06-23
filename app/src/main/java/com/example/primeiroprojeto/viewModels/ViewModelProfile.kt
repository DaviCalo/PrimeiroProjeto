import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelProfile: ViewModel() {
    private val _doubleSwitchCursos = mutableStateOf(true)
    val doubleSwitchCursos: MutableState<Boolean> = _doubleSwitchCursos

    private val _doubleSwitchCertificados = mutableStateOf(false)
    val doubleSwitchCertificados: MutableState<Boolean> = _doubleSwitchCertificados


    private val _selectedIndex = mutableStateOf(0)
    val selectedIndex: State<Int> = _selectedIndex

    fun setSelectedIndex(index: Int){
        _selectedIndex.value = index
    }
}