package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import view.LoginView;

public class MainController implements Initializable {

	@FXML
	private AnchorPane pane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void loginButton(ActionEvent event) {
		
		LoginView l = new LoginView();
	}
	
	@FXML
	public void showSearch(ActionEvent event) throws IOException {
		
		BorderPane borderPane = FXMLLoader.load(getClass().getResource("../SearchWindow.fxml"));
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().setAll(borderPane);
	}
	
	@FXML
	public void showMyShows(ActionEvent event) throws IOException {
		
		BorderPane borderPane = FXMLLoader.load(getClass().getResource("../MyshowsWindow.fxml"));
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().setAll(borderPane);
		
		/*ImageView iv1 = new ImageView(new Image("http://static.tvmaze.com/uploads/images/medium_portrait/25/64201.jpg")); 
		iv1.relocate(10, 10);
		HBox hbox = new HBox();
		TextArea t = new TextArea("Toto je novy serial");
		hbox.getChildren().addAll(iv1, t);
		vbox.getChildren().add(hbox);*/
	}
	
	@FXML
	public void showSettings(ActionEvent event) throws IOException {
		
		BorderPane borderPane = FXMLLoader.load(getClass().getResource("../MyshowsWindow.fxml"));
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().setAll(borderPane);

	}
	
	@FXML
	public void exit(ActionEvent event) throws IOException {
		
		BorderPane borderPane = FXMLLoader.load(getClass().getResource("../MyshowsWindow.fxml"));
		pane.setTopAnchor(borderPane, 0.0);
		pane.setLeftAnchor(borderPane, 0.0);
		pane.setRightAnchor(borderPane, 0.0);
		pane.setBottomAnchor(borderPane, 0.0);
		pane.getChildren().setAll(borderPane);

	}

}
