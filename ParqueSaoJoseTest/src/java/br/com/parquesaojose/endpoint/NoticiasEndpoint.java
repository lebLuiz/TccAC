package br.com.parquesaojose.endpoint;

import br.com.parquesaojose.domain.Noticias;
import br.com.parquesaojose.service.implement.NoticiasService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NoticiasEndpoint extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NoticiasEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NoticiasEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("idNoticia");
        NoticiasService service = new NoticiasService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<Noticias> listaNoticias = service.findAll();
            
            out.println(gson.toJson(listaNoticias));
        }else{
            Noticias noticias = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(noticias));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Noticias noticias = new Noticias();
        NoticiasService service = new NoticiasService();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Gson gson = new Gson();
        
        noticias.getEmpresa().setIdEmpresa(Long.parseLong(request.getParameter("idEmpresa")));
        noticias.setTitulo(request.getParameter("titulo"));
        noticias.setDataPublicacao(LocalDate.parse(request.getParameter("dataPublicacao")));
        noticias.setNoticia(request.getParameter("noticia"));
        //noticias.setImagem(request.getParameter("imagem"));
        
        String idNoticia = request.getParameter("idNoticia");
        
        if(("").equals(idNoticia)){
            noticias = service.save(noticias);
        }else{
            noticias.setIdNoticia(Long.parseLong(idNoticia));
            noticias = service.update(noticias);
        }
        out.println(gson.toJson(noticias));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idNoticia = Long.valueOf(req.getParameter("idNoticia"));
        
        NoticiasService service = new NoticiasService();
        service.delete(idNoticia);
    }

    
}
