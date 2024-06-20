import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ViewModelSign: ViewModel() {
    //TESTE
    private val _count = mutableStateOf(0)
    val count: MutableState<Int> = _count
    fun increment(){
        count.value++
    }
    fun decrement(){
        count.value--
    }


    //SIGN SCREEN VAR
    private val _checked = mutableStateOf(true)
    private val _inputString = mutableStateOf("")
    private val _inputStringPassword = mutableStateOf("")
    private val _passwordVisibleCheck = mutableStateOf(false)


    val checked: MutableState<Boolean> = _checked
    val inputString: MutableState<String> = _inputString
    val inputStringPassword: MutableState<String> = _inputStringPassword
    val passwordVisibleCheck: MutableState<Boolean> = _passwordVisibleCheck

    //SIGN SCREEN
//    fun CheckedBoxSignal(){
//        !checked.value
//    }

    fun inputStringSignal(){

    }

    fun inputPasswordSignal(){

    }


}