package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import json.SearchShows;
import json.ShowEpisodeList;
import json.ShowSeasons;
import model.Search;

public class SearchController implements Initializable {

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
	
	@FXML
	public void insertShows(ActionEvent event) throws IOException {
		vbox.getChildren().clear();
		String image;
		String string = textField.getText();
		SearchShows shows = new SearchShows();
		Search[] ss = shows.searchedshows(string);
		for(Search s : ss) {
			System.out.println(s.getShow().getName());
			if(s.getShow().getImage() == null) {
				image = "http://static.tvmaze.com/images/no-img/no-img-portrait-text.png";
			} else {
				image = s.getShow().getImage().getMedium();
			}
			
			ImageView iv1 = new ImageView(new Image(image)); 
			HBox hbox = new HBox();
			VBox infoVbox = new VBox();
			//infoVbox.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
			infoVbox.setStyle("-fx-background-color: #a00080; -fx-fill-width:true; -fx-padding: 10,10,10,10;");
			hbox.setStyle("-fx-padding: 10,10,10,10; -fx-fill-width:true;");
			String strippedText = s.getShow().getSummary().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", "");
			System.out.println(strippedText);
			Label nazov = new Label(s.getShow().getName());
			nazov.setStyle("-fx-font-size: 16pt; -fx-text-fill: white; -fx-font-style:bold");
			Label popis = new Label(strippedText);
			popis.setStyle("-fx-text-fill: white;");
			popis.setWrapText(true);
			Button add = new Button("Add");
			add.setStyle("-fx-vpos: bottom;");
			infoVbox.getChildren().addAll(nazov, popis, add);
			hbox.getChildren().addAll(iv1, infoVbox);
			//hbox.setPrefSize(720, 480);
			vbox.getChildren().add(hbox);
		}
		/*
		ImageView iv1 = new ImageView(new Image("http://static.tvmaze.com/uploads/images/medium_portrait/25/64201.jpg")); 
		iv1.relocate(10, 10);
		HBox hbox = new HBox();
		VBox infoVbox = new VBox();
		hbox.setStyle("-fx-background-color: #abcf");
		//infoVbox.setBackground(new Background(new BackgroundFill(Color.DARKGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		Label nazov = new Label("Nazov");
		Label popis = new Label("Popis serialu");
		Button add = new Button("Add");
		infoVbox.getChildren().addAll(nazov, popis, add);
		hbox.getChildren().addAll(iv1, infoVbox);
		//hbox.setPrefSize(720, 480);
		vbox.getChildren().add(hbox);*/
	}

}
