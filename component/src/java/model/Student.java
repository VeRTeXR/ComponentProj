package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilities.DatabaseHandler;

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
    
    public String getAdress() {
        return address;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public static ArrayList<AccountS> getStudentById(DatabaseHandler dbHandler,String id)throws SQLException {
        String sql = "select * from ACCOUNT_S WHERE ID = "+id;
        ResultSet rs; 
        ArrayList<AccountS> empList = null;
        rs = dbHandler.query(sql);
        empList = extractEmployee(rs);
        return empList;
    }
    public static ArrayList<Report> getAllReport(DatabaseHandler dbHandler)throws SQLException {
        String sql = "select * from Report where APPROVE = '0'";
        ResultSet rs; 
        ArrayList<Report> empList = null;
        rs = dbHandler.query(sql);
        empList = extractReport(rs);
        return empList;
    }
    public static ArrayList<AccountS> findAllEmployee(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from ACCOUNT_S order by id";
        ResultSet rs; 
        ArrayList<AccountS> empList = null;
        rs = dbHandler.query(sql);
        empList = extractEmployee(rs);
        return empList;
    }
    private static ArrayList<Report> extractReport(ResultSet rs) {
        ArrayList<Report> empList = new ArrayList<>();
        try {
            while(rs.next()) {
                Report employee = new Report();
                try {
                    employee.setStdid(rs.getInt("STDID"));
                    employee.setReport(rs.getString("REPORT"));
                    employee.setApprove(rs.getBoolean("APPROVE"));                 
                } catch (SQLException ex) {
                    Logger.getLogger(AccountS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                empList.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(empList.size() == 0) {
            empList = null;
        }
        return empList;
    }
    private static ArrayList<AccountS> extractEmployee(ResultSet rs) {
        ArrayList<AccountS> empList = new ArrayList<>();
        try {
            while(rs.next()) {
                AccountS employee = new AccountS();
                try {
                    employee.setId(rs.getInt("id"));
                    employee.setName(rs.getString("name"));
                    employee.setAddress(rs.getString("address"));
                    employee.setFaculty(rs.getString("faculty"));
                } catch (SQLException ex) {
                    Logger.getLogger(AccountS.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                empList.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountS.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(empList.size() == 0) {
            empList = null;
        }
        return empList;
    }

}