/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ubber.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Admin
 */
@Entity
public class Conducteur implements Serializable {
    public enum Genre {HOMME,FEMME; }
    public enum Disponible {OUI,NON;}
    
    private String nom;
    private String prenom;
    private int age;
    private String email;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String photo;
    @Temporal(TemporalType.DATE)
    private Date date_inscription;
    @Enumerated(EnumType.STRING)
    private Disponible disponible;
    private float position_latitude;
    private float position_longitude;
    private String login;
    private String password;
    private String adresse_demandee;
    private String marque_auto;
    private String modele;
    private int nb_places_dispo;
    private float prix_km;
    private float total_notation;
    private int nb_notes;
    
     //Ajout**************
    @OneToMany(mappedBy="conducteur")
    private List<Commande> commandes = new ArrayList<>();
//----------------    

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(Date date_inscription) {
        this.date_inscription = date_inscription;
    }

    public Disponible getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponible disponible) {
        this.disponible = disponible;
    }

    public float getPosition_latitude() {
        return position_latitude;
    }

    public void setPosition_latitude(float position_latitude) {
        this.position_latitude = position_latitude;
    }

    public float getPosition_longitude() {
        return position_longitude;
    }

    public void setPosition_longitude(float position_longitude) {
        this.position_longitude = position_longitude;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse_demandee() {
        return adresse_demandee;
    }

    public void setAdresse_demandee(String adresse_demandee) {
        this.adresse_demandee = adresse_demandee;
    }

    public String getMarque_auto() {
        return marque_auto;
    }

    public void setMarque_auto(String marque_auto) {
        this.marque_auto = marque_auto;
    }

    public int getNb_places_dispo() {
        return nb_places_dispo;
    }

    public void setNb_places_dispo(int nb_places_dispo) {
        this.nb_places_dispo = nb_places_dispo;
    }

    public float getPrix_km() {
        return prix_km;
    }

    public void setPrix_km(float prix_km) {
        this.prix_km = prix_km;
    }

    public float getTotal_notation() {
        return total_notation;
    }

    public void setTotal_notation(float total_notation) {
        this.total_notation = total_notation;
    }

    public int getNb_notes() {
        return nb_notes;
    }

    public void setNb_notes(int nb_notes) {
        this.nb_notes = nb_notes;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

 
    

  
    
//-----------------    
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
        if (!(object instanceof Conducteur)) {
            return false;
        }
        Conducteur other = (Conducteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ubber.entity.Conducteur[ id=" + id + " ]";
    }
    
}
