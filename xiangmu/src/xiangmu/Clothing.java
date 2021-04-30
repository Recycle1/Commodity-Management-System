package xiangmu;

import java.awt.Image;
import java.util.Scanner;

public class Clothing extends Goods{
    String size[]=new String[10];
	public Clothing()
	{}
    public Clothing(int number, String name, String brand, String origin, double price, String size[],Image image) {
        super(number, name, brand, origin, price,image);
        this.size = size;
    }
    public String[] getSize() {
        return size;
    }
    public void setSize(String size[]) {
        this.size = size;
    }
}