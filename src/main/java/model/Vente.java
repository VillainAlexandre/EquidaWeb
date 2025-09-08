/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Lieu;

/**
 *
 * @author sio2
 */
public class Vente {
    private int id;
    private String nom;
    private String dateDebutVente; 
    private Lieu lieu;

    public Vente() {
    }

    public Vente(int id) {
        this.id = id;
    }

    public Vente(String nom) {
        this.nom = nom;
    }

    public Vente(int id, String nom, String dateDebutVente) {
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

    public String getDateDebutVente() {
        return dateDebutVente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateDebutVente(String dateDebutVente) {
        this.dateDebutVente = dateDebutVente;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }
    
   
    
    
}
