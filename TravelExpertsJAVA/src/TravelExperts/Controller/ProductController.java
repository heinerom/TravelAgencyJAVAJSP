package TravelExperts.Controller;

/*
* Author: Sohail, Eugenia, Sheila, Muhammad
* Date: 20th April 2019
* Product Controller
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

public class ProductController {

    // Product variables
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane bpMain;

    @FXML
    private Label lblCreateProduct;

    @FXML
    private Label lblEditProduct;

    @FXML
    private Label lblDeleteProduct;

    @FXML
    private Label lblExit;


    // button click exit handler
    @FXML
    void onClickedExit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Main.fxml"));
        clickLabel(event, root);
    }

    @FXML
    void initialize() {
        assert bpMain != null : "fx:id=\"bpMain\" was not injected: check your FXML file 'Products.fxml'.";
        assert lblCreateProduct != null : "fx:id=\"lblCreateProduct\" was not injected: check your FXML file 'Products.fxml'.";
        assert lblEditProduct != null : "fx:id=\"lblEditProduct\" was not injected: check your FXML file 'Products.fxml'.";
        assert lblDeleteProduct != null : "fx:id=\"lblDeleteProduct\" was not injected: check your FXML file 'Products.fxml'.";
        assert lblExit != null : "fx:id=\"lblExit\" was not injected: check your FXML file 'Products.fxml'.";

    }

}
