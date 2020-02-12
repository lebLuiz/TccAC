package br.com.parquesaojose.domain;

import java.awt.image.BufferedImage;
import java.time.LocalDate;

public class Noticias {
    
    private Long idNoticia;
    private String titulo;
    private LocalDate dataPublicacao;
    private String noticia;
    //private byte[] imagem;
    private Empresas empresa;
    
    //Método Construtor
    public Noticias(){
        
    }

    //Get e Set do Código da Noticia
    public Long getIdNoticia() {
        return idNoticia;
    }
    public void setIdNoticia(Long idNoticia) {
        this.idNoticia = idNoticia;
    }

    //Get e Set do Titulo da Noticia
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    //Get e Set da Publicação da Noticia
    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    //Get e Set da Descrição da Noticia
    public String getNoticia() {
        return noticia;
    }
    public void setNoticia(String noticia) {
        this.noticia = noticia;
    }

    //Get e Set da Imagem da Noticia
    /*public byte[] getImagem() {
        return imagem;
    }
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }*/

    //Get e Set da Empresa
    public Empresas getEmpresa() {
        return empresa;
    }
    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
    
    
}
