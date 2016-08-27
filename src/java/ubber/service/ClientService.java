/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.service;

import java.util.List;
import ubber.dao.ClientDAO;
import ubber.entity.Client;

/**
 *
 * @author Admin
 */
public class ClientService {

     //On recherche un utilisateur existant pour le connecter
    public Client rechercheParLoginEtMdp(String login, String password) {
   
        return new ClientDAO().rechercheParLoginEtMdp(login, password);
    }

    //On gere la verifiaction et l'inscription
    public void inscription(Client client) {
        ClientDAO dao = new ClientDAO();
        //On verifie le nouveau login, s'il existe on renvoit une erreur,
        List<Client> listeUtilAvecCeLogin = dao.rechercheParLoginEtMdp(client.getLogin());
        if(listeUtilAvecCeLogin.size() > 0)
            throw new RuntimeException("Ce login existe dejà");
        
        // s'il n'existe pas on le crée
        dao.creerUtilisateur(client);
    }
    
    
}
