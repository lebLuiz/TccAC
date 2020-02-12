
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

/**
 *
 * @author free
 */
public class LoginEndpoint extends HttpServlet {


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
        
        usuarios = service.logar(usuarios.getNomeUsuario(), usuarios.getSenha());
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(usuarios));
        
    }

}
