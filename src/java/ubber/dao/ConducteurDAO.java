/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ubber.entity.Conducteur;


/**
 *
 * @author Admin
 */
public class ConducteurDAO {
     public List<Conducteur> ListerConducteurs() {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        return em.createQuery("SELECT c FROM Conducteur c").getResultList();
    } 
    
   public Conducteur RecupererUnConducteur(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        Query query=em.createQuery("SELECT c FROM Conducteur c WHERE c.id=:un");
        query.setParameter("un", id);
        return (Conducteur)query.getSingleResult();
    }  
    
}
