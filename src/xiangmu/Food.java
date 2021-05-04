package xiangmu;

import java.awt.Image;
import java.util.Scanner;

public class Food extends Goods{
    String shelflife;
	public Food()
	{}
    public Food(int number, String name, String brand, String origin, double price, String shelflife,Image image) {
        super(number, name, brand, origin, price,image);
        this.shelflife = shelflife;
    }
    public String getShelflife() {
        return shelflife;
    }
    public void setShelflife(String shelflife) {
        this.shelflife = shelflife;
    }
}