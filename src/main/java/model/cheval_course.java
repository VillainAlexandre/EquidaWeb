/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sio2
 */
public class cheval_course {
    private Cheval Cheval;
    private Course Course;
    private int position;

    public cheval_course() {
    }

    public cheval_course(Cheval Cheval, Course Course, int position) {
        this.Cheval = Cheval;
        this.Course = Course;
        this.position = position;
    }

    public Cheval getCheval() {
        return Cheval;
    }

    public Course getCourse() {
        return Course;
    }

    public int getPosition() {
        return position;
    }

    public void setCheval(Cheval Cheval) {
        this.Cheval = Cheval;
    }

    public void setCourse(Course Course) {
        this.Course = Course;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
    
}
