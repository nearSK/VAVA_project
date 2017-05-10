package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable {
	
	@FXML
	private TextField userText;
	@FXML
	private TextField emailText;
	@FXML
	private PasswordField pswdText;
	@FXML
	private PasswordField pswd2Text;
	@FXML
	private Label lblUser;
	@FXML
	private Label lblEmail;
	@FXML
	private Label lblPswd;
	@FXML
	private Label lblPswd2;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void register(ActionEvent event) {
		
		String user = userText.getText();
		String email = emailText.getText();
		String pswd = pswdText.getText();
		String pswd2 = pswd2Text.getText();
		
		//lblUser.wrapTextProperty();
		lblUser.setText(null);
		lblEmail.setText(null);
		lblPswd.setText(null);
		lblPswd2.setText(null);
		
		if(user.length() < 4) {
			lblUser.setText("Username too short");
		}
		if(user.length() > 20) {
			lblUser.setText("Username too long");
		}
		if(!email.contains("@")) {
			lblEmail.setText("Email not valid");
		}
		if(pswd.length() < 4) {
			lblPswd.setText("Password too short");
		}
		if(pswd.length() > 20) {
			lblPswd.setText("Password too long");
		}
		if(user.isEmpty()) {
			lblUser.setText("This field is required");
		}
		if(email.isEmpty()) {
			lblEmail.setText("This field is required");
		}
		if(pswd.isEmpty()) {
			lblPswd.setText("This field is required");
		}
		if(pswd2.isEmpty()) {
			lblPswd2.setText("This field is required");
		}
		
		if(pswd.equals(pswd2)) {
			System.out.println("OKEJ");
		}
		else {
			lblPswd2.setText("Passwords don't match");
			System.out.println("Passwords don't match.");
		}
		System.out.println(pswd);
		System.out.println(pswd2);
	}
	
	

}
