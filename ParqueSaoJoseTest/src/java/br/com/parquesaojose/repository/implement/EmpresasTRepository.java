package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.domain.EmpresasT;
import br.com.parquesaojose.repository.interfaces.IEmpresasRepository;
import br.com.parquesaojose.repository.interfaces.IEmpresasTRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresasTRepository implements IEmpresasTRepository{
    
    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";

    @Override
    public EmpresasT save(EmpresasT empresasT) {
        
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasTRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into empresast (ds_nome_empresa, ds_nome_fantasia, ds_categoria, ds_cnpj, ds_telefone, ds_email, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            ps.setString(1, empresasT.getRazaoSocial());
            ps.setString(2, empresasT.getNomeFantasia());
            ps.setString(3, empresasT.getCategoria());
            ps.setString(4, empresasT.getCnpj());
            ps.setString(5, empresasT.getTelefone());
            ps.setString(6, empresasT.getEmail());
            ps.setString(7, empresasT.getDataFundacao());
            ps.setString(8, empresasT.getHoraAberto());
            ps.setString(9, empresasT.getHoraFechado());
            ps.setString(10, empresasT.getNomeRua());
            ps.setInt(11, empresasT.getNumeroRua());
            ps.setString(12, empresasT.getResponsavel());
            ps.setInt(13, empresasT.getQuantFuncionarios());
            
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasTRepository");
        }
        
        return empresasT;
        
    }

    @Override
    public EmpresasT update(EmpresasT empresasT) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe EmpresasTRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("update empresast set ds_nome_empresa=?, ds_nome_fantasia=?, ds_categoria=?, ds_cnpj=?, ds_telefone=?, ds_email=?, dt_fundacao=?, hr_aberto=?, hr_fechado=?, ds_rua=?, nr_rua=?, ds_responsavel=?, quant_funcionarios=? where id_empresa=?");
            
            
            ps.setString(1, empresasT.getRazaoSocial());
            ps.setString(2, empresasT.getNomeFantasia());
            ps.setString(3, empresasT.getCategoria());
            ps.setString(4, empresasT.getCnpj());
            ps.setString(5, empresasT.getTelefone());
            ps.setString(6, empresasT.getEmail());
            ps.setString(7, empresasT.getDataFundacao());
            ps.setString(8, empresasT.getHoraAberto());
            ps.setString(9, empresasT.getHoraFechado());
            ps.setString(10, empresasT.getNomeRua());
            ps.setInt(11, empresasT.getNumeroRua());
            ps.setString(12, empresasT.getResponsavel());
            ps.setInt(13, empresasT.getQuantFuncionarios());
            ps.setLong(14, empresasT.getIdEmpresa());
            
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasTRepository");
        }
        return empresasT;
        
    }

    @Override
    public void delete(Long idEmpresa) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasTRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from empresast where id_empresa=?");
        
            ps.setLong(1, idEmpresa);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasTRepository");
        }   
    }

    @Override
    public EmpresasT findOne(Long idEmpresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasTRepository");
        }
        
        EmpresasT empresasT = new EmpresasT();
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_empresa, ds_nome_empresa, ds_nome_fantasia, ds_categoria, ds_cnpj, ds_telefone, ds_email, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios from empresast where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                empresasT.setIdEmpresa(rs.getLong(1));
                empresasT.setRazaoSocial(rs.getString(2));
                empresasT.setNomeFantasia(rs.getString(3));
                empresasT.setCategoria(rs.getString(4));
                empresasT.setCnpj(rs.getString(5));
                empresasT.setTelefone(rs.getString(6));
                empresasT.setEmail(rs.getString(7));
                empresasT.setDataFundacao(rs.getString(8));
                empresasT.setHoraAberto(rs.getString(9));
                empresasT.setHoraFechado(rs.getString(10));
                empresasT.setNomeRua(rs.getString(11));
                empresasT.setNumeroRua(rs.getInt(12));
                empresasT.setResponsavel(rs.getString(13));
                empresasT.setQuantFuncionarios(rs.getInt(14));
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasTRepository");
        }
        return empresasT;
    }

    @Override
    public List<EmpresasT> findAll() {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe EmpesasTRepository");
        }
        List<EmpresasT> listaRetorno = new ArrayList();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_empresa, ds_nome_empresa, ds_nome_fantasia, ds_categoria, ds_cnpj, ds_telefone, ds_email, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios from empresast order by id_empresa");
        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                EmpresasT empresas = new EmpresasT();
                
                empresas.setIdEmpresa(rs.getLong(1));
                empresas.setRazaoSocial(rs.getString(2));
                empresas.setNomeFantasia(rs.getString(3));
                empresas.setCategoria(rs.getString(4));
                empresas.setCnpj(rs.getString(5));
                empresas.setTelefone(rs.getString(6));
                empresas.setEmail(rs.getString(7));
                empresas.setDataFundacao(rs.getString(8));
                empresas.setHoraAberto(rs.getString(9));
                empresas.setHoraFechado(rs.getString(10));
                empresas.setNomeRua(rs.getString(11));
                empresas.setNumeroRua(rs.getInt(12));
                empresas.setResponsavel(rs.getString(13));
                empresas.setQuantFuncionarios(rs.getInt(14));
                
                //empresas.setImagem(rs.getBytes(14));
                
                listaRetorno.add(empresas);
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasTRepository");
        }
        return listaRetorno;
        
    }

    
}
