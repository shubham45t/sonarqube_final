import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GoalManager {

    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Goal Title:");

        String title=sc.nextLine();

        System.out.println("Enter Description:");

        String desc=sc.nextLine();

        addGoal(title,desc);

        viewGoals();

    }

    public static void addGoal(String title,String desc){

        try{

            Connection conn=DBConnection.connect();

            Statement stmt=conn.createStatement();

            // SECURITY BUG 2
            // SQL Injection vulnerability

            String query=
            "INSERT INTO goals(title,description) VALUES('"
            +title+"','"+desc+"')";

            stmt.executeUpdate(query);

            conn.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

    public static void viewGoals(){

        try{

            Connection conn=DBConnection.connect();

            Statement stmt=conn.createStatement();

            ResultSet rs=
            stmt.executeQuery("SELECT * FROM goals");

            while(rs.next()){

                System.out.println(
                rs.getInt("id")+" "
                +rs.getString("title")+" "
                +rs.getString("description"));

            }

            conn.close();

        }

        catch(Exception e){

            e.printStackTrace();

        }

    }

}