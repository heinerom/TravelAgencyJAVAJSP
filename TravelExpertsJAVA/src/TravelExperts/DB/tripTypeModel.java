package TravelExperts.DB;
/*
* Author: Sohail Barat
* Date: 20th April 2019
* Trip Type ID
*/

import TravelExperts.DBLoginConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Trip Type Class
public class tripTypeModel {
    private String tripTypeID;
    private String tripTypeName;

    // Paramtereized constructor
    public tripTypeModel(String tripTypeID, String tripTypeName) {
        this.tripTypeID = tripTypeID;
        this.tripTypeName = tripTypeName;
    }

    // empty constructor
    public tripTypeModel() {}

    public tripTypeModel(String tripTypeID) {
        this.tripTypeID = tripTypeID;
    }

    // getters and setters
    public String getTripTypeID() {
        return tripTypeID;
    }

    public void setTripTypeID(String tripTypeID) {
        this.tripTypeID = tripTypeID;
    }

    public String getTripTypeName() {
        return tripTypeName;
    }

    public void setTripTypeName(String tripTypeName) {
        this.tripTypeName = tripTypeName;
    }

    // load the trip type id
    public ObservableList<tripTypeModel> loadTripTypeID() {
        // Observable list for agent data
        ObservableList<tripTypeModel> data = FXCollections.observableArrayList();
        // Getting the connection
        DBLoginConnection db = new DBLoginConnection();
        Connection Con = db.getConnection();

        try {
            // Getting the agent information
            Statement stmt = Con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TRIPTYPES");
            // Getting all the information until we are done
            while(rs.next()) {
                data.add(new tripTypeModel(rs.getString(1)));
            }
            // Closing the connection
            Con.close();
        } catch (SQLException ex) {
            // Outputting the errors for any error
            ex.printStackTrace();
        }
        return data;
    }

    // toString overrided function
    @Override
    public String toString() {
        return tripTypeID;
    }
}
