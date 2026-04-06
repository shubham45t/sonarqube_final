import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // SECURITY BUG 1
    // Hardcoded credentials
    private static String username="admin";
    private static String password="admin123";

    public static Connection connect(){

        Connection conn=null;

        try{

            conn=DriverManager.getConnection(
                    "jdbc:sqlite:goals.db",
                    username,
                    password
            );

        }
        catch(Exception e){

            e.printStackTrace();

        }

        return conn;

    }

}