/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stdregis;


import java.math.BigDecimal;
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
        String url = "jdbc:derby://localhost:1527/regis";
        //String url="jdbc:mysql://localhost/employee";
        String user = "app";
        String passwd = "app";
        //String user = "sarun";
        //String passwd = "";
        Connection con = DriverManager.getConnection(url, user, passwd);
        //create statement
        Statement stmt = con.createStatement();
       // insertData(stmt, 1, "John", 12345);     //add data here or wot 
        // insertData(stmt, 2, "Marry", 45678);
        //deleteDataById(stmt, 6);
        //updateSalaryById(stmt, 3, 5000.50);
        insertDataPreparedStatement(con, 3, "Markus", 14578);
        //deleteDataPreparedStatementById(con, 5);
        //updateSalaryPreparedStatementById(con, 3, 6000.50);
        //simpleQuery(stmt);
        simpleQueryObject(stmt);
        //close connection
        stmt.close();
        con.close();
    
    }
    
     public static void simpleQueryObject(Statement stmt) throws SQLException {
       String sql = "select * from student order by id";
       ArrayList<Student> stdList = new ArrayList<>();
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()) {
           Student std = new Student();
           std.setId(rs.getInt("id"));
           std.setName(rs.getString("name"));
           std.setSalary(rs.getDouble("salary"));
           stdList.add(std);
       }
       rs.close();
       for(Employee emp : employeeList) {
           System.out.print(emp.getId() + " ");
           System.out.print(emp.getName() + " ");
           System.out.println(emp.getSalary() + " ");
       }
    }
    public static void simpleQuery(Statement stmt) throws SQLException {
       String sql = "select * from employee order by id";
       ResultSet rs = stmt.executeQuery(sql);
       while(rs.next()) {
           System.out.print(rs.getInt("id") + " ");
           System.out.print(rs.getString("name") + " ");
           System.out.println(rs.getDouble("salary"));
       }
       rs.close();
   }
   public static void insertData(Statement stmt, int id, String name, 
           double salary) throws SQLException {
       /*String sql = "insert into employee (id, name, salary)" +
                     " values (5, 'Mark', 12345)";*/
        String sql = "insert into employee (id, name, salary)" +
                     " values (" + id + "," + "'" + name + "'" + "," + salary + ")";
        int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("Insert " + result + " row");
   } 
   public static void deleteDataById(Statement stmt, int id) throws SQLException {
       String sql = "delete from employee where id = " + id;
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("delete " + result + " row");
   }
   public static void updateSalaryById(Statement stmt, int id, double salary) throws SQLException {
       String sql = "update employee set salary  = " + salary + 
               " where id = " + id;
       int result = stmt.executeUpdate(sql);
        //display result
        System.out.println("update " + result + " row");
   }
   public static void insertDataPreparedStatement(Connection con, int id, 
           String name, double salary) throws SQLException {
       String sql = "insert into employee (id, name, salary)" + 
               " values (?,?,?)";
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, id);
       ps.setString(2, name);
       ps.setDouble(3, salary);
       int result = ps.executeUpdate();
        //display result
        System.out.println("Insert " + result + " row");
   }
   public static void deleteDataPreparedStatementById(Connection con, int id) throws SQLException {
       String sql ="delete from employee where id = ?";
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
    
    
     public static void createStudent() {
        Student std = new Student ();
        std.setID();
        std.setName();
        std.setAddress();
        std.setFaculty();
        persist(std);
    }
    
    public static void editStudent(id,std){
    
    } 
    
    public static void deleteStudent(id){
        
    }

    public static void persist(Object object) { //adding teh static bruhh
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DuhPU");
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
