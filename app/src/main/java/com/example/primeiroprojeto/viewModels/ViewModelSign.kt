import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.regex.Pattern

class ViewModelSign: ViewModel() {
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
    val checked: MutableState<Boolean> = _checked

    private val _inputStringName = mutableStateOf("")
    val inputStringName: MutableState<String> = _inputStringName

    private val _inputStringEmail = MutableStateFlow("")
    val inputStringEmail: StateFlow<String> get() = _inputStringEmail


    private val _isEmailValid = MutableStateFlow(true)
    val isEmailValid: StateFlow<Boolean> get() = _isEmailValid

    private val _inputStringPassword = mutableStateOf("")
    val inputStringPassword: MutableState<String> = _inputStringPassword

    private val _passwordVisibleCheck = mutableStateOf(false)
    val passwordVisibleCheck: MutableState<Boolean> = _passwordVisibleCheck

    //SIGN SCREEN
//    fun CheckedBoxSignal(){
//        !checked.value
//    }

    private val EMAIL_ADDRESS_PATTERN: Pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    fun checkEmail(email: String): Boolean {
        return EMAIL_ADDRESS_PATTERN.matcher(email).matches()
    }

    fun onEmailChanged(newEmail: String){
        _inputStringEmail.value = newEmail
    }


    fun validateEmail(onScreenCurso: () -> Unit){
        val currentEmail = _inputStringEmail.value
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"
        _isEmailValid.value = currentEmail.matches(Regex(emailPattern))
        onScreenCurso()
    }

    fun inputStringSignal(){

    }

    fun inputPasswordSignal(){

    }



}