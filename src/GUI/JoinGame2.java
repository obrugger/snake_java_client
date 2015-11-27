package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-11-2015.
 */
public class JoinGame2 extends JPanel {

    private JLabel lblJoinGame;
    private JLabel lblEnterControls;
    private JTextField txtControls;
    private JButton btnStartGame;
    private JButton btnBack;

    private Methods methods;

    public JoinGame2(){

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

        lblEnterControls = new JLabel("Enter controls");
        lblEnterControls.setBounds(851, 500, 298, 38);
        methods.fontColor(lblEnterControls);
        methods.setAlignment(lblEnterControls);
        methods.setFontLabel(lblEnterControls);
        add(lblEnterControls);

        txtControls = new JTextField();
        txtControls.setBounds(800, 600, 400, 60);
        methods.setFontText(txtControls);
        methods.setAlignmentText(txtControls);
        add(txtControls);
        txtControls.setColumns(10);

        btnStartGame = new JButton("Start game");
        btnStartGame.setBounds(425, 1000, 400, 100);
        btnStartGame.setFont(methods.getFontLabel());
        add(btnStartGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(1175, 1000, 400, 100);
        btnBack.setFont(methods.getFontLabel());
        add(btnBack);

    }

    public String getControls(){
        return txtControls.getText();
    }

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnStartGame() {
        return btnStartGame;
    }

    public void addActionListener(ActionListener l){

        btnBack.addActionListener(l);
        btnStartGame.addActionListener(l);
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
