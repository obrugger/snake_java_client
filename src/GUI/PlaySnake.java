package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 30-10-2015.
 */
public class PlaySnake extends JPanel {
    
    /** The lbl play snake. */
    private JLabel lblPlaySnake;
    
    /** The btn create game. */
    private JButton btnCreateGame;
    
    /** The btn join game. */
    private JButton btnJoinGame;
    
    /** The btn back. */
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public PlaySnake() {

        Methods methods = new Methods();
        Color fontColor = Color.decode("#FFFAFA");

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);

        lblPlaySnake = new JLabel("PLAY SNAKE");
        lblPlaySnake.setBounds(792, 200, 415, 80);
        lblPlaySnake.setForeground(fontColor);
        lblPlaySnake.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));
        methods.setAlignment(lblPlaySnake);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(1175, 500, 400, 100);
        btnCreateGame.setFont(methods.getFontLabel());
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(425, 500, 400, 100);
        btnJoinGame.setFont(methods.getFontLabel());
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(800, 1000, 400, 100);
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
