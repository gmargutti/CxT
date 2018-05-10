package CustomListeners

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.view.View
import android.widget.TextView
import java.util.*

class DatePicker(private val context: Context) : View.OnClickListener
{
    override fun onClick(v: View?) {
        val calendar = Calendar.getInstance();
        DatePickerDialog(context, CustomGlobal.calendarStyle, DateListener(v as TextView), calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }
}