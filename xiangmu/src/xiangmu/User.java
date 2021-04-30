package xiangmu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import xiangmu.User.buy;

public class User extends Thread{
	JFrame f1;
	JScrollPane j;
	JPanel p;
	JPanel p0;
	JPanel p1;
	static JPanel p2;
	JTextArea dingdan[]=new JTextArea [10];
	JButton shop_b=new JButton("商品选购");
	JButton rec_b=new JButton("猜你喜欢");
	JButton personal_b=new JButton("个人中心");
	static JButton [] u_b=new JButton[24];
	JButton [] r_b=new JButton[8];
	String s;
	User(String s){
		this.s=s;
	}
	public void run() {
		Goods_information user_g=new Goods_information();
		ImageIcon ct1;
		Image ct2;
		f1=new JFrame("用户 "+s+"欢迎登录");
		
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
		
		rec_b.setBackground(Color.lightGray);
		rec_b.addActionListener(new tuijian());
		rec_b.setBounds(195,50,195,30);
		rec_b.setBorder(BorderFactory.createLineBorder(Color.white));
		rec_b.setFocusPainted(false);
		
		personal_b.setBackground(Color.lightGray);
		personal_b.addActionListener(new personal());
		personal_b.setBounds(390,50,195,30);
		personal_b.setBorder(BorderFactory.createLineBorder(Color.white));
		personal_b.setFocusPainted(false);
		
		p=new JPanel();
		p.setLayout(null);
		Dimension dim=new Dimension(1000,1042);
		p.setPreferredSize(dim);
		Label huanying=new Label("welcome");
		huanying.setFont(new Font("宋体",Font.CENTER_BASELINE,40));
		huanying.setBounds(200,0,1000,50);
		p.add(huanying);
		p.add(shop_b);
		p.add(rec_b);
		p.add(personal_b);
		p.add(p0);
		p.add(p1);
		p.add(p2);
		//服装商品
		Label clothing=new Label("服装");
		clothing.setFont(new Font("宋体",Font.BOLD,15));
		clothing.setBounds(0,80,1000,30);
		clothing.setForeground(Color.black);
		clothing.setBackground(Color.cyan);
		p0.add(clothing);       
		int k1=0,k2=0;
		//设置图片等显示信息
		for(int i=0;i<8;i++,k1++) {
			u_b[i]=new JButton();
			u_b[i].setContentAreaFilled(false);
			u_b[i].addActionListener(new buy(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,110+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.C[i].name.equals("0")) {
				u_b[i].setText("已下架");
				u_b[i].setEnabled(false);
			}
			else if(user_g.C[i].number==0) {
				u_b[i].setText("库存不足");
				u_b[i].setEnabled(false);
			}
			else {
				ct1=new ImageIcon(user_g.C[i].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			
			p0.add(u_b[i]);
		}
		//食物商品
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
			u_b[i].addActionListener(new buy(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,285+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.F[i-8].name.equals("0")) {
				u_b[i].setText("已下架");
				u_b[i].setEnabled(false);
			}
			else if(user_g.F[i-8].number==0) {
				u_b[i].setText("库存不足");
				u_b[i].setEnabled(false);
			}			
			else {
			    ct1=new ImageIcon(user_g.F[i-8].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			p0.add(u_b[i]);
		}
		//家居商品
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
			u_b[i].addActionListener(new buy(i));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			u_b[i].setBounds(145*k1,605+145*k2,145,145);
			u_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(user_g.H[i-16].name.equals("0")) {
				u_b[i].setText("已下架");
				u_b[i].setEnabled(false);
			}
			else if(user_g.H[i-16].number==0) {
				u_b[i].setText("库存不足");
				u_b[i].setEnabled(false);
			}
			else {
				ct1=new ImageIcon(user_g.H[i-16].image);
			    ct2=ct1.getImage().getScaledInstance(u_b[i].getWidth(),u_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
			    ct1=new ImageIcon(ct2);
			    u_b[i].setIcon(ct1);
			}
			
			p0.add(u_b[i]);
		}
		//推荐
		//初始推荐模型
		int o[][]={{0,1,2,3,4,5,8,11},
		            {2,1,12,13,4,5,18,20},
		            {3,7,2,9,4,5,8,10},
		            {7,5,14,3,2,6,8,17},
		            {6,1,18,3,4,15,23,22}};
		int u_o[]=new int[8];
		for(int k=0;k<8;k++) {
			u_o[k]=(int)(Math.random()*23);
		}
		double fen[]=new double [5];
		for(int k=0;k<5;k++) {
			fen[k]=compare(u_o,o[k]);
			
		}
		int recommond_g=0;
		for(int k=1;k<5;k++) {
			if(fen[k]>fen[k-1])recommond_g=k;
		}
		k1=0;
		k2=0;
		for(int i=0;i<8;i++,k1++) {
			r_b[i]=new JButton();
			r_b[i].setContentAreaFilled(false);
			int jg=o[recommond_g][i];
			r_b[i].addActionListener(new buy(jg));
			r_b[i].setFont(new Font("宋体",Font.BOLD,15));
			if(i%4==0&&i!=0) {
				k1=0;
				k2++;
			}
			r_b[i].setBounds(145*k1,80+145*k2,145,145);
			if(jg<8) {
				if(user_g.C[jg].name.equals("0")) {
					r_b[i].setText("已下架");
					r_b[i].setEnabled(false);
				}
				else if(user_g.C[jg].number==0) {
					r_b[i].setText("库存不足");
					r_b[i].setEnabled(false);
				}			
				else {
				    ct1=new ImageIcon(user_g.C[jg].image);
				    ct2=ct1.getImage().getScaledInstance(r_b[i].getWidth(),r_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
				    ct1=new ImageIcon(ct2);
				    r_b[i].setIcon(ct1);
				}
			}
			if(jg>=8&&jg<16) {
				if(user_g.F[jg-8].name.equals("0")) {
					r_b[i].setText("已下架");
					r_b[i].setEnabled(false);
				}
				else if(user_g.F[jg-8].number==0) {
					r_b[i].setText("库存不足");
					r_b[i].setEnabled(false);
				}			
				else {
				    ct1=new ImageIcon(user_g.F[jg-8].image);
				    ct2=ct1.getImage().getScaledInstance(r_b[i].getWidth(),r_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
				    ct1=new ImageIcon(ct2);
				    r_b[i].setIcon(ct1);
				}
			}
			if(jg>=16&&jg<24) {
				if(user_g.H[jg-16].name.equals("0")) {
					r_b[i].setText("已下架");
					r_b[i].setEnabled(false);
				}
				else if(user_g.H[jg-16].number==0) {
					r_b[i].setText("库存不足");
					r_b[i].setEnabled(false);
				}			
				else {
				    ct1=new ImageIcon(user_g.H[jg-16].image);
				    ct2=ct1.getImage().getScaledInstance(r_b[i].getWidth(),r_b[i].getHeight(),ct1.getImage().SCALE_DEFAULT);
				    ct1=new ImageIcon(ct2);
				    r_b[i].setIcon(ct1);
				}
			}
			p1.add(r_b[i]);
		}
		
		j=new JScrollPane(p,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		f1.setContentPane(j);
		p.setBackground(Color.white);
		f1.setSize(612,500);
		f1.setVisible(true);
        f1.setResizable(false);
        f1.setLocation(300,50);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
    class buy implements ActionListener{
    	int i;
    	buy(int i){
    	    this.i=i;
    	}
    	public void actionPerformed(ActionEvent a) {
            new Goods_buy(i);
    	}
    }
    class shop implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
    		  p0.setVisible(true);
    		  p1.setVisible(false);
    		  p2.setVisible(false);
    		  shop_b.setBackground(Color.cyan);
              rec_b.setBackground(Color.lightGray);
              personal_b.setBackground(Color.lightGray);
    	}
    }
    class tuijian implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
      		  p1.setVisible(true);
      		  p0.setVisible(false);
      		  p2.setVisible(false);
              rec_b.setBackground(Color.cyan);
              shop_b.setBackground(Color.lightGray);
              personal_b.setBackground(Color.lightGray);
    	}
    }
    class personal implements ActionListener{
    	public void actionPerformed(ActionEvent a) {
    		  p2.setVisible(true);
     		  p0.setVisible(false);
     		  p1.setVisible(false);
              personal_b.setBackground(Color.cyan);
              rec_b.setBackground(Color.lightGray);
              shop_b.setBackground(Color.lightGray);
    	}
    }
	Double compare(int[] o1, int[] o2) {
	    //分子求和
	    Double fenzi = 0.0 ;
	    for (int i = 0; i < o1.length; i++) {
	        fenzi += o1[i]*o2[i];
	    }
	    //分母第一部分
	    Double fenmu1 = 0.0;
	    for (int i = 0; i < o1.length; i++) {
	        fenmu1 += o1[i] * o1[i];
	    }
	    fenmu1 = Math.sqrt(fenmu1);
	    //分母第二部分
	    Double fenmu2 = 0.0;
	    for (int i = 0; i < o2.length; i++) {
	        fenmu2 += o2[i] * o2[i];
	    }
	    fenmu2 = Math.sqrt(fenmu2);
	    return fenzi / (fenmu1 * fenmu2);
	}
}
