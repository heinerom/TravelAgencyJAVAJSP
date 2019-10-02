package TravelExperts.Controller;

/*
* Author: Sohail Barat, Muhammad, Eugenia, Sheila
* Menu Controller class. This is used to see all the menus
* */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController {

    // Variables
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bpMain;

    @FXML
    private Label lblMenu;

    @FXML
    private Label lblCustomer;

    @FXML
    private Label lblBooking;

    @FXML
    private Label lblPackage;

    @FXML
    private Label lblProduct;

    @FXML
    private Label lblSupplier;

    @FXML
    private Label lblSignout;

    // customer clicked event handler
    @FXML
    void OnCustomerClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Customers.fxml"));
        clickLabel(event, root);
    }

    // clicked booking event handler
    @FXML
    void OnBookingClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Bookings.fxml"));
        clickLabel(event, root);
    }

    // packaged clicked event handler
    @FXML
    void OnPackageClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/TravelPackages.fxml"));
        clickLabel(event, root);
    }

    // product clicked event handler
    @FXML
    void OnProductClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Products.fxml"));
        clickLabel(event, root);
    }

    // supplier clicked event handler
    @FXML
    void OnSupplierClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Suppliers.fxml"));
        clickLabel(event, root);
    }

    // Sign out clicked event handler
    @FXML
    void OnSignOutClicked(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/LoginPage.fxml"));
        clickLabel(event, root);
    }

    // click event handler
    public static void clickLabel(MouseEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    // on page load initializa
    @FXML
    void initialize() {
        assert bpMain != null : "fx:id=\"bpMain\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblMenu != null : "fx:id=\"lblMenu\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblCustomer != null : "fx:id=\"lblCustomer\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblBooking != null : "fx:id=\"lblBooking\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblPackage != null : "fx:id=\"lblPackage\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblProduct != null : "fx:id=\"lblProduct\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblSupplier != null : "fx:id=\"lblSupplier\" was not injected: check your FXML file 'Main.fxml'.";
        assert lblSignout != null : "fx:id=\"lblSignout\" was not injected: check your FXML file 'Main.fxml'.";

    }
}
