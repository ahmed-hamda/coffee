package controllers;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import observablePattern.ViennoiserieObserver;
import observablePattern.ViennoiseriePublisher;
import patternFactory.Factory;
import patternFactory.gestionFactory;

@WebServlet("/servletSuppVan")
public class servletSuppVan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory vanS = gestionFactory.getFactory("Viennoiseries");
	ViennoiseriePublisher v= ViennoiseriePublisher.getInstance();
	ViennoiserieObserver observer = new ViennoiserieObserver();
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String VanId = request.getParameter("VanId");
        if (VanId != null && !VanId.isEmpty()) {
            vanS.supprimer(VanId); 
            List<String> notifications=v.getNotifications();
            request.getSession().setAttribute("notifications", notifications);
            response.sendRedirect("viennoiseries"); 
        } else {
            request.setAttribute("errorMessage", "Nom du Viennoiserie invalide.");
            request.getRequestDispatcher("ListeVan.jsp").forward(request, response);
        }
    }
}

