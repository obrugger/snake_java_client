package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oscar on 26-10-2015.
 */
public class CreateGame extends JPanel {

    public CreateGame(){

        setOpaque(false);
        setBackground(Color.BLUE);


    }

    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0,0, getWidth(),getHeight());
        graphics2D.setComposite(old);
    }
}
