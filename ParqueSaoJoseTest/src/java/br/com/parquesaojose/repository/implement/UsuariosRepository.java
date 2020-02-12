package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.repository.interfaces.IUsuariosRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuariosRepository implements IUsuariosRepository{

    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";
    
    @Override
    public Usuarios save(Usuarios usuarios) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe UsuariosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into usuarios (ds_nome_usuario, nr_cpf, nr_rg, dt_data_nascimento, ds_email, nr_telefone, ds_usuario, ds_senha, ds_sexo) values (?,?,?,?,?,?,?,?,?)");
            
            ps.setString(1, usuarios.getNomeResponsavelUsuario());
            ps.setString(2, usuarios.getCpf());
            ps.setString(3, usuarios.getRg());
            ps.setString(4, usuarios.getDataNascimento());
            ps.setString(5, usuarios.getEmail());
            ps.setString(6, usuarios.getTelefone());
            ps.setString(7, usuarios.getNomeUsuario());
            ps.setString(8, usuarios.getSenha());
            ps.setString(9, usuarios.getSexo());
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
        return usuarios;
    }

    @Override
    public Usuarios update(Usuarios usuarios) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe UsuariosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conexao.prepareStatement("update usuarios set ds_nome_usuario=?, nr_cpf=?, nr_rg=?, dt_data_nascimento=?, ds_email=?, nr_telefone=?, ds_usuario=?, ds_senha=?, ds_sexo=? where id_usuario=?");
            
            ps.setString(1, usuarios.getNomeResponsavelUsuario());
            ps.setString(2, usuarios.getCpf());
            ps.setString(3, usuarios.getRg());
            ps.setString(4, usuarios.getDataNascimento());
            ps.setString(5, usuarios.getEmail());
            ps.setString(6, usuarios.getTelefone());
            ps.setString(7, usuarios.getNomeUsuario());
            ps.setString(8, usuarios.getSenha());
            ps.setString(9, usuarios.getSexo());
            ps.setLong(10, usuarios.getIdUsuario());
            
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
        return usuarios;
    }

    @Override
    public void delete(Long idUsuarios) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe UsuariosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from usuarios where id_usuario=?");
            
            ps.setLong(1, idUsuarios);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
    }

    @Override
    public Usuarios findOne(Long idUsuarios) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe UsuariosRepository");
        }
        
        Usuarios usuarios = new Usuarios();
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_usuario, ds_nome_usuario, nr_cpf, nr_rg, dt_data_nascimento, ds_email, nr_telefone, ds_usuario, ds_senha, ds_sexo from usuarios where id_usuario=?");
            
            ps.setLong(1, idUsuarios);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuarios.setIdUsuario(rs.getLong(1));
                usuarios.setNomeResponsavelUsuario(rs.getString(2));
                usuarios.setCpf(rs.getString(3));
                usuarios.setRg(rs.getString(4));
                usuarios.setDataNascimento(rs.getString(5));
                usuarios.setEmail(rs.getString(6));
                usuarios.setTelefone(rs.getString(7));
                usuarios.setNomeUsuario(rs.getString(8));
                usuarios.setSenha(rs.getString(9));
                usuarios.setSexo(rs.getString(10));
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe UsuariosRepository");
        }
        
        List<Usuarios> listaRetorno = new ArrayList();
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_usuario, ds_nome_usuario, nr_cpf, nr_rg, dt_data_nascimento, ds_email, nr_telefone, ds_usuario, ds_senha, ds_sexo from usuarios order by id_usuario");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Usuarios usuarios = new Usuarios();
                
                usuarios.setIdUsuario(rs.getLong(1));
                usuarios.setNomeResponsavelUsuario(rs.getString(2));
                usuarios.setCpf(rs.getString(3));
                usuarios.setRg(rs.getString(4));
                usuarios.setDataNascimento(rs.getString(5));
                usuarios.setEmail(rs.getString(6));
                usuarios.setTelefone(rs.getString(7));
                usuarios.setNomeUsuario(rs.getString(8));
                usuarios.setSenha(rs.getString(9));
                usuarios.setSexo(rs.getString(10));
                
                listaRetorno.add(usuarios);
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
        return listaRetorno;
    }
    
    @Override
    public Usuarios logar(String login, String senha) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe UsuariosRepository");
        }
        
        Usuarios usuarios = null;
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_usuario, ds_nome_usuario, nr_cpf, nr_rg, dt_data_nascimento, ds_email, nr_telefone, ds_usuario, ds_senha, ds_sexo from usuarios where ds_usuario=? and ds_senha=?");
            
            ps.setString(1, login);
            ps.setString(2, senha);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                usuarios = new Usuarios();
                
                usuarios.setIdUsuario(rs.getLong(1));
                usuarios.setNomeResponsavelUsuario(rs.getString(2));
                usuarios.setCpf(rs.getString(3));
                usuarios.setRg(rs.getString(4));
                usuarios.setDataNascimento(rs.getString(5));
                usuarios.setEmail(rs.getString(6));
                usuarios.setTelefone(rs.getString(7));
                usuarios.setNomeUsuario(rs.getString(8));
                usuarios.setSenha(rs.getString(9));
                usuarios.setSexo(rs.getString(10));
            }
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe UsuariosRepository");
        }
        return usuarios;
    }
    
}
