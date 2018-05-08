package CustomWatchers

import android.text.TextWatcher
import android.widget.EditText

abstract class AbstractCustomWatcher : TextWatcher
{
    protected var oldValue: String? = "";
    protected var allowChange: Boolean = true
}