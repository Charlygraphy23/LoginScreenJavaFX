package sample.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.controller.DetailsController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField usernameText;

    @FXML
    private JFXPasswordField passwordText;

    @FXML
    private JFXButton loginButton;

    @FXML
    void initialize() {

        usernameText.setStyle("-fx-text-inner-color: #fafafa ");
        passwordText.setStyle("-fx-text-inner-color: #fafafa ");

        loginButton.setOnMouseClicked(mouseEvent -> {
            try {
                showDetailsPage();
                loginButton.getScene().getWindow().hide();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });


    }

    private void showDetailsPage() throws IOException {

        if (!usernameText.getText().toString().trim().equals("") && !passwordText.getText().toString().trim().equals("")) {


           FXMLLoader loader=new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/view/details.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Parent root=loader.getRoot();
            Stage stage=new Stage();
            stage.setScene(new Scene(root));

            DetailsController detailsController=loader.getController();
            detailsController.setDetailsName(usernameText.getText().toUpperCase(),"M",16,"Java");

            stage.show();
            stage.setResizable(false);

        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid Username And Password");
            alert.setHeaderText("Alert");
            alert.setWidth(100);
            alert.setHeight(100);
            Stage stage=new Stage();
            Parent root=FXMLLoader.load(getClass().getResource("/sample/view/sample.fxml"));
            stage.setScene(new Scene(root));
            alert.setOnHiding(dialogEvent -> {
                stage.show();
            });
            alert.setResizable(false);
            alert.show();



        }

    }
}
