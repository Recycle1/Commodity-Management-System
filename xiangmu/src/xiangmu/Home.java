package xiangmu;

import java.awt.Image;
import java.util.Scanner;

public class Home extends Goods{
    String materal[]=new String[10];
	public Home()
	{}
    public Home(int number, String name, String brand, String origin, double price, String materal[],Image image) {
        super(number, name, brand, origin, price,image);
        this.materal = materal;
    }
    public String[] getMateral() {
        return materal;
    }
    public void setMateral(String materal[]) {
        this.materal = materal;
    }

}