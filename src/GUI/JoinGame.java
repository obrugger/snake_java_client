package GUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
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
    private JTextField txtControls;
    private JLabel lblControls;
    private JLabel lblGameName;

    private Methods methods;
    /**
     * Create the panel.
     */
    public JoinGame() {


        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);

        methods = new Methods();

        lblJoinGame = new JLabel("JOIN GAME");
        lblJoinGame.setBounds(760, 200, 480, 81);
        methods.fontColor(lblJoinGame);
        methods.setAlignment(lblJoinGame);
        methods.setFontHeadline(lblJoinGame);
        add(lblJoinGame);

        lblSearchForGame = new JLabel("Select game to join");
        lblSearchForGame.setBounds(851, 400, 298, 38);
        methods.fontColor(lblSearchForGame);
        methods.setAlignment(lblSearchForGame);
        methods.setFontLabel(lblSearchForGame);
        add(lblSearchForGame);

        comboBox = new JComboBox();
        comboBox.setBounds(800, 500, 400, 60);
        comboBox.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        ((JLabel)comboBox.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        ((JLabel)comboBox.getRenderer()).setVerticalAlignment(JLabel.CENTER);
        add(comboBox);

        lblGameName = new JLabel();
        lblGameName.setBounds(750, 600, 500, 38);
        methods.fontColor(lblGameName);
        methods.setAlignment(lblGameName);
        methods.setFontLabel(lblGameName);
        add(lblGameName);

        lblControls = new JLabel("Enter controls");
        lblControls.setBounds(890, 725, 220, 38);
        methods.fontColor(lblControls);
        methods.setAlignment(lblControls);
        methods.setFontLabel(lblControls);
        add(lblControls);

        txtControls = new JTextField();
        txtControls.setBounds(800, 800, 400, 60);
        methods.setFontText(txtControls);
        methods.setAlignmentText(txtControls);
        add(txtControls);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(425, 1150, 400, 100);
        btnJoinGame.setFont(methods.getFontLabel());
        add(btnJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(1175, 1150, 400, 100);
        btnBack.setFont(methods.getFontLabel());
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

    public String getControls(){
        return txtControls.getText();
    }

    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnJoinGame.addActionListener(l);
        comboBox.addActionListener(l);
    }


    public JLabel getLblGameName() {
        return lblGameName;
    }

    public void clearGames(){

        comboBox.removeAllItems();
        txtControls.setText("");

    }

    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0,0, getWidth(),getHeight());
        graphics2D.setComposite(old);
    }
}
