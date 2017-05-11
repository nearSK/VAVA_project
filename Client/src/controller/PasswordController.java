package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 *Kontrola ci je emailova adresa pouzivatela v databaze
 * @author Peter Ocelik
 *
 */
public class PasswordController implements Initializable {
	
	@FXML
	private TextField emailText;
	@FXML
	private Label lblEmail;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	/**
	 * Skontroluje ci je emailva adresa
	 * v spravnom tvare
	 * @param event
	 */
	@FXML
	public void sendPassword(ActionEvent event) {
		String email = emailText.getText();
		
		lblEmail.setText(null);
		
		if(email.isEmpty()) {
			lblEmail.setText("This field is required");
		}
		if(!email.isEmpty()) {
			lblEmail.setText("Email address is wrong");
		}
		
	}

}
