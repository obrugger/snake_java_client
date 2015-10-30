package GUI;

import javax.swing.*;
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
        setLayout(null);

        lblPlaySnake = new JLabel("PLAY SNAKE");
        lblPlaySnake.setBounds(441, 126, 148, 33);
        add(lblPlaySnake);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setBounds(422, 289, 187, 41);
        add(btnCreateGame);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(422, 418, 187, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(26, 819, 171, 41);
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
}
