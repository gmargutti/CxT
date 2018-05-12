package ViewModel

import DataBase.DatabaseConnection
import Entity.Produto

class ProdutoViewModel
{
    companion object {
        private var dao = DatabaseConnection.getDB().produtoDao();

        fun insert(produto: Produto)
        {
            dao.insert(produto);
            if(produto.viewIndex == -1)
                CustomGlobal.listProdutos.add(produto)
            else
                CustomGlobal.listProdutos.set(produto.viewIndex, produto);
        }

        fun getProduto(produto: Produto): Produto
        {
            return dao.getProduto(produto.id);
        }

        fun delete(produto: Produto)
        {
            dao.delete(produto);
        }

        fun getProdutoList(): ArrayList<Produto>
        {
            return ArrayList(dao.getProdutoList());
        }

        fun update(newProduto: Produto, oldProduto: Produto)
        {

        }
    }
}