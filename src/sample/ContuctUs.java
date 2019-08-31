package sample;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.EventListener;
import java.util.ResourceBundle;

public class ContuctUs {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField contactName;

    @FXML
    private JFXTextField contactEmail;

    @FXML
    private JFXTextField contactMobile;

    @FXML
    private JFXTextArea contactMessage;

    @FXML
    private Hyperlink hyperlink;
    @FXML
    private Hyperlink insta;

    private Image fbImage,instaImage;
    private ImageView fbImageView,instaImaveView;

    @FXML
    void initialize() throws FileNotFoundException {

        facbookClicked();
        instaClicked();

    }

    private void instaClicked() throws FileNotFoundException {
        instaImage=new Image(new FileInputStream("C:\\Users\\Dip\\IdeaProjects\\LoginScreenJavaFX\\src\\sample\\assets\\icons8-instagram-32.png"));
        instaImaveView=new ImageView(instaImage);
        insta.setGraphic(instaImaveView);
        insta.setOnAction(actionEvent -> {
            if(Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.instagram.com/charlygraphy23"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void facbookClicked() throws FileNotFoundException {
         fbImage=new Image(new FileInputStream("C:\\Users\\Dip\\IdeaProjects\\LoginScreenJavaFX\\src\\sample\\assets\\icons8-facebook-26.png"));
        fbImageView=new ImageView(fbImage);
        hyperlink.setGraphic(fbImageView);
        hyperlink.setOnAction(actionEvent -> {
            if(Desktop.isDesktopSupported()){
                try {
                    Desktop.getDesktop().browse(new URI("http://www.facbook.com/charlygraphy23"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setContactName(String contactName) {
        this.contactName.setText(contactName);
    }
}
