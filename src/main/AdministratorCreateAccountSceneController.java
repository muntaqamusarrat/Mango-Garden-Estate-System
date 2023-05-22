/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class AdministratorCreateAccountSceneController implements Initializable {

    private User user;
    
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private TextArea readFileTextArea;
    @FXML
    private ComboBox<String> groupComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        groupComboBox.getItems().addAll("CEO", "Manager", "Employee", "Administrator", "Distributor");
        groupComboBox.setValue("user group");  
       
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
        Administrator admin = new Administrator();
        Administrator.createUser(Integer.parseInt(userIdTextField.getText()), nameTextField.getText(), passwordTextField.getText(), groupComboBox.getValue());
        nameTextField.setText("");
        userIdTextField.setText("");
        passwordTextField.setText("");
        readFileTextArea.setText("");
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("AdministratorScene.fxml"));
       Parent assignTaskParent = loader.load();
       Scene assignTaskScene = new Scene (assignTaskParent);
       AdministratorSceneController controller = loader.getController();
       controller.initData(user);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(assignTaskScene);
       window.show();
    }

    @FXML
    private void readButtonOnClick(ActionEvent event) {
   
    }
    
    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }    

    void initData(User user) {
        this.user = user;
    }
    
}
