package xiangmu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Size_or_Materal {
	JFrame sm_f;
    Container sm_c;
    JTextArea sum;
    JTextArea s_m[]=new JTextArea[6];
    JLabel shu;
    JButton queding;
    JButton change;
    Goods_information g=new Goods_information();
    int a;
    int i;
   Size_or_Materal(int i){
	        this.i=i;
		    sm_f=new JFrame();
	  		sm_c=sm_f.getContentPane();
	  		sm_c.setLayout(null);
	  		
	  		shu=new JLabel("数量");
	  		shu.setBounds(120,60,100,40);
	  		shu.setFont(new Font("宋体",Font.BOLD,20));
	  		sm_c.add(shu);
	  		sum=new JTextArea();
			sum.setFont(new Font("宋体",Font.BOLD,28));
			sum.setLineWrap(true);
			sum.setBounds(170,60,100,37);
			sm_c.add(sum);
			
			queding=new JButton("确定");
			queding.setBounds(270,60,100,37);
			queding.setBackground(Color.orange);
			queding.setFont(new Font("宋体",Font.BOLD,28));
			queding.setFocusPainted(false);
			queding.addActionListener(new change_sm());
			sm_c.add(queding);
			
			change=new JButton("确定");
			change.setBounds(120,320,200,40);
			change.setBackground(Color.orange);
			change.setFont(new Font("宋体",Font.BOLD,28));
			change.setFocusPainted(false);
			change.addActionListener(new confirm_change());
			sm_c.add(change);
			
	  		if(i<8) {
	  			sm_f.setTitle("尺寸");
	  			sum.append(String.valueOf(g.C[i].size.length));
	  			for(a=0;a<Integer.parseInt(sum.getText());a++) {
	 				   s_m[a]=new JTextArea();
	 				   s_m[a].setBounds(120,110+35*a,250,25);
	 				   s_m[a].setFont(new Font("宋体",Font.BOLD,15));
	 				   s_m[a].append(g.C[i].size[a]);
	 				   sm_c.add(s_m[a]);
	 			   }
	  		}
	  		if(i>=16&&i<24) {
	  			sm_f.setTitle("材质");
	  			sum.append(String.valueOf(g.H[i-16].materal.length));
	  			for(a=0;a<Integer.parseInt(sum.getText());a++) {
	 				   s_m[a]=new JTextArea();
	 				   s_m[a].setBounds(120,110+35*a,250,25);
	 				   s_m[a].setFont(new Font("宋体",Font.BOLD,15));
	 				   s_m[a].append(g.H[i-16].materal[a]);
	 				   sm_c.add(s_m[a]);
	 			   }
	  		}
	  		
	  		sm_f.setSize(500,420);
			sm_f.setVisible(true);
			sm_f.setResizable(false);
			sm_f.setLocation(350,50);
   }
   class change_sm implements ActionListener{
 		public void actionPerformed(ActionEvent e) {
 			if(i<8) {
 				if(Integer.parseInt(sum.getText())<g.C[i].size.length||Integer.parseInt(sum.getText())>6)
 					JOptionPane.showMessageDialog(null,"数量有误");
 				else {
 					for(;a<Integer.parseInt(sum.getText());a++) {
 						 s_m[a]=new JTextArea();
 		 				   s_m[a].setBounds(120,110+35*a,250,25);
 		 				   s_m[a].setFont(new Font("宋体",Font.BOLD,15));
 		 				   sm_c.add(s_m[a]);
 					}
 				}
 			}
 			else {
 				if(Integer.parseInt(sum.getText())<g.H[i-16].materal.length||Integer.parseInt(sum.getText())>6)
 					JOptionPane.showMessageDialog(null,"数量有误");
 				else {
 					for(;a<Integer.parseInt(sum.getText());a++) {
 						 s_m[a]=new JTextArea();
 		 				   s_m[a].setBounds(120,110+35*a,250,25);
 		 				   s_m[a].setFont(new Font("宋体",Font.BOLD,15));
 		 				   sm_c.add(s_m[a]);
 					}
 				}
 			}
 			   
 		}
      }
   class confirm_change implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int con=JOptionPane.showConfirmDialog(null,"确认修改","确认修改？",JOptionPane.YES_NO_OPTION);
    		if(con==JOptionPane.YES_OPTION) {
    			JOptionPane.showMessageDialog(null,"修改成功");
    			String m=new String();
    			for(int b=0;b<a;b++)m+=s_m[b].getText()+" ";
    			if(i<8)g.C[i].change_s_or_m(i,g.size_information.shuju,m,g.size_txt);
		        else g.H[i-16].change_s_or_m(i-16,g.materal_information.shuju,m,g.materal_txt);
    		 }
		}
     }
}
