package goalmanager;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DBConnection {

    private DBConnection(){

        throw new IllegalStateException("Utility class");

    }

    public static Connection connect(){

        Connection conn=null;

        try{

            String url="jdbc:sqlite:goals.db";

            conn=DriverManager.getConnection(url);

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return conn;

    }

}