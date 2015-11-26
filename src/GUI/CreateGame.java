package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class CreateGame extends JPanel {

    private JLabel lblCreateGame;
    private JLabel lblEnterGamename;
    private JLabel lblEnterMapsize;
    private JLabel lblEnterControls;

    private JTextField txtGamename;
    private JTextField txtMapsize;
    private JTextField txtControls;

    private JButton btnCreate;
    private JButton btnCancel;


    public CreateGame(){

        setOpaque(false);
        setBackground(Color.BLUE);
        setLayout(null);


        lblCreateGame = new JLabel("CREATE GAME");
        lblCreateGame.setBounds(760, 200, 480, 81);
        lblCreateGame.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));
        lblCreateGame.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblCreateGame);

        lblEnterGamename = new JLabel("Enter game name");
        lblEnterGamename.setBounds(875, 395, 250, 35);
        lblEnterGamename.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblEnterGamename);

        txtGamename = new JTextField();
        txtGamename.setBounds(825, 455, 350, 60);
        add(txtGamename);
        txtGamename.setColumns(10);

        lblEnterMapsize = new JLabel("Enter map size");
        lblEnterMapsize.setBounds(905, 630, 190, 35);
        add(lblEnterMapsize);

        txtMapsize = new JTextField();
        txtMapsize.setBounds(825, 690, 350, 60);
        add(txtMapsize);

        lblEnterControls = new JLabel("Enter controls");
        lblEnterControls.setBounds(905, 865, 190, 35);
        lblEnterControls.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblEnterControls);

        txtControls = new JTextField();
        txtControls.setBounds(825, 925, 350, 60);
        add(txtControls);
        txtControls.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(425, 1100, 400, 100);
        add(btnCreate);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(1175, 1100, 400, 100);
        add(btnCancel);



    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public String getGamename(){
        return txtGamename.getText();
    }

    public int getMapsize(){
        return Integer.parseInt(txtMapsize.getText());
    }

    public String getControls(){
        return txtControls.getText();
    }

    public void addActionListener(ActionListener l) {

        btnCancel.addActionListener(l);
        btnCreate.addActionListener(l);

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
