package sample.controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class DetailsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private Label detailsWelcome;

    @FXML
    private URL location;

    @FXML
    private Label detailsName;

    @FXML
    private Label detailsGender;

    @FXML
    private Label detailsAge;

    @FXML
    private Label detailsProfession;

    @FXML
    private Hyperlink detailInsta;

    @FXML
    private Hyperlink DetailsGithub;
    @FXML
    private JFXButton detailsButtonContact;

    @FXML
    public void initialize() {

        detailInsta.setOnAction(actionEvent -> {
            if(Desktop.isDesktopSupported()){
                try {
                    Desktop.getDesktop().browse(new URI("http://www.instagram.com/charlygraphy23"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

        DetailsGithub.setOnAction(actionEvent -> {
            if(Desktop.isDesktopSupported()){
                try {
                    Desktop.getDesktop().browse(new URI("http://www.github.com/Charlygraphy23"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });

       detailsButtonContact.setOnMouseClicked(mouseEvent ->  {

           detailsButtonContact.getScene().getWindow().hide();

            FXMLLoader loader=new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/view/contuct.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage stage=new Stage();
            Parent root=loader.getRoot();
            stage.setScene(new Scene(root));
            ContuctUs contuctUs=loader.getController();
            contuctUs.setContactName(detailsName.getText());
            stage.show();
            stage.setResizable(false);


        });
    }

    public void setDetailsName(String detailsName,String detailsGender, int detailsAge,String detailsProfession ) {
        this.detailsName.setText(detailsName);
        detailsWelcome.setText("Welcome "+detailsName);
        this.detailsGender.setText(detailsGender);
        this.detailsAge.setText(String.valueOf(detailsAge));
        this.detailsProfession.setText(detailsProfession);

    }


}
