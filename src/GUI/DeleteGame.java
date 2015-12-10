package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class DeleteGame extends JPanel {

    /** The txt insertgameid. */
    private final JTextField txtInsertgameid;
    
    /** The btn delete. */
    private final JButton btnDelete;
    
    /** The btn back. */
    private final JButton btnBack;

    /**
     * Create the panel.
     */
    public DeleteGame() {

        Methods methods = new Methods();

        setLayout(null);
        setOpaque(false);

        /* The lbl delete game. */
        JLabel lblDeleteGame = new JLabel("DELETE GAME");
        lblDeleteGame.setBounds(369, 100, 263, 43);
        methods.fontColor(lblDeleteGame);
        methods.setFontHeadline(lblDeleteGame);
        methods.setAlignment(lblDeleteGame);
        add(lblDeleteGame);

        /* The lbl insert game id. */
        JLabel lblInsertGameId = new JLabel("Insert Game ID ");
        lblInsertGameId.setBounds(431, 275, 138, 19);
        methods.fontColor(lblInsertGameId);
        methods.setFontLabel(lblInsertGameId);
        methods.setAlignment(lblInsertGameId);
        add(lblInsertGameId);

        txtInsertgameid = new JTextField();
        txtInsertgameid.setBounds(413, 295, 175, 30);
        methods.setFontText(txtInsertgameid);
        methods.setAlignmentText(txtInsertgameid);
        add(txtInsertgameid);
        txtInsertgameid.setColumns(10);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(588, 500, 200, 50);
        btnDelete.setFont(methods.getFontLabel());
        add(btnDelete);

        btnBack = new JButton("Back");
        btnBack.setBounds(213, 500, 200, 50);
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
