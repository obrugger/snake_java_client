package GUI;

import javax.swing.*;
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

    /**
     * Create the panel.
     */
    public Menu() {

        setLayout(null);

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
}
