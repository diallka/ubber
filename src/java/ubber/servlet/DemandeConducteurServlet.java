/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "DemandeConducteurServlet", urlPatterns = {"/DemandeConducteurServlet"})
public class DemandeConducteurServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String idConducteur=req.getParameter("idConducteur");
      String adresseDestination=req.getParameter("adresseDestination");
      
      System.out.println("id:"+idConducteur+"...adresse:"+adresseDestination);
      req.setAttribute("reponse", "Demande de conducteur reussie");
      
      req.getRequestDispatcher("pageAccueil.jsp").forward(req, resp);
        
        
    }

   
    
    
    
    
    

}
