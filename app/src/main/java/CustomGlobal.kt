import Entity.Produto
import com.example.gustavo.cxt.R

class CustomGlobal{
    companion object {
        var listProdutos: ArrayList<Produto>? = null;
        val ListView_item: Int = R.layout.simple_listitem;
    }
}