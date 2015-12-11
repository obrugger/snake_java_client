package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 06-12-2015.
 */
public class GameInfo extends JPanel {

    private final JComboBox comboBox;
    private final JLabel lblShowGame;
    private final JLabel lblShowWinner;
    private final JButton btnBack;



    public GameInfo(){

        //Sets layout to absolute
        setLayout(null);

        //sets transparency
        setOpaque(false);

        //Initializes new methods object
        Methods methods = new Methods();

        /* The lbl headline */
        JLabel lblHeadline = new JLabel("GAME INFO");
        lblHeadline.setBounds(380, 100, 240, 41);
        methods.fontColor(lblHeadline);
        methods.setAlignment(lblHeadline);
        methods.setFontHeadline(lblHeadline);
        add(lblHeadline);

        /* The lbl choose game*/
        JLabel lblChooseGame = new JLabel("Select game");
        lblChooseGame.setBounds(426, 200, 149, 19);
        methods.fontColor(lblChooseGame);
        methods.setAlignment(lblChooseGame);
        methods.setFontLabel(lblChooseGame);
        add(lblChooseGame);

        /* The combobox */
        comboBox = new JComboBox();
        comboBox.setBounds(400, 250, 200, 30);
        comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)comboBox.getRenderer()).setVerticalAlignment(JLabel.CENTER);
        add(comboBox);

        /* The lbl game name*/
        JLabel lblGameName = new JLabel("Game name");
        lblGameName.setBounds(426, 325, 149, 19);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblGameName);

        /* The lbl show game*/
        lblShowGame = new JLabel();
        lblShowGame.setBounds(426, 358, 149, 19);
        methods.fontColor(lblShowGame);
        methods.setAlignment(lblShowGame);
        methods.setFontLabel(lblShowGame);
        add(lblShowGame);

        /* The lbl winner*/
        JLabel lblWinner = new JLabel("The winner was");
        lblWinner.setBounds(426, 433, 149, 19);
        methods.fontColor(lblWinner);
        methods.setAlignment(lblWinner);
        methods.setFontLabel(lblWinner);
        add(lblWinner);

        /* The lbl show winner*/
        lblShowWinner = new JLabel();
        lblShowWinner.setBounds(426, 465, 149, 19);
        methods.fontColor(lblShowWinner);
        methods.setAlignment(lblShowWinner);
        methods.setFontLabel(lblShowWinner);
        add(lblShowWinner);

        /* The btn back*/
        btnBack = new JButton("Back");
        btnBack.setBounds(400, 625, 200, 50);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);


    }

    /**
     * Get Lbl show game
     *
     * @return the lbl show game.
     */
    public JLabel getLblShowGame() {
        return lblShowGame;
    }

    /**
     * Get Show winner label.
     *
     * @return the lblShowWinner
     */
    public JLabel getLblShowWinner() {
        return lblShowWinner;
    }


    /**
     * Get btn back
     *
     * @return btnBack
     */
    public JButton getBtnBack() {
        return btnBack;
    }

    /**
     * Get the comboBox
     *
     * @return comboBox
     */
    public JComboBox getComboBox() {
        return comboBox;
    }

    /**
     * Adds actionlisteners
     *
     * @param l
     */
    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        comboBox.addActionListener(l);
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

    /**
     * Clear the games.
     */
    public void clearGames(){

        //Removes all items loaded into the combobox
        comboBox.removeAllItems();
    }
}
