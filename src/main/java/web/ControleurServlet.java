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
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("Pays.jsp").forward(request, response);

        } else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            PaysModele model = new PaysModele();
            model.setMotCle(motCle);
            List<Pays> paysList = metier.paysParMC(motCle);
            model.setPaysList(paysList);
            request.setAttribute("model", model);
            request.getRequestDispatcher("Pays.jsp").forward(request, response);
        
            
          
        } else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisiePays.jsp").forward(request, response); 

        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nomPays");
            int population = Integer.parseInt(request.getParameter("population"));
            String continent = request.getParameter("continent");
            Pays p = metier.save(new Pays(nom, population, continent));
            request.setAttribute("pays", p);
            request.getRequestDispatcher("confirmation.jsp").forward(request, response); 

            
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deletePays(id);
            response.sendRedirect("chercher.do?motCle=");

        }else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Pays p = metier.getPays(id); 
            request.setAttribute("pays", p);
            request.getRequestDispatcher("editerPays.jsp").forward(request, response); 
        } 

        else if (path.equals("/update.do")) {
            Long id = Long.parseLong(request.getParameter("idPays")); 
            String nom = request.getParameter("nomPays");
            int population = Integer.parseInt(request.getParameter("population"));
            String continent = request.getParameter("continent");

            
            Pays p = new Pays();
            p.setIdPays(id);
            p.setNomPays(nom);
            p.setPopulation(population);
            p.setContinent(continent);

            metier.updatePays(p); 
            request.setAttribute("pays", p);
            //request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            response.sendRedirect("chercher.do?motCle=");
        }
        else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


