package GUI;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */



public class Frame extends JFrame {

    /** The main panel. */
    private final MainPanel mainPanel;

    /**
     * Create the frame.
     */
    public Frame() {

        /* The background. */
        Background background = new Background();
        mainPanel = new MainPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1075, 800);
        setContentPane(background);
        setTitle("Snake");
        setLocationRelativeTo(null);


        //Builds path to snake.png in GUI package
        /* The image icon. */
        ImageIcon imageIcon = new ImageIcon(this.getClass().getResource("snake.png"));

        //Uses setIconImage method to set the icon image to snake.png
        setIconImage(imageIcon.getImage());

        //background.setBorder(new EmptyBorder(0, 0, 0, 0));

        add(mainPanel);
    }

    /**
     * Gets the main panel.
     *
     * @return the main panel
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }


}

