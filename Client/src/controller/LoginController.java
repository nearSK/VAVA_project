package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.BasicConfigurator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.TestBeanRemote;



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
	
	@FXML
	private void loadSecond(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getResource("../RegisterWindow.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	private void loadThird(ActionEvent event) throws IOException {
		BorderPane pane = FXMLLoader.load(getClass().getResource("../PasswordWindow.fxml"));
		rootPane.getChildren().setAll(pane);
	}
	
	@FXML
	private void login(ActionEvent event) throws NamingException {
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
			//System.out.println("Peter");
			Context context = createRemoteEjbContext("localhost", "8080");
			TestBeanRemote remote = (TestBeanRemote)context.lookup("ejb:/Server//TestBean!main.TestBeanRemote");
			//TestBeanRemote testMe = connectToStatelessBean();
			//System.out.println(testMe.rozsirMa("Peter"));
			System.out.println(remote.rozsirMa("Peter"));
			/*if(remote.getUser(user, pswd) == null) {
				lblWrong.setText("Username or email is not valid");
			}*/
			
		}
		
	}
	
	private  Context createRemoteEjbContext(String host, String port) throws NamingException {
		BasicConfigurator.configure();
		
		Hashtable<Object, Object> props = new Hashtable<Object, Object>();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		
		props.put("jboss.naming.client.ejb.context", false);
		props.put("org.jboss.ejb.client.scoped.context", true);
 
		props.put("endpoint.name", "client-endpoint");
		props.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", false);
		props.put("remote.connections", "default");
		props.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", false);
 
        props.put(Context.PROVIDER_URL, "http-remoting://" + host + ":" + port);
        props.put("remote.connection.default.host", host);
        props.put("remote.connection.default.port", port);
 
        return new InitialContext(props);
    }
	
	private static TestBeanRemote connectToStatelessBean() throws NamingException {
        Properties jndiProperties = new Properties();
        jndiProperties.put("jboss.naming.client.ejb.context", true);
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        jndiProperties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
        jndiProperties.put(javax.naming.Context.PROVIDER_URL, "http-remoting://localhost:8080");
        jndiProperties.put(javax.naming.Context.SECURITY_PRINCIPAL, "near");
        jndiProperties.put(javax.naming.Context.SECURITY_CREDENTIALS, "Ocelikp@00023");
        final Context context = new InitialContext(jndiProperties);
       
        final String appName = "Server";
        final String moduleName = "Server";
        final String distinctName = "";
        final String beanName = TestBeanRemote.class.getSimpleName();
        final String viewClassName = TestBeanRemote.class.getName();
        
        TestBeanRemote bean = (TestBeanRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+beanName+"!"+viewClassName);
       // context.close();
        final String greeting = bean.rozsirMa("Petericek moj");
        System.out.println(greeting);
        System.out.println("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+beanName+"!"+viewClassName);
        
        return (TestBeanRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+distinctName+"/"+beanName+"!"+viewClassName);
    }

}
