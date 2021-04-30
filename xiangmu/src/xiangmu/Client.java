package xiangmu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    Client(String s){
    	try {
    		Socket socket;
    		if(s.length()>2)socket=new Socket("127.0.0.1",1680);
    		else socket=new Socket("127.0.0.1",5000);
			PrintWriter w=new PrintWriter(socket.getOutputStream());
			w.println(s);
			w.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    }
}
