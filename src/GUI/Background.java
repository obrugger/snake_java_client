package GUI;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * The Background class.
 * Works as an image container, that shows
 * the background.
 *
 * @author Oscar
 * @since 16-11-2015
 *
 * Created by Oscar on 16-11-2015.
 */
class Background extends JPanel {


    /** The image. */
    private BufferedImage image;


    /**
     * Creates the Background constructor.
     */
    public Background() {

        //Sets the layout to anonymous class, BorderLayout.
        setLayout(new BorderLayout());

        try{

            /*
            Instantiates the image variable by calling a static object of ImageIO,
            and call the read method. The parameter for read method is an anonymous
            class of URL, which takes a parameter of getting the resource, which
            is the background picture.
             */
            image = ImageIO.read(
                    new URL(
                            getClass().getResource("background.png"), "background.png"
                    )
            );
        }

        //Catches every exception thrown by try-block.
        catch(Exception e){
            //Prints the stacktrace.
            e.printStackTrace();
        }
    }

    /**
     * The PaintComponent.
     *
     * @param g the graphic.
     */
    public void paintComponent(Graphics g){

        /*
        Calls the JComponent method paintComponent, which accepts
        the parameter g, as its parameter.
         */
        super.paintComponent(g);

        /*
        Calls drawImage method from g-object. For parameters, there are
        the image object, two integer values of 0, then gets the width
        and height of the image, and declares Background class as
        ImageObserver.
         */
        g.drawImage(image, 0, 0,getWidth(), getHeight(), this);
    }
}
