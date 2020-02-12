package br.com.parquesaojose.endpoint;

import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.service.implement.UsuariosService;
import br.com.parquesaojose.utils.RequestHelper;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UsuariosEndpoint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuariosEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuariosEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("idUsuario");
        UsuariosService service = new UsuariosService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<Usuarios> listaUsuarios = service.findAll();
            
            out.println(gson.toJson(listaUsuarios));
        }else{
            Usuarios usuarios = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(usuarios));
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String body = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        
        Usuarios usuarios = gson.fromJson(body, Usuarios.class);
        
        UsuariosService service = new UsuariosService();
        
        service.save(usuarios);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(usuarios));
        
//        usuarios.setNomeResponsavelUsuario(request.getParameter("nomeResponsavelUsuario"));
//        usuarios.setCpf(request.getParameter("cpf"));
//        usuarios.setRg(request.getParameter("rg"));
//        usuarios.setDataNascimento(request.getParameter("dataNascimento"));
//        usuarios.setEmail(request.getParameter("email"));
//        usuarios.setTelefone(request.getParameter("telefone"));
//        usuarios.setSexo(request.getParameter("sexo"));
//        usuarios.setNomeUsuario(request.getParameter("nomeUsuario"));
//        usuarios.setSenha(request.getParameter("senha"));
        
//        String idUsuarios = request.getParameter("idUsuario");
//        
//        if(("").equals(idUsuarios)){
//            usuarios = service.save(usuarios);
//        }else{
//            usuarios.setIdUsuario(Long.parseLong(request.getParameter("idUsuario")));
//            usuarios = service.update(usuarios);
//        }
        
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String body = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        
        Usuarios usuarios = gson.fromJson(body, Usuarios.class);
        
        UsuariosService service = new UsuariosService();
        
        service.update(usuarios);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(usuarios));
        
    }
    
    

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idUsuarios = Long.valueOf(req.getParameter("idUsuario"));
        
        UsuariosService service = new UsuariosService();
        service.delete(idUsuarios);
    }
    
    

}
