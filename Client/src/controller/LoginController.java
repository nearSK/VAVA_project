package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class LoginController implements Initializable{
	
	@FXML
	private BorderPane rootPane;
	@FXML
	private TextField userText;
	@FXML
	private PasswordField pswdText;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void loadSecond(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getResource("../RegisterWindow.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	private void login(ActionEvent event) {
		String user = userText.getText();
		String pswd = pswdText.getText();
		System.out.println(user);
		System.out.println(pswd);
		
	}

}
