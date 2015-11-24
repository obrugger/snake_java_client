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
        setSize(2000,1500);
        setOpaque(false);
        setBackground(Color.BLUE);

        Methods methods = new Methods();
        Color fontColor = Color.decode("#FFFAFA");


        lblCreateUser = new JLabel("CREATE USER");
        lblCreateUser.setBounds(775, 200, 450, 85);
        lblCreateUser.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 75));
        methods.setAlignment(lblCreateUser);
        add(lblCreateUser);

        lblEnterUsername = new JLabel("Enter username");
        lblEnterUsername.setBounds(905, 350, 190, 35);
        add(lblEnterUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(825, 410, 350, 60);
        add(txtUsername);
        txtUsername.setColumns(10);

        lblEnterPassword = new JLabel("Enter password");
        lblEnterPassword.setBounds(905, 505, 190, 35);
        add(lblEnterPassword);

        pwdPassword = new JPasswordField();
        pwdPassword.setBounds(825, 575, 350, 60);
        add(pwdPassword);

        lblFirstName = new JLabel("First name");
        lblFirstName.setBounds(905, 670, 190, 35);
        lblFirstName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblFirstName);

        txtFirstname = new JTextField();
        txtFirstname.setBounds(825, 730, 350, 60);
        add(txtFirstname);
        txtFirstname.setColumns(10);

        lblLastName = new JLabel("Last name");
        lblLastName.setBounds(905, 825, 190, 35);
        lblLastName.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblLastName);

        txtLastname = new JTextField();
        txtLastname.setBounds(825, 885, 350, 60);
        add(txtLastname);
        txtLastname.setColumns(10);

        lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(905, 980, 190, 35);
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(825, 1040, 350, 60);
        add(txtEmail);
        txtEmail.setColumns(10);

        btnCreate = new JButton("Create");
        btnCreate.setBounds(425, 1280, 400, 100);
        add(btnCreate);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(1175, 1280, 400, 100);
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
