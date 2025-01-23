package controllers;

import models.Viennoiserie;
import observablePattern.ViennoiserieObserver;
import observablePattern.ViennoiseriePublisher;
import patternFactory.Factory;
import patternFactory.gestionFactory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AjoutVan")
public class servletAjoutVan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory vanS = gestionFactory.getFactory("Viennoiseries");
	ViennoiseriePublisher v= ViennoiseriePublisher.getInstance();
	ViennoiserieObserver observer = new ViennoiserieObserver();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("ajoutVan.jsp").forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("viennoiserieName");
        int foId = Integer.parseInt(request.getParameter("FoID"));
        float price = Float.parseFloat(request.getParameter("prix"));
        int vents = Integer.parseInt(request.getParameter("ventes"));
        v.addObserver(observer);
        vanS.insert(name, foId, price, vents);
        List<String> notifications=v.getNotifications();
        request.getSession().setAttribute("notifications", notifications);
        response.sendRedirect("viennoiseries");



    }

}
