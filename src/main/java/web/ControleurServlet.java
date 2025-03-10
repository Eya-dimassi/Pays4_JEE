package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.IPaysDao;
import dao.PaysDaoImpl;
import metier.entities.Pays;
import org.apache.catalina.connector.Response;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" }) 
public class ControleurServlet extends HttpServlet {
    IPaysDao metier;

    @Override
    public void init() throws ServletException {
        metier = new PaysDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("Request received for: " + path);
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("pays.jsp").forward(request, response);

        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            PaysModele model = new PaysModele();
            model.setMotCle(motCle);
            List<Pays> paysList = metier.paysParMC(motCle);
            model.setPaysList(paysList);
            request.setAttribute("model", model);
            request.getRequestDispatcher("pays.jsp").forward(request, response);
        
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


