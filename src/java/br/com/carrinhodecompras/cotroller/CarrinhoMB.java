package br.com.carrinhodecompras.cotroller;

import br.com.carrinhodecompras.domain.Carrinho;
import br.com.carrinhodecompras.domain.Produto;
import br.com.carrinhodecompras.util.UtilMessages;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "carrinhoMB")
@SessionScoped
public class CarrinhoMB {
    FacesContext context = FacesContext.getCurrentInstance();
    
    private List<Produto> produtos = new ArrayList<>();
    private Carrinho carrinho = new Carrinho();
    private float soma = 0;
    
    public CarrinhoMB() {
        
    }
    
    
    public String somar(Produto produto){
       
        for(Produto p: produtos){
            soma = soma + p.getPreco();
        }
        return "pagamento.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String finalizar (){
        
        if(soma == 0){
           UtilMessages.messageInfo("Não há produtos no carrinho");
        }else
            UtilMessages.messageInfo("Compra efetuada com sucesso");
            soma = 0;
            carrinho.clear();
        
        return "list.xhtml?faces-redirect=true";
    }
    
    
    public void adicionarCarrinho(Produto produto){
        
       if(produtos.add(produto)){
        carrinho.setProdutos(produtos);
            UtilMessages.messageInfo("Adicionado ao carrinho com sucesso!");
        }else{
            UtilMessages.messageError("Ocorreu um erro ao adicionar ao carrinho!");
       }
    }
     public void excluir(Produto produto){
        produtos.remove(produto);     
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public float getSoma() {
        return soma;
    }

    public void setSoma(float soma) {
        this.soma = soma;
    }

}
