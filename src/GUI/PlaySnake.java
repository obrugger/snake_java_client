package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 30-10-2015.
 */
public class PlaySnake extends JPanel {
    private JLabel lblPlaySnake;
    private JButton btnCreateGame;
    private JButton btnJoinGame;
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

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnCreateGame() {
        return btnCreateGame;
    }

    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnCreateGame.addActionListener(l);
        btnJoinGame.addActionListener(l);

    }

    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(old);
    }
}
