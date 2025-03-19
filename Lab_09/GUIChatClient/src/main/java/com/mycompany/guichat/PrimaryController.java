/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.guichat;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author nemesis
 */
public class PrimaryController implements Initializable {

    private Socket server;
    private DataInputStream ear;
    private PrintStream mouth;
    boolean runFlag = true;
    
    @FXML
    private TextField msgTextField;
    @FXML
    private Button sendMsg;
    @FXML
    private TextArea textArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            server = new Socket("127.0.0.1", 5005);
            ear = new DataInputStream(server.getInputStream());
            mouth = new PrintStream(server.getOutputStream());
            new Thread (new Runnable() {
                public void run() {
                    try {
                        while (runFlag) {
                            String msg = ear.readLine();
                            if (msg == null) {
                                runFlag = false;
                            }
                            
                            textArea.appendText(msg);
                        }
                    } catch (IOException ex) {
                        
                    }
                }
            }).start();
        } catch (IOException ex) {
            
        }
        
        
        
    }    
    
    @FXML
    private void sendMsgHandler(ActionEvent event) {
        String message = msgTextField.getText();
        if(message.isEmpty()) {}
        else {
            mouth.println("Nemesis: " + message);
            textArea.appendText("\nServer: " + message + "\n");
            msgTextField.clear();
        }
    }

}
