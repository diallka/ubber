/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
public class Commande implements Serializable {
    public enum Arrive {OUI,NON; }
    
    
    @Temporal(TemporalType.DATE)
    private Date date;
    private String adresse_destination;
    @Enumerated(EnumType.STRING)
    private Arrive arrive;
    private float prix;
    private String commentaire_client;
    
    //Ajout***********************
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name = "conducteur_id")
    private Conducteur conducteur;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    //-------------------
    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAdresse_destination() {
        return adresse_destination;
    }

    public void setAdresse_destination(String adresse_destination) {
        this.adresse_destination = adresse_destination;
    }

    public Arrive getArrive() {
        return arrive;
    }

    public void setArrive(Arrive arrive) {
        this.arrive = arrive;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getCommentaire_client() {
        return commentaire_client;
    }

    public void setCommentaire_client(String commentaire_client) {
        this.commentaire_client = commentaire_client;
    }



   
   
    
//--------------------
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubber.entity.Commande[ id=" + id + " ]";
    }
    
}
