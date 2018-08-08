import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainViewController{
	@FXML private Text actionT;
	
	public MainViewController() {
		
	}
	
	@FXML 
	protected void handleStartButton(ActionEvent e) {
		MainServer ms = new MainServer();
		ms.start_connection();
		System.out.println("OKAI");
	}
	
}

