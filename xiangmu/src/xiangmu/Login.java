package xiangmu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login{
	JFrame f;
	Container c;
	JButton b1;
	JButton b2;
	JTextField jt;
	JPasswordField jp;
	String s1;
	String s2;
	int sum=2;
	String bjt[]=new String[10];
	String bjp[]=new String[10];
	String spt[]=new String[10];
	String spp[]=new String[10];
    Login(){
    	f=new JFrame("登录界面");
    	c=f.getContentPane();
    	f.setLayout(null);
    	BackgroundPanel back=new BackgroundPanel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\12.jpg").getImage());
        back.setBounds(-5,-27,400,650);
        c.add(back);
    	JLabel jtn=new JLabel("用户名");
    	jt=new JTextField(20);
    	jt.setBounds(95,250,200,40);
    	f.add(jtn);
    	c.add(jt);
    	
    	JLabel jtp=new JLabel("密码");
    	jp=new JPasswordField(20);
    	jp.setBounds(95,310,200,40);
    	f.add(jtp);
    	c.add(jp);
    	
    	b1=new JButton("登录");
    	b1.setBounds(89,450,212,40);
    	b1.setContentAreaFilled(false);
    	c.add(b1);
    	b1.setFont(new Font("SimHei",Font.BOLD,20));
    	b1.addActionListener(new denglu());
    	
    	b2=new JButton("注册");
    	b2.setBounds(89,519,212,40);
    	b2.setContentAreaFilled(false);
    	b2.setFocusPainted(false);
    	b2.setFont(new Font("SimHei",Font.BOLD,20));
    	b2.addActionListener(new zhuce());
    	c.add(b2);
    	
    	//设置初始登录密码
    	bjt[0]="hyh";
		bjp[0]="123456";
		bjt[1]="1";
		bjp[1]="1";
		spt[0]="2";
		spp[0]="2";
    	f.setSize(400,650);
    	f.setLocation(400,20);
    	f.setResizable(false);
    	f.setVisible(true); 
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    class Zc{
    	JFrame zc_f;
    	Container zc_c;
    	JTextField njt;
    	JPasswordField njp1;
    	JPasswordField njp2;
    	Zc(){
    		zc_f=new JFrame("注册");;
    	    zc_c=zc_f.getContentPane();
    	    zc_f.setLayout(null);
    	    BackgroundPanel zc_back=new BackgroundPanel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\13.jpg").getImage());
            zc_back.setBounds(0,0,600,400);
            zc_c.add(zc_back);
            
            JButton zcb=new JButton("注册");
            zcb.addActionListener(new complete_zc());
            zcb.setBounds(341,303,191,35);
            zcb.setForeground(Color.white);
            zcb.setBackground(Color.blue);
            zc_c.add(zcb);
            
        	njt=new JTextField(20);
        	njt.setBounds(387,162,145,34);
        	zc_c.add(njt);
        	
        	JLabel jtp1=new JLabel("密码");
        	njp1=new JPasswordField(20);
        	njp1.setBounds(387,202,145,34);
        	zc_c.add(jtp1);
        	zc_c.add(njp1);
        	
        	JLabel jtp2=new JLabel("确认密码");
        	njp2=new JPasswordField(20);
        	njp2.setBounds(387,243,145,34);
        	zc_c.add(jtp2);
        	zc_c.add(njp2);
        	       	
        	zc_f.setSize(600,435);
        	zc_f.setLocation(300,100);
        	zc_f.setVisible(true);
        	zc_f.setResizable(false);
    	}
    	class complete_zc implements ActionListener{//检验注册信息是否正确
        	public void actionPerformed(ActionEvent e) {
        		boolean zc_flag=true;
        		for(int i=0;i<bjt.length;i++) {
        			if(njt.getText().equals(bjt[i])) {
        				zc_flag=false;
        				JOptionPane.showMessageDialog(null,"用户名已被使用");
        			}
        		}
        		if(zc_flag) {
        			if(njt.getText().length()==0||njp1.getText().length()==0)JOptionPane.showMessageDialog(null,"用户名或密码不能是空");
        			else if(njp1.getText().equals(njp2.getText())) {
        			     bjt[sum]=njt.getText();
        			     bjp[sum]=njp1.getText();
        			     sum++;
        			     zc_f.setVisible(false);
        		         f.setVisible(true);
        			     JOptionPane.showMessageDialog(null,"注册成功");
        		    }
        		    else JOptionPane.showMessageDialog(null,"密码输入有误");
        		 }	
        	}
    	}
    }
    
    class denglu implements ActionListener{//检验登录信息是否正确
    	public void actionPerformed(ActionEvent e) {
    		boolean flag=true;
    		for(int i=0;i<bjt.length||i<spt.length;i++) {
    			if(jt.getText().equals(bjt[i])||jt.getText().equals(spt[i])) {
    				if(jt.getText().equals(bjt[i])&&jp.getText().equals(bjp[i])) {
    					flag=false;
    					f.setVisible(false);
    					new User(bjt[i]).start();
    					new User_server().start();
    				}
    				else if(jt.getText().equals(spt[i])&&jp.getText().equals(spp[i])) {
    					flag=false;
    					f.setVisible(false);
    					new Shop_manager(spt[i]).start();
    					new Server().start();
    				}
    				else{
    					flag=false;
    					JOptionPane.showMessageDialog(null,"用户名或密码错误");
    				}
    				break;
    			}	
    		}
    		if(flag)JOptionPane.showMessageDialog(null,"用户名不存在");
    	}
    }
    
    class zhuce implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		new Zc();
    	}
    }
}
