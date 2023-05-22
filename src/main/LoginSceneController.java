
package main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginSceneController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> groupComboBox;
    @FXML
    private Label label;
    @FXML
    private Button login;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        groupComboBox.getItems().addAll("CEO", "Manager", "Employee", "Administrator", "Distributor");
        groupComboBox.setValue("user group");  
        ArrayList<User>uList = User.usersGroup();
        for(User u : uList){
            System.out.println(u.toString());
        }
    }    

    @FXML
    private void loginButtonOnClick(ActionEvent event) throws IOException {
        User user = User.login(Integer.parseInt(userIdTextField.getText()),passwordTextField.getText(),groupComboBox.getValue());

        if(user == null){
            label.setText("Incorrect user ID or password. Please try again!");
            userIdTextField.setText("");
            passwordTextField.setText("");
            groupComboBox.setValue("user group");
        }
        else if(userIdTextField.getText().isEmpty() && passwordTextField.getText().isEmpty()){
            label.setText("Please enter user ID or password");
        }   
        else{
            if(user instanceof CEO){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("CEOScene.fxml"));
                Parent CEOParent = loader.load();
                Scene CEOHomescene = new Scene(CEOParent);
                CEOSceneController controller = loader.getController();
                controller.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(CEOHomescene);
                window1.show();
            }
            else if(user instanceof Manager){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("ManagerScene.fxml"));
                Parent ManagerParent = loader.load();
                Scene ManagerHomescene = new Scene(ManagerParent);
                ManagerSceneController controller = loader.getController();
                controller.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(ManagerHomescene);
                window1.show();
            } 
            else if(user instanceof Employee){
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
            else if(user instanceof Administrator){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("AdministratorScene.fxml"));
                Parent AdminParent = loader.load();
                Scene AdminHomescene = new Scene(AdminParent);
                AdministratorSceneController controller = loader.getController();
                controller.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(AdminHomescene);
                window1.show();
            }   
            else if(user instanceof Distributor){
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("DistributorScene.fxml"));
                Parent DistributorParent = loader.load();
                Scene DistributorHomescene = new Scene(DistributorParent);
                DistributorSceneController controller = loader.getController();
                controller.initData(user);
                Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
                window1.setScene(DistributorHomescene);
                window1.show();
            }
        }
         
    }

    void initData(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
