/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ubber.entity.Client;
import ubber.service.ClientService;

/**
 *
 * @author pro
 */
@WebServlet(name = "InscriptionClientServlet", urlPatterns = {"/inscription_client"})
public class InscriptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prennom");
        String email = req.getParameter("email");
        String genre = req.getParameter("genre");
        //String genreFeminin = req.getParameter("FEMME");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        
        Client client = new Client();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setEmail(email);
        client.setGenre(Client.Genre.valueOf(genre));
       
        
        new ClientService().inscription(client);
        
        resp.sendRedirect("connexion_client");
    }

    
}
