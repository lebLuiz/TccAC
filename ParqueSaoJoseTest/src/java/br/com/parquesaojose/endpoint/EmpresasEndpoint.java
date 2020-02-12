package br.com.parquesaojose.endpoint;

import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.domain.EmpresasT;
import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.repository.implement.EmpresasRepository;
import br.com.parquesaojose.repository.implement.ManipularImg;
import br.com.parquesaojose.service.implement.EmpresasService;
import br.com.parquesaojose.service.implement.EmpresasTService;
import br.com.parquesaojose.utils.RequestHelper;
import com.google.gson.Gson;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmpresasEndpoint extends HttpServlet {

    BufferedImage imagem;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpresasEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpresasEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String param = request.getParameter("idEmpresa");
        EmpresasTService service = new EmpresasTService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<EmpresasT> listaEmpresas = service.findAll();
            
            out.println(gson.toJson(listaEmpresas));
        }else{
            EmpresasT empresas = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(empresas));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
            
        
        /*EmpresasService service = new EmpresasService();
        
        Empresas empresa = service.findByIdUsuario(Long.valueOf(request.getParameter("idUsuario")));
        
        if(Objects.isNull(empresa)){
            
            empresa = new Empresas();
            empresa.setNomeEmpresa(request.getParameter("nomeEmpresa"));
            empresa.setNomeFantasia(request.getParameter("nomeFantasia"));
            empresa.setCnpj(request.getParameter("cnpj"));
            empresa.setCategoria(request.getParameter("categoria"));
            empresa.setDataFundacao(request.getParameter("dataFundacao"));
            empresa.setHoraAberto(request.getParameter("horaAberto"));
            empresa.setHoraFechado(request.getParameter("horaFechado"));
            empresa.setNomeRua(request.getParameter("nomeRua"));
            empresa.setNumeroRua(Integer.parseInt(request.getParameter("numeroRua")));
            empresa.setResponsavel(request.getParameter("responsavel"));
            empresa.setQuantFuncionarios(Integer.parseInt(request.getParameter("quantFuncionarios")));
            
            Usuarios usuario = new Usuarios();
            usuario.setIdUsuario(Long.valueOf(request.getParameter("idUsuario")));
            
            empresa.setUsuario(usuario);
            
            service.save(empresa);
        }else{
            
            empresa.setNomeEmpresa(request.getParameter("nomeEmpresa"));
            empresa.setNomeFantasia(request.getParameter("nomeFantasia"));
            empresa.setCnpj(request.getParameter("cnpj"));
            empresa.setCategoria(request.getParameter("categoria"));
            empresa.setDataFundacao(request.getParameter("dataFundacao"));
            empresa.setHoraAberto(request.getParameter("horaAberto"));
            empresa.setHoraFechado(request.getParameter("horaFechado"));
            empresa.setNomeRua(request.getParameter("nomeRua"));
            empresa.setNumeroRua(Integer.parseInt(request.getParameter("numeroRua")));
            empresa.setResponsavel(request.getParameter("responsavel"));
            empresa.setQuantFuncionarios(Integer.parseInt(request.getParameter("quantFuncionarios")));
            
            Usuarios usuario = new Usuarios();
            usuario.setIdUsuario(Long.valueOf(request.getParameter("idUsuario")));
            
            empresa.setUsuario(usuario);
            
            service.update(empresa);
            
        }*/
    
        /*String body = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        Empresas empresas = gson.fromJson(body, Empresas.class);
        
        EmpresasService service = new EmpresasService();
        
        service.save(empresas);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(empresas));*/
        
        String body = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        EmpresasT empresas = gson.fromJson(body, EmpresasT.class);
        
        EmpresasTService service = new EmpresasTService();
        
        service.save(empresas);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(empresas));
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String body = RequestHelper.getBody(request);
        
        Gson gson = new Gson();
        
        Empresas empresas = gson.fromJson(body, Empresas.class);
        
        EmpresasService service = new EmpresasService();
        
        service.update(empresas);
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println(gson.toJson(empresas));
    }
    
    
    
        
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold> 

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        EmpresasService service = new EmpresasService();
        
        service.delete(Long.valueOf(req.getParameter("idEmpresa")));
    }
    
    
}
