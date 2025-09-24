/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Lieu;
import model.CategVente;
/**
 *
 * @author sio2
 */
public class Vente {
    private int id;
    private String nom;
    private Date dateDebutVente; 
    private ArrayList<Lieu> lesLieux;
    private CategVente categvente;

    public Vente() {
    }

    public Vente(int id) {
        this.id = id;
    }

    public Vente(String nom) {
        this.nom = nom;
    }

    public Vente(int id, String nom, Date dateDebutVente) {
        this.id = id;
        this.nom = nom;
        this.dateDebutVente = dateDebutVente;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebutVente() {
        return dateDebutVente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebutVente(Date dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

   
     public ArrayList<Lieu> getLesLieux() {
        return lesLieux;
    }

    public void setLesLieux(ArrayList<Lieu> lesLieux) {
        this.lesLieux = lesLieux;
    }
    public void addLieu(Lieu unLieu){
        if (lesLieux ==null ){
            lesLieux = new ArrayList<Lieu>();
        }
        lesLieux.add(unLieu);
    }

    public CategVente getCategvente() {
        return categvente;
    }

    public void setCategvente(CategVente categvente) {
        this.categvente = categvente;
    }
    
   
    
    
}
