package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class DeleteGame extends JPanel {
    private JLabel lblDeleteGame;
    private JLabel lblInsertGameId;
    private JTextField txtInsertgameid;
    private JButton btnDelete;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public DeleteGame() {

        setLayout(null);

        lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setBounds(406, 128, 170, 33);
        add(lblDeleteGame);

        lblInsertGameId = new JLabel("Insert Game ID ");
        lblInsertGameId.setBounds(395, 282, 191, 33);
        add(lblInsertGameId);

        txtInsertgameid = new JTextField();
        txtInsertgameid.setBounds(377, 367, 236, 39);
        add(txtInsertgameid);
        txtInsertgameid.setColumns(10);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(405, 517, 171, 41);
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(26, 774, 171, 41);
        add(btnBack);

    }

    public JTextField getTxtInsertgameid() {
        return txtInsertgameid;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public void addActionListener(ActionListener l){

        btnDelete.addActionListener(l);
        btnBack.addActionListener(l);

    }


}