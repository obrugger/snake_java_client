package GUI;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import javax.swing.*;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Login extends JPanel {


    private JLabel lblLogin;
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField passwordField;
    private JButton btnLogin;

    /**
     * Create the panel.
     */
    public Login() {

        Methods methods = new Methods();
        Color fontColor = Color.decode("#FFFAFA");
        Color textColor = Color.decode("#A9A9A9");

        int screenWidth = methods.getScreenWidth();
        int screenHeight = methods.getScreenHeight();

        double width = 0.109375*screenWidth;
        double height = 0.033333*screenHeight;

        int txt_width = (int) width;
        int txt_height = (int) height;

        System.out.println(txt_width + "\n" + txt_height);

        setLayout(null);
        setOpaque(false);
        setBackground(Color.BLUE);


        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(792, 200, 415, 80);
        lblLogin.setForeground(fontColor);
        lblLogin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));
        methods.setAlignment(lblLogin);
        add(lblLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(920, 430, 155, 40);
        lblUsername.setForeground(fontColor);
        lblUsername.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(825, 490, 350, 60);
        txtUsername.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        add(txtUsername);
        txtUsername.setForeground(textColor);
        txtUsername.setColumns(100);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(920, 650, 155, 40);
        lblPassword.setForeground(fontColor);
        lblPassword.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(825, 710, 350, 60);
        passwordField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        passwordField.setForeground(textColor);
        add(passwordField);
        passwordField.setColumns(100);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(800, 1000, 400, 100);
        btnLogin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(btnLogin);


    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getBtnLogin() {
        return btnLogin;
    }

    public String getUsername(){
        return txtUsername.getText();
    }

    public String getPassword(){
        char[] charPass = passwordField.getPassword();
        String password = new String(charPass);
        return password;
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

    public void paintComponents (Graphics g){
        super.paintComponents(g);

        int w = getSize().width;
        int h = getSize().height;

        Graphics2D g2d = (Graphics2D) g;
        FontRenderContext fontRenderContext = g2d.getFontRenderContext();
        Font font = new Font("Segoe UI Emoji", Font.PLAIN, 35);
        String st = "HELLO WORLD";

        TextLayout tl = new TextLayout(st,font,fontRenderContext);
        Shape outline = tl.getOutline(null);


    }

    public void setAlignment(JLabel label){

        label.setHorizontalAlignment(SwingConstants.LEFT);
    }

}
