package TravelExperts;

/*
* Author: Sohail, Muhammad, Eugenia, Sheila
* */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// DBLogin Connection class
public class DBLoginConnection {
    Statement stmt;
    Connection con;
    public Connection getConnection(){

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts", "root", "");
            stmt = con.createStatement();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return con;
    }

    // connect db function
    public boolean connectDb(){

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts", "root", "");
            stmt = con.createStatement();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return true;
    }

    // login user function
    public boolean loginUser(String userName, String pass){
        boolean userFound=false;
        int count=0;
        if(connectDb())
        {
            try {
                //Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("SELECT * from users where userName ='"+userName+"'"+" and userPassword ='"
                        +pass+"'");

                while (rs.next())
                {
                    count++;
                }
                con.close();
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
            if(count>0)
            {
                userFound=true;
            }

        }

        return userFound;
    }
}
