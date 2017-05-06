package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	
	@FXML
	public void register() {
		
		String user = userText.getText();
		String email = emailText.getText();
		String pswd = pswdText.getText();
		String pswd2 = pswd2Text.getText();
		System.out.println(user);
		System.out.println(email);
		System.out.println(pswd);
		System.out.println(pswd2);
	}
	
	

}
