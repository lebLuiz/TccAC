package br.com.parquesaojose.endpoint;

import br.com.parquesaojose.domain.Produtos;
import br.com.parquesaojose.service.implement.ProdutosService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProdutosEndpoint extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProdutosEndpoint</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProdutosEndpoint at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("idProduto");
        ProdutosService service = new ProdutosService();
        
        Gson gson = new Gson();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if(Objects.isNull(param)){
            List<Produtos> listaProdutos = service.findAll();
            
            out.println(gson.toJson(listaProdutos));
        }else{
            Produtos produtos = service.findOne(Long.valueOf(param));
            
            out.println(gson.toJson(produtos));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Produtos produtos = new Produtos();
        ProdutosService service = new ProdutosService();
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Gson gson = new Gson();
        
        produtos.getEmpresa().setIdEmpresa(Long.parseLong(request.getParameter("idEmpresa")));
        produtos.setProduto(request.getParameter("produto"));
        produtos.setValor(Double.parseDouble(request.getParameter("valor")));
        //produtos.setImagem(request.getParameter("imagem"));
        
        String idProduto = request.getParameter("idProduto");
        
        if(("").equals(idProduto)){
            produtos = service.save(produtos);
        }else{
            produtos.setIdProduto(Long.parseLong(idProduto));
            produtos = service.update(produtos);
        }
        out.println(gson.toJson(produtos));
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long idProduto = Long.valueOf(req.getParameter("idProduto"));
        
        ProdutosService service = new ProdutosService();
        service.delete(idProduto);
    }

    
}
