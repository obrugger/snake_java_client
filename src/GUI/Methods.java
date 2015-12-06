package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oscar on 27-10-2015.
 */
public class Methods extends JPanel{
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
        return new Font("Segoe UI Emoji", Font.BOLD, 35);
    }

    /**
     * Sets the font label.
     *
     * @param label the new font label
     */
    public void setFontLabel(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.BOLD, 35));
    }

    /**
     * Sets the font headline.
     *
     * @param label the new font headline
     */
    public void setFontHeadline(JLabel label){

        label.setFont(new Font("Segoe UI Emoji", Font.BOLD, 75));

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
