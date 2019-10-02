package TravelExperts.DB;

/*
* Date: 25th April 2019
* Booking model
* Author: Sohail Barat
* */
import TravelExperts.DBLoginConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class bookingModel {
    // Class variables
    private int bookingID;
    private String bookingDate;
    private String bookingNum;
    private int travelerCount;
    private String customerID;
    private String tripTypeID;
    private String packageID;

    // constructor booking model
    public bookingModel(int bookingID, String bookingDate, String bookingNum, int travelerCount, String customerID,
                        String tripTypeID, String packageID) {
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
        this.bookingNum = bookingNum;
        this.travelerCount = travelerCount;
        this.customerID = customerID;
        this.tripTypeID = tripTypeID;
        this.packageID = packageID;
    }

    // single varibale constructor
    public bookingModel(int bookingID) {
        this.bookingID = bookingID;
    }

    // empty constructor
    public bookingModel(){}

    // getters and setters
    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNum() {
        return bookingNum;
    }

    public void setBookingNum(String bookingNum) {
        this.bookingNum = bookingNum;
    }

    public int getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(int travelerCount) {
        this.travelerCount = travelerCount;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getTripTypeID() {
        return tripTypeID;
    }

    public void setTripTypeID(String tripTypeID) {
        this.tripTypeID = tripTypeID;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    // loading the bookingIDs
    public ObservableList<bookingModel> loadBookingID() {
        // Observable list for agent data
        ObservableList<bookingModel> data = FXCollections.observableArrayList();
        // Getting the connection
        DBLoginConnection db = new DBLoginConnection();
        Connection Con = db.getConnection();

        try {
            // Getting the agent information
            Statement stmt = Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKINGS");
            // Getting all the information until we are done
            while(rs.next()) {
                data.add(new bookingModel(rs.getInt(1)));
            }
            // Closing the connection
            Con.close();
        } catch (SQLException ex) {
            // Outputting the errors for any error
            ex.printStackTrace();
        }
        return data;
    }

    // get booking data
    public void getBookingData(String id){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts","root","");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM bookings where bookingId= '"+id+"'");

            while(rs.next())
            {
                setBookingDate(rs.getString(2));
                setBookingNum(rs.getString(3));
                setTravelerCount(rs.getInt(4));
                setCustomerID(rs.getString(5));
                setTripTypeID(rs.getString(6));
                setPackageID(rs.getString(7));
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    // update booking
    public boolean updateBooking(String bookingID)
    {
        boolean updated=false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "UPDATE Bookings SET BookingDate=?,BookingNo=?,TravelerCount=?,CustomerId=?,TripTypeId=?," +
                    "PackageId=? where CustomerId= '" + bookingID + "'";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, getBookingDate());
            preparedStmt.setString(2, getBookingNum());
            preparedStmt.setInt(3, getTravelerCount());
            preparedStmt.setString(4, getCustomerID());
            preparedStmt.setString(5, getTripTypeID());
            preparedStmt.setString(6, getPackageID());

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            updated = true;
            con.close();
        }
        catch(Exception e)
        {
            updated=false;
            System.out.println(e);
        }

        return  updated;

    }

    // delete booking
    public boolean deleteBooking(String pkgId, String customerID, String triptTypeID, String PackageID)
    {
        boolean deleted=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts", "root", "");

            String query = "Delete From bookings where bookingid=?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1,pkgId);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();
            deleted=true;

            con.close();
        }
        catch(Exception e)
        {
            deleted=false;
            System.out.println(e);
        }
        return deleted;
    }

    // insert new booking
    public boolean insertBooking(){
        boolean updated=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/travelexperts", "root", "");
            String query = "INSERT INTO BOOKINGS(BookingDate,BookingNo,TravelerCount,CustomerId,TripTypeId,PackageId) " +
                    "VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString(1, getBookingDate());
                preparedStmt.setString(2, getBookingNum());
                preparedStmt.setInt(3, getTravelerCount());
                preparedStmt.setString(4, getCustomerID());
                preparedStmt.setString(5, getTripTypeID());
                preparedStmt.setString(6, getPackageID());

                // execute the java preparedstatement
                preparedStmt.executeUpdate();
                updated = true;
            }catch (NumberFormatException ex){
                ex.printStackTrace();
            }finally {
                con.close();
            }
        }
        catch(Exception e)
        {
            updated=false;
            System.out.println(e);
        }

        return  updated;

    }
    // to String override method
    @Override
    public String toString() {
        return bookingID + "";
    }

}
