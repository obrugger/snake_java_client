package GUI;

import com.sun.javafx.css.StyleableProperty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class Menu extends JPanel {
    
    /** The lbl menu. */
    private JLabel lblMenu;
    
    /** The btn play snake. */
    private JButton btnPlaySnake;
    
    /** The btn highscores. */
    private JButton btnHighscores;
    
    /** The btn delete game. */
    private JButton btnDeleteGame;
    
    /** The btn logout. */
    private JButton btnLogout;
    
    /** The lblhello user. */
    private JLabel lblhelloUser;
    
    /** The lbldate. */
    private JLabel lbldate;

    /** The image. */
    private ImageIcon image;
    
    /** The label iamge. */
    private JLabel labelIamge;
    /**
     * Create the panel.
     */
    public Menu() {

        Methods methods = new Methods();

        image = new ImageIcon(this.getClass().getResource("snake.png"));
        labelIamge = new JLabel(image);
        labelIamge.setBounds(0,70,300,300);
        add(labelIamge);

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);

        lblMenu = new JLabel("MENU");
        lblMenu.setBounds(792, 200, 415, 80);
        methods.fontColor(lblMenu);
        methods.setFontHeadline(lblMenu);
        methods.setAlignment(lblMenu);
        add(lblMenu);

        btnPlaySnake = new JButton("Play Snake");
        btnPlaySnake.setBounds(800, 425, 400, 100);
        btnPlaySnake.setFont(methods.getFontLabel());
        add(btnPlaySnake);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setBounds(800, 575, 400, 100);
        btnHighscores.setFont(methods.getFontLabel());
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete game");
        btnDeleteGame.setBounds(800, 725, 400, 100);
        btnDeleteGame.setFont(methods.getFontLabel());
        add(btnDeleteGame);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(800, 1000, 400, 100);
        btnLogout.setFont(methods.getFontLabel());
        add(btnLogout);

        lblhelloUser = new JLabel();
        lblhelloUser.setBounds(500, 90, 575, 35);
        methods.fontColor(lblhelloUser);
        methods.setFontLabel(lblhelloUser);
        add(lblhelloUser);

        DateFormat df = new SimpleDateFormat("dd/MM/yy");
        Date dateobj = new Date();

        lbldate = new JLabel(df.format(dateobj));
        lbldate.setBounds(500, 135, 575, 35);
        methods.fontColor(lbldate);
        methods.setFontLabel(lbldate);
        add(lbldate);


    }

    /**
     * Gets the btn play snake.
     *
     * @return the btn play snake
     */
    public JButton getBtnPlaySnake() {
        return btnPlaySnake;
    }

    /**
     * Gets the btn highscores.
     *
     * @return the btn highscores
     */
    public JButton getBtnHighscores() {
        return btnHighscores;
    }

    /**
     * Gets the btn delete game.
     *
     * @return the btn delete game
     */
    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    /**
     * Gets the btn logout.
     *
     * @return the btn logout
     */
    public JButton getBtnLogout() {
        return btnLogout;
    }

    /**
     * Gets the lbldate.
     *
     * @return the lbldate
     */
    public JLabel getLbldate() {
        return lbldate;
    }

    /**
     * Gets the lblhello user.
     *
     * @return the lblhello user
     */
    public JLabel getLblhelloUser() {
        return lblhelloUser;
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){

        btnDeleteGame.addActionListener(l);
        btnHighscores.addActionListener(l);
        btnLogout.addActionListener(l);
        btnPlaySnake.addActionListener(l);
    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(old);
    }
}
