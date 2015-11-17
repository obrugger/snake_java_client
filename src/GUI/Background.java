package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Oscar on 16-11-2015.
 */
public class Background extends JPanel {


    BufferedImage image;


    public Background() {

        setLayout(new BorderLayout());
        try{

            image = javax.imageio.ImageIO.read(
                    new java.net.URL(getClass().getResource("background.png"), "background.png"));

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public Dimension getPrefferedSize(){
        return image == null ? super.getPreferredSize() : new Dimension(image.getWidth(), image.getHeight());
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
    }
}
