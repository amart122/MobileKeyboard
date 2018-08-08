
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import java.io.BufferedReader;
import java.io.ObjectInputStream;

public class MainServer extends Thread {
	
	private int portNum = 8080;
	private ServerSocket ss = null;
	//private BufferedReader in;
	private Socket client = null;
	private ObjectInputStream inFC;
	
	public MainServer(){
		try {
				System.out.println("Setting Server...");
				ss = new ServerSocket(portNum);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start_connection() {
		try {
			client = ss.accept();
			inFC = new ObjectInputStream(client.getInputStream());
			System.out.println("Client Connected");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receive_message() throws IOException, ClassNotFoundException{
		//in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		MsgPacket newP = null;
		while((newP = (MsgPacket) inFC.readObject()) != null) {
			if(true) {
				System.out.println("Client: " + newP.get_msg());
				System.out.println("Length: " + newP.get_size());
				if(newP.get_msg().equals("OUT")) break;
			}
			newP = null;
		}
		System.out.println("OUT\n");
		ss.close();
	}
}
