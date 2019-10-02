package TravelExperts.Controller;
/**
 * Sample Skeleton for 'Customers.fxml' Controller Class
 *  Author: Sohail Barat
 *  Date 20th April 2019
 * */

import TravelExperts.DB.customerModel;
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

// Customer Controller
public class CustomerController {

    // variables for time
    private int minute;
    private int hour;
    private int second;
    private String day = "";

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cbCustomerID"
    private ComboBox<customerModel> cbCustomerID; // Value injected by FXMLLoader

    @FXML // fx:id="tfFirstName"
    private TextField tfFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="tfLastName"
    private TextField tfLastName; // Value injected by FXMLLoader

    @FXML // fx:id="tfAddress"
    private TextField tfAddress; // Value injected by FXMLLoader

    @FXML // fx:id="tfCity"
    private TextField tfCity; // Value injected by FXMLLoader

    @FXML // fx:id="tfProvince"
    private TextField tfProvince; // Value injected by FXMLLoader

    @FXML // fx:id="tfPostalCode"
    private TextField tfPostalCode; // Value injected by FXMLLoader

    @FXML // fx:id="tfCountry"
    private TextField tfCountry; // Value injected by FXMLLoader

    @FXML // fx:id="tfBusPhone"
    private TextField tfBusPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfResPhone"
    private TextField tfResPhone; // Value injected by FXMLLoader

    @FXML // fx:id="tfEmail"
    private TextField tfEmail; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgentID"
    private TextField tfAgentID; // Value injected by FXMLLoader

    @FXML // fx:id="btnMainMenu"
    private Button btnMainMenu; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditCustomer"
    private Button btnEditCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnSaveCustomer"
    private Button btnSaveCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeleteCustomer"
    private Button btnDeleteCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="tbListCustomer"
    private ToggleButton tbListCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnListCustomers"
    private Button btnListCustomers; // Value injected by FXMLLoader

    @FXML // fx:id="lblDateAndTime"
    private Label lblDateAndTime; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName"
    private Label lblUserName; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName1"
    private Label lblUserName1; // Value injected by FXMLLoader

    @FXML
    void btnListCustomers(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/listCustomers.fxml"));
        clickLabel(event, root);
    }

    // clear button event
    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
        cbCustomerID.setDisable(false);
        btnEditCustomer.setDisable(false);
    }

    // button delete customer event
    @FXML
    void btnDeleteCustomer(ActionEvent event) {
        boolean isMyComboBoxEmpty = cbCustomerID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a customer ID");
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you sure to delete this? " + tfFirstName.getText() + " " + tfLastName.getText() + " record");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                String packageId = String.valueOf(cbCustomerID.getValue());
                String agentId = tfAgentID.getText();
                customerModel pkg = new customerModel();
                if (pkg.deleteCustomer(packageId, agentId)) {
                    Alert alerts = new Alert(Alert.AlertType.INFORMATION);
                    alerts.setTitle("Delete Package");
                    alerts.setContentText("Successfully Deleted package");
                    alerts.setHeaderText(null);
                    alerts.showAndWait();
                }
                loadCustomerID();
            }
        }
    }

    // Alert creation function
    private void myAlert(String title, String content, String addInfo)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content + " " + addInfo);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    // button edit customer event handler
    @FXML
    void btnEditCustomer(ActionEvent event) {
        boolean isMyComboBoxEmpty = cbCustomerID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a customer ID");
        }else {
            try {
                String customerId = cbCustomerID.getValue().toString();
                customerModel customer = new customerModel();
                customer.getCustomerData(customerId);
                tfProvince.setText(customer.getCustProv());
                tfResPhone.setText(customer.getCustHomePhone());
                tfPostalCode.setText(customer.getCustPostal());
                tfLastName.setText(customer.getCustLastName());
                tfFirstName.setText(customer.getCustFirstName());
                tfEmail.setText(customer.getCustEmail());
                tfAgentID.setText(String.valueOf(customer.getCustAgent()));
                tfCountry.setText(customer.getCustCountry());
                tfCity.setText(customer.getCustCity());
                tfBusPhone.setText(customer.getCustBussPhone());
                tfAddress.setText(customer.getCustAddress());
                enableFields();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // button to go to main menu event handler
    @FXML
    void btnMainMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        clickLabel(event, root);
    }

    // move to another scene
    private void clickLabel(MouseEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    // clear fields function
    private void clearFields() {
        cbCustomerID.setPromptText("Select customer ID");
        tfAddress.setText("");
        tfBusPhone.setText("");
        tfCity.setText("");
        tfCountry.setText("");
        tfAgentID.setText("");
        tfEmail.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        tfPostalCode.setText("");
        tfProvince.setText("");
        tfResPhone.setText("");
    }

    // button update customer event handler
    @FXML
    void btnSaveCustomer(ActionEvent event) {
            try{
                customerModel customer = new customerModel();
                customer.setCustFirstName(tfFirstName.getText());
                customer.setCustLastName(tfLastName.getText());
                customer.setCustAddress(tfAddress.getText());
                customer.setCustCity(tfCity.getText());
                customer.setCustProv(tfProvince.getText());
                customer.setCustPostal(tfPostalCode.getText());
                customer.setCustCountry(tfCountry.getText());
                customer.setCustHomePhone(tfResPhone.getText());
                customer.setCustBussPhone(tfBusPhone.getText());
                customer.setCustEmail(tfEmail.getText());
                customer.setCustAgent(Integer.parseInt(tfAgentID.getText()));
                String customerId = cbCustomerID.getValue().toString();
                if (customer.getCustFirstName().trim().isEmpty() || customer.getCustLastName().trim().isEmpty() || customer.getCustAddress().trim().isEmpty() || customer.getCustCity().trim().isEmpty() || customer.getCustProv().trim().isEmpty() || customer.getCustPostal().trim().isEmpty() || customer.getCustBussPhone().trim().isEmpty() || customer.getCustEmail().trim().isEmpty()) {
                    myAlert("Error Message", "The following columns can not be empty", "First Name, Last Name, " +
                            "Address, City, Province, Postal Code, Business Phone, Email");
                }else{
                    Boolean result = customer.updateCustData(customerId);
                    if (result==true) {
                        btnEditCustomer.setDisable(false);
                        myAlert("Saved Data","Successfully updated the data for: ", tfFirstName.getText() + " " + tfLastName.getText());
                        disableFields();
                        clearFields();
                    }
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        // enable the fields
    private void enableFields() {
        tfAddress.setDisable(false);
        tfBusPhone.setDisable(false);
        tfCity.setDisable(false);
        tfCountry.setDisable(false);
        tfAgentID.setDisable(false);
        tfEmail.setDisable(false);
        tfFirstName.setDisable(false);
        tfLastName.setDisable(false);
        tfPostalCode.setDisable(false);
        tfProvince.setDisable(false);
        btnSaveCustomer.setDisable(false);
        tfResPhone.setDisable(false);
        btnEditCustomer.setDisable(true);
        cbCustomerID.setDisable(true);
    }

    // load customer IDs
    private void loadCustomerID() {
        customerModel customer = new customerModel();
        ObservableList<customerModel> customerIdsList = customer.loadCombo();
        cbCustomerID.setItems(customerIdsList);
    }

    // disable fields
    private void disableFields()
    {
        tfAddress.setDisable(true);
        tfBusPhone.setDisable(true);
        tfCity.setDisable(true);
        tfCountry.setDisable(true);
        tfAgentID.setDisable(true);
        tfEmail.setDisable(true);
        tfFirstName.setDisable(true);
        tfLastName.setDisable(true);
        tfPostalCode.setDisable(true);
        tfProvince.setDisable(true);
        btnSaveCustomer.setDisable(true);
        tfResPhone.setDisable(true);
        cbCustomerID.setDisable(false);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cbCustomerID != null : "fx:id=\"cbCustomerID\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfFirstName != null : "fx:id=\"tfFirstName\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfLastName != null : "fx:id=\"tfLastName\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfAddress != null : "fx:id=\"tfAddress\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfCity != null : "fx:id=\"tfCity\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfProvince != null : "fx:id=\"tfProvince\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfPostalCode != null : "fx:id=\"tfPostalCode\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfCountry != null : "fx:id=\"tfCountry\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfBusPhone != null : "fx:id=\"tfBusPhone\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfResPhone != null : "fx:id=\"tfResPhone\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfEmail != null : "fx:id=\"tfEmail\" was not injected: check your FXML file 'Customers.fxml'.";
        assert tfAgentID != null : "fx:id=\"tfAgentID\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnMainMenu != null : "fx:id=\"btnMainMenu\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnEditCustomer != null : "fx:id=\"btnEditCustomer\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnSaveCustomer != null : "fx:id=\"btnSaveCustomer\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnDeleteCustomer != null : "fx:id=\"btnDeleteCustomer\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnListCustomers != null : "fx:id=\"btnListCustomers\" was not injected: check your FXML file 'Customers.fxml'.";
        assert lblDateAndTime != null : "fx:id=\"lblDateAndTime\" was not injected: check your FXML file 'Customers.fxml'.";
        assert lblUserName != null : "fx:id=\"lblUserName\" was not injected: check your FXML file 'Customers.fxml'.";
        assert lblUserName1 != null : "fx:id=\"lblUserName1\" was not injected: check your FXML file 'Customers.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Customers.fxml'.";
        loadDate();
        loadCustomerID();
        disableFields();
        cbCustomerID.setStyle("-fx-text-fill: blue;");
    }

    // load date function
    private void loadDate() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            second = LocalDateTime.now().getSecond();
            minute = LocalDateTime.now().getMinute();
            hour = LocalDateTime.now().getHour();
            hour = LocalDateTime.now().getHour();
            day = loadDay();
            lblDateAndTime.setText(hour + ":" + (minute) + ":" + second + " " + day);
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
        Calendar cal = Calendar.getInstance();
        lblUserName.setText(cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));
    }

    // load day
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
