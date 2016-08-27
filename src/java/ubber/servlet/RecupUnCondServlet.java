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
import org.codehaus.jackson.map.ObjectMapper;
import ubber.dao.ConducteurDAO;
import ubber.entity.Conducteur;

/**
 *
 * @author admin
 */
@WebServlet(name = "RecupUnCondServlet", urlPatterns = {"/RecupUnCondServlet"})
public class RecupUnCondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        
        System.out.println("id...."+id);
        Conducteur conducteur = new ConducteurDAO().RecupererUnConducteur(id);
        System.out.println(conducteur);
        String json = new ObjectMapper().writeValueAsString(conducteur);
        resp.getWriter().println(json);
    }

}
