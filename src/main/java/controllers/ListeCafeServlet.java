package controllers;

import models.Cafe;
import patternFactory.Factory;
import patternFactory.gestionFactory;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cafes")
public class ListeCafeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    gestionFactory gestionFactory=new gestionFactory(); 
	Factory Cafe = gestionFactory.getFactory("Cafe");
	
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cafe> cafes = Cafe.getAll();
        request.setAttribute("cafes", cafes);
        request.getRequestDispatcher("listeCafe.jsp").forward(request, response);
    }
}
