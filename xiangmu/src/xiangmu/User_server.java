package xiangmu;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import xiangmu.Server.fahuo;

public class User_server extends Thread{
	public void run() {
  	  try {
			ServerSocket serversocket=new ServerSocket(5000);
			while(true) {
  		      Socket socket=serversocket.accept();
  		      InputStreamReader out=new InputStreamReader(socket.getInputStream());
			  BufferedReader in=new BufferedReader(out);
			  String s1=in.readLine();
			  Goods_buy.confirm[Integer.parseInt(s1)].setText("确认收货");
			  Goods_buy.confirm[Integer.parseInt(s1)].setEnabled(true);
  		      in.close();
  	  }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
  	  }
}
