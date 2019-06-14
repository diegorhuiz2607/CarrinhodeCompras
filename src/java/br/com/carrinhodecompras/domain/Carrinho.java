package br.com.carrinhodecompras.domain;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public Carrinho(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
