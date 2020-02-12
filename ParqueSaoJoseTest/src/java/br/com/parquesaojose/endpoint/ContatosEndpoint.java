package br.com.parquesaojose.endpoint;

import br.com.parquesaojose.domain.Contatos;
import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.service.implement.ContatosService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContatosEndpoint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContatosEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContatosEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("idContato");
        ContatosService service = new ContatosService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<Contatos> listaContatos = service.findAll();
            
            out.println(gson.toJson(listaContatos));
        }else{
            Contatos contatos = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(contatos));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ContatosService service = new ContatosService();
        
        Contatos contato = service.findByIdEmpresa(Long.valueOf(request.getParameter("idEmpresa")));
        
        if(Objects.isNull(contato)){
            
            contato = new Contatos();
            contato.setTipoContato(request.getParameter("tipoContato"));
            contato.setContato(request.getParameter("contato"));
            
            
            Empresas empresa = new Empresas();
            empresa.setIdEmpresa(Long.valueOf(request.getParameter("idEmpresa")));
            
            contato.setEmpresa(empresa);
            
            service.save(contato);
        }else{
            
            contato.setTipoContato(request.getParameter("tipoContato"));
            contato.setContato(request.getParameter("contato"));
            
            Empresas empresa = new Empresas();
            empresa.setIdEmpresa(Long.valueOf(request.getParameter("idEmpresa")));
            
            contato.setEmpresa(empresa);
            
            service.update(contato);
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContatosService service = new ContatosService();
        
        service.delete(Long.valueOf(req.getParameter("idContato")));
    }

    
}
