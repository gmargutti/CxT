package CustomListeners

import android.text.TextWatcher

abstract class AbstractCustomWatcher : TextWatcher
{
    protected var oldValue: String? = "";
    protected var allowChange: Boolean = true
}