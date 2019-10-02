/**
 * Sample Skeleton for 'listCustomers.fxml' Controller Class
 *  Author: Sohail Barat
 *  Date: 20th April 2019
 * */

package TravelExperts.Controller;

import TravelExperts.DB.customerModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

// List customer controller
public class listCustomerController {

    @FXML // fx:id="columnCustomerId"
    private TableColumn<customerModel, Integer> columnCustomerId; // Value injected by FXMLLoader

    @FXML // fx:id="ColumnFirstName"
    private TableColumn<customerModel, String> ColumnFirstName; // Value injected by FXMLLoader

    @FXML // fx:id="ColumnLastName"
    private TableColumn<customerModel, String> ColumnLastName; // Value injected by FXMLLoader

    @FXML // fx:id="columnAddress"
    private TableColumn<customerModel, String> columnAddress; // Value injected by FXMLLoader

    @FXML // fx:id="columnCountry"
    private TableColumn<customerModel, String> columnCountry; // Value injected by FXMLLoader

    @FXML // fx:id="columnEmail"
    private TableColumn<customerModel, String> columnEmail; // Value injected by FXMLLoader

    @FXML // fx:id="columnAgentID"
    private TableColumn<customerModel, String> columnAgentID; // Value injected by FXMLLoader

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="tvListCustomer"
    private TableView<customerModel> tvListCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="tfSearchCustomer"
    private TextField tfSearchCustomer; // Value injected by FXMLLoader

    @FXML // fx:id="btnMainMenu"
    private Button btnMainMenu; // Value injected by FXMLLoader

    @FXML
    void searchCustomer(KeyEvent event) {

    }

    // go to main menu button handler
    @FXML
    void btnMainMenu(MouseEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/Customers.fxml"));
        clickLabel(event, root);
    }

    // main menu scene
    private void clickLabel(MouseEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    private void clickLabel(ActionEvent event, Parent root) {
        Scene page = new Scene(root);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(page);
        window.show();
    }

    private void loadCustomerTableView(){
        //customerModel customer = null;
        //tvListCustomer.setItems(customer.loadCustomerTView());

    }


    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() throws SQLException {
        assert tvListCustomer != null : "fx:id=\"tvListCustomer\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert tfSearchCustomer != null : "fx:id=\"tfSearchCustomer\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert btnMainMenu != null : "fx:id=\"btnMainMenu\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert columnCustomerId != null : "fx:id=\"columnCustomerId\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert ColumnFirstName != null : "fx:id=\"ColumnFirstName\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert ColumnLastName != null : "fx:id=\"ColumnLastName\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert columnAddress != null : "fx:id=\"columnAddress\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert columnCountry != null : "fx:id=\"columnCountry\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert columnEmail != null : "fx:id=\"columnEmail\" was not injected: check your FXML file 'listCustomers.fxml'.";
        assert columnAgentID != null : "fx:id=\"columnAgentID\" was not injected: check your FXML file 'listCustomers.fxml'.";
        //columnCustomerId.setCellValueFactory(new PropertyValueFactory<>("columnCustomerId"));
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("CustAddress"));
        columnAgentID.setCellValueFactory(new PropertyValueFactory<>("CustAgent"));
        columnCountry.setCellValueFactory(new PropertyValueFactory<>("CustCountry"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("custEmail"));
        ColumnFirstName.setCellValueFactory(new PropertyValueFactory<>("CustFirstName"));
        ColumnLastName.setCellValueFactory(new PropertyValueFactory<>("CustLastName"));
        loadCustomerTableView();
        customerModel customer = null;

        ObservableList<customerModel> data;// = FXCollections.observableArrayList();
                /*new customerModel("kjhk","Amos", "Chepchieng","jhgj","jhgjhg","khjh","gjhg","hgh","hgfgh","hghgf",
                1));*/
        tvListCustomer.setItems(customer.loadCustomerTView());
        tvListCustomer.getColumns().addAll(columnAgentID, ColumnFirstName, ColumnLastName, columnAddress,
                columnCountry, columnAgentID);
    }
}
