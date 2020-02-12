package br.com.parquesaojose.domain;

public class EmpresasT {
    
    private Long idEmpresa;
    private String razaoSocial;
    private String nomeFantasia;
    private String categoria;
    private String cnpj;
    private String telefone;
    private String email;
    private String dataFundacao;
    private String horaAberto;
    private String horaFechado;
    private String nomeRua;
    private int numeroRua;
    private String responsavel;
    private int quantFuncionarios;
    
    
    public EmpresasT(){
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String nomeEmpresa) {
        this.razaoSocial = nomeEmpresa;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
