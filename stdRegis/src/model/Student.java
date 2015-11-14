/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Sakdinan
 */

public class Student  {
    
    private Integer id;
    //@Size(max = 40)
    //@Column(name = "NAME")
    private String name;
    //@Size(max = 200)
    //@Column(name = "ADDRESS")
    private String address;
    //@Size(max = 100)
    //@Column(name = "FACULTY")
    private String faculty;

   /* public Students() {
    }

    public Students(Integer id) {
        this.id = id;
    }*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

   /* @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Students)) {
            return false;
        }
        Students other = (Students) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Students[ id=" + id + " ]";
    }*/
    
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
