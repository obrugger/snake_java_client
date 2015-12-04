package GUI;

import Logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class DeleteGame extends JPanel {
    
    /** The lbl delete game. */
    private JLabel lblDeleteGame;
    
    /** The lbl insert game id. */
    private JLabel lblInsertGameId;
    
    /** The txt insertgameid. */
    private JTextField txtInsertgameid;
    
    /** The btn delete. */
    private JButton btnDelete;
    
    /** The btn back. */
    private JButton btnBack;
    
    /** The methods. */
    private Methods methods;

    /**
     * Create the panel.
     */
    public DeleteGame() {

        methods = new Methods();

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);

        lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setBounds(775, 200, 466, 81);
        methods.fontColor(lblDeleteGame);
        methods.setFontHeadline(lblDeleteGame);
        methods.setAlignment(lblDeleteGame);
        add(lblDeleteGame);

        lblInsertGameId = new JLabel("Insert Game ID ");
        lblInsertGameId.setBounds(875, 450, 250, 35);
        methods.fontColor(lblInsertGameId);
        methods.setFontLabel(lblInsertGameId);
        methods.setAlignment(lblInsertGameId);
        add(lblInsertGameId);

        txtInsertgameid = new JTextField();
        txtInsertgameid.setBounds(825, 590, 350, 60);
        methods.setFontText(txtInsertgameid);
        methods.setAlignmentText(txtInsertgameid);
        add(txtInsertgameid);
        txtInsertgameid.setColumns(10);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(1175, 1000, 400, 100);
        btnDelete.setFont(methods.getFontLabel());
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(425, 1000, 400, 100);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);

    }

    /**
     * Gets the game id.
     *
     * @return the game id
     */
    public int getGameId(){

        return Integer.parseInt(txtInsertgameid.getText());
    }

    /**
     * Gets the btn delete.
     *
     * @return the btn delete
     */
    public JButton getBtnDelete() {
        return btnDelete;
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
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){

        btnDelete.addActionListener(l);
        btnBack.addActionListener(l);

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
