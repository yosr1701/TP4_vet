package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.Response;
import dao.IVetementDao;
import dao.VetementDaoImpl;
import metier.entities.Vetement;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do", "*.go" })
public class ControleurServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IVetementDao metier;

    @Override
    public void init() throws ServletException {
        metier = new VetementDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/index.do")) {
            request.getRequestDispatcher("vetements.jsp").forward(request, response);
        } 
        
        else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            VetementModele model = new VetementModele();
            model.setMotCle(motCle);
            List<Vetement> vetements = metier.vetementsParMC(motCle);
            model.setVetements(vetements);
            request.setAttribute("model", model);
            request.getRequestDispatcher("vetements.jsp").forward(request, response);
        } 
        
        else if (path.equals("/saisie.do")) {
            request.getRequestDispatcher("saisieVetement.jsp").forward(request, response);
        } 
        
        else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nomVet = request.getParameter("nomVet");
            String taille = request.getParameter("taille");
            double prix = Double.parseDouble(request.getParameter("prix"));
            Vetement v = metier.save(new Vetement(nomVet, taille, prix));
            request.setAttribute("vetement", v);
            response.sendRedirect("chercher.do?motCle=");
            //request.getRequestDispatcher("confirmation.jsp").forward(request, response);
            
        } 
        
        else if (path.equals("/supprimer.do")) {
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.trim().isEmpty()) { 
                try {
                    Long id = Long.parseLong(idParam);
                    metier.deleteVetement(id);
                    response.sendRedirect("chercher.do?motCle=");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalide");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID cannot be empty");
            }
        }

        
        else if (path.equals("/editer.do")) {
            String idParam = request.getParameter("id");
            
            if (idParam != null && !idParam.trim().isEmpty()) { 
                Long id = Long.parseLong(idParam);
                Vetement v = metier.getVetement(id);
                request.setAttribute("vetement", v);
                request.getRequestDispatcher("editerVetement.jsp").forward(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID cannot be empty");
            }
        } 
        
        else if (path.equals("/update.do") && request.getMethod().equals("POST")) {
            String idParam = request.getParameter("id");

            if (idParam != null && !idParam.trim().isEmpty()) {
                try {
                    Long id = Long.parseLong(idParam);
                    String nomVet = request.getParameter("nomVet");
                    String taille = request.getParameter("taille");
                    double prix = Double.parseDouble(request.getParameter("prix"));

                    Vetement v = new Vetement();
                    v.setIdVet(id);
                    v.setNomVet(nomVet);
                    v.setTaille(taille);
                    v.setPrix(prix);
                    metier.updateVetement(v);

                    response.sendRedirect("chercher.do?motCle=");
                } catch (NumberFormatException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Données invalides");
                }
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID cannot be empty");
            }
        }

        
        else {
            response.sendError(Response.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}