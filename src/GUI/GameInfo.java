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

        setLayout(null);
        setOpaque(false);
        setVisible(true);

        Methods methods = new Methods();

        JLabel lblHeadline = new JLabel("GAME INFO");
        lblHeadline.setBounds(380, 100, 240, 41);
        methods.fontColor(lblHeadline);
        methods.setAlignment(lblHeadline);
        methods.setFontHeadline(lblHeadline);
        add(lblHeadline);

        JLabel lblChooseGame = new JLabel("Select game");
        lblChooseGame.setBounds(426, 200, 149, 19);
        methods.fontColor(lblChooseGame);
        methods.setAlignment(lblChooseGame);
        methods.setFontLabel(lblChooseGame);
        add(lblChooseGame);

        comboBox = new JComboBox();
        comboBox.setBounds(400, 250, 200, 30);
        comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 18));
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)comboBox.getRenderer()).setVerticalAlignment(JLabel.CENTER);
        add(comboBox);

        JLabel lblGameName = new JLabel("Game name");
        lblGameName.setBounds(426, 325, 149, 19);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblGameName);

        lblShowGame = new JLabel();
        lblShowGame.setBounds(426, 358, 149, 19);
        methods.fontColor(lblShowGame);
        methods.setAlignment(lblShowGame);
        methods.setFontLabel(lblShowGame);
        add(lblShowGame);

        JLabel lblWinner = new JLabel("The winner was");
        lblWinner.setBounds(426, 433, 149, 19);
        methods.fontColor(lblWinner);
        methods.setAlignment(lblWinner);
        methods.setFontLabel(lblWinner);
        add(lblWinner);

        lblShowWinner = new JLabel();
        lblShowWinner.setBounds(426, 465, 149, 19);
        methods.fontColor(lblShowWinner);
        methods.setAlignment(lblShowWinner);
        methods.setFontLabel(lblShowWinner);
        add(lblShowWinner);

        btnBack = new JButton("Back");
        btnBack.setBounds(400, 625, 200, 50);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);


    }

    public JLabel getLblShowGame() {
        return lblShowGame;
    }

    public JLabel getLblShowWinner() {
        return lblShowWinner;
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        comboBox.addActionListener(l);
    }

    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(old);
    }

    public void clearGames(){

        comboBox.removeAllItems();
    }
}
