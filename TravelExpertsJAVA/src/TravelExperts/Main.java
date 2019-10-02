package TravelExperts;
/*
* Author: Sohail Barat
* Date: 20th April 2019
* Main class
* */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

// Main class
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Scene settings
        Parent root = FXMLLoader.load(getClass().getResource("GUI/LoginPage.fxml"));
        primaryStage.setTitle("Travel Experts");
        primaryStage.setScene(new Scene(root, 800,  440));
        primaryStage.setResizable(false);
        primaryStage.alwaysOnTopProperty();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
