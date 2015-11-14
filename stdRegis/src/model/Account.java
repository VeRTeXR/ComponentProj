/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Sakdinan
 */

public class Account {
   
    private String username;
    private String password;
    private Boolean isAdmin;
    
    public Boolean getIsAdmin() {
        return isAdmin;
    }
   
    public Boolean setIsAdmin(Boolean isAdmin)  {
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
