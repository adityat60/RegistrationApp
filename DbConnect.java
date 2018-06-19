
package DataBase;
import java.sql.*;
import javax.swing.JOptionPane;
public class DbConnect {
    public static Connection c;
    public static Statement st;
     static public PreparedStatement insertUser,getUser,updateUser,deleteUser;
    static{
        try{
            //Class.forName("oracle.jdbc.driver.OracleDriver");
           Class.forName("com.mysql.jdbc.Driver");
           c=DriverManager.getConnection("jdbc:mysql://localhost:3306/regdb","root","system");
          //  c=DriverManager.getConnection("jdbc.oracle:thin:@localhost:1521:xe","regdb","regdb");
            st=c.createStatement();
            insertUser=c.prepareStatement(
                    "insert into user_info (name,gen,dob,country,skills,adr) values (?,?,?,?,?,?)");
            getUser=c.prepareStatement(
                    "select * from user_info where name like ?");
            updateUser=c.prepareStatement(
                    "update user_info set name=?,gen=?,dob=?,country=?,skills=?,adr=? where user_id=?");
            deleteUser=c.prepareStatement(
                    "delete from user_info where user_id=?");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
            
        }
            
    } 
}
