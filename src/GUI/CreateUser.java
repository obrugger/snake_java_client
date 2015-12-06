package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Oscar
 * @since 24-11-2015
 */
public class CreateUser extends JPanel {

    /** The txt username. */
    private final JTextField txtUsername;

    /** The pwd password. */
    private final JPasswordField pwdPassword;

    /** The txt firstname. */
    private final JTextField txtFirstname;

    /** The txt lastname. */
    private final JTextField txtLastname;

    /** The txt email. */
    private final JTextField txtEmail;
    
    /** The btn create. */
    private final JButton btnCreate;
    
    /** The btn cancel. */
    private final JButton btnCancel;

    /**
     * Create the panel.
     */
    public CreateUser() {

        setLayout(null);
        setOpaque(false);

        Methods methods = new Methods();


        /* The lbl create user. */
        JLabel lblCreateUser = new JLabel("CREATE USER");
        lblCreateUser.setBounds(737, 200, 525, 85);
        methods.fontColor(lblCreateUser);
        methods.setFontHeadline(lblCreateUser);
        methods.setAlignment(lblCreateUser);
        add(lblCreateUser);

        /* The lbl enter username. */
        JLabel lblEnterUsername = new JLabel("Enter username");
        lblEnterUsername.setBounds(862, 350, 275, 38);
        methods.fontColor(lblEnterUsername);
        methods.setFontLabel(lblEnterUsername);
        methods.setAlignment(lblEnterUsername);
        add(lblEnterUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(825, 410, 350, 60);
        methods.setFontText(txtUsername);
        methods.setAlignmentText(txtUsername);
        add(txtUsername);
        txtUsername.setColumns(10);

        /* The lbl enter password. */
        JLabel lblEnterPassword = new JLabel("Enter password");
        lblEnterPassword.setBounds(862, 505, 275, 38);
        methods.fontColor(lblEnterPassword);
        methods.setFontLabel(lblEnterPassword);
        methods.setAlignment(lblEnterPassword);
        add(lblEnterPassword);

        pwdPassword = new JPasswordField();
        pwdPassword.setBounds(825, 575, 350, 60);
        pwdPassword.setFont(methods.getFontLabel());
        pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
        add(pwdPassword);

        /* The lbl first name. */
        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(875, 670, 250, 35);
        methods.fontColor(lblFirstName);
        methods.setFontLabel(lblFirstName);
        methods.setAlignment(lblFirstName);
        add(lblFirstName);

        txtFirstname = new JTextField();
        txtFirstname.setBounds(825, 730, 350, 60);
        methods.setFontText(txtFirstname);
        methods.setAlignmentText(txtFirstname);
        add(txtFirstname);
        txtFirstname.setColumns(10);

        /* The lbl last name. */
        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setBounds(875, 825, 250, 35);
        methods.fontColor(lblLastName);
        methods.setFontLabel(lblLastName);
        methods.setAlignment(lblLastName);
        add(lblLastName);

        txtLastname = new JTextField();
        txtLastname.setBounds(825, 885, 350, 60);
        methods.setFontText(txtLastname);
        methods.setAlignmentText(txtLastname);
        add(txtLastname);
        txtLastname.setColumns(10);

        /* The lbl email. */
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(875, 980, 250, 35);
        methods.fontColor(lblEmail);
        methods.setFontLabel(lblEmail);
        methods.setAlignment(lblEmail);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(825, 1040, 350, 60);
        methods.setFontText(txtEmail);
        methods.setAlignmentText(txtEmail);
        add(txtEmail);
        txtEmail.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(425, 1280, 400, 100);
        btnCreate.setFont(methods.getFontLabel());
        add(btnCreate);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(1175, 1280, 400, 100);
        btnCancel.setFont(methods.getFontLabel());
        add(btnCancel);

    }

    /**
     * Gets the btn cancel.
     *
     * @return the btn cancel
     */
    public JButton getBtnCancel() {
        return btnCancel;
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
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail(){
        return txtEmail.getText();
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName(){
        return txtFirstname.getText();
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName(){
        return txtLastname.getText();
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
        char[] charPass = pwdPassword.getPassword();
        return new String(charPass);
    }

    /**
     * Clear text.
     */
    public void clearText(){
        txtEmail.setText("");
        txtFirstname.setText("");
        txtLastname.setText("");
        txtUsername.setText("");
        pwdPassword.setText("");
    }

    /**
     * Adds the action listener.
     *
     * @param l the l
     */
    public void addActionListener(ActionListener l){
        btnCancel.addActionListener(l);
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
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(old);
    }
}
