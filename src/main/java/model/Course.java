/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class Course {
    private int id;
    private String nom;
    private String lieu;
    private int date;

    public Course() {
    }

    public Course(int id, String nom, String lieu, int date) {
        this.id = id;
        this.nom = nom;
        this.lieu = lieu;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getLieu() {
        return lieu;
    }

    public int getDate() {
        return date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setDate(int date) {
        this.date = date;
    }
   
    
    
}
