package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.repository.interfaces.IEmpresasRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmpresasRepository implements IEmpresasRepository{
    
    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";

    @Override
    public Empresas save(Empresas empresas) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe EmpresasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into empresas (id_usuario, ds_nome_empresa, ds_nome_fantasia, ds_cnpj, ds_categoria, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios) values (?,?,?,?,?,?,?,?,?,?,?,?)");
            
            ps.setLong(1, empresas.getUsuario().getIdUsuario());
            ps.setString(2, empresas.getNomeEmpresa());
            ps.setString(3, empresas.getNomeFantasia());
            ps.setString(4, empresas.getCnpj());
            ps.setString(5, empresas.getCategoria());
            ps.setString(6, empresas.getDataFundacao());
            ps.setString(7, empresas.getHoraAberto());
            ps.setString(8, empresas.getHoraFechado());
            ps.setString(9, empresas.getNomeRua());
            ps.setInt(10, empresas.getNumeroRua());
            ps.setString(11, empresas.getResponsavel());
            ps.setInt(12, empresas.getQuantFuncionarios());
            
            
            //ps.setBytes(13, empresas.getImagem());
            //INCOMPLETOOOOOOOO!!!!!!!!!!!!!
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        return empresas;
        
    }

    @Override
    public Empresas update(Empresas empresas) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe EmpresasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("update empresas set id_usuario=?, ds_nome_empresa=?, ds_nome_fantasia=?, ds_cnpj=?, ds_categoria=?, dt_fundacao=?, hr_aberto=?, hr_fechado=?, ds_rua=?, nr_rua=?, ds_responsavel=?, quant_funcionarios=? where id_empresa=?");
            
            ps.setLong(1, empresas.getUsuario().getIdUsuario());
            ps.setString(2, empresas.getNomeEmpresa());
            ps.setString(3, empresas.getNomeFantasia());
            ps.setString(4, empresas.getCnpj());
            ps.setString(5, empresas.getCategoria());
            ps.setString(6, empresas.getDataFundacao());
            ps.setString(7, empresas.getHoraAberto());
            ps.setString(8, empresas.getHoraFechado());
            ps.setString(9, empresas.getNomeRua());
            ps.setInt(10, empresas.getNumeroRua());
            ps.setString(11, empresas.getResponsavel());
            ps.setInt(12, empresas.getQuantFuncionarios());
            ps.setLong(13, empresas.getIdEmpresa());
            
            
            //ps.setBytes(13, empresas.getImagem());
            
            ps.setLong(13, empresas.getIdEmpresa());
            
            ps.executeUpdate();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        return empresas;
    }

    @Override
    public void delete(Long idEmpresa) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Econtrado. Classe EmpresasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete id_usuario, ds_nome_empresa, ds_nome_fantasia, ds_cnpj, ds_categoria, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios empresas where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
    }

    @Override
    public Empresas findOne(Long idEmpresa) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Econtrado. Classe EmpresasRepository");
        }
        Empresas empresas = new Empresas();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_empresa, id_usuario, ds_nome_empresa, ds_nome_fantasia, ds_cnpj, ds_categoria, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios from empresas where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                empresas.setIdEmpresa(rs.getLong(1));
                empresas.getUsuario().setIdUsuario(rs.getLong(2));
                empresas.setNomeEmpresa(rs.getString(3));
                empresas.setNomeFantasia(rs.getString(4));
                empresas.setCnpj(rs.getString(5));
                empresas.setCategoria(rs.getString(6));
                empresas.setDataFundacao(rs.getString(7));
                empresas.setHoraAberto(rs.getString(8));
                empresas.setHoraFechado(rs.getString(9));
                empresas.setNomeRua(rs.getString(10));
                empresas.setNumeroRua(rs.getInt(11));
                empresas.setResponsavel(rs.getString(12));
                empresas.setQuantFuncionarios(rs.getInt(13));
                
                //empresas.setImagem(rs.getBytes(14));
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        return empresas;
    }
    

    @Override
    public List<Empresas> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe EmpesasRepository");
        }
        List<Empresas> listaRetorno = new ArrayList();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_empresa, id_usuario, ds_nome_empresa, ds_nome_fantasia, ds_cnpj, ds_categoria, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios from empresas order by id_empresa");
        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Empresas empresas = new Empresas();
                
                empresas.setIdEmpresa(rs.getLong(1));
                empresas.getUsuario().setIdUsuario(rs.getLong(2));
                empresas.setNomeEmpresa(rs.getString(3));
                empresas.setNomeFantasia(rs.getString(4));
                empresas.setCnpj(rs.getString(5));
                empresas.setCategoria(rs.getString(6));
                empresas.setDataFundacao(rs.getString(7));
                empresas.setHoraAberto(rs.getString(8));
                empresas.setHoraFechado(rs.getString(9));
                empresas.setNomeRua(rs.getString(10));
                empresas.setNumeroRua(rs.getInt(11));
                empresas.setResponsavel(rs.getString(12));
                empresas.setQuantFuncionarios(rs.getInt(13));
                
                //empresas.setImagem(rs.getBytes(14));
                
                listaRetorno.add(empresas);
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        return listaRetorno;
    }

    @Override
    public Empresas findByIdUsuario(Long idUsuario) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasRepository");
        }
        Empresas empresa = null;
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_empresa, ds_nome_empresa, ds_nome_fantasia, ds_cnpj, ds_categoria, dt_fundacao, hr_aberto, hr_fechado, ds_rua, nr_rua, ds_responsavel, quant_funcionarios, id_usuario from empresas where id_usuario=?");
        
            ps.setLong(1, idUsuario);
  
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                empresa = new Empresas();
                
                empresa.setIdEmpresa(rs.getLong(1));
                empresa.setNomeEmpresa(rs.getString(2));
                empresa.setNomeFantasia(rs.getString(3));
                empresa.setCnpj(rs.getString(4));
                empresa.setCategoria(rs.getString(5));
                empresa.setDataFundacao(rs.getString(6));
                empresa.setHoraAberto(rs.getString(7));
                empresa.setHoraFechado(rs.getString(8));
                empresa.setNomeRua(rs.getString(9));
                empresa.setNumeroRua(rs.getInt(10));
                empresa.setResponsavel(rs.getString(11));
                empresa.setQuantFuncionarios(rs.getInt(12));
                
                Usuarios usuario = new Usuarios();
                usuario.setIdUsuario(rs.getLong(13));
                
                empresa.setUsuario(usuario);
                
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        return empresa;
    }

    @Override
    public void deleteByIdUsuario(Long idUsuario) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from empresas where id_usuario=?");
            
            ps.setLong(1, idUsuario);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        
    }

}
