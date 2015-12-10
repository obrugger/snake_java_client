package GUI;

import java.awt.*;
import java.awt.event.ActionListener;


import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class Login extends JPanel {


    /** The txt username. */
    private final JTextField txtUsername;

    /** The password field. */
    private final JPasswordField passwordField;
    
    /** The btn login. */
    private final JButton btnLogin;
    
    /** The btn create. */
    private final JButton btnCreate;

    /**
     * Create the panel.
     */
    public Login() {

        Methods methods = new Methods();

        setLayout(null);
        setOpaque(false);

        /* The lbl login. */
        JLabel lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(396, 100, 208, 40);
        methods.fontColor(lblLogin);
        methods.setFontHeadline(lblLogin);
        methods.setAlignment(lblLogin);
        add(lblLogin);

        /* The lbl username. */
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(413, 215, 175, 18);
        methods.fontColor(lblUsername);
        methods.setAlignment(lblUsername);
        methods.setFontLabel(lblUsername);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(413, 245, 175, 30);
        methods.setAlignmentText(txtUsername);
        methods.setFontText(txtUsername);
        add(txtUsername);

        /* The lbl password. */
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(413, 325, 175, 18);
        methods.setAlignment(lblPassword);
        methods.setFontLabel(lblPassword);
        methods.fontColor(lblPassword);
        add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setBounds(413, 355, 175, 30);
        passwordField.setFont(new Font("Segoe UI Emoji", Font.BOLD, 15));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setBounds(400, 500, 200, 50);
        btnLogin.setFont(methods.getFontLabel());
        add(btnLogin);

        btnCreate = new JButton("Create User");
        btnCreate.setBounds(75, 625, 200, 50);
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
        return new String(charPass);
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
