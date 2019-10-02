package myServlet;
import java.sql.*;
import java.util.ArrayList;
/* This class returns an object of packages class conatining all the package info 
 * 
 * Author: Muhammad Islam
 * Date: Apr 2019
 * 
 * 
 * */
public class packageController extends Packages {
	
	packageController pkg;
public packageController() {}
	ArrayList<packageController>pkgList=new ArrayList<packageController>();
	
	public ArrayList<packageController>getPackage(){
		
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM packages order by PackageId");
            while(rs.next()) {
                // agentObj.setAgentId(rs.getInt(1));
                // System.out.println(rs.getInt(1)+"  "+rs.getString(2));
            	pkg=new packageController();
            	pkg.PkgName=rs.getString(2);
            	pkg.PkgStartDate=rs.getDate(3);
            	pkg.PkgEndDate=rs.getDate(4);
            	pkg.PkgDesc=rs.getString(5);
            	pkg.PkgBasePrice=rs.getDouble(6);
            	pkg.PkgAgencyCommission=rs.getDouble(7);
            	pkgList.add(pkg);
            	
                //agentObjList.add(rs.getInt(1)+"");
            }
            con.close();

        }
        //Define catch block for runtime exception
        catch(Exception e)
        {
            System.out.println(e);
        }
		
		
		return pkgList;
	}
}
