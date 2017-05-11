package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Hashtable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

import connection.Connection;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import session.UserBeanRemote;
import view.LoginView;


/**
 * 
 * @author Peter Ocelik
 *
 */
public class LoginController implements Initializable {
	
	@FXML
	private BorderPane rootPane;
	@FXML
	private TextField userText;
	@FXML
	private PasswordField pswdText;
	@FXML
	private Label lblUser;
	@FXML
	private Label lblPswd;
	@FXML
	private Label lblWrong;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Zobrazi obrazovku na registraciu
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void loadSecond(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getResource("../RegisterWindow.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Zobrazi obrazovku na zabudnutie hesla
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void loadThird(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getResource("../PasswordWindow.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	/**
	 * Prihlasi pouzivatela
	 * @param event
	 * @throws NamingException
	 * @throws IOException 
	 */
	@FXML
	private void login(ActionEvent event) throws NamingException, IOException {
		String user = userText.getText();
		String pswd = pswdText.getText();
		
		lblUser.setText(null);
		lblPswd.setText(null);
		lblWrong.setText(null);
		
		if(user.isEmpty()) {
			lblUser.setText("This field is required");;
		}
		if(pswd.isEmpty()) {
			lblPswd.setText("This field is required");;
		}
		if(!pswd.isEmpty() && !user.isEmpty()) {
			//pripojenie na server
			Connection c = new Connection();
			Context context = c.getRemoteEjbContext();
			UserBeanRemote remote = (UserBeanRemote)context.lookup("ejb:Ear/Server//UserBean!session.UserBeanRemote");
			List<User> u = remote.getUser(user, pswd);
			if(u.isEmpty()) {
				lblWrong.setText("Username or email is not valid");
			} else {
				BorderPane pane = FXMLLoader.load(getClass().getResource("../MainWindow.fxml"));
				VBox vbox = (VBox) pane.lookup("#vbox");
				HBox hbox = (HBox) vbox.lookup("#hbox");
				Button but = (Button) hbox.lookup("#btnLog");
				but.setVisible(false);
				but.setManaged(false);
				lblWrong.setText("User logged in");
				
				OutputStream os = null;
				Properties prop = new Properties();
				prop.setProperty("user", u.get(0).getId().toString());
				try {
		            os = new FileOutputStream("etc/user.properties");
		            prop.store(os, "User Property File");
		            System.out.println(u.get(0).getId());
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        }
				
			}
		}
		
	}
	
	

}
