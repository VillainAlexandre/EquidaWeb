/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import model.Enchere;
/**
 *
 * @author sio2
 */
public class Lot {
    private int id;
    private String prixDepart;
    private Enchere enchere;

    public Lot() {
    }

    public Lot(int id) {
        this.id = id;
    }

    public Lot(int id, String prixDepart) {
        this.id = id;
        this.prixDepart = prixDepart;
    }

    public int getId() {
        return id;
    }

    public String getPrixDepart() {
        return prixDepart;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrixDepart(String prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Enchere getEnchere() {
        return enchere;
    }

    public void setEnchere(Enchere enchere) {
        this.enchere = enchere;
    }
    
    
}
