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

        //Sets layout to absolute
        setLayout(null);

        //Sets transparency
        setOpaque(false);

        //Initialize methods object.
        Methods methods = new Methods();


        /* The lbl create user. */
        JLabel lblCreateUser = new JLabel("CREATE USER");
        lblCreateUser.setBounds(369, 100, 263, 43);
        methods.fontColor(lblCreateUser);
        methods.setFontHeadline(lblCreateUser);
        methods.setAlignment(lblCreateUser);
        add(lblCreateUser);

        /* The lbl enter username. */
        JLabel lblEnterUsername = new JLabel("Enter username");
        lblEnterUsername.setBounds(431, 175, 138, 19);
        methods.fontColor(lblEnterUsername);
        methods.setFontLabel(lblEnterUsername);
        methods.setAlignment(lblEnterUsername);
        add(lblEnterUsername);

        /* The txt username */
        txtUsername = new JTextField();
        txtUsername.setBounds(413, 205, 175, 30);
        methods.setFontText(txtUsername);
        methods.setAlignmentText(txtUsername);
        add(txtUsername);
        txtUsername.setColumns(10);

        /* The lbl enter password. */
        JLabel lblEnterPassword = new JLabel("Enter password");
        lblEnterPassword.setBounds(431, 253, 138, 19);
        methods.fontColor(lblEnterPassword);
        methods.setFontLabel(lblEnterPassword);
        methods.setAlignment(lblEnterPassword);
        add(lblEnterPassword);

        /* The passwordfield */
        pwdPassword = new JPasswordField();
        pwdPassword.setBounds(413, 288, 175, 30);
        pwdPassword.setFont(methods.getFontLabel());
        pwdPassword.setHorizontalAlignment(SwingConstants.CENTER);
        add(pwdPassword);

        /* The lbl first name. */
        JLabel lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(438, 335, 125, 28);
        methods.fontColor(lblFirstName);
        methods.setFontLabel(lblFirstName);
        methods.setAlignment(lblFirstName);
        add(lblFirstName);

        /* The txt firstname */
        txtFirstname = new JTextField();
        txtFirstname.setBounds(413, 365, 175, 30);
        methods.setFontText(txtFirstname);
        methods.setAlignmentText(txtFirstname);
        add(txtFirstname);
        txtFirstname.setColumns(10);

        /* The lbl last name. */
        JLabel lblLastName = new JLabel("Last name");
        lblLastName.setBounds(438, 413, 125, 18);
        methods.fontColor(lblLastName);
        methods.setFontLabel(lblLastName);
        methods.setAlignment(lblLastName);
        add(lblLastName);

        /* The txt lastname */
        txtLastname = new JTextField();
        txtLastname.setBounds(413, 443, 175, 30);
        methods.setFontText(txtLastname);
        methods.setAlignmentText(txtLastname);
        add(txtLastname);
        txtLastname.setColumns(10);

        /* The lbl email. */
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(438, 490, 175, 18);
        methods.fontColor(lblEmail);
        methods.setFontLabel(lblEmail);
        methods.setAlignment(lblEmail);
        add(lblEmail);

        /* The txt email */
        txtEmail = new JTextField();
        txtEmail.setBounds(413, 520, 175, 30);
        methods.setFontText(txtEmail);
        methods.setAlignmentText(txtEmail);
        add(txtEmail);

        /* The btn create*/
        btnCreate = new JButton("Create");
        btnCreate.setBounds(213, 640, 200, 50);
        btnCreate.setFont(methods.getFontLabel());
        add(btnCreate);

        /* The btn cancel */
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(588, 640, 200, 50);
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

        //Reads the password input, from passwordfield into a char array
        char[] charPass = pwdPassword.getPassword();

        //Returns the char array as a string
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
