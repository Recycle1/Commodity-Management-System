package xiangmu;

import java.awt.Image;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Goods                             //定义商品
{
    int number;                         //数量
    String name;                        //名称
    String brand;                       //品牌
    String origin;                      //产地
    double price;                       //价格
    Image image;
	public Goods()
	{}
    public Goods(int number, String name, String brand, String origin, double price,Image image) {
        this.number = number;
        this.name = name;
        this.brand = brand;
        this.origin = origin;
        this.price = price;
        this.image=image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
		write(this.name,"d:\\test.txt");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
	//如果文件存在，则追加内容；如果文件不存在，则创建文件
	public void write(String name,String filepath) 
	{
		FileWriter fw = null;
		try 
		{
			File f=new File(filepath);
			fw = new FileWriter(f, true);//true,进行追加写。
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fw);
		pw.println(name);
		pw.flush();
		try 
		{
			fw.flush();
			pw.close();
			fw.close();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	//删除文件中指定内容
	public void delete(int i,int j,String sj[][],File filepath)
	{
		try {
			sj[i][j]="0";
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), "utf-8"));
			FileWriter fout = new FileWriter(filepath);// 创建文件输出流
			for(int a=0;a<sj.length;a++) {
				for(int b=0;b<sj[a].length;b++) {
					//out.write(sj[a][b].toCharArray());// 把替换完成的字符串写入文件内
					out.write(sj[a][b].toString()+" ");
				}
				out.write("\n");
			}
			out.close();// 关闭输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void change_information(int i,int j,String sj[][],String name,File filepath)
	{
		try {
			sj[i][j]=name;
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), "utf-8"));
			FileWriter fout = new FileWriter(filepath);// 创建文件输出流
			for(int a=0;a<sj.length;a++) {
				for(int b=0;b<sj[a].length;b++) {
					//out.write(sj[a][b].toCharArray());// 把替换完成的字符串写入文件内
					out.write(sj[a][b].toString()+" ");
				}
				out.write("\n");
			}
			out.close();// 关闭输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void change_s_or_m(int i,String sj[][],String name,File filepath)
	{
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), "utf-8"));
			FileWriter fout = new FileWriter(filepath);// 创建文件输出流
			for(int a=0;a<sj.length;a++) {
				if(a==i) out.write(name);
				else for(int b=0;b<sj[a].length;b++)out.write(sj[a][b].toString()+" ");
				out.write("\n");
			}
			out.close();// 关闭输出流
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}