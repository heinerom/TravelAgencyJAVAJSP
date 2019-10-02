package TravelExperts.Controller;

/*
* Author: Sohail Barat, Muhammad, Sheila, Eugenia
* Supplier Controller
* Date: 20th April 2019
* */
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static TravelExperts.Controller.MenuController.clickLabel;

// Supplier Controller
public class SupplierController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bpMain;

    @FXML
    private Label lblAddSupplier;

    @FXML
    private Label lblEditSupplier;

    @FXML
    private Label lblDeleteSupplier;

    @FXML
    private Label lblExit;

    // button exit event handler
    @FXML
    void onClickedExit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        clickLabel(event, root);
    }

    // on page load event
    @FXML
    void initialize() {
        assert bpMain != null : "fx:id=\"bpMain\" was not injected: check your FXML file 'Suppliers.fxml'.";
        assert lblAddSupplier != null : "fx:id=\"lblAddSupplier\" was not injected: check your FXML file 'Suppliers.fxml'.";
        assert lblEditSupplier != null : "fx:id=\"lblEditSupplier\" was not injected: check your FXML file 'Suppliers.fxml'.";
        assert lblDeleteSupplier != null : "fx:id=\"lblDeleteSupplier\" was not injected: check your FXML file 'Suppliers.fxml'.";
        assert lblExit != null : "fx:id=\"lblExit\" was not injected: check your FXML file 'Suppliers.fxml'.";

    }
}
