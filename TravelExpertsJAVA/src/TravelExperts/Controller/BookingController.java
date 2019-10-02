package TravelExperts.Controller;
/**
 * Sample Skeleton for 'Bookings.fxml' Controller Class
 * Author: Sohail Barat
 * Date: 20th April 2019
 * */

import TravelExperts.DB.bookingModel;
import TravelExperts.DB.customerModel;
import TravelExperts.DB.packagesModel;
import TravelExperts.DB.tripTypeModel;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

// Booking Controller
public class BookingController {

    // Variables for live time
    @FXML private Label time;
    private int minute;
    private int hour;
    private int second;
    private String day = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnInsertBooking;

    @FXML // fx:id="cbBookingID"
    private ComboBox<bookingModel> cbBookingID; // Value injected by FXMLLoader

    @FXML // fx:id="lblDateAndTime"
    private Label lblDateAndTime; // Value injected by FXMLLoader

    @FXML // fx:id="lblBookingDate"
    private Label lblBookingDate; // Value injected by FXMLLoader

    @FXML
    private DatePicker dpBookingDate;

    @FXML // fx:id="lblBookingNumber"
    private Label lblBookingNumber; // Value injected by FXMLLoader

    @FXML // fx:id="teBookingNumber"
    private TextField teBookingNumber; // Value injected by FXMLLoader

    @FXML // fx:id="cbTravellerCount"
    private ComboBox<Integer> cbTravellerCount; // Value injected by FXMLLoader

    @FXML // fx:id="lblTravellerCount"
    private Label lblTravellerCount; // Value injected by FXMLLoader

    @FXML // fx:id="cbCustomerID"
    private ComboBox<customerModel> cbCustomerID; // Value injected by FXMLLoader

    @FXML // fx:id="lblCustomerID"
    private Label lblCustomerID; // Value injected by FXMLLoader

    @FXML // fx:id="cbTripTypeID"
    private ComboBox<tripTypeModel> cbTripTypeID; // Value injected by FXMLLoader

    @FXML // fx:id="lblTripTypeID"
    private Label lblTripTypeID; // Value injected by FXMLLoader

    @FXML // fx:id="cbPackageID"
    private ComboBox<packagesModel> cbPackageID; // Value injected by FXMLLoader

    @FXML // fx:id="lblPackageID"
    private Label lblPackageID; // Value injected by FXMLLoader

    @FXML // fx:id="btnNewBooking"
    private Button btnNewBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditBooking"
    private Button btnEditBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveBooking"
    private Button btnSaveBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteBooking"
    private Button btnDeleteBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnListBooking"
    private Button btnListBooking; // Value injected by FXMLLoader

    @FXML // fx:id="btnMakePDFCopy"
    private Button btnMakePDFCopy; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName"
    private Label lblUserName; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName1"
    private Label lblUserName1; // Value injected by FXMLLoader

    @FXML // fx:id="btnMainMenu"
    private Button btnMainMenu; // Value injected by FXMLLoader

    // delete booking action
    @FXML
    void btnDeleteBooking(ActionEvent event) {
        boolean isMyComboBoxEmpty = cbBookingID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a booking ID");
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you sure to delete this? " + cbBookingID.getValue() + " record");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                String bookingID = String.valueOf(cbBookingID.getValue());
                String customerID = String.valueOf(cbCustomerID.getValue());
                String tripTypeID = String.valueOf(cbTripTypeID.getValue());
                String packageID = String.valueOf(cbPackageID.getValue());
                bookingModel booking = new bookingModel();
                if (booking.deleteBooking(bookingID, customerID, tripTypeID, packageID)) {
                    Alert alerts = new Alert(Alert.AlertType.INFORMATION);
                    alerts.setTitle("Delete Package");
                    alerts.setContentText("Successfully Deleted package");
                    alerts.setHeaderText(null);
                    alerts.showAndWait();
                }
            }
        }
        loadBookingID();
    }

    // clearing the fields
    private void clearFields(){
        dpBookingDate.setPromptText("Select Booking Date");
        teBookingNumber.setText("");
        cbBookingID.setDisable(false);
        cbTravellerCount.setPromptText("Select Traveler Count");
        cbCustomerID.setPromptText("Select Customer ID");
        cbBookingID.setPromptText("Select Booking ID");
        cbTripTypeID.setPromptText("Select Trip Type ID");
        cbPackageID.setPromptText("Select Package ID");
        btnEditBooking.setDisable(false);
    }

    // creating alert function
    private void myAlert(String title, String content, String addInfo)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content + " " + addInfo);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    // Booking Insert Action
    @FXML
    void btnInsertBooking(ActionEvent event) {
        btnInsertBooking.setVisible(false);
        bookingModel booking = new bookingModel();
        booking.setBookingDate(dpBookingDate.getValue().toString());
        booking.setBookingNum(teBookingNumber.getText());
        booking.setTravelerCount(cbTravellerCount.getValue());
        booking.setCustomerID(String.valueOf(cbCustomerID.getValue()));
        booking.setTripTypeID(String.valueOf(cbTripTypeID.getValue()));
        booking.setPackageID(String.valueOf(cbPackageID.getValue()));
        if (booking.getBookingNum().trim().isEmpty()) {
            myAlert("Error Message", "The following columns can not be empty",
                    "Booking Date, Booking Number, Traveler Count, Customer ID, Trip Type ID, Package ID");
        }else if(booking.insertBooking() == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add New Package");
            alert.setContentText("Successfully Added Booking");
            alert.setHeaderText(null);
            alert.showAndWait();
            disableFields();
            cbBookingID.setDisable(false);
            btnEditBooking.setDisable(false);
            btnDeleteBooking.setDisable(false);
            btnSaveBooking.setVisible(true);
        }
    }

    // Edit booking action
    @FXML
    void btnEditBooking(ActionEvent event) {
        boolean isMyComboBoxEmpty = cbBookingID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a booking ID");
        }else {
            try {
                btnSaveBooking.setVisible(true);
                String bookingID = cbBookingID.getValue().toString();
                bookingModel booking = new bookingModel();
                booking.getBookingData(bookingID);
                teBookingNumber.setText(booking.getBookingNum());
                dpBookingDate.setPromptText(String.valueOf(booking.getBookingDate()));
                cbTravellerCount.setPromptText(String.valueOf(booking.getTravelerCount()));
                cbCustomerID.setPromptText(String.valueOf(booking.getCustomerID()));
                cbTripTypeID.setPromptText(booking.getTripTypeID());
                cbPackageID.setPromptText(String.valueOf(booking.getPackageID()));

                customerModel customer = new customerModel();
                ObservableList<customerModel> customerList = customer.loadCombo();
                cbCustomerID.setItems(customerList);

                packagesModel pkgs = new packagesModel();
                ObservableList<packagesModel> pkgsList = pkgs.loadPackageID();
                cbPackageID.setItems(pkgsList);

                tripTypeModel tripType = new tripTypeModel();
                ObservableList<tripTypeModel> tripTypeList = tripType.loadTripTypeID();
                cbTripTypeID.setItems(tripTypeList);

                cbTravellerCount.setDisable(false);
                cbTravellerCount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
                enableFields();
                btnEditBooking.setDisable(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Enabing the fields
    private void enableFields() {
        dpBookingDate.setDisable(false);
        teBookingNumber.setDisable(false);
        cbTravellerCount.setDisable(false);
        cbCustomerID.setDisable(false);
        cbTripTypeID.setDisable(false);
        cbPackageID.setDisable(false);
        btnSaveBooking.setDisable(false);
    }


    @FXML
    void btnListBooking(ActionEvent event) {

    }

    // main menu button event handler
    @FXML
    void btnMainMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        clickLabel(event, root);
    }

    // click event to go back
    private void clickLabel(MouseEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    // clearing the fields
    @FXML
    void btnMakePDFCopy(ActionEvent event) {
        clearFields();
    }

    // New booking event handler
    @FXML
    void btnNewBooking(ActionEvent event) {
        clearFields();
        btnInsertBooking.setVisible(true);
        cbBookingID.setDisable(true);
        cbCustomerID.setDisable(false);
        customerModel customer = new customerModel();
        ObservableList<customerModel> customerList = customer.loadCombo();
        cbCustomerID.setItems(customerList);

        cbPackageID.setDisable(false);
        packagesModel pkgs = new packagesModel();
        ObservableList<packagesModel> pkgsList = pkgs.loadPackageID();
        cbPackageID.setItems(pkgsList);

        cbTripTypeID.setDisable(false);
        tripTypeModel tripType = new tripTypeModel();
        ObservableList<tripTypeModel> tripTypeList = tripType.loadTripTypeID();
        cbTripTypeID.setItems(tripTypeList);

        cbTravellerCount.setDisable(false);
        cbTravellerCount.getItems().addAll(1,2,3,4,5,6,7,8,9,10);

        dpBookingDate.setDisable(false);
        teBookingNumber.setDisable(false);
        btnSaveBooking.setVisible(false);
        btnEditBooking.setDisable(true);
        btnDeleteBooking.setDisable(true);
        loadBookingID();
    }

    // update booking handler
    @FXML
    void btnSaveBooking(ActionEvent event) {
        btnInsertBooking.setVisible(false);
        try{
            bookingModel booking = new bookingModel();
            booking.setBookingDate(String.valueOf(dpBookingDate.getPromptText()));
            booking.setBookingNum(teBookingNumber.getText());
            booking.setTravelerCount(Integer.parseInt(cbTravellerCount.getPromptText()));
            booking.setCustomerID(String.valueOf(cbCustomerID.getValue()));
            booking.setTripTypeID(String.valueOf(cbTripTypeID.getPromptText()));
            booking.setPackageID(String.valueOf(cbPackageID.getValue()));

            String bookingID = cbBookingID.getValue().toString();
            Boolean result = booking.updateBooking(bookingID);
                if (result==true) {
                    btnEditBooking.setDisable(false);
                    myAlert("Saved Data","Successfully updated the data for: ", teBookingNumber.getText() + " Booking");
                    disableFields();
                    clearFields();
                }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // loading the Booking ID
    private void loadBookingID() {
        bookingModel booking = new bookingModel();
        ObservableList<bookingModel> bookingList = booking.loadBookingID();
        cbBookingID.setItems(bookingList);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cbBookingID != null : "fx:id=\"cbBookingID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblDateAndTime != null : "fx:id=\"lblDateAndTime\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblBookingDate != null : "fx:id=\"lblBookingDate\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblBookingNumber != null : "fx:id=\"lblBookingNumber\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert teBookingNumber != null : "fx:id=\"teBookingNumber\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert cbTravellerCount != null : "fx:id=\"cbTravellerCount\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblTravellerCount != null : "fx:id=\"lblTravellerCount\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert cbCustomerID != null : "fx:id=\"cbCustomerID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblCustomerID != null : "fx:id=\"lblCustomerID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert cbTripTypeID != null : "fx:id=\"cbTripTypeID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblTripTypeID != null : "fx:id=\"lblTripTypeID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert cbPackageID != null : "fx:id=\"cbPackageID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblPackageID != null : "fx:id=\"lblPackageID\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnNewBooking != null : "fx:id=\"btnNewBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnEditBooking != null : "fx:id=\"btnEditBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnSaveBooking != null : "fx:id=\"btnSaveBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnDeleteBooking != null : "fx:id=\"btnDeleteBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnListBooking != null : "fx:id=\"btnListBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnMakePDFCopy != null : "fx:id=\"btnMakePDFCopy\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblUserName != null : "fx:id=\"lblUserName\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert lblUserName1 != null : "fx:id=\"lblUserName1\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnMainMenu != null : "fx:id=\"btnMainMenu\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert dpBookingDate != null : "fx:id=\"dpBookingDate\" was not injected: check your FXML file 'Bookings.fxml'.";
        assert btnInsertBooking != null : "fx:id=\"btnInsertBooking\" was not injected: check your FXML file 'Bookings.fxml'.";
        loadDate();
        loadBookingID();
        disableFields();
    }

    // disabling the fields
    private void disableFields() {
        dpBookingDate.setDisable(true);
        teBookingNumber.setDisable(true);
        cbTravellerCount.setDisable(true);
        cbCustomerID.setDisable(true);
        cbTripTypeID.setDisable(true);
        cbPackageID.setDisable(true);
        btnSaveBooking.setDisable(true);
        btnInsertBooking.setVisible(false);
    }

    // load date
    private void loadDate() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            second = LocalDateTime.now().getSecond();
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();
            day = loadDay();
            lblDateAndTime.setText(hour + ":" + (minute) + ":" + second + " " + day);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        Calendar cal = Calendar.getInstance();
        lblUserName.setText(cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)+1) + "/" + cal.get(Calendar.YEAR));
    }

    // load AM/PM
    private String loadDay() {
        switch(hour){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return day = "A.M";
                //break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                return day = "P.M";
                //break;
        }
        return "XYZ";
    }
}
