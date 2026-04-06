package goalmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Logger;

public class GoalManager {

    private static final Logger logger =
    Logger.getLogger(GoalManager.class.getName());

    public static void main(String args[]){

        try(Scanner sc=new Scanner(System.in)){

            logger.info("Enter Goal Title:");

            String title=sc.nextLine();

            logger.info("Enter Description:");

            String desc=sc.nextLine();

            addGoal(title,desc);

            viewGoals();

        }

    }

    public static void addGoal(String title,String desc){

        String query=
        "INSERT INTO goals(title,description) VALUES(?,?)";

        try(
            Connection conn=DBConnection.connect();
            PreparedStatement stmt=
            conn.prepareStatement(query);
        ){

            stmt.setString(1,title);
            stmt.setString(2,desc);

            stmt.executeUpdate();

            logger.info("Goal added");

        }

        catch(Exception e){

            logger.severe("Error adding goal: "+e.getMessage());

        }

    }

    public static void viewGoals(){

        String query="SELECT * FROM goals";

        try(
            Connection conn=DBConnection.connect();
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(query);
        ){

            while(rs.next()){

                logger.info(
                rs.getInt("id")+" "
                +rs.getString("title")+" "
                +rs.getString("description"));

            }

        }

        catch(Exception e){

            logger.severe("Error reading goals: "+e.getMessage());

        }

    }

}