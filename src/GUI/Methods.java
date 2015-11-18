package GUI;

import java.awt.*;

/**
 * Created by Oscar on 27-10-2015.
 */
public class Methods {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int screenWidth = (int) screenSize.getWidth();
    private int screenHeight = (int) screenSize.getHeight();

    private double frameWidth = screenWidth/1.3;
    private double frameHeight = screenHeight/1.3;



    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public double getFrameHeight(){
        return frameHeight;
    }

    public double getFrameWidth() {
        return frameWidth;
    }
}
