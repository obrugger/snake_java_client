package GUI;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class Login extends JPanel {


    /** The lbl login. */
    private JLabel lblLogin;
    
    /** The lbl username. */
    private JLabel lblUsername;
    
    /** The txt username. */
    private JTextField txtUsername;
    
    /** The lbl password. */
    private JLabel lblPassword;
    
    /** The password field. */
    private JPasswordField passwordField;
    
    /** The btn login. */
    private JButton btnLogin;
    
    /** The btn create. */
    private JButton btnCreate;

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
        txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
        add(txtUsername);
        txtUsername.setColumns(100);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(920, 650, 155, 40);
        lblPassword.setForeground(fontColor);
        lblPassword.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(825, 710, 350, 60);
        passwordField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        add(passwordField);
        passwordField.setColumns(100);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(800, 1000, 400, 100);
        btnLogin.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(btnLogin);

        btnCreate = new JButton("Create User");
        btnCreate.setBounds(150, 1250, 400, 100);
        btnCreate.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 35));
        add(btnCreate);


    }

    /**
     * Gets the btn login.
     *
     * @return the btn login
     */
    public JButton getBtnLogin() {
        return btnLogin;
    }

    /**
     * Gets the btn create.
     *
     * @return the btn create
     */
    public JButton getBtnCreate() {
        return btnCreate;
    }

    /**
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername(){
        return txtUsername.getText();
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword(){
        char[] charPass = passwordField.getPassword();
        String password = new String(charPass);
        return password;
    }

    /**
     * Clear login.
     */
    public void clearLogin(){
        txtUsername.setText("");
        passwordField.setText("");
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){
        btnLogin.addActionListener(l);
        btnCreate.addActionListener(l);
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

    /* (non-Javadoc)
     * @see java.awt.Container#paintComponents(java.awt.Graphics)
     */
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

    /**
     * Sets the alignment.
     *
     * @param label the new alignment
     */
    public void setAlignment(JLabel label){

        label.setHorizontalAlignment(SwingConstants.LEFT);
    }

}
