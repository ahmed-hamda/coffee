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

/**
 * Servlet implementation class java.controllers.servletAjoutCafe
 */
@WebServlet("/AjouterCafe")
public class servletAjoutCafe extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory Cafe = gestionFactory.getFactory("Cafe");
	CafePublisher c=CafePublisher.getInstance();
	CafeObserver observer = new CafeObserver();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("ajoutCafe.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("cafeName");
        int foId = Integer.parseInt(request.getParameter("FoID"));
        float price = Float.parseFloat(request.getParameter("prix"));
        int vents = Integer.parseInt(request.getParameter("ventes"));
 		c.addObserver(observer);
        Cafe.insert(name, foId, price, vents);
        List<String> notifications=c.getNotifications();
        request.getSession().setAttribute("notifications", notifications);
        response.sendRedirect("cafes");



    }

}
