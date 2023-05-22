/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ManagerAssignMeetingSceneController implements Initializable {

    private User selectedUser;
    @FXML
    private TextField dateTextField;
    @FXML
    private TextField timeTextField;
    @FXML
    private TextArea topicTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void saveButtonOnClick(ActionEvent event) {
    Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure you want to assign the meeting?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task
            Manager m = new Manager();
            m.assignMeetingtoEmployee(dateTextField.getText(), timeTextField.getText(),topicTextArea.getText());
            
            showCustomInformationAlert("Meeting is assigned.");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Failed to assign the meeting"); 
        }
        dateTextField.setText("");
        timeTextField.setText("");
        topicTextArea.setText("");
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
    FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("ManagerScene.fxml"));
       Parent assignTaskParent = loader.load();
       Scene assignTaskScene = new Scene (assignTaskParent);
       ManagerSceneController controller = loader.getController();
       controller.initData(selectedUser);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(assignTaskScene);
       window.show();
    }

    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait(); 
    }
    
}
