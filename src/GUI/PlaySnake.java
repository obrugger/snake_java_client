package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 30-10-2015.
 */
public class PlaySnake extends JPanel {

    /** The btn create game. */
    private final JButton btnCreateGame;
    
    /** The btn join game. */
    private final JButton btnJoinGame;
    
    /** The btn back. */
    private final JButton btnBack;

    /**
     * Create the panel.
     */
    public PlaySnake() {

        Methods methods = new Methods();

        setLayout(null);
        setOpaque(false);

        ImageIcon image = new ImageIcon(this.getClass().getResource("snake.png"));
        JLabel labelIamge = new JLabel(image);
        labelIamge.setBounds(425, 300, 150, 150);
        add(labelIamge);

        /* The lbl play snake. */
        JLabel lblPlaySnake = new JLabel("PLAY SNAKE");
        lblPlaySnake.setBounds(387, 100, 252, 41);
        methods.fontColor(lblPlaySnake);
        methods.setFontHeadline(lblPlaySnake);
        methods.setAlignment(lblPlaySnake);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(588, 250, 200, 50);
        btnCreateGame.setFont(methods.getFontLabel());
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(213, 250, 200, 50);
        btnJoinGame.setFont(methods.getFontLabel());
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 500, 200, 50);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);
    }

    /**
     * Gets the btn join game.
     *
     * @return the btn join game
     */
    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    /**
     * Gets the btn back.
     *
     * @return the btn back
     */
    public JButton getBtnBack() {
        return btnBack;
    }

    /**
     * Gets the btn create game.
     *
     * @return the btn create game
     */
    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnCreateGame.addActionListener(l);
        btnJoinGame.addActionListener(l);

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
