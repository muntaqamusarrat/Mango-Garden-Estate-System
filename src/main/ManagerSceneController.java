/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class ManagerSceneController implements Initializable {

    private User user;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void assignTaskButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("ManagerAssignTaskScene.fxml"));
       Parent assignTaskParent = loader.load();
       Scene assignTaskScene = new Scene (assignTaskParent);
       ManagerAssignTaskSceneController controller = loader.getController();
       controller.initData(user);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(assignTaskScene);
       window.show();
    }

    @FXML
    private void setMeetingButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void approveLeaveButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("LoginScene.fxml"));
       Parent logoutParent = loader.load();
       Scene logoutScene = new Scene (logoutParent);
       ManagerAssignTaskSceneController controller = loader.getController();
       controller.initData(user);
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
       
       window.setScene(logoutScene);
       window.show();
    }

    void initData(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
