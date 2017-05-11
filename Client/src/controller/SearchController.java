package controller;

import java.io.FileInputStream;
import java.io.IOException;

import java.net.URL;
import java.util.Properties;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import json.SearchShows;

import model.Search;
import session.ShowBeanRemote;
/**
 * Riadi vyhladavanie serialov a nasledne ukladanie do databazy,
 * vyhladavanie riadi externa API a vkladanie do databazy
 * je cez remote seesion beanu
 * @author Peter Ocelik
 *
 */
public class SearchController implements Initializable {
	
	private Logger LOG = Logger.getLogger("controller.SearchController");
	private FileHandler fh;  

	@FXML
	AnchorPane pane;
	@FXML
	VBox vbox;
	@FXML
	TextField textField;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Ulozi do databazy serial, ktory si pouzivate vybral
	 * pri kliknuti na tlacidlo
	 * @param event
	 * @throws IOException
	 * @throws NamingException
	 */
	@FXML
	public void insertShows(ActionEvent event) throws IOException, NamingException {
		
		fh = new FileHandler("etc/mylog.log");  
        LOG.addHandler(fh);
        SimpleFormatter formatter = new SimpleFormatter();  
        fh.setFormatter(formatter); 
		
		vbox.getChildren().clear();
		String image;
		String string = textField.getText();
		
		//vyberanie udajov z properties
		LOG.info("Loading from user properties");
		Properties p = new Properties();
		p.load(new FileInputStream("etc/user.properties"));
		Integer user_id = Integer.parseInt((String) p.get("user"));
		
		//Vyhladanie serialov na webovej API
		LOG.info("Access to external web API");
		SearchShows search = new SearchShows();
		Search[] shows = search.searchedshows(string);
		
		//vyberanie zo zoznamu a nahravanie do klienta
		for(Search s : shows) {
			System.out.println(s.getShow().getName());
			if(s.getShow().getImage() == null) {
				image = "http://tvshowepisodes.com/img/no_poster.png";
			} else {
				image = s.getShow().getImage().getMedium();
			}
			//vlozenie informacii o seriali do klienta
			ImageView iv1 = new ImageView(new Image(image)); 
			iv1.resize(20, 40);
			HBox hbox = new HBox();
			VBox infoVbox = new VBox();
			infoVbox.setStyle("-fx-background-color: #a00080; -fx-fill-width:true; -fx-padding: 10,10,10,10;");
			hbox.setStyle("-fx-padding: 10,10,10,10; -fx-fill-width:true;");
			String strippedText = s.getShow().getSummary().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", "");

			Label nazov = new Label(s.getShow().getName());
			nazov.setStyle("-fx-font-size: 16pt; -fx-text-fill: white; -fx-font-style:bold");
			Label popis = new Label(strippedText);
			popis.setStyle("-fx-text-fill: white;");
			popis.setWrapText(true);
			Button add = new Button("Add");
			add.setId(s.getShow().getId().toString());
			add.setStyle("-fx-vpos: bottom;");
			infoVbox.getChildren().addAll(nazov, popis, add);
			hbox.getChildren().addAll(iv1, infoVbox);
			vbox.getChildren().add(hbox);
			
			//vybrany serial prida do databazy
			add.setOnAction((ActionEvent e)-> {
				LOG.info("Access to remote seesion bean through searching");
				Connection c = new Connection();
				Context context = c.getRemoteEjbContext();
				try {
					ShowBeanRemote remote = (ShowBeanRemote)context.lookup("ejb:Ear/Server//ShowBean!session.ShowBeanRemote");
					boolean success = remote.insertShow(user_id, Integer.parseInt(add.getId()));
					if(success) {
						add.setStyle("-fx-background-color: red;");
						add.setText("Added");
					} else {
						add.setText("Already in library");
					}
				} catch (NamingException e1) {
					LOG.log(Level.SEVERE, "Remote access error", e);
				}
			});
		}
	}
	

}
