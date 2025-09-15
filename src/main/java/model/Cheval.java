package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cheval {

    private int id;
    private String nom;
    private LocalDate dateNaissance;
    private Race race;
    private Cheval cheval_pere;
    private Cheval cheval_mere;
    private Course Course;
    
    private ArrayList<Course> lesCourses ; 
    
    private ArrayList<Cheval> lescheval_peres ;
    
    private ArrayList<Cheval> lescheval_meres ;
    
    private ArrayList<Lot> lesLots ;

    public Cheval() {
    }

    public Cheval getCheval_pere() {
        return cheval_pere;
    }

    public Cheval getCheval_mere() {
        return cheval_mere;
    }

    public void setCheval_pere(Cheval cheval_pere) {
        this.cheval_pere = cheval_pere;
    }

    public void setCheval_mere(Cheval cheval_mere) {
        this.cheval_mere = cheval_mere;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public Race getRace() {
        return race;
    }
    public void setRace(Race race) {
        this.race = race;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public void setLescourse(ArrayList<Course> lescourse) {
        this.lesCourses = lescourse;
    }

    public Course getCourse() {
        return Course;
    }

    public ArrayList<Course> getLescourse() {
        return lesCourses;
    }

    public void setLescheval_peres(ArrayList<Cheval> lescheval_peres) {
        this.lescheval_peres = lescheval_peres;
    }

    public void setLescheval_meres(ArrayList<Cheval> lescheval_meres) {
        this.lescheval_meres = lescheval_meres;
    }

    public ArrayList<Cheval> getLescheval_peres() {
        return lescheval_peres;
    }

    public ArrayList<Cheval> getLescheval_meres() {
        return lescheval_meres;
    }

    public ArrayList<Lot> getLesLots() {
        return lesLots;
    }

    public void setLesLots(ArrayList<Lot> lesLots) {
        this.lesLots = lesLots;
    }
    
    public void addCourse(Course uneCourse){
        if (lesCourses ==null ){
            lesCourses = new ArrayList<Course>();
        }
        lesCourses.add(uneCourse);
    }
    
    public void addCheval_pere(Cheval uncheval_pere){
        if (lescheval_peres ==null ){
            lescheval_peres = new ArrayList<Cheval>();
        }
        lescheval_peres.add(uncheval_pere);
    }
    
    public void addCheval_mere(Cheval unCheval_mere){
        if (lescheval_meres ==null ){
            lescheval_meres = new ArrayList<Cheval>();
        }
        lescheval_meres.add(unCheval_mere);
    }
    
    public void addLot(Lot unLot){
        if (lesLots ==null ){
            lesLots = new ArrayList<Lot>();
        }
        lesLots.add(unLot);
    }
    
}
