package CustomWatchers

import android.text.Editable

class DecimalWatcher : AbstractCustomWatcher()
{
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        var regex = Regex("""^\d*$|^\d+\.\d{1,2}$""");
        var match = regex.find(s ?: "");
        var currentChar: CharSequence? = s?.subSequence(start, start + count);
        allowChange = if (match != null || currentChar.toString() == "." || s?.substring(s?.length - 1, s?.length) == ".") true else false;
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        oldValue = s.toString();
    }

    override fun afterTextChanged(s: Editable?) {
        if(!allowChange)
        {
            s?.replace(0, s?.length, oldValue)
        }
    }

}