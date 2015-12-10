package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class JoinGame extends JPanel {

    /** The combo box. */
    private final JComboBox comboBox;
    
    /** The btn join game. */
    private final JButton btnJoinGame;
    
    /** The btn back. */
    private final JButton btnBack;
    
    /** The txt controls. */
    private final JTextField txtControls;

    /** The lbl game name. */
    private final JLabel lblGameName;

    /**
     * Create the panel.
     */
    public JoinGame() {

        Methods methods = new Methods();

        setLayout(null);
        setOpaque(false);

        /* The lbl join game. */
        JLabel lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setBounds(380, 100, 240, 41);
        methods.fontColor(lblJoinGame);
        methods.setAlignment(lblJoinGame);
        methods.setFontHeadline(lblJoinGame);
        add(lblJoinGame);

        /* The lbl search for game. */
        JLabel lblSearchForGame = new JLabel("Select game to join");
        lblSearchForGame.setBounds(413, 200, 175, 19);
        methods.fontColor(lblSearchForGame);
        methods.setAlignment(lblSearchForGame);
        methods.setFontLabel(lblSearchForGame);
        add(lblSearchForGame);

        comboBox = new JComboBox();
        comboBox.setBounds(400, 250, 200, 30);
        comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)comboBox.getRenderer()).setVerticalAlignment(JLabel.CENTER);
        add(comboBox);

        lblGameName = new JLabel();
        lblGameName.setBounds(375, 300, 250, 19);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblGameName);

        /* The lbl controls. */
        JLabel lblControls = new JLabel("Enter controls");
        lblControls.setBounds(413, 363, 175, 19);
        methods.fontColor(lblControls);
        methods.setAlignment(lblControls);
        methods.setFontLabel(lblControls);
        add(lblControls);

        txtControls = new JTextField();
        txtControls.setBounds(400, 400, 200, 30);
        methods.setFontText(txtControls);
        methods.setAlignmentText(txtControls);
        add(txtControls);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(213, 575, 200, 50);
        btnJoinGame.setFont(methods.getFontLabel());
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(588, 575, 200, 50);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);

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
     * Gets the btn join game.
     *
     * @return the btn join game
     */
    public JButton getBtnJoinGame() {
        return btnJoinGame;
    }

    /**
     * Gets the combo box.
     *
     * @return the combo box
     */
    public JComboBox getComboBox() {
        return comboBox;
    }

    /**
     * Gets the controls.
     *
     * @return the controls
     */
    public String getControls(){
        return txtControls.getText();
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnJoinGame.addActionListener(l);
        comboBox.addActionListener(l);
    }


    /**
     * Gets the lbl game name.
     *
     * @return the lbl game name
     */
    public JLabel getLblGameName() {
        return lblGameName;
    }

    /**
     * Clear games.
     */
    public void clearGames(){

        comboBox.removeAllItems();
        txtControls.setText("");

    }

    /* (non-Javadoc)
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0,0, getWidth(),getHeight());
        graphics2D.setComposite(old);
    }
}
