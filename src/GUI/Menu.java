package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Menu extends JPanel {
    private JLabel lblMenu;
    private JButton btnPlaySnake;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogout;

    private ImageIcon image;
    private JLabel labelIamge;
    /**
     * Create the panel.
     */
    public Menu() {

        image = new ImageIcon(this.getClass().getResource("snake.png"));
        labelIamge = new JLabel(image);
        labelIamge.setBounds(0,70,300,300);
        add(labelIamge);

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);

        lblMenu = new JLabel("MENU");
        lblMenu.setBounds(405, 152, 72, 33);
        add(lblMenu);

        btnPlaySnake = new JButton("Play Snake");
        btnPlaySnake.setBounds(355, 237, 171, 41);
        add(btnPlaySnake);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setBounds(355, 346, 171, 41);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete game");
        btnDeleteGame.setBounds(350, 452, 181, 41);
        add(btnDeleteGame);

        btnLogout = new JButton("Logout");
        btnLogout.setBounds(89, 649, 171, 41);
        add(btnLogout);



    }

    public JButton getBtnPlaySnake() {
        return btnPlaySnake;
    }

    public JButton getBtnHighscores() {
        return btnHighscores;
    }

    public JButton getBtnDeleteGame() {
        return btnDeleteGame;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public void addActionListener(ActionListener l){

        btnDeleteGame.addActionListener(l);
        btnHighscores.addActionListener(l);
        btnLogout.addActionListener(l);
        btnPlaySnake.addActionListener(l);
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
