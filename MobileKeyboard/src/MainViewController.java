import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class MainViewController{
	@FXML private Text actionT;
	private MainServer ms;
	
	public MainViewController() {
		
	}
	
	@FXML 
	protected void handleStartButton(ActionEvent e) {
		ms = new MainServer();
		ms.start_connection();
		System.out.println("OKAI");
	}
	
	@FXML
	protected void handleReceiveAndPerform(ActionEvent e) throws ClassNotFoundException, IOException {
		ms.receive_message();
	}
	
}

