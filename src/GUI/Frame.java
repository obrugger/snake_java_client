package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;

/**
 * Created by Oscar on 26-10-2015.
 */



public class Frame extends JFrame {

    public static final String MENU = "name_68481068440976";
    public static final String LOGIN = "name_67871361319331";
    private JPanel contentPane;
    private Login login;
    private CardLayout c;
    private Menu menu;


    /**
     * Create the frame.
     */
    public Frame() {

        contentPane = new JPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 250, 550, 350);
        setContentPane(contentPane);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout(0, 0));

        login = new Login();
        contentPane.add(login, LOGIN);

        menu = new Menu();
        contentPane.add(menu, MENU);

        setLocationRelativeTo(null);
    }

}
