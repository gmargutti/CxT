package Adapters

import Entity.Produto
import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.gustavo.cxt.R
import java.text.SimpleDateFormat

class ProdutosAdapter(private val list: ArrayList<Produto>, private val act: Activity): BaseAdapter()
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View
    {
        var view: View = act.layoutInflater.inflate(CustomGlobal.ListView_item, parent, false);
        var txt = view.findViewById<TextView>(R.id.txtNome);
        var item = getItem(position);
        txt.text = item.nome;
        txt = view.findViewById(R.id.txtDtInicio);
        txt.text = item.dataInicio;
        item.viewIndex = position;
        return view;
    }

    override fun getItem(position: Int): Produto
    {
        return list.get(position);
    }

    override fun getItemId(position: Int): Long
    {
        return 0;
    }

    override fun getCount(): Int
    {
        return list.count();
    }
}