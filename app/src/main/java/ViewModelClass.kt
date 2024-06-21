import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelClass: ViewModel() {
    private val _inputStringClass = mutableStateOf("")
    val inputStringClass: MutableState<String> = _inputStringClass

    private val _checkedClassBox = mutableStateOf(false)
    val checkedClassBox: MutableState<Boolean> = _checkedClassBox

}