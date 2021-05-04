package xiangmu;

import java.awt.Image;
import java.io.*;

import javax.swing.ImageIcon;

public class Goods_information {//从文件中将内容信息读取放在定义的类中

	Clothing []C=new Clothing[8];
    Food []F=new Food[8];
    Home []H=new Home[8];
    File c_txt=new File("C:\\Users\\LENOVO\\Desktop\\clothing.txt");
    File f_txt=new File("C:\\Users\\LENOVO\\Desktop\\food.txt");
    File h_txt=new File("C:\\Users\\LENOVO\\Desktop\\home.txt");
    File size_txt=new File("C:\\Users\\LENOVO\\Desktop\\size.txt");
    File materal_txt=new File("C:\\Users\\LENOVO\\Desktop\\materal.txt");
    Read_file c_information;
    Read_file f_information;
    Read_file h_information;
    Read_file size_information;
    Read_file materal_information;
	Goods_information(){
		 for(int i=0;i<8;i++) {
		      C[i]=new Clothing();
		      F[i]=new Food();
		      H[i]=new Home();
		 }
         c_information=new Read_file(c_txt);
         for(int i=0;i<c_information.sum;i++) {
        	 for(int j=0;j<c_information.shuju[i].length;j++) {
        		 if(i==0)C[j].setName(c_information.shuju[i][j]);
        		 if(i==1)C[j].setNumber(Integer.parseInt(c_information.shuju[i][j]));
        		 if(i==2)C[j].setBrand(c_information.shuju[i][j]);
        		 if(i==3)C[j].setOrigin(c_information.shuju[i][j]);
        		 if(i==4)C[j].setPrice(Double.parseDouble(c_information.shuju[i][j]));
        	 }
         }
         size_information=new Read_file(size_txt);
        	 for(int i=0;i<size_information.sum;i++) {
        		 C[i].setSize(size_information.shuju[i]);
        	 }
        	 
         f_information=new Read_file(f_txt);
         for(int i=0;i<f_information.sum;i++) {
        	 for(int j=0;j<f_information.shuju[i].length;j++) {
        		 if(i==0)F[j].setName(f_information.shuju[i][j]);
        		 if(i==1)F[j].setNumber(Integer.parseInt(f_information.shuju[i][j]));
        		 if(i==2)F[j].setBrand(f_information.shuju[i][j]);
        		 if(i==3)F[j].setOrigin(f_information.shuju[i][j]);
        		 if(i==4)F[j].setPrice(Double.parseDouble(f_information.shuju[i][j]));
        		 if(i==5)F[j].setShelflife(f_information.shuju[i][j]);
        	 }
         }
         
         h_information=new Read_file(h_txt);
         for(int i=0;i<h_information.sum;i++) {
        	 for(int j=0;j<h_information.shuju[i].length;j++) {
        		 if(i==0)H[j].setName(h_information.shuju[i][j]);
        		 if(i==1)H[j].setNumber(Integer.parseInt(h_information.shuju[i][j]));
        		 if(i==2)H[j].setBrand(h_information.shuju[i][j]);
        		 if(i==3)H[j].setOrigin(h_information.shuju[i][j]);
        		 if(i==4)H[j].setPrice(Double.parseDouble(h_information.shuju[i][j]));
        	 }
         }
         materal_information=new Read_file(materal_txt);
        	 for(int i=0;i<materal_information.sum;i++) {
        		 H[i].setMateral(materal_information.shuju[i]);
        	 }
        	 
        	 C[0].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\1.jpg").getImage();
        	 C[1].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\2.jpg").getImage();
        	 C[2].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\3.jpg").getImage();
        	 C[3].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\4.jpg").getImage();
        	 C[4].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\5.jpg").getImage();
        	 C[5].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\6.jpg").getImage();
        	 C[6].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\7.jpg").getImage();
        	 C[7].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\8.jpg").getImage();
        	 F[0].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\9.jpg").getImage();
        	 F[1].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\10.jpg").getImage();
        	 F[2].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\11.jpg").getImage();
        	 F[3].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\12.jpg").getImage();
        	 F[4].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\13.jpg").getImage();
        	 F[5].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\14.jpg").getImage();
        	 F[6].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\15.jpg").getImage();
        	 F[7].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\16.jpg").getImage();
        	 H[0].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\17.jpg").getImage();
        	 H[1].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\18.jpg").getImage();
        	 H[2].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\19.jpg").getImage();
        	 H[3].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\20.jpg").getImage();
        	 H[4].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\21.jpg").getImage();
        	 H[5].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\22.jpg").getImage();
        	 H[6].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\23.jpg").getImage();
        	 H[7].image=new ImageIcon("C:\\Users\\LENOVO\\Desktop\\Image\\24.jpg").getImage();        
	  }
}
