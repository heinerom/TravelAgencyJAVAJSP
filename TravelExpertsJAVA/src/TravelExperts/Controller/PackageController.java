package TravelExperts.Controller; /**
 * Sample Skeleton for 'TravelPackages.fxml' Controller Class
 * Author: Sohail Barat
 * Date: 20th April 2019
 * */

import TravelExperts.DB.packagesModel;
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
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;

// Package controller
public class PackageController {

    // variables for time
    private int minute;
    private int hour;
    private int second;
    private String day = "";

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cbPackageID"
    private ComboBox<packagesModel> cbPackageID; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgName"
    private TextField tfPkgName; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgDesc"
    private TextField tfPkgDesc; // Value injected by FXMLLoader

    @FXML // fx:id="tfPkgBasePrice"
    private TextField tfPkgBasePrice; // Value injected by FXMLLoader

    @FXML // fx:id="tfAgencyComm"
    private TextField tfAgencyComm; // Value injected by FXMLLoader

    @FXML // fx:id="btnEditPackage"
    private Button btnEditPackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnMainMenu"
    private Button btnMainMenu; // Value injected by FXMLLoader

    @FXML // fx:id="btnSavePackage"
    private Button btnSavePackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnAddPackage"
    private Button btnAddPackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnInsertPackage"
    private Button btnInsertPackage; // Value injected by FXMLLoader

    @FXML // fx:id="btnDeletePackage"
    private Button btnDeletePackage; // Value injected by FXMLLoader

    @FXML // fx:id="dpEndDate"
    private DatePicker dpEndDate; // Value injected by FXMLLoader

    @FXML // fx:id="dpStartDate"
    private DatePicker dpStartDate; // Value injected by FXMLLoader

    @FXML // fx:id="lblDateAndTime"
    private Label lblDateAndTime; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName"
    private Label lblUserName; // Value injected by FXMLLoader

    @FXML // fx:id="lblUserName1"
    private Label lblUserName1; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader

    // button clear handler
    @FXML
    void btnClear(ActionEvent event) {
        clearFields();
        cbPackageID.setDisable(false);
        btnEditPackage.setDisable(false);
    }

    // button delete handler
    @FXML
    void btnDeletePackage(ActionEvent event) {
        boolean isMyComboBoxEmpty = cbPackageID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a package ID");
        }else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you sure to delete this? " + cbPackageID.getValue() + " record");
            Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    String packageId = String.valueOf(cbPackageID.getValue());
                    packagesModel pkg = new packagesModel();
                    if (pkg.deletePackage(packageId)) {
                        Alert alerts = new Alert(Alert.AlertType.INFORMATION);
                        alerts.setTitle("Delete Package");
                        alerts.setContentText("Successfully Deleted package");
                        alerts.setHeaderText(null);
                        alerts.showAndWait();
                    }
                    loadPackageID();
                }
        }
    }

    // button add package handler
    @FXML
    void btnAddPackage(ActionEvent event) {
        clearFields();
        btnEditPackage.setDisable(true);
        btnSavePackage.setDisable(true);
        enableFields();
        btnSavePackage.setVisible(false);
        btnAddPackage.setDisable(true);
        btnInsertPackage.setVisible(true);
        btnDeletePackage.setDisable(true);
    }

    // button insert package handler
    @FXML
    void btnInsertPackage(ActionEvent event) {
        packagesModel pkg = new packagesModel();
        pkg.setPkgBasePrice(Double.parseDouble(tfPkgBasePrice.getText()));
        pkg.setPkgDesc(tfPkgDesc.getText());
        pkg.setPkgEndDate(String.valueOf(dpEndDate.getValue()));
        pkg.setPkgEndDate(String.valueOf(dpEndDate.getValue()));
        pkg.setPkgName(tfPkgName.getText());
        pkg.setAgencyComm(Double.parseDouble(tfAgencyComm.getText()));
        if (pkg.getPkgName().trim().isEmpty() || Double.valueOf(pkg.getPkgBasePrice()).isNaN()) {
            myAlert("Error Message", "The following columns can not be empty", "Package Name and Package Base Price");
        }else if(pkg.insertPackage() == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Add New Package");
            alert.setContentText("Successfully Added package");
            alert.setHeaderText(null);
            alert.showAndWait();
            disableFields();
            cbPackageID.setDisable(false);
            btnEditPackage.setDisable(false);
            btnDeletePackage.setDisable(false);
            btnSavePackage.setDisable(false);
            }
        }

        // click label handler
    public void clickLabel(MouseEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    //alert handler
    private void myAlert(String title, String content, String addInfo)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content + " " + addInfo);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    // button edit package handler
    @FXML
    void btnEditPackage(ActionEvent event) throws ParseException {
        boolean isMyComboBoxEmpty = cbPackageID.getSelectionModel().isEmpty();
        if (isMyComboBoxEmpty==true){
            myAlert("Combo Box Alert", "Error Message: ", "Please select a Package ID");
        }else {
            try {
                String customerId = cbPackageID.getValue().toString();
                packagesModel pkg = new packagesModel();
                pkg.getPackageData(customerId);
                tfPkgName.setText(pkg.getPkgName());
                dpStartDate.setPromptText(String.valueOf(pkg.getPkgStartDate()));
                dpEndDate.setPromptText(String.valueOf(pkg.getPkgEndDate()));
                tfPkgDesc.setText(pkg.getPkgDesc());
                tfPkgBasePrice.setText(String.valueOf(pkg.getPkgBasePrice()));
                tfAgencyComm.setText(String.valueOf(pkg.getAgencyComm()));
                enableFields();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // enable fields
    private void enableFields() {
        tfAgencyComm.setDisable(false);
        tfPkgBasePrice.setDisable(false);
        tfPkgDesc.setDisable(false);
        dpEndDate.setDisable(false);
        tfPkgName.setDisable(false);
        dpStartDate.setDisable(false);
        btnSavePackage.setDisable(false);
        btnEditPackage.setDisable(true);
        cbPackageID.setDisable(true);
    }

    // button main menu handler
    @FXML
    void btnMainMenu(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        clickLabel(event, root);
    }

    // button update package handler
    @FXML
    void btnSavePackage(ActionEvent event) {
        try{
            packagesModel pkg = new packagesModel();
            pkg.setPkgBasePrice(Double.parseDouble(tfPkgBasePrice.getText()));
            pkg.setPkgDesc(tfPkgDesc.getText());
            pkg.setPkgEndDate(String.valueOf(dpEndDate.getValue()));
            pkg.setPkgStartDate(String.valueOf(dpStartDate.getValue()));
            pkg.setPkgName(tfPkgName.getText());
            pkg.setAgencyComm(Double.parseDouble(tfAgencyComm.getText()));
            String packageId = cbPackageID.getValue().toString();
            if (pkg.getPkgName().trim().isEmpty() || Double.valueOf(pkg.getPkgBasePrice()).isNaN() || dpStartDate.getValue() == null|| dpEndDate.getValue() == null) {
                myAlert("Error Message", "The following columns can not be empty", "Package Name, Package Start Date," +
                        " Package End Date" +
                        " and " +
                        "Package Base " +
                        "Price");
            }else{
            Boolean result = pkg.updatePackage(packageId);
            if (result==true){
                myAlert("Message", "Data saved for package number: ", "" + cbPackageID.getValue());
                btnEditPackage.setDisable(false);
                disableFields();
                clearFields();
                cbPackageID.setDisable(false);
            }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    // clear fields
    private void clearFields() {
        tfPkgName.setText("");
        dpStartDate.setValue(LocalDate.of(1998, 10, 8));
        dpEndDate.setValue(LocalDate.of(1998, 10, 8));
        tfPkgDesc.setText("");
        tfPkgBasePrice.setText("");
        tfAgencyComm.setText("");
    }

    // load package ID
    public void loadPackageID(){
        packagesModel pkg = new packagesModel();
        ObservableList<packagesModel> packageIdsList = pkg.loadPackageID();
        cbPackageID.setItems(packageIdsList);
    }

    // disable fields
    private void disableFields() {
        tfAgencyComm.setDisable(true);
        tfPkgBasePrice.setDisable(true);
        tfPkgDesc.setDisable(true);
        dpEndDate.setDisable(true);
        tfPkgName.setDisable(true);
        dpStartDate.setDisable(true);
        btnSavePackage.setDisable(true);
        btnInsertPackage.setVisible(false);
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert tfPkgName != null : "fx:id=\"tfPkgName\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert tfPkgDesc != null : "fx:id=\"tfPkgDesc\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert tfPkgBasePrice != null : "fx:id=\"tfPkgBasePrice\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert tfAgencyComm != null : "fx:id=\"tfAgencyComm\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnEditPackage != null : "fx:id=\"btnEditPackage\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnMainMenu != null : "fx:id=\"btnMainMenu\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnSavePackage != null : "fx:id=\"btnSavePackage\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnInsertPackage != null : "fx:id=\"btnInsertPackage\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnDeletePackage != null : "fx:id=\"btnDeletePackage\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert dpEndDate != null : "fx:id=\"dpEndDate\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert dpStartDate != null : "fx:id=\"dpStartDate\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert lblDateAndTime != null : "fx:id=\"lblDateAndTime\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert lblUserName != null : "fx:id=\"lblUserName\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert lblUserName1 != null : "fx:id=\"lblUserName1\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'TravelPackages.fxml'.";
        loadDate();
        loadPackageID();
        disableFields();
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
