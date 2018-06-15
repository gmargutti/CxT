package Adapters

import Entity.Produto
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gustavo.cxt.R
import kotlinx.android.synthetic.main.simple_listitem.view.*

class ProdutosAdapter(private val list: ArrayList<Produto>, private val context: Context) :
        RecyclerView.Adapter<ProdutosAdapter.ViewHolder>()
{
    companion object
    {
        private lateinit var onClickListener: OnClickListener;
    }

    class ViewHolder(val listItem: View) : RecyclerView.ViewHolder(listItem), View.OnClickListener, View.OnLongClickListener
    {

        init
        {
            listItem.setOnClickListener(this);
            listItem.setOnLongClickListener(this);
        }

        override fun onClick(v: View?) {
            onClickListener.onClick(adapterPosition, v);
        }

        override fun onLongClick(v: View?): Boolean {
            onClickListener.onLongClick(adapterPosition, v);
            return true;
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item: View = LayoutInflater.from(parent.context).inflate(R.layout.itemProduto,
                parent, false);
        return ViewHolder(item);
    }

    override fun getItemCount(): Int {
        return list.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position];
        holder.listItem.txtNome.text = currentItem.nome;
        holder.listItem.txtDtInicio.text = currentItem.dataInicio;
    }

    fun setOnItemClickListener(listener: ProdutosAdapter.OnClickListener)
    {
        onClickListener = listener;
    }

    interface OnClickListener
    {
        fun onClick(position: Int, v: View?);
        fun onLongClick(position: Int, v: View?);
    }
}