package GUI;

import javax.swing.*;
import java.awt.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 27-10-2015.
 */
public class Methods {

    /** The screen size. */
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /** The screen width. */
    private int screenWidth = (int) screenSize.getWidth();
    
    /** The screen height. */
    private int screenHeight = (int) screenSize.getHeight();

    /** The frame width. */
    private double frameWidth = screenWidth/1.3;
    
    /** The frame height. */
    private double frameHeight = screenHeight/1.3;



    /**
     * Gets the screen height.
     *
     * @return the screen height
     */
    public int getScreenHeight() {
        return screenHeight;
    }

    /**
     * Gets the screen width.
     *
     * @return the screen width
     */
    public int getScreenWidth() {
        return screenWidth;
    }

    /**
     * Gets the frame height.
     *
     * @return the frame height
     */
    public double getFrameHeight(){
        return frameHeight;
    }

    /**
     * Gets the frame width.
     *
     * @return the frame width
     */
    public double getFrameWidth() {
        return frameWidth;
    }

    /**
     * Sets the alignment.
     *
     * @param label the new alignment
     */
    public void setAlignment(JLabel label){
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Sets the alignment text.
     *
     * @param txtField the new alignment text
     */
    public void setAlignmentText(JTextField txtField){
        txtField.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /**
     * Gets the font label.
     *
     * @return the font label
     */
    public Font getFontLabel(){
        return new Font("Segoe UI Emoji", Font.PLAIN, 35);
    }

    /**
     * Sets the font label.
     *
     * @param label the new font label
     */
    public void setFontLabel(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
    }

    /**
     * Sets the font headline.
     *
     * @param label the new font headline
     */
    public void setFontHeadline(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));

    }

    /**
     * Sets the font text.
     *
     * @param txtField the new font text
     */
    public void setFontText(JTextField txtField){
        txtField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
    }

    /**
     * Font color.
     *
     * @param label the label
     */
    public void fontColor(JLabel label){

        label.setForeground(Color.decode("#FFFAFA"));

    }
}
