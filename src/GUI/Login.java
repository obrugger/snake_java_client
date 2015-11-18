package GUI;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Login extends JPanel {


    private JLabel lblLogin;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JTextField txtPassword;
    private JButton btnLogin;

    /**
     * Create the panel.
     */
    public Login() {

        Methods methods = new Methods();
        Color fontColor = Color.decode("#FFFAFA");

        int screenWidth = methods.getScreenWidth();
        int screenHeight = methods.getScreenHeight();

        double width = 0.109375*screenWidth;
        double height = 0.033333*screenHeight;

        int txt_width = (int) width;
        int txt_height = (int) height;

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);


        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(419, 155, 150, 50);
        lblLogin.setForeground(fontColor);
        lblLogin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 42));
        add(lblLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(398, 290, 120, 33);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(340, 333, txt_width, txt_height);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 33));
        add(txtUsername);
        txtUsername.setColumns(100);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(398, 453, 115, 33);
        add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(340, 496, txt_width, txt_height);
        txtPassword.setFont(new Font("Tahoma", Font.PLAIN, 33));
        add(txtPassword);
        txtPassword.setColumns(10);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(372, 621, 171, 41);
        add(btnLogin);


    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public void addActionListener(ActionListener l){
        btnLogin.addActionListener(l);
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
