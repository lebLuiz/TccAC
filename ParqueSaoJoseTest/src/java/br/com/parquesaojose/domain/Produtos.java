package br.com.parquesaojose.domain;

import java.awt.image.BufferedImage;

public class Produtos {
    
    private Long idProduto;
    private String produto;
    private double valor;
    //private byte[] imagem;
    private Empresas empresa;
    
    //Método Construtor
    public Produtos(){
        
    }

    //Get e Set de Código do Produto
    public Long getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    //Get e Set do Produto
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }

    //Get e Set do Valor do Produto
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    //Get e Set da Imagem do Produto
    /*public byte[] getImagem() {
        return imagem;
    }
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }*/

    //Get e Set da Empresa(Outra Tabela)
    public Empresas getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
    
    
}
