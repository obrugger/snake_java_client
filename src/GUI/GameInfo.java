package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 06-12-2015.
 */
public class GameInfo extends JPanel {

    private JLabel lblHeadline;
    private JLabel lblChooseGame;
    private JComboBox comboBox;
    private JLabel lblGameName;
    private JLabel lblShowGame;
    private JLabel lblWinner;
    private JLabel lblShowWinner;
    private JButton btnBack;



    public GameInfo(){

        setLayout(null);
        setOpaque(false);
        setVisible(true);

        Methods methods = new Methods();

        lblHeadline = new JLabel("JOIN GAME");
        lblHeadline.setBounds(760, 200, 480, 81);
        methods.fontColor(lblHeadline);
        methods.setAlignment(lblHeadline);
        methods.setFontHeadline(lblHeadline);
        add(lblHeadline);

        lblChooseGame = new JLabel("Select game");
        lblChooseGame.setBounds(851, 400, 298, 38);
        methods.fontColor(lblChooseGame);
        methods.setAlignment(lblChooseGame);
        methods.setFontLabel(lblChooseGame);
        add(lblChooseGame);

        comboBox = new JComboBox();
        comboBox.setBounds(800, 500, 400, 60);
        comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)comboBox.getRenderer()).setVerticalAlignment(JLabel.CENTER);
        add(comboBox);

        lblGameName = new JLabel("Game name");
        lblGameName.setBounds(851, 650, 298, 38);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblGameName);

        lblShowGame = new JLabel();
        lblShowGame.setBounds(851, 750, 500, 60);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblShowGame);

        lblWinner = new JLabel("The winner was");
        lblWinner.setBounds(851, 800, 298, 38);
        methods.fontColor(lblWinner);
        methods.setAlignment(lblWinner);
        methods.setFontLabel(lblWinner);
        add(lblWinner);

        lblShowWinner = new JLabel();
        lblShowWinner.setBounds(851,900,500,60);
        methods.fontColor(lblShowWinner);
        methods.setAlignment(lblShowWinner);
        methods.setFontLabel(lblShowWinner);
        add(lblShowWinner);

        btnBack = new JButton("Back");
        btnBack.setBounds(800, 1250, 400, 100);
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
