package Login;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class My_CNX {
    
    /*
    1. Download connector for java and MySQL database 
    2. Add JAR to prohect libraries
    3. Open XAMPP and start Apache and Mysql 
    4. Go to -> https://localhost/phpmyadmin and create a new database
    5. Create connection with database 
    */
    
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname ="users_db";
    private static String password = "";
    private static Integer portnumber = 3306;
    
    public static Connection getConnection(){
        Connection cnx = null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPassword(password);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(My_CNX.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;    
    }
}
