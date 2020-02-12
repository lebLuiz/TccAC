package br.com.parquesaojose.domain;

public class Contatos {
    
    private Long idContato;
    private Empresas empresa;
    private String tipoContato;
    private String contato;
    
    
    //Método Construtor
    public Contatos(){
        
    }

    //Get e Set de Código do Contato
    public Long getIdContato() {
        return idContato;
    }
    public void setIdContato(Long idContato) {
        this.idContato = idContato;
    }

    //Get e Set do Tipo do Contato
    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }
    
    //Get e Set do Contato
    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    //Get e Set da Empresa
    public Empresas getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresas empresa) {
        this.empresa = empresa;
    }
    
    
}
