package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
/**
 * Hlavne graficke rohranie appky
 * @author Peter Ocelik
 *
 */
public class MainView extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Parent root = FXMLLoader.load(getClass().getResource("../MainWindow.fxml"));
		primaryStage.getIcons().add(new Image("http://www.iconsdb.com/icons/preview/purple/tv-xxl.png"));
		primaryStage.setTitle("TVguider");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}

}
