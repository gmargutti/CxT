package CustomListeners

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class DateListener(private val editor: TextView) : DatePickerDialog.OnDateSetListener
{
    private var calendar = Calendar.getInstance();
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        editor.text = SimpleDateFormat("dd/MM/yyyy").format(calendar.time);
    }

}