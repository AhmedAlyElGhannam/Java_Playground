/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.dbapp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import register.dal.DAO;
import register.dal.UserDTO;
/**
 * FXML Controller class
 *
 * @author nemesis
 */
public class PrimaryController implements Initializable {


    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField userNameTF;
    @FXML
    private TextField userPasswordTF;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loginButtonHandler(ActionEvent event) {
        UserDTO newUser = new UserDTO(userNameTF.getText(), userPasswordTF.getText());
        
        try {
            boolean res = DAO.login(newUser);
            if (res) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("FYI");
                alert.setHeaderText("Login was Successful!");
                alert.showAndWait();
            }
            else {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Warning!");
                alert.setHeaderText("Invalid Username or Password");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void registerButtonHandler(ActionEvent event) {
        UserDTO newUser = new UserDTO(userNameTF.getText(), userPasswordTF.getText());
        
        try {
            int res = DAO.register(newUser);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("FYI");
            alert.setHeaderText("Registration Successful!");
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Warning!");
            alert.setHeaderText("User is Already Registered!");
            alert.showAndWait();
        }
    }

}
