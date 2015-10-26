package Logic;
import GUI.Frame;
import Test.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    private static Socket socket;
    private static PrintWriter printWriter;
    private static Scanner sc;

    private Frame frame;

    public Controller(){

        frame = new Frame();
        frame.setVisible(true);

    }

    public void run(){

       // socketMethod();

        frame.getLogin().addActionListener(new LoginActionListener());
        frame.getMenu().addActionListener(new MenuActionListener());
        frame.getHighscore().addActionListener(new HighscoreActionListener());
        frame.show(Frame.LOGIN);
    }

    public void socketMethod(){

        try {


            socket = new Socket("localhost", 45782);

            printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("Woop WOop");

            sc = new Scanner(System.in);
            printWriter.println("Input: ");
            String string = sc.next();

            printWriter.println(string + " you have written.");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    private class LoginActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){



            if (e.getSource() == frame.getLogin().getBtnLogin()){

                frame.show(Frame.MENU);
            }
        }
    }

    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getMenu().getBtnDeleteGame()){

            }
            else if (e.getSource() == frame.getMenu().getBtnHighscores()){

                frame.show(Frame.HIGHSCORE);

            }
            else if (e.getSource() == frame.getMenu().getBtnLogout()){

                frame.show(Frame.LOGIN);

            }
            else if (e.getSource() == frame.getMenu().getBtnPlaySnake()){

            }
        }
    }

    private class HighscoreActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getHighscore().getBtnBack()){
                frame.show(Frame.MENU);
            }

        }
    }

}
