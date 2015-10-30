package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class JoinGame extends JPanel {
    private JLabel lblJoinGame;
    private JLabel lblSearchForGame;
    private JComboBox comboBox;
    private JButton btnJoinGame;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public JoinGame() {


        setLayout(null);

        lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setBounds(529, 79, 136, 33);
        add(lblJoinGame);

        lblSearchForGame = new JLabel("Search for game");
        lblSearchForGame.setBounds(499, 252, 196, 33);
        add(lblSearchForGame);

        comboBox = new JComboBox();
        comboBox.setBounds(471, 313, 252, 39);
        add(comboBox);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(511, 479, 171, 41);
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(26, 773, 171, 41);
        add(btnBack);

    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

    public void clearGames(){

        comboBox.removeAllItems();

    }
}
