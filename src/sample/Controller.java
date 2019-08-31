package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

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
            showDetailsPage();
            loginButton.getScene().getWindow().hide();
        });


    }

    private void showDetailsPage()  {

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

    }
}
