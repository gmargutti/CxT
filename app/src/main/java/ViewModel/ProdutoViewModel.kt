package ViewModel

import DataBase.DatabaseConnection
import Entity.Produto

class ProdutoViewModel
{
    companion object {
        private var dao = DatabaseConnection.getDB().produtoDao();
        @JvmStatic
        fun insert(produto: Produto)
        {
            dao.insert(produto);
            CustomGlobal.listProdutos.add(produto);
        }

        @JvmStatic
        fun getProduto(produto: Produto): Produto
        {
            return dao.getProduto(produto.id);
        }

        @JvmStatic
        fun delete(produto: Produto)
        {

        }

        @JvmStatic
        fun getProdutoList(): ArrayList<Produto>
        {
            return ArrayList(dao.getProdutoList());
        }

        @JvmStatic
        fun update(newProduto: Produto, oldProduto: Produto)
        {

        }
    }
}