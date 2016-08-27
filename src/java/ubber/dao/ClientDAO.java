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
import ubber.entity.Client;

/**
 *
 * @author Admin
 */
public class ClientDAO {
    
        //Rechercher utilisateur existant par login et mdp et on le connecte
    public Client rechercheParLoginEtMdp(String login, String password) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       Query query = em.createQuery("SELECT u FROM Client u WHERE u.login=:monLogin AND u.password=:monMdp");
       query.setParameter("monLogin", login);
       query.setParameter("monMdp", password);
       return (Client) 
               query.getSingleResult();
    }

    //Rechercher si un utilisateur a deja ce login si oui on renvoie une exception specifiée dans le Service
    public List<Client> rechercheParLoginEtMdp(String login) {
       EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
       return em.createQuery("SELECT u FROM Client u WHERE u.login=:newLogin").setParameter("newLogin", login).getResultList();
    }
    
    //On crée un Utilisateur s'il n'existe pas
    public void creerUtilisateur(Client util){
        EntityManager em = Persistence.createEntityManagerFactory("PU").createEntityManager();
        
        em.getTransaction().begin();
        em.persist(util);
        em.getTransaction().commit();
    }
    
}
