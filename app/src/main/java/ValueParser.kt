import android.text.Editable
import android.text.InputType
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*

class ValueParser
{
    companion object
    {
//        fun getValue(text: EditText) : Any?
//        {
//            var value: Any? = null;
//            var valueString: String = text.toString();
//            when(text.inputType)
//            {
//                InputType.TYPE_NUMBER_VARIATION_NORMAL -> value = if(valueString == "") 0 else valueString.toInt();
//                InputType.TYPE_NUMBER_FLAG_DECIMAL -> value = if(text.toString() == "") 0 else valueString.toDouble();
//                InputType.TYPE_CLASS_DATETIME -> value = if(text.toString() == "") null else SimpleDateFormat("dd/MM/yyyy").parse(valueString);
//            }
//            return value;
//        }
        fun getInt(value: String): Int
        {
            return if(value == "") 0 else value.toInt();
        }
        fun getDouble(value: String): Double
        {
            return if(value == "") 0.0 else value.toDouble();
        }
        fun getDate(value: String): Date?
        {
            return if(value == "") null else SimpleDateFormat("dd/MM/yyyy").parse(value);
        }
    }
}