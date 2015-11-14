/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author VeRTeXR
 */
public class Student {
    
    private int id;
    private String name;
    private String address;
    private String faculty;

    public void setFaculty (String faculty){
        this.faculty = faculty;
    }
    
    public String getFaculty () {
        return faculty;
    }
    
    public void setAddress(String address) {
        this.address = address;
    } 
    
    public String getAddress() {
        return address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

}
