package xiangmu;

import java.awt.*;
import javax.swing.*;

import xiangmu.User.buy;
import xiangmu.User.personal;
import xiangmu.User.shop;
import xiangmu.User.tuijian;

import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Shop_manager extends Thread{
	static JFrame f2;
	JScrollPane j;
	JPanel p;
	JPanel p0;
	JPanel p1;
	static JPanel p2;
	JTextArea cz=new JTextArea();
	int danshu=0;
	JButton shop_b=new JButton("商品管理");
	JButton cha_b=new JButton("查找商品");
	JButton dingdan_b=new JButton("订单详情");
	static JButton [] u_b=new JButton[24];
	static JButton send[]=new JButton[20];
	JButton cz_b;
	JButton czjg_b[]=new JButton[100];
	Goods_information user_g=new Goods_information();
	static int search_sum=0;
	String s;
	Shop_manager(String s){
		this.s=s;
	}
	public void run() {
		ImageIcon ct1;
		Image ct2;
		f2=new JFrame("管理员 "+s+"欢迎登录");
		p0=new JPanel();
		p0.setLayout(null);
		p0.setBounds(0,0,1000,1042);
		p0.setBackground(Color.white);
		
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBounds(0,0,1000,1042);
		p1.setBackground(Color.white);
		p1.setVisible(false);
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBounds(0,0,1000,962);
		p2.setBackground(Color.white);
		p2.setVisible(false);
		
		shop_b.setBackground(Color.CYAN);
		shop_b.addActionListener(new shop());
		shop_b.setBounds(0,50,195,30);
		shop_b.setBorder(BorderFactory.createLineBorder(Color.white));
		shop_b.setFocusPainted(false);
		
		cha_b.setBackground(Color.lightGray);
		cha_b.addActionListener(new cha());
		cha_b.setBounds(195,50,195,30);
		cha_b.setBorder(BorderFactory.createLineBorder(Color.white));
		cha_b.setFocusPainted(false);
		
		dingdan_b.setBackground(Color.lightGray);
		dingdan_b.addActionListener(new order());
		dingdan_b.setBounds(390,50,195,30);
		dingdan_b.setBorder(BorderFactory.createLineBorder(Color.white));
		dingdan_b.setFocusPainted(false);
		
		p=new JPanel();
		p.setLayout(null);
		Dimension dim=new Dimension(1000,1042);
		p.setPreferredSize(dim);
		Label huanying=new Label("welcome");
		huanying.setFont(new Font("宋体",Font.CENTER_BASELINE,40));
		huanying.setBounds(200,0,1000,50);
		p.add(huanying);
		p.add(shop_b);
		p.add(cha_b);
		p.add(dingdan_b);
		p.add(p0);
		p.add(p1);
		p.add(p2);
		//服装
		Label clothing=new Label("服装");
		clothing.setFont(new Font("宋体",Font.BOLD,15));
		clothing.setBounds(0,80,1000,30);
		clothing.setForeground(Color.black);
		clothing.setBackground(Color.cyan);
		p0.add(clothing);       
		int k1=0,k2=0;
		for(int i=0;i<8;i++,k1++) {
			u_b[i]=new JButton();
			u_b[i].setContentAreaFilled(false);
			u_b[i].addActionListener(new manage(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,110+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.C[i].name.equals("0"))u_b[i].setText("已下架");
			else if(user_g.C[i].number==0)u_b[i].setText("库存不足");
			else {
				ct1=new ImageIcon(user_g.C[i].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			
			p0.add(u_b[i]);
		}
		//食物
		Label food=new Label("食品");
		food.setFont(new Font("宋体",Font.BOLD,15));
		food.setBounds(0,400,1000,30);
		food.setForeground(Color.black);
		food.setBackground(Color.cyan);
		p0.add(food); 
		k1=0;
		k2=0;
		for(int i=8;i<16;i++,k1++) {
			u_b[i]=new JButton();
			u_b[i].setContentAreaFilled(false);
			u_b[i].addActionListener(new manage(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,285+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.F[i-8].name.equals("0"))u_b[i].setText("已下架");
			else if(user_g.F[i-8].number==0)u_b[i].setText("库存不足");			
			else {
			    ct1=new ImageIcon(user_g.F[i-8].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			p0.add(u_b[i]);
		}
		//家居
		Label home=new Label("家居");
		home.setFont(new Font("宋体",Font.BOLD,15));
		home.setBounds(0,720,1000,30);
		home.setForeground(Color.black);
		home.setBackground(Color.cyan);
		p0.add(home);
		k1=0;
		k2=0;
		for(int i=16;i<24;i++,k1++) {
			u_b[i]=new JButton();
			u_b[i].setContentAreaFilled(false);
			u_b[i].addActionListener(new manage(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,605+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.H[i-16].name.equals("0"))u_b[i].setText("已下架");
			else if(user_g.H[i-16].number==0)u_b[i].setText("库存不足");
			else {
				ct1=new ImageIcon(user_g.H[i-16].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			
			p0.add(u_b[i]);
		}
		
		   cz=new JTextArea();
		   cz.setBounds(30,90,470,30);
		   cz.setBackground(Color.white);
		   cz.setBorder(BorderFactory.createLineBorder(Color.black));
		   cz.setFont(new Font("宋体",Font.BOLD,20));
		   p1.add(cz);
		   
		   cz_b=new JButton("查找");
           cz_b.setBounds(500,90,70,30);
           cz_b.setFocusPainted(false);
	       p1.add(cz_b);
	       cz_b.addActionListener(new search());
	       czjg_b[search_sum]=new JButton();
	       
	       cz_b.setBounds(500,90,70,30);
           cz_b.setFocusPainted(false);
		j=new JScrollPane(p,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		f2.setContentPane(j);
		p.setBackground(Color.white);
		f2.setSize(612,500);
		f2.setVisible(true);
        f2.setResizable(false);
        f2.setLocation(300,50);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
	class manage implements ActionListener{
    	int i;
    	manage(int i){
    	    this.i=i;
    	}
    	public void actionPerformed(ActionEvent a) {
            new Goods_manage(i);
    	}
    }
    class shop implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
    		  p0.setVisible(true);
    		  p1.setVisible(false);
    		  shop_b.setBackground(Color.cyan);
              cha_b.setBackground(Color.lightGray);
              dingdan_b.setBackground(Color.lightGray);
    	}
    }
    class cha implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
      		  p1.setVisible(true);
      		  p0.setVisible(false);
              cha_b.setBackground(Color.cyan);
              shop_b.setBackground(Color.lightGray);
              dingdan_b.setBackground(Color.lightGray);
    	}
    }
    class order implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
    		  p2.setVisible(true);
     		  p0.setVisible(false);
     		  p1.setVisible(false);
              dingdan_b.setBackground(Color.cyan);
              cha_b.setBackground(Color.lightGray);
              shop_b.setBackground(Color.lightGray);
    	}
        }
    class search implements ActionListener{//查找商品
    	public void actionPerformed(ActionEvent a) {
    		String s=cz.getText();
    		search_sum++;
    		int n=0;
    		ImageIcon ct1;
    		Image ct2;
    		czjg_b[search_sum-1].setVisible(false);
    		czjg_b[search_sum]=new JButton();
            czjg_b[search_sum].setBounds(30,130,145,145);
 	        p1.add(czjg_b[search_sum]);
    		for(int i=0;i<24;i++) {
    			if(i<8) {
    				if(this.Compare(s,user_g.C[i].name)>n)n=i;
    			}
    			if(i>=8&&i<16) {
    				if(this.Compare(s,user_g.F[i-8].name)>n)n=i;
    			}
    			if(i>=16&&i<24) {
    				if(this.Compare(s,user_g.H[i-16].name)>n)n=i;
    			}
    		}
    		
    		czjg_b[search_sum].addActionListener(new manage(n));
    		if(n<8) {
    			if(user_g.C[n].name.equals("0"))czjg_b[search_sum].setText("已下架");
    			else if(user_g.C[n].number==0)czjg_b[search_sum].setText("库存不足");
    			else {
    				ct1=new ImageIcon(user_g.C[n].image);
    			    ct2=ct1.getImage().getScaledInstance(czjg_b[search_sum].getWidth(),czjg_b[search_sum].getHeight(),ct1.getImage().SCALE_DEFAULT);
    			    ct1=new ImageIcon(ct2);
    			    czjg_b[search_sum].setIcon(ct1);
    			}
			}
			if(n>=8&&n<16) {
				if(user_g.F[n-8].name.equals("0"))czjg_b[search_sum].setText("已下架");
    			else if(user_g.F[n-8].number==0)czjg_b[search_sum].setText("库存不足");
    			else {
    				ct1=new ImageIcon(user_g.F[n-8].image);
    			    ct2=ct1.getImage().getScaledInstance(czjg_b[search_sum].getWidth(),czjg_b[search_sum].getHeight(),ct1.getImage().SCALE_DEFAULT);
    			    ct1=new ImageIcon(ct2);
    			    czjg_b[search_sum].setIcon(ct1);
			    }
			}
			if(n>=16&&n<24) {
				if(user_g.H[n-16].name.equals("0"))czjg_b[search_sum].setText("已下架");
    			else if(user_g.H[n-16].number==0)czjg_b[search_sum].setText("库存不足");
    			else {
    				ct1=new ImageIcon(user_g.H[n-16].image);
    			    ct2=ct1.getImage().getScaledInstance(czjg_b[search_sum].getWidth(),czjg_b[search_sum].getHeight(),ct1.getImage().SCALE_DEFAULT);
    			    ct1=new ImageIcon(ct2);
    			    czjg_b[search_sum].setIcon(ct1);
			    }
			}
    	}
    	int Compare(String str1,String str2) {//用来比较是否相似的函数
    	byte b1[]=new byte[200];
    	byte b2[]=new byte[200];
    	b1=str1.getBytes();
    	b2=str2.getBytes();
    	int degree=0;
    	for(int i=0;i<b1.length-1;i=i+2) {
    		for(int j=0;j<b2.length-1;j=j+2) {
    			if(b1[i]==b2[j]&&b1[i+1]==b2[j+1]) {
    				degree++;
    				if(b1[i+1]==b2[i+1])degree++;
    				break;
    			}
    		}
    	}
    	return degree;
       }
    	
    }
    
}