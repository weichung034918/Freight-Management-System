package fxml.controller;

import Service.AccountService;
import Utils.Popup;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Account;

import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable{

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button loginbtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        username.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if(oldValue){
                if (username.getText().isEmpty())
                    username.setText("Username");
            }else if(newValue){
                if(username.getText().equals("Username"))
                    username.setText("");
            }
        });


        loginbtn.setOnAction((event)->{
            if(username.getText().isEmpty()|| username.getText().equals("Username")) {
                Popup.warning("Empty field!","Please fill in your username");
            }else  if (password.getText().isEmpty()){
                Popup.warning("Empty field!","Please fill in your password");
            }else {
                Account account = (Account) AccountService.get(username.getText()).getObject();
                if (account !=null) {
                    if (account.getPassword().equals(password.getText())) {
                        Popup.inform("Login Success","Welcome, "+username.getText());
                    }else
                        Popup.error("Incorrect password","The password you entered does not match");
                }else
                    Popup.error("Invalid username","The username you entered does not exist");
            }
        });
    }
}
