import Entity.Produto
import android.app.Activity
import android.content.Context
import com.example.gustavo.cxt.R
import java.util.*
import kotlin.collections.ArrayList

class CustomGlobal{
    companion object {
        var  listProdutos = ArrayList<Produto>();
        val ListView_item: Int = R.layout.simple_listitem;
        val calendarStyle = android.R.style.Theme_Holo_Light_Dialog;
        val appLocale = Locale("pt", "br");
        var context: Context? = null;
    }
}
