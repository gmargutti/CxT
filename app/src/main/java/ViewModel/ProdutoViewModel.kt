package ViewModel

import CustomApplication.CustomApp
import Entity.Produto

class ProdutoViewModel
{
    companion object {
        private var dao = CustomApp.getDataBaseConnection().produtoDao();

        fun insert(produto: Produto, listProdutos: ArrayList<Produto>)
        {
            listProdutos.add(produto)
            dao.insert(produto);
        }

        fun getProduto(produto: Produto): Produto
        {
            return dao.getProduto(produto.id);
        }

        fun delete(produto: Produto, listProdutos: ArrayList<Produto>)
        {
            listProdutos.remove(produto);
            dao.delete(produto);
        }

        fun getProdutoList(): ArrayList<Produto>
        {
            return ArrayList(dao.getProdutoList());
        }

        fun update(newProduto: Produto, oldProduto: Produto, listProdutos: ArrayList<Produto>)
        {
            listProdutos.set(listProdutos.indexOf(oldProduto), newProduto);
            dao.update(newProduto);
        }
    }
}