package GUI;

import javax.swing.*;
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

    public void setAlignment(JLabel label){
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }



    public Font getFontLabel(){
        return new Font("Segoe UI Emoji", Font.PLAIN, 35);
    }

    public void setFontLabel(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
    }

    public void setFontHeadline(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));

    }

    public void setFontText(JTextField txtField){
        txtField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
    }

    public void fontColor(JLabel label){

        label.setForeground(Color.decode("#FFFAFA"));

    }
}
