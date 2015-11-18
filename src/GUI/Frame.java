package GUI;

import java.awt.*;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by Oscar on 26-10-2015.
 */



public class Frame extends JFrame {

    private Background background;
    private MainPanel mainPanel;
    private ImageIcon imageIcon;

    /**
     * Create the frame.
     */
    public Frame() {

        Methods methods = new Methods();
        background = new Background();
        mainPanel = new MainPanel();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize((int) methods.getFrameWidth(), (int) methods.getFrameHeight());
        setSize(2000,1500);
        System.out.print(methods.getFrameWidth() + "\t" + methods.getFrameHeight());
        setContentPane(background);
        setTitle("Snake");
        setLocationRelativeTo(null);

        //Builds path to snake.png in GUI package
        imageIcon = new ImageIcon(this.getClass().getResource("snake.png"));

        //Uses setIconImage method to set the icon image to snake.png
        setIconImage(imageIcon.getImage());

        background.setBorder(new EmptyBorder(0, 0, 0, 0));

        add(mainPanel);


    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}

