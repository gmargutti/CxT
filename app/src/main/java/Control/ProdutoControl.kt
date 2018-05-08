package Control

import DAO.ProdutoDAO
import Entity.Produto

class ProdutoControl{
    companion object {
        @JvmStatic
        fun insert(produto: Produto)
        {
            ProdutoDAO.insert(produto);
        }

        @JvmStatic
        fun select(produto: Produto)
        {

            ProdutoDAO.select(produto);
        }

        @JvmStatic
        fun delete(produto: Produto)
        {

            ProdutoDAO.delete(produto);
        }

        @JvmStatic
        fun getList(list: ArrayList<Produto>? = null)
        {

        }

        @JvmStatic
        fun update(newProduto: Produto, oldProduto: Produto)
        {

        }
    }
}