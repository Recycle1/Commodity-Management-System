package xiangmu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import xiangmu.Goods_buy.buy_something;
import xiangmu.Goods_buy.listener1;
import xiangmu.Goods_buy.listener2;

public class Goods_manage {
      JFrame m_f;
      Container m_c;
      JTextArea g_name;
  	  JTextArea g_origin;
  	  JTextArea g_brand;
  	  JTextArea g_price;
  	  JTextArea g_amount;
  	  JTextArea g_cost;
  	  JLabel name;
  	  JLabel origin;
  	  JLabel brand;
  	  JLabel price;
  	  JLabel number;
  	  JLabel shelflife;
  	  JTextArea c_size=new JTextArea();
  	  JTextArea h_materal=new JTextArea();
  	  JTextArea f_shelflife;
  	  JButton change_b;
  	  JButton delete_b;
  	  JButton other;
  	  JButton jin_b;
  	  JButton chu_b;
      int amount;
      int g_a;
      Goods_information mg=new Goods_information();
      Goods_manage(int i){
        
  		m_f=new JFrame("管理");
  		m_c=m_f.getContentPane();
  		m_c.setLayout(null);
  		  
  		name=new JLabel("名称");
  		name.setBounds(100,60,100,40);
  		name.setFont(new Font("宋体",Font.BOLD,20));
  		m_c.add(name);
  		g_name=new JTextArea();
		g_name.setFont(new Font("宋体",Font.BOLD,17));
		g_name.setLineWrap(true);
		g_name.setBounds(170,60,200,45);
		m_c.add(g_name);
  		//设置产地文本
  		origin=new JLabel("产地");
  		origin.setBounds(100,110,100,40);
  		origin.setFont(new Font("宋体",Font.BOLD,20));
  		m_c.add(origin);
  		g_origin=new JTextArea();
		g_origin.setFont(new Font("宋体",Font.BOLD,19));
		g_origin.setLineWrap(true);
		g_origin.setBounds(170,115,200,30);
		m_c.add(g_origin);
  		//设置品牌文本
  		brand=new JLabel("品牌");
  		brand.setBounds(100,150,100,40);
  		brand.setFont(new Font("宋体",Font.BOLD,20));
  		m_c.add(brand);
  		g_brand=new JTextArea();
		g_brand.setFont(new Font("宋体",Font.BOLD,19));
		g_brand.setLineWrap(true);
		g_brand.setBounds(170,155,200,30);
		m_c.add(g_brand);
  		//设置价格文本
  		price=new JLabel("价格");
  		price.setBounds(100,190,100,40);
  		price.setFont(new Font("宋体",Font.BOLD,20));
  		m_c.add(price);
  		g_price=new JTextArea();
		g_price.setFont(new Font("宋体",Font.BOLD,19));
		g_price.setBounds(170,195,200,30);
		m_c.add(g_price);
  		//设置库存文本
  		number=new JLabel("库存");
  		number.setBounds(100,230,100,40);
  		number.setFont(new Font("宋体",Font.BOLD,20));
  		m_c.add(number);
  		g_amount=new JTextArea();
		g_amount.setFont(new Font("宋体",Font.BOLD,22));
		g_amount.setBounds(175,235,70,30);
		g_amount.setEditable(false);
		m_c.add(g_amount);
		
		other=new JButton();
		other.setBounds(110,275,200,35);
		other.setBackground(Color.orange);
		other.setForeground(Color.white);
		other.setFont(new Font("宋体",Font.BOLD,25));
		other.setFocusPainted(false);
		other.addActionListener(new other_shangpin(i));
		
		
		if(i<8) {
		    g_amount.append(String.valueOf(mg.C[i].number));
		    g_name.append(mg.C[i].name);
		    g_price.append(String.valueOf(mg.C[i].price));
		    g_brand.append(mg.C[i].brand);
		    g_origin.append(mg.C[i].origin);
		    m_c.add(other);
		    other.setText("修改尺寸");
		}
		if(i>=8&&i<16) {
		    g_amount.append(String.valueOf(mg.F[i-8].number));
		    g_name.append(mg.F[i-8].name);
		    g_price.append(String.valueOf(mg.F[i-8].price));
		    g_brand.append(mg.F[i-8].brand);
		    g_origin.append(mg.F[i-8].origin);
		    shelflife=new JLabel("保质期");
		    shelflife.setBounds(100,270,100,40);
		    shelflife.setFont(new Font("宋体",Font.BOLD,20));
	  		m_c.add(shelflife);
		    f_shelflife=new JTextArea();
		    f_shelflife.append(mg.F[i-8].shelflife);
			f_shelflife.setFont(new Font("宋体",Font.BOLD,19));
			f_shelflife.setLineWrap(true);
			f_shelflife.setBounds(170,275,200,30);
			m_c.add(f_shelflife);
		}
		if(i>=16&&i<24) {
			g_amount.append(String.valueOf(mg.H[i-16].number));
		    g_name.append(mg.H[i-16].name);
		    g_price.append(String.valueOf(mg.H[i-16].price));
		    g_brand.append(mg.H[i-16].brand);
		    g_origin.append(mg.H[i-16].origin);
		    m_c.add(other);
		    other.setText("修改材质");
		}
		g_a=Integer.parseInt(g_amount.getText());
		change_b=new JButton("确认修改");
		change_b.setBounds(110,320,200,40);
		change_b.setBackground(Color.orange);
		change_b.setForeground(Color.white);
		change_b.setFont(new Font("宋体",Font.BOLD,30));
		change_b.setFocusPainted(false);
		change_b.addActionListener(new change_something(i));
		m_c.add(change_b);
		//删除商品
		delete_b=new JButton("删除");
		delete_b.setBounds(320,322,100,35);
		delete_b.setBackground(Color.red);
		delete_b.setFont(new Font("宋体",Font.BOLD,28));
		delete_b.setFocusPainted(false);
		delete_b.addActionListener(new delete_shangpin(i));
		m_c.add(delete_b);
		//修改库存
		amount=Integer.parseInt(g_amount.getText());
		jin_b=new JButton("进货");
		jin_b.addActionListener(new adjust_amount1());
		jin_b.setBounds(260,231,70,40);
		jin_b.setFont(new Font("宋体",Font.BOLD,17));
		jin_b.setFocusPainted(false);
		m_c.add(jin_b);
		chu_b=new JButton("出货");
		chu_b.addActionListener(new adjust_amount2());
		chu_b.setBounds(330,231,70,40);
		chu_b.setFont(new Font("宋体",Font.BOLD,17));
		chu_b.setFocusPainted(false);
		m_c.add(chu_b);
  		  
  		m_f.setSize(500,420);
		m_f.setVisible(true);
		m_f.setResizable(false);
		m_f.setLocation(350,50);
      }
      class adjust_amount1 implements ActionListener{
      	public void actionPerformed(ActionEvent e) {
      			amount++;
      		    g_amount.setText("");
      		    g_amount.append(String.valueOf(amount));
      	}
  	}
  	class adjust_amount2 implements ActionListener{
      	public void actionPerformed(ActionEvent e) {
      		if(amount>0) {
      			amount--;
      		    g_amount.setText("");
      		    g_amount.append(String.valueOf(amount));
      		}
      	}
  	}
  	class other_shangpin implements ActionListener{
  		int i;
    	other_shangpin(int i){
    	    this.i=i;
    	}
  		public void actionPerformed(ActionEvent e) {
  			   new Size_or_Materal(i);
  		}
  	 }
  	class change_something implements ActionListener{
  		int i;
    	change_something(int i){
    	    this.i=i;
    	}
  		public void actionPerformed(ActionEvent e) {//修改商品
  			int con=JOptionPane.showConfirmDialog(null,"确认修改","修改内容信息",JOptionPane.YES_NO_OPTION);
    		if(con==JOptionPane.YES_OPTION) {
    			JOptionPane.showMessageDialog(null,"修改成功");
    			if(g_a==0&&Integer.parseInt(g_amount.getText())>0) {
    				Shop_manager.u_b[i].setText("已补货");
    			}
    			if(g_a!=0&&Integer.parseInt(g_amount.getText())==0) {
    				Shop_manager.u_b[i].setIcon(null);
        			Shop_manager.u_b[i].setText("库存不足");
    			}
      			if(i<8) {
      				mg.C[i].change_information(0,i,mg.c_information.shuju,g_name.getText(),mg.c_txt);
      				mg.C[i].change_information(1,i,mg.c_information.shuju,g_amount.getText(),mg.c_txt);
      				mg.C[i].change_information(2,i,mg.c_information.shuju,g_brand.getText(),mg.c_txt);
      				mg.C[i].change_information(3,i,mg.c_information.shuju,g_origin.getText(),mg.c_txt);
      				mg.C[i].change_information(4,i,mg.c_information.shuju,g_price.getText(),mg.c_txt);
      			}
      	        if(i>=8&&i<16) {
      	        	mg.F[i-8].change_information(0,i-8,mg.f_information.shuju,g_name.getText(),mg.f_txt);
      	        	mg.F[i-8].change_information(1,i-8,mg.f_information.shuju,g_amount.getText(),mg.f_txt);
      	        	mg.F[i-8].change_information(2,i-8,mg.f_information.shuju,g_brand.getText(),mg.f_txt);
      	        	mg.F[i-8].change_information(3,i-8,mg.f_information.shuju,g_origin.getText(),mg.f_txt);
      	        	mg.F[i-8].change_information(4,i-8,mg.f_information.shuju,g_price.getText(),mg.f_txt);
      	        	mg.F[i-8].change_information(5,i-8,mg.f_information.shuju,f_shelflife.getText(),mg.f_txt);
      	        }
      	        if(i>=16&&i<24) {
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,g_name.getText(),mg.h_txt);
      	        	mg.H[i-16].change_information(1,i-16,mg.h_information.shuju,g_amount.getText(),mg.h_txt);
      	        	mg.H[i-16].change_information(2,i-16,mg.h_information.shuju,g_brand.getText(),mg.h_txt);
      	        	mg.H[i-16].change_information(3,i-16,mg.h_information.shuju,g_origin.getText(),mg.h_txt);
      	        	mg.H[i-16].change_information(4,i-16,mg.h_information.shuju,g_price.getText(),mg.h_txt);
      	        }
    	  }
  		}
  	}
  	class delete_shangpin implements ActionListener{
  		int i;
    	delete_shangpin(int i){
    	    this.i=i;
    	}
  		public void actionPerformed(ActionEvent e) {//删除商品
  			int con=JOptionPane.showConfirmDialog(null,"确认删除","删除内容信息",JOptionPane.YES_NO_OPTION);
    		if(con==JOptionPane.YES_OPTION) {
    			JOptionPane.showMessageDialog(null,"删除成功");
    			Shop_manager.u_b[i].setIcon(null);
    			Shop_manager.u_b[i].setText("已删除");
      			if(i<8) {
      				mg.C[i].change_information(0,i,mg.c_information.shuju,"0",mg.c_txt);
      				mg.C[i].change_information(1,i,mg.c_information.shuju,"0",mg.c_txt);
      				mg.C[i].change_information(2,i,mg.c_information.shuju,"0",mg.c_txt);
      				mg.C[i].change_information(3,i,mg.c_information.shuju,"0",mg.c_txt);
      				mg.C[i].change_information(4,i,mg.c_information.shuju,"0",mg.c_txt);
      			}
      	        if(i>=8&&i<16) {
      	        	mg.F[i-8].change_information(0,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        	mg.F[i-8].change_information(1,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        	mg.F[i-8].change_information(2,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        	mg.F[i-8].change_information(3,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        	mg.F[i-8].change_information(4,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        	mg.F[i-8].change_information(5,i-8,mg.f_information.shuju,"0",mg.f_txt);
      	        }
      	        if(i>=16&&i<24) {
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,"0",mg.h_txt);
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,"0",mg.h_txt);
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,"0",mg.h_txt);
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,"0",mg.h_txt);
      	        	mg.H[i-16].change_information(0,i-16,mg.h_information.shuju,"0",mg.h_txt);
      	        }
    	    }
  		}
  	}
}
