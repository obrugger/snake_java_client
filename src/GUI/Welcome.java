package GUI;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.AlphaComposite;
import javax.swing.JPanel;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 17-11-2015.
 */
public class Welcome extends JPanel {

    /**
     * Instantiates a new welcome.
     */
    public Welcome(){

        setOpaque(false);


    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.001f));
        graphics2D.fillRect(0,0, getWidth(),getHeight());
        graphics2D.setComposite(old);
    }
}
