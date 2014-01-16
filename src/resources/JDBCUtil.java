package resources;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 * @author tombisnis@yahoo.com
 */
public class JDBCUtil {
    private static final Connection CONNECTION;
    
    static {
        try {
            CONNECTION = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","");
        } catch (Throwable ex) {
            System.err.println("Initial JDBC creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Connection getConnection() {
        return CONNECTION;
    }
}