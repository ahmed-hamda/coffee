package controllers;
import models.Cafe;
import observablePattern.CafeObserver;
import observablePattern.CafePublisher;
import patternFactory.Factory;
import patternFactory.gestionFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servletSuppCafe")
public class servletSuppCafe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory Cafe = gestionFactory.getFactory("Cafe");
	CafePublisher c= CafePublisher.getInstance();
	CafeObserver observer = new CafeObserver();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cafeId = request.getParameter("cafeId"); // Récupérer le nom du café à supprimer
        if (cafeId != null && !cafeId.isEmpty()) {
            Cafe.supprimer(cafeId); 
            List<String> notifications=c.getNotifications();
            request.getSession().setAttribute("notifications", notifications);
            response.sendRedirect("cafes"); 
        } else {
            request.setAttribute("errorMessage", "Nom du café invalide.");
            request.getRequestDispatcher("ListeCafe.jsp").forward(request, response);
        }
    }
}

