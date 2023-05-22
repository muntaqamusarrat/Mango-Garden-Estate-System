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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class CEOAssignTaskSceneController implements Initializable {

    private User user;
    @FXML
    private TextField employeeIdTextField;
    @FXML
    private TextArea taskTextArea;
    @FXML
    private TextField deadlineTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void submitButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure you want to assign the task?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task
            Integer.parseInt(employeeIdTextField.getText());
            deadlineTextField.getText();
            taskTextArea.getText();
            showCustomInformationAlert("Task is assigned.");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Failed to assign the task"); 
        }
        employeeIdTextField.setText("");
        deadlineTextField.setText("");
        taskTextArea.setText("");
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("CEOScene.fxml"));
       Parent CEOParent = loader.load();
       Scene assignTaskScene = new Scene (CEOParent);
       CEOAssignTaskSceneController controller = loader.getController();
       controller.initData(user);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(assignTaskScene);
       window.show();
    }

    void initData(User user) {
      
    }
    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }  
}
