/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author sio2
 */
public class Lieu {
    private int id;
    private String ville;
    private int nbBoxes; 
    private String commentaires;
    private Vente vente;
 

    public Lieu() {
    }

    public Lieu(int id) {
        this.id = id;
    }

    public Lieu(String ville) {
        this.ville = ville;
    }

    public Lieu(int id, String ville, int nbBoxes, String commentaires) {
        this.id = id;
        this.ville = ville;
        this.nbBoxes = nbBoxes;
        this.commentaires = commentaires;
    }

    public int getId() {
        return id;
    }

    public String getVille() {
        return ville;
    }

    public int getNbBoxes() {
        return nbBoxes;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public Vente getVente() {
        return vente;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setNbBoxes(int nbBoxes) {
        this.nbBoxes = nbBoxes;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public void setVente(Vente vente) {
        this.vente = vente;
    }

   
    
}
