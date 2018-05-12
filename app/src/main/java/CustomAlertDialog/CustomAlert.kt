package CustomAlertDialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface

class CustomAlert() : AlertDialog(CustomGlobal.context)
{
    fun show(title: String, message: String): Boolean {
        var r: Boolean = false;
        Builder(CustomGlobal.context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                    r = true;
                })
                .setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->
                    r = false;
                })
                .show();
        return r;
    }
}