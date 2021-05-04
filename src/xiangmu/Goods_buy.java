package xiangmu;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.*;

public class Goods_buy {
	JFrame buy_f;
	Container buy_c;
	JButton buy_b;
	JTextArea g_name;
	JTextArea g_origin;
	JTextArea g_brand;
	JTextArea g_price;
	JTextArea g_amount;
	JTextArea g_cost;
	JComboBox c_size=new JComboBox();
	JComboBox h_materal=new JComboBox();
	JTextArea f_shelflife;
	String true_size;
	String true_materal;
	JButton amount1;
	JButton amount2;
	static JButton confirm[]=new JButton[20];
	int number;
	int amount;
	BackgroundPanel goods_back=null;
	BackgroundPanel goods_image=null;
	JLabel jlabel=null;
	ImageIcon g_image=null;
	String buy_information1;
	String buy_information2;
	static int danshu=0;
	Goods_information g=new Goods_information();
	Goods_buy(int i){
		buy_f=new JFrame("购买");
		buy_c=buy_f.getContentPane();
		buy_c.setLayout(null);
		//价格文本
		g_price=new JTextArea();
		g_price.setOpaque(false);
		g_price.setFont(new Font("宋体",Font.BOLD,45));
		g_price.setEditable(false);
		g_price.setBounds(117,317,190,45);
		buy_c.add(g_price);
		//名称文本
		g_name=new JTextArea();
		g_name.setFont(new Font("宋体",Font.BOLD,28));
		g_name.setLineWrap(true);
		g_name.setEditable(false);
		g_name.setBounds(310,20,280,80);
		buy_c.add(g_name);
		//品牌文本
		g_brand=new JTextArea();
		g_brand.setOpaque(false);
		g_brand.setFont(new Font("宋体",Font.BOLD,18));
		g_brand.setLineWrap(true);
		g_brand.setEditable(false);
		g_brand.setBounds(362,122,190,30);
		buy_c.add(g_brand);
		//产地文本
		g_origin=new JTextArea();
		g_origin.setFont(new Font("宋体",Font.BOLD,22));
		g_origin.setLineWrap(true);
		g_origin.setEditable(false);
		g_origin.setBounds(370,191,190,30);
		buy_c.add(g_origin);
		//设置服装界面
		if(i<8) {
			goods_back=new BackgroundPanel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\2.jpg").getImage());
		    goods_back.setBounds(0,0,600,435);
		    number=g.C[i].number;
		    g_name.append(g.C[i].name);
		    g_price.append(String.valueOf(g.C[i].price));
		    g_brand.append(g.C[i].brand);
		    g_origin.append(g.C[i].origin);  
		    g_image=(new ImageIcon(g.C[i].image));
		    c_size.addItemListener(new listener1());
		    for(int a=0;a<g.C[i].size.length;a++) {
			     c_size.addItem(g.C[i].size[a]);
		    }
		    c_size.setBounds(363,299,200,42);
		    buy_c.add(c_size);
		}
		//设置食物界面
		if(i>=8&&i<16) {
			goods_back=new BackgroundPanel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\3.jpg").getImage());
		    goods_back.setBounds(0,0,600,435);
		    number=g.F[i-8].number;
		    g_name.append(g.F[i-8].name);
		    g_price.append(String.valueOf(g.F[i-8].price));
		    g_brand.append(g.F[i-8].brand);
		    g_origin.append(g.F[i-8].origin);
		    g_image=(new ImageIcon(g.F[i-8].image));
		    f_shelflife=new JTextArea();
		    f_shelflife.append(g.F[i-8].shelflife);
			f_shelflife.setFont(new Font("宋体",Font.BOLD,22));
			f_shelflife.setLineWrap(true);
			f_shelflife.setEditable(false);
			f_shelflife.setBounds(363,308,190,30);
			buy_c.add(f_shelflife);
		}
		//设置家居界面
		if(i>=16&&i<24) {
			goods_back=new BackgroundPanel(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\4.jpg").getImage());
		    goods_back.setBounds(0,0,600,435);
		    number=g.H[i-16].number;
		    g_name.append(g.H[i-16].name);
		    g_price.append(String.valueOf(g.H[i-16].price));
		    g_brand.append(g.H[i-16].brand);
		    g_origin.append(g.H[i-16].origin);
		    g_image=(new ImageIcon(g.H[i-16].image));
		    h_materal.addItemListener(new listener2());
		    for(int a=0;a<g.H[i-16].materal.length;a++) {
			     h_materal.addItem(g.H[i-16].materal[a]);
		    }
		    h_materal.setBounds(363,299,200,42);
		    buy_c.add(h_materal);
		}
		g_image.setImage(g_image.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH));
		jlabel=new JLabel(g_image);
		jlabel.setBounds(5,10,300,300);
		buy_c.add(jlabel);
		//数量文本
		g_amount=new JTextArea();
		g_amount.setFont(new Font("宋体",Font.BOLD,22));
		if(number!=0)g_amount.append("1");
		else {
			g_amount.append("0");
		}
		g_amount.setOpaque(false);
		g_amount.setBounds(369,250,45,30);
		g_amount.setEditable(false);
		buy_c.add(g_amount);
		//调节数量
		amount=Integer.parseInt(g_amount.getText());
		amount1=new JButton("▲");
		amount1.addActionListener(new adjust_amount1());
		amount1.setBounds(400,240,45,22);
		amount1.setFont(new Font("宋体",Font.BOLD,10));
		buy_c.add(amount1);
		
		amount2=new JButton("▼");
		amount2.addActionListener(new adjust_amount2());
		amount2.setBounds(400,267,45,22);
		amount2.setFont(new Font("宋体",Font.BOLD,10));
		buy_c.add(amount2);
		
		g_cost=new JTextArea();
		g_cost.setFont(new Font("宋体",Font.BOLD,22));
		g_cost.append(String.valueOf(Double.parseDouble(g_price.getText())));
		g_cost.setOpaque(false);
		g_cost.setBounds(490,252,70,49);
		g_cost.setEditable(false);
		buy_c.add(g_cost);
		
		buy_c.add(goods_back);
		buy_b=new JButton("立即购买");
		buy_b.setBounds(337,350,240,49);
		buy_b.setBackground(Color.red);
		buy_b.setForeground(Color.white);
		buy_b.setFont(new Font("宋体",Font.BOLD,30));
		buy_b.setFocusPainted(false);
		buy_b.addActionListener(new buy_something(i));
		buy_c.add(buy_b);
		
		buy_f.setSize(615,472);
		buy_f.setVisible(true);
		buy_f.setResizable(false);
		buy_f.setLocation(350,50);
	}
	class adjust_amount1 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(amount<number) {
    			amount++;
    		    g_amount.setText("");
    		    g_cost.setText("");
    		    g_amount.append(String.valueOf(amount));
    		    g_cost.append(String.valueOf(Double.parseDouble(g_price.getText())*amount));
    		}
    		else JOptionPane.showMessageDialog(null,"单数过大，超出库存");
    	}
	}
	class adjust_amount2 implements ActionListener{
    	public void actionPerformed(ActionEvent e) {
    		if(amount>1) {
    			amount--;
    		    g_amount.setText("");
    		    g_cost.setText("");
    		    g_amount.append(String.valueOf(amount));
    		    g_cost.append(String.valueOf(Double.parseDouble(g_price.getText())*amount));
    		}
    	}
    	
	}
	 class listener1 implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
		           true_size=c_size.getSelectedItem().toString();
			}
	 }
	 class listener2 implements ItemListener{
			public void itemStateChanged(ItemEvent e) {
		           true_materal=h_materal.getSelectedItem().toString();
			}
	 }
	class buy_something implements ActionListener{
		int i;
		queren q[]=new queren[20];
		buy_something(int i){
    	    this.i=i;
    	}
    	public void actionPerformed(ActionEvent e) {//当用户确认购买，将购买信息设为订单放在个人中心
    		if(number==0) JOptionPane.showMessageDialog(null,"库存不足");
    		else {
    		int con=JOptionPane.showConfirmDialog(null,"确认购买","确认信息",JOptionPane.YES_NO_OPTION);
    		if(con==JOptionPane.YES_OPTION) {
    			if(amount==number) {
    				User.u_b[i].setIcon(null);
    				User.u_b[i].setText("库存不足");
    				User.u_b[i].setEnabled(false);
    			}
    			JOptionPane.showMessageDialog(null,"购买成功");
    			buy_information1=" 品名："+g_name.getText();
    			buy_information2=" 品牌："+g_brand.getText()+"  产地："+g_origin.getText()+"            ×"+String.valueOf(amount)+"   价钱："+g_cost.getText();
    			JTextArea order=new JTextArea();
    			LineBorder lb=new LineBorder(Color.black,1,false);
    			order.setBorder(BorderFactory.createTitledBorder(lb,"订单"+String.valueOf(danshu+1),TitledBorder.LEFT,TitledBorder.TOP));
    			order.setBounds(13,90+100*danshu,555,90);
    			order.setFont(new Font("宋体",Font.BOLD,17));
    			order.setEditable(false);
    			confirm[danshu]=new JButton("未收货");
    			confirm[danshu].setBounds(462,105+100*danshu,100,32);
    			confirm[danshu].setEnabled(false);
    		    q[danshu]=new queren(danshu);
    		    confirm[danshu].addActionListener(q[danshu]);
    			order.setBackground(Color.cyan);
    			order.append(buy_information1+"\n\n"+buy_information2);
    			User.p2.add(confirm[danshu]);
    			User.p2.add(order);
    			
    			danshu++;
    			int new_number;
    			if(i<8) {
    				new_number=g.C[i].number-Integer.parseInt(g_amount.getText());
    				g.C[i].change_information(1,i,g.c_information.shuju,String.valueOf(new_number),g.c_txt);
    			}
    			 if(i>=8&&i<16) {
    				 new_number=g.F[i-8].number-Integer.parseInt(g_amount.getText());
    				 g.F[i-8].change_information(1,i-8,g.f_information.shuju,String.valueOf(new_number),g.f_txt);
    			 }
    			 if(i>=16&&i<24) {
    				 new_number=g.H[i-16].number-Integer.parseInt(g_amount.getText());
    				 g.H[i-16].change_information(1,i-16,g.h_information.shuju,String.valueOf(new_number),g.h_txt);
    			 }
    			 new Client(buy_information1+"x123x"+buy_information2);
    		}
    	}
    	}
    	class queren implements ActionListener{
    		int a1;
    		queren(int danshu){
    			a1=danshu;
    		}
			public void actionPerformed(ActionEvent e) {
				confirm[a1].setEnabled(false);
				confirm[a1].setText("已收货");
			}
    	 }		
	}
}
