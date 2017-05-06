package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("../MainWindow.fxml"));
		primaryStage.setTitle("TVguide");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}

}
