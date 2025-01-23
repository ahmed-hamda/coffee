package controllers;


import models.Viennoiserie;
import patternFactory.Factory;
import patternFactory.gestionFactory;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viennoiseries")
public class servletListeVan extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory vanS = gestionFactory.getFactory("Viennoiseries");
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Viennoiserie> viens = vanS.getAll();
        request.setAttribute("viens", viens);
        request.getRequestDispatcher("listeVan.jsp").forward(request, response);
    }
}
