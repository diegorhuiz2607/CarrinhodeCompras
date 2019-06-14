package br.com.carrinhodecompras.domain;

import java.io.Serializable;

public class Produto implements Serializable{
    
    private String titulo; 
    private float preco;

    public Produto() {
    }

    public Produto(String titulo) {
        this.titulo = titulo;
        
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }
 
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }           
}
