/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class StudentLogger {
    public static int insertStudent(DatabaseHandler dbHandler, Student std,Account acc)throws SQLException {
         String sql = "insert into ACCOUNT (id, password)" + 
               " values (?,?)";
         String sql2 = "insert into STUDENT (id, name, address, faculty)" + 
               " values (?,?,?,?)";
         
         int rowInserted,rowInserted2;
         try {
             rowInserted = dbHandler.update(sql, std.getId() ,acc.getPassword());
             rowInserted2 = dbHandler.update(sql2, std.getId() ,std.getName(),std.getAddress(),std.getFaculty());

         }catch(SQLException ex) {
             rowInserted = 0;
             rowInserted2 = 0;
         }
         return rowInserted+rowInserted2;
    } 
    public static int removeStudent(DatabaseHandler dbHandler, int id) {
         String sql ="delete from STUDENT where id = ?";
         String sql2 ="delete from ACCOUNT where id = ?";
         int rowDeleted,rowDeleted2;
         try {
            rowDeleted = dbHandler.update(sql, id);
            rowDeleted2 = dbHandler.update(sql2, id);
         }
         catch (SQLException ex ) {
             rowDeleted = 0;
             rowDeleted2 = 0;
             
         }
        return rowDeleted+rowDeleted2;
    }
    
    public static int updateStudent(DatabaseHandler dbHandler, Student std)throws SQLException {
        String sql = "update STUDENT set NAME=?, ADDRESS=? ,FACULTY=? where ID="+std.getId();
        System.out.println(std.getId());
        int rowUpdated;
        try {
            rowUpdated = dbHandler.update(sql, std.getName(), std.getAddress(), std.getFaculty());
        }
        catch (Exception ex ) {
            System.out.println(ex);
            rowUpdated = 0;
        }
        
        return rowUpdated;
    }
    
    public static ArrayList<Student> getStudentById(DatabaseHandler dbHandler,String id)throws SQLException {
        String sql = "select * from student WHERE ID = "+id;
        ResultSet rs; 
        ArrayList<Student> stdList = null;
        rs = dbHandler.query(sql);
        stdList = extractStudent(rs);
        return stdList;
    }
    public static ArrayList<Report> getAllReport(DatabaseHandler dbHandler)throws SQLException {
        String sql = "select * from Report where APPROVE = '0'";
        ResultSet rs; 
        ArrayList<Report> stdList = null;
        rs = dbHandler.query(sql);
        stdList = extractReport(rs);
        return stdList;
    }
    public static ArrayList<Student> findAllStudent(DatabaseHandler dbHandler) throws SQLException {
        String sql = "select * from student order by id";
        ResultSet rs; 
        ArrayList<Student> stdList = null;
        rs = dbHandler.query(sql);
        stdList = extractStudent(rs);
        return stdList;
    }
    public static ArrayList<Student> findStudent(DatabaseHandler dbHandler,int id) throws SQLException {
        String sql = "select * from student where id ="+id;
        ResultSet rs; 
        ArrayList<Student> stdList = null;
        rs = dbHandler.query(sql);
        stdList = extractStudent(rs);
        return stdList;
    }
    private static ArrayList<Report> extractReport(ResultSet rs) {
        ArrayList<Report> stdList = new ArrayList<>();
        try {
            while(rs.next()) {
                Report std = new Report();
                try {
                    std.setStdid(rs.getInt("STDID"));
                    std.setReport(rs.getString("REPORT"));
                    std.setApprove(rs.getBoolean("APPROVE"));                 
                } catch (SQLException ex) {
                    Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                stdList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(stdList.size() == 0) {
            stdList = null;
        }
        return stdList;
    }
    private static ArrayList<Student> extractStudent(ResultSet rs) {
        ArrayList<Student> stdList = new ArrayList<>();
        try {
            while(rs.next()) {
                Student std = new Student();
                try {
                    std.setId(rs.getInt("id"));
                    std.setName(rs.getString("name"));
                    std.setAddress(rs.getString("address"));
                    std.setFaculty(rs.getString("faculty"));
                } catch (SQLException ex) {
                    Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                stdList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(stdList.size() == 0) {
            stdList = null;
        }
        return stdList;
    }
    
}
