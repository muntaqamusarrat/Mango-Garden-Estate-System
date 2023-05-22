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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hp
 */
public class EmployeeViewTaskByCEOSceneController implements Initializable {

    private User user;
    @FXML
    private TextArea viewTaskTextArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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

}
