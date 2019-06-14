
package br.com.carrinhodecompras.cotroller;

import br.com.carrinhodecompras.domain.Produto;
import br.com.carrinhodecompras.util.UtilMessages;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "produtoMB")
@SessionScoped
public class ProdutoMB {
    
    private Produto produto;
    private List<Produto> produtos;

    public ProdutoMB() {
        produtos = new ArrayList<>();
    }
    
    public String cadastrar(){
        if(produtos.add(produto)){
            UtilMessages.messageInfo("Produto cadastrada com sucesso!");
            return "list.xhtml?faces-redirect=true";
        }else{
            UtilMessages.messageError("Ocorreu um erro ao cadastrar produto!");
            return null;
        }
    }
    
    public String alterar(Produto produto){
        this.produto = produto;
        return "list.xhtml?faces-redirect=true";
    }
    
    public void excluir(Produto produto){
        produtos.remove(produto);
    }
    
    public String carregarDados(Produto produto){
        this.produto = produto;
        System.out.println("ENTROU : " + produto.getTitulo());
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        produto = new Produto();
        return "new.xhtml?faces-redirect=true";
        
   }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
 
 }
  
