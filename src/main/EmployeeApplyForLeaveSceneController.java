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
public class EmployeeApplyForLeaveSceneController implements Initializable {

    private User user;
    @FXML
    private TextField startingDate;
    @FXML
    private TextField endingDate;
    @FXML
    private TextArea reasonTaskArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void applyForLeaveButtonOnClick(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmation Alert");
        a.setHeaderText("Confirm your opinion...");
        a.setContentText("Are you sure you want to apply for this request?");
                
        Optional<ButtonType> result = a.showAndWait();
        if(result.get() == ButtonType.OK){
            //you need to write the code to perform the actual task
            Employee emp = new Employee();
            emp.applyLeave(startingDate.getText(), endingDate.getText(), reasonTaskArea.getText());
            
            showCustomInformationAlert("Request for leave is successful");
        }
        else{
            //show appropriate cancellation message
            showCustomInformationAlert("Failed to request"); 
        }
        startingDate.setText("");
        endingDate.setText("");
        reasonTaskArea.setText("");
    }

    @FXML
    private void backButtonOnClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("EmployeeScene.fxml"));
        Parent EmployeeParent = loader.load();
        Scene EmployeeHomescene = new Scene(EmployeeParent);
        EmployeeSceneController controller = loader.getController();
        controller.initData(user);
        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
        window1.setScene(EmployeeHomescene);
        window1.show();
    }
    
    private void showCustomInformationAlert(String str) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(str);
        a.showAndWait();         
    }   

    void initData(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
