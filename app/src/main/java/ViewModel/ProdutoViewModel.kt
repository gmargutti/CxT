package ViewModel

import DataBase.DatabaseConnection
import Entity.Produto

class ProdutoViewModel
{
    companion object {
        private var dao = DatabaseConnection.getDB().produtoDao();

        fun insert(produto: Produto)
        {
            CustomGlobal.listProdutos.add(produto)
            dao.insert(produto);
        }

        fun getProduto(produto: Produto): Produto
        {
            return dao.getProduto(produto.id);
        }

        fun delete(produto: Produto)
        {
            CustomGlobal.listProdutos.remove(produto);
            dao.delete(produto);
        }

        fun getProdutoList(): ArrayList<Produto>
        {
            return ArrayList(dao.getProdutoList());
        }

        fun update(newProduto: Produto, oldProduto: Produto)
        {
            val list = CustomGlobal.listProdutos;
            list.set(list.indexOf(oldProduto), newProduto);
            dao.update(newProduto);
        }
    }
}