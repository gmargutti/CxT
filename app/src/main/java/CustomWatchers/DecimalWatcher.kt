package CustomWatchers

import android.text.Editable
import android.text.TextWatcher

class DecimalWatcher : TextWatcher
{
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        val teste = "";
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        val teste = s;
    }

    override fun afterTextChanged(s: Editable?) {
        val teste = "";
    }

}