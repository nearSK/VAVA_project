package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.naming.Context;
import javax.naming.NamingException;

import connection.Connection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import session.UserBeanRemote;
/**
 * Registracia noveho zakaznika, kontrola ci su udaje spravne
 * zadane a nasledne vlozenie do databazy
 * @author Peter Ocelik
 *
 */
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
	
	private Logger LOG = Logger.getLogger("controller.MainController");  
    private FileHandler fh; 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}
	/**
	 * Kontrola spravne zadanych hodnot v textovych
	 * poliach
	 * @param event
	 * @throws NamingException
	 * @throws IOException 
	 * @throws SecurityException 
	 */
	@FXML
	public void register(ActionEvent event) throws SecurityException, IOException {
		
		fh = new FileHandler("etc/mylog.log");
		LOG.addHandler(fh);
		SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter);  
		
		String user = userText.getText();
		String email = emailText.getText();
		String pswd = pswdText.getText();
		String pswd2 = pswd2Text.getText();
		
		lblUser.setText(null);
		lblEmail.setText(null);
		lblPswd.setText(null);
		lblPswd2.setText(null);
		
		//kontrola hodnot v poliach
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
		if(!pswd.equals(pswd2)) {
			lblPswd2.setText("Passwords don't match");
		}
		if(pswd.equals(pswd2) && !user.isEmpty() && !email.isEmpty()) {
			LOG.info("Access to remote seesion bean through register");
			Connection c = new Connection();
			Context context = c.getRemoteEjbContext();
			//UserBeanRemote remote = (UserBeanRemote)context.lookup("ejb:/Server//UserBean!session.UserBeanRemote");
			UserBeanRemote remote;
			try {
				remote = (UserBeanRemote)context.lookup("ejb:Ear/Server//UserBean!session.UserBeanRemote");
				if(!remote.insertUser(user, pswd, email)) {
					lblPswd2.setText("Username or email are already taken");
				} else {
					lblPswd2.setText("User registered");
				}
			} catch (NamingException e) {
				LOG.log(Level.SEVERE, "Remote access error", e);
			}
			
		}
	}
	
	

}
