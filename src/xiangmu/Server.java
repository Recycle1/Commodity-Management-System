package xiangmu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import xiangmu.Goods_buy.buy_something.queren;

public class Server extends Thread{
	int danshu=0;
	fahuo f[]=new fahuo[20];
    	  public void run() {
    	  try {
			ServerSocket serversocket=new ServerSocket(1680);
			while(true) {
    		  Socket socket=serversocket.accept();
    		  InputStreamReader out=new InputStreamReader(socket.getInputStream());
  			  BufferedReader in=new BufferedReader(out);
  			  String s1=in.readLine();
  			  String s2[];
  			  s2=s1.split("x123x");
  			  JTextArea order=new JTextArea();
			  LineBorder lb=new LineBorder(Color.black,1,false);
			  order.setBorder(BorderFactory.createTitledBorder(lb,"订单"+String.valueOf(danshu+1),TitledBorder.LEFT,TitledBorder.TOP));
			  order.setBounds(13,90+100*danshu,555,90);
			  order.setFont(new Font("宋体",Font.BOLD,17));
			  order.setEditable(false);
			  order.setBackground(Color.cyan);
			  order.append(s2[0]+"\n\n"+s2[1]);
			  Shop_manager.send[danshu]=new JButton("发货");
			  Shop_manager.send[danshu].setBounds(472,105+100*danshu,75,32);
			  f[danshu]=new fahuo(danshu);
			  Shop_manager.send[danshu].addActionListener(f[danshu]);
			  Shop_manager.p2.add(Shop_manager.send[danshu]);
			  Shop_manager.p2.add(order);
			  danshu++;
    		  in.close();
    	  }
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    	  }
          class fahuo implements ActionListener{//查找商品
        	  int a1;
        	  fahuo(int danshu){
        		  a1=danshu;
        	  }
          	public void actionPerformed(ActionEvent a) {
          	Shop_manager.send[a1].setEnabled(false);
          	Shop_manager.send[a1].setText("已发货");
          	new Client(String.valueOf(a1));
          	}
          }
      
}
