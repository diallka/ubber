/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.servlet;

import java.io.IOException;
import java.util.List;
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
 * @author Admin
 */
@WebServlet(name = "RecupCondServlet", urlPatterns = {"/RecupCondServlet"})
public class RecupCondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Conducteur> listeCond=new ConducteurDAO().ListerConducteurs();
        
        String json = new ObjectMapper().writeValueAsString(listeCond);
        
        
        resp.getWriter().println(json);
    } 

}
