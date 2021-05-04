package xiangmu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BackgroundPanel extends JPanel{//…Ë÷√±≥æ∞Õº∆¨
	Image im;  
    public BackgroundPanel(Image im)  
    {  
        this.im=im;  
        this.setOpaque(true);                   
    }  
    public void paintComponent(Graphics g)       
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);

    }  
}
