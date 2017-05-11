package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * Graficke rohranie prihlasovania
 * @author Peter Ocelik
 *
 */
public class LoginView {
	
	public Stage window;
	
	public LoginView() {}
	
	public void showView() {
		
		window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setResizable(false);
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../LoginWindow.fxml"));
			window.setScene(new Scene(root));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		window.initStyle(StageStyle.UTILITY);
		window.showAndWait();
	}
	
	

}
