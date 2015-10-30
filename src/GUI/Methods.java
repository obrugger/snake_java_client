package GUI;

import java.awt.*;

/**
 * Created by Oscar on 27-10-2015.
 */
public class Methods {

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    private int screenWidth = (int) screenSize.getWidth();
    private int screenHeight = (int) screenSize.getHeight();

    private int frameWidth = screenWidth/2;
    private int frameHeight = screenHeight/2;

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getFrameHeight(){
        return frameHeight;
    }

    public int getFrameWidth() {
        return frameWidth;
    }
}
