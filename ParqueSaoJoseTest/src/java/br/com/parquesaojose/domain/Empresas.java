package br.com.parquesaojose.domain;

import java.awt.image.BufferedImage;
import java.sql.Time;
import java.time.LocalDate;

public class Empresas {
    
    private Long idEmpresa;
    private Usuarios usuario;
    private String nomeEmpresa;
    private String nomeFantasia;
    private String cnpj;
    private String categoria;
    private String dataFundacao;
    private String horaAberto;
    private String horaFechado;
    private String nomeRua;
    private int numeroRua;
    private String responsavel;
    private int quantFuncionarios;
    
    
    //private byte[] imagem;
    
    
    //Método Construtor
    public Empresas(){
        
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getHoraAberto() {
        return horaAberto;
    }

    public void setHoraAberto(String horaAberto) {
        this.horaAberto = horaAberto;
    }

    public String getHoraFechado() {
        return horaFechado;
    }

    public void setHoraFechado(String horaFechado) {
        this.horaFechado = horaFechado;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(int numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public int getQuantFuncionarios() {
        return quantFuncionarios;
    }

    public void setQuantFuncionarios(int quantFuncionarios) {
        this.quantFuncionarios = quantFuncionarios;
    }
    
    
}
