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
public class Course {
    private int id;
    private String nom;
    private String lieu;
    private int date;
    private Cheval Cheval;
    
    private ArrayList<ChevalCourse> LesCourseByCheval;
    private ArrayList<Cheval> lesChevals;
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

    public Cheval getCheval() {
        return Cheval;
    }

    public ArrayList<Cheval> getLesCheval() {
        return lesChevals;
    }

    public void setCheval(Cheval Cheval) {
        this.Cheval = Cheval;
    }

    public void setLesCheval(ArrayList<Cheval> lesCheval) {
        this.lesChevals = lesCheval;
    }
   
    public void addCheval(Cheval unCheval){
        if (lesChevals ==null ){
            lesChevals = new ArrayList<Cheval>();
        }
        lesChevals.add(unCheval);
    }
    
}
