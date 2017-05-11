package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

import javax.naming.Context;
import javax.naming.NamingException;

import connection.Connection;
import entity.Usershow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import json.SearchShows;
import json.ShowEpisodeList;
import model.Episode;
import model.Show;
import session.ShowBeanRemote;
import view.LoginView;

public class MainController implements Initializable {

	@FXML
	private AnchorPane pane;
	@FXML
	private VBox vbox;
	@FXML
	private HBox hbox;
	@FXML
	private Button btnLog;
	@FXML
	private Label lblLog;
	
	private Logger LOG = Logger.getLogger("controller.MainController");  
    private FileHandler fh; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void loginButton(ActionEvent event) {
		
		LoginView l = new LoginView();
		l.showView();
	}
	
	@FXML
	public void showSearch(ActionEvent event) {
		try {
			fh = new FileHandler("etc/mylog.log");
			LOG.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  
		} catch (SecurityException e1) {
			//LOG.log(Level.SEVERE, "Error", e1);
		} catch (IOException e1) {
			//LOG.log(Level.SEVERE, "Error", e1);
		} 
		BorderPane borderPane = null;
		try {
			
			borderPane = FXMLLoader.load(getClass().getResource("../SearchWindow.fxml"));
		} catch (IOException e) {
			LOG.log(Level.SEVERE, "Error", e);
		}
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().setAll(borderPane);
	}
	
	/**
	 * Zobrazi serialy, ktore ma pouzivatel v databaze
	 * @param event
	 * @throws IOException
	 */
	@FXML
	public void showMyShows(ActionEvent event) throws IOException {
		
		AnchorPane borderPane = FXMLLoader.load(getClass().getResource("../MyshowsWindow.fxml"));
		TilePane hbox = new TilePane();
		hbox.setStyle("-fx-padding: 10,10,10,10; -fx-spacing: 10");
		//nacitanie pouzivateli zo suboru
		Properties p = new Properties();
		p.load(new FileInputStream("etc/user.properties"));
		Integer user_id = Integer.parseInt((String) p.get("user"));
		//vytvorenie spojenia s databazou
		Connection c = new Connection();
		Context context = c.getRemoteEjbContext();
		try {
			//ShowBeanRemote remote = (ShowBeanRemote)context.lookup("ejb:/Server//ShowBean!session.ShowBeanRemote");
			ShowBeanRemote remote = (ShowBeanRemote)context.lookup("ejb:Ear/Server//ShowBean!session.ShowBeanRemote");
			List<Usershow> shows = remote.getShows(user_id);
			for(Usershow u : shows) {
				u.getShow_id();
				SearchShows search = new SearchShows();
				Show show = search.getShow(u.getShow_id());
				ImageView iv1 = new ImageView(new Image(show.getImage().getMedium()));
				iv1.setStyle("-fx-padding: 5,5,5,5");
				
				Button button = new Button(show.getName());
				button.setId(show.getId().toString());
				HBox hhh = new HBox();
				HBox.setHgrow(button, Priority.ALWAYS);
				button.setMaxWidth(Double.MAX_VALUE);
				button.setStyle("-fx-");
				hhh.getChildren().addAll(button);

				ImageView iv = new ImageView(new Image(show.getImage().getMedium()));

				StackPane stackPane = new StackPane();
				StackPane.getAlignment(button);
				stackPane.getChildren().addAll(iv, hhh);
				
				hbox.getChildren().addAll(stackPane);
				
				button.setOnAction((ActionEvent e)-> {
					try {
						showEpisodes(Integer.parseInt(button.getId()));
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						LOG.log(Level.SEVERE, "Error", e1);
						e1.printStackTrace();
					}
				});
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		borderPane.getChildren().addAll(hbox);
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().addAll(borderPane);
	}
	
	/*@FXML
	public void exit(ActionEvent event) throws IOException {

	}*/
	/**
	 * Zobrazi epizody daneho serialu
	 * @param id
	 * @throws IOException
	 */
	public void showEpisodes(Integer id) throws IOException {
		
		AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../EpisodesWindow.fxml"));
		TilePane tilePane = new TilePane();
		//vyhlada epizody
		ShowEpisodeList search = new ShowEpisodeList();
		Episode[] episodes = search.showEpisodeList(id);
		
		for(Episode e : episodes) {
			ImageView iv;
			//kontrola ci existuje obrazok
			if(e.getImage() == null) {
				iv = new ImageView(new Image("http://static.tvmaze.com/images/no-img/no-img-landscape-text.png"));
			} else {
				iv = new ImageView(new Image(e.getImage().getMedium()));
			}
			
			Button button = new Button(e.getName());
			button.setId(e.getId().toString());
			HBox hhh = new HBox();
			HBox.setHgrow(button, Priority.ALWAYS);
			button.setMaxWidth(Double.MAX_VALUE);
			hhh.getChildren().addAll(button);

			StackPane stackPane = new StackPane();
			StackPane.getAlignment(button);
			stackPane.getChildren().addAll(iv, hhh);
			
			tilePane.getChildren().addAll(stackPane);

		}
		
		pane.setTopAnchor(anchorPane, 0.0);
		pane.setLeftAnchor(anchorPane, 0.0);
		pane.setRightAnchor(anchorPane, 0.0);
		pane.setBottomAnchor(anchorPane, 0.0);
		anchorPane.getChildren().addAll(tilePane);
		pane.getChildren().setAll(anchorPane);
	}

}
