package GUI;

import java.awt.*;
import java.awt.event.ActionListener;


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

        setLayout(null);
        setOpaque(false);

        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(792, 200, 415, 80);
        methods.fontColor(lblLogin);
        methods.setFontHeadline(lblLogin);
        methods.setAlignment(lblLogin);
        add(lblLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(825, 430, 350, 35);
        methods.fontColor(lblUsername);
        methods.setAlignment(lblUsername);
        methods.setFontLabel(lblUsername);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(825, 490, 350, 60);
        methods.setAlignmentText(txtUsername);
        methods.setFontText(txtUsername);
        add(txtUsername);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(825, 650, 350, 35);
        methods.setAlignment(lblPassword);
        methods.setFontLabel(lblPassword);
        methods.fontColor(lblPassword);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(825, 710, 350, 60);
        passwordField.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(800, 1000, 400, 100);
        btnLogin.setFont(methods.getFontLabel());
        add(btnLogin);

        btnCreate = new JButton("Create User");
        btnCreate.setBounds(150, 1250, 400, 100);
        btnCreate.setFont(methods.getFontLabel());
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

        /*
        Instantiates an array of chars, with the getPassword method
        from the passwordField object.
         */
        char[] charPass = passwordField.getPassword();

        /*
        Initializes String object with the Array of chars, that
        contain the password.
         */
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
}
