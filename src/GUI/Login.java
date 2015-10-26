package GUI;

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

        setLayout(null);


        lblLogin = new JLabel("LOGIN");
        lblLogin.setBounds(419, 155, 78, 33);
        add(lblLogin);

        lblUsername = new JLabel("Username");
        lblUsername.setBounds(398, 290, 120, 33);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(340, 333, 236, 39);
        add(txtUsername);
        txtUsername.setColumns(10);

        lblPassword = new JLabel("Password");
        lblPassword.setBounds(398, 453, 115, 33);
        add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(340, 496, 236, 39);
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
}
