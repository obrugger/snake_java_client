package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 24-11-2015.
 */
public class CreateUser extends JPanel {

    private JLabel lblCreateUser;
    private JLabel lblEnterUsername;
    private JTextField txtUsername;
    private JLabel lblEnterPassword;
    private JPasswordField pwdPassword;
    private JLabel lblFirstName;
    private JTextField txtFirstname;
    private JLabel lblLastName;
    private JTextField txtLastname;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JButton btnCreate;
    private JButton btnCancel;

    /**
     * Create the panel.
     */
    public CreateUser() {

        setLayout(null);
        setSize(2000, 1500);
        setOpaque(false);
        setBackground(Color.BLUE);

        Methods methods = new Methods();


        lblCreateUser = new JLabel("CREATE USER");
        lblCreateUser.setBounds(775, 200, 450, 85);
        methods.fontColor(lblCreateUser);
        methods.setFontHeadline(lblCreateUser);
        methods.setAlignment(lblCreateUser);
        add(lblCreateUser);

        lblEnterUsername = new JLabel("Enter username");
        lblEnterUsername.setBounds(875, 350, 250, 35);
        methods.fontColor(lblEnterUsername);
        methods.setFontLabel(lblEnterUsername);
        methods.setAlignment(lblEnterUsername);
        add(lblEnterUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(825, 410, 350, 60);
        methods.setFontText(txtUsername);
        add(txtUsername);
        txtUsername.setColumns(10);

        lblEnterPassword = new JLabel("Enter password");
        lblEnterPassword.setBounds(875, 505, 250, 35);
        methods.fontColor(lblEnterPassword);
        methods.setFontLabel(lblEnterPassword);
        methods.setAlignment(lblEnterPassword);
        add(lblEnterPassword);

        pwdPassword = new JPasswordField();
        pwdPassword.setBounds(825, 575, 350, 60);
        pwdPassword.setFont(methods.getFontLabel());
        add(pwdPassword);

        lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(875, 670, 250, 35);
        methods.fontColor(lblFirstName);
        methods.setFontLabel(lblFirstName);
        methods.setAlignment(lblFirstName);
        add(lblFirstName);

        txtFirstname = new JTextField();
        txtFirstname.setBounds(825, 730, 350, 60);
        methods.setFontText(txtFirstname);
        add(txtFirstname);
        txtFirstname.setColumns(10);

        lblLastName = new JLabel("Last name");
        lblLastName.setBounds(875, 825, 250, 35);
        methods.fontColor(lblLastName);
        methods.setFontLabel(lblLastName);
        methods.setAlignment(lblLastName);
        add(lblLastName);

        txtLastname = new JTextField();
        txtLastname.setBounds(825, 885, 350, 60);
        methods.setFontText(txtLastname);
        add(txtLastname);
        txtLastname.setColumns(10);

        lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(875, 980, 250, 35);
        methods.fontColor(lblEmail);
        methods.setFontLabel(lblEmail);
        methods.setAlignment(lblEmail);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(825, 1040, 350, 60);
        methods.setFontText(txtEmail);
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

    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public String getEmail(){
        return txtEmail.getText();
    }

    public String getFirstName(){
        return txtFirstname.getText();
    }

    public String getLastName(){
        return txtLastname.getText();
    }

    public String getUsername(){
        return txtUsername.getText();
    }

    public String getPassword(){
        char[] charPass = pwdPassword.getPassword();
        String password = new String(charPass);
        return password;
    }

    public void clearText(){
        txtEmail.setText("");
        txtFirstname.setText("");
        txtLastname.setText("");
        txtUsername.setText("");
        pwdPassword.setText("");
    }

    public void addActionListener(ActionListener l){
        btnCancel.addActionListener(l);
        btnCreate.addActionListener(l);
    }

    protected void paintComponent(Graphics graphics){

        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics.create();
        Composite old = graphics2D.getComposite();
        graphics2D.setComposite(AlphaComposite.SrcOver.derive(0.25f));
        graphics2D.fillRect(0, 0, getWidth(), getHeight());
        graphics2D.setComposite(old);
    }
}
