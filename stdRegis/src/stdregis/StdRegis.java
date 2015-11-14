/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdregis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;

/**
 *
 * @author VeRTeXR
 */
public class StdRegis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String derbyClientDriver = "org.apache.derby.jdbc.ClientDriver";
        //String mySqlDriver = "com.mysql.jdbc.Driver";
        //load driver
        Class.forName(derbyClientDriver);
        //Class.forName(mySqlDriver);
        //create connection
        /*
         * String url="jdbc:mysql://server[:port]/databaseName"; //for mySQL
         * String url="jdbc:derby:databaseName"; //for DerbyEmbedded
         * String url= "jdbc:odbc:Driver=:datasourceNameOfODBC" //for MS Accces
         * String url= "jdbc:sqlserver://server[:port]:database="databaseName" //for MS SQL Server 
         * String url= "jdbc:oracle:thin:@server:port:databaseName" //for Oracle
         */
        String url = "jdbc:derby://localhost:1527/accounts";
        //String url="jdbc:mysql://localhost/employee";
        String user = "root";
        String passwd = "root";
        //String user = "sarun";
        //String passwd = "";
        Connection con = DriverManager.getConnection(url, user, passwd);
        //create statement
        Statement stmt = con.createStatement();
       // insertData(stmt, 1, "John", 12345);     //add data here or wot 
            
        //insertData(stmt, 1, "Marry", "address", "faculty");
       // deleteDataById(stmt, 1);
        //updateAddressById(stmt, 3, 5000.50);
        updateFacultyById(con, 1, "ddd");
        //simpleQuery(stmt);
        //simpleQueryObject(stmt);
        //close connection
        stmt.close();
        con.close();

    }

    public static void simpleQueryObject(Statement stmt) throws SQLException {
        String sql = "select * from student order by id";
        ArrayList<Student> stdList = new ArrayList<>();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Student std = new Student();
            std.setID(rs.getInt("id"));
            std.setName(rs.getString("name"));
            std.setAddress(rs.getString("address")); // change to address
            std.setFaculty(rs.getString("faculty"));
            stdList.add(std);
        }
        rs.close();
        for (Student std : stdList) {
            System.out.print(std.getID() + " ");
            System.out.print(std.getName() + " ");
            System.out.println(std.getAddress() + " ");
            System.out.println(std.getFaculty() + " ");
        }
    }

    public static void simpleQuery(Statement stmt) throws SQLException {
        String sql = "select * from student order by id";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.print(rs.getInt("id") + " ");
            System.out.print(rs.getString("name") + " ");
            System.out.println(rs.getString("address") + " ");
            System.out.println(rs.getString("faculty") + " ");
        }
        rs.close();
    }

    public static void insertData(Statement stmt, int id, String name,
            String address, String faculty) throws SQLException {
        /*String sql = "insert into employee (id, name, salary)" +
         " values (5, 'Mark', 12345)";*/
        String sql = "insert into student (id, name, address, faculty)"
                + " values (" + id + "," + "'" + name + "'" + "," + "'" + address + "'" + "," + "'" + faculty + "'" + ")";
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("Insert " + result + " row");
    }

    public static void deleteDataById(Statement stmt, int id) throws SQLException {
        String sql = "delete from student where id = " + id;
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("delete " + result + " row");
    }

    public static void updateAddressById(Statement stmt, int id, String address) throws SQLException {
        String sql = "update student set address  = " + address
                + " where id = " + id;
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
    }
    
    public static void updateFacultyById(Connection con, int id, String faculty) throws SQLException {
        String sql = "update student set faculty = ? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, faculty);
        ps.setInt(2, id);
        int result = ps.executeUpdate(sql);
        //display resul
        System.out.println("update " + result + " row");
    }

    public static void deleteDataPreparedStatementById(Connection con, int id) throws SQLException {
        String sql = "delete from student where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        //display result
        System.out.println("Delete " + result + " row");
    }

    public static void updateSalaryPreparedStatementById(Connection con,
            int id, double salary) throws SQLException {
        String sql = "update employee set salary  = ? where id = ? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDouble(1, salary);
        ps.setInt(2, id);
        int result = ps.executeUpdate();
        //display result
        System.out.println("update " + result + " row");
    }

    public static void persist(Object object) { //adding teh static bruhh
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("stdRegisPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
