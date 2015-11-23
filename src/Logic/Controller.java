package Logic;
import GUI.Frame;
import SDK.ServerConnection;
import Test.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    private Frame frame;

    ServerConnection sc = new ServerConnection();
    User currentUser = new User();
    Gson gson = new GsonBuilder().create();


    public Controller(){

        frame = new Frame();
        frame.setVisible(true);

        frame.getMainPanel().getLogin().addActionListener(new LoginActionListener());
        frame.getMainPanel().getMenu().addActionListener(new MenuActionListener());
        frame.getMainPanel().getDeleteGame().addActionListener(new DeleteGameActionListener());
        frame.getMainPanel().getHighscore().addActionListener(new HighscoreActionListener());
        frame.getMainPanel().getJoinGame().addActionListener(new JoinGameActionListener());
        frame.getMainPanel().getPlaySnake().addActionListener(new PlaySnakeActionListener());





    }

    private class LoginActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){



            if (e.getSource() == frame.getMainPanel().getLogin().getBtnLogin()){

                User user = new User();
                Boolean isUserAuth = false;

                String userName = frame.getMainPanel().getLogin().getUsername();
                String password = frame.getMainPanel().getLogin().getPassword();

                if(!userName.equals("") && !password.equals("")) {



                    user.setPassword(password);
                    user.setUsername(userName);


                    String json = new Gson().toJson(user);

                    sc.send(json, "login/");

                    currentUser = user;

                    System.out.println(currentUser.getCreated() + "\n");
                    System.out.println(currentUser.getEmail() + "\n");
                    System.out.println(currentUser.getFirst_name() + "\n");
                    System.out.println(currentUser.getLast_name() + "\n");
                    System.out.println(currentUser.getId() + "\n");
                    System.out.println(currentUser.getPassword() + "\n");
                    System.out.println(currentUser.getType() + "\n");
                    System.out.println(currentUser.getStatus() + "\n");
                    System.out.println(currentUser.getUsername() + "\n");


                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
                }
            }
        }
    }

    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getMainPanel().getMenu().getBtnDeleteGame()){

            }
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnHighscores()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getHIGHSCORE());

            }
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnLogout()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getLOGIN());

            }
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnPlaySnake()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE());
            }

        }
    }

    private class HighscoreActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getMainPanel().getHighscore().getBtnBack()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
            }

        }
    }

    private class  JoinGameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getJoinGame().getBtnBack()){
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
            }
            else if(e.getSource() == frame.getMainPanel().getJoinGame().getBtnJoinGame()){

            }
        }
    }

    private class PlaySnakeActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getPlaySnake().getBtnBack()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());

            }
            else if(e.getSource() == frame.getMainPanel().getPlaySnake().getBtnJoinGame()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getJOINGAME());

            }
            else if (e.getSource() == frame.getMainPanel().getPlaySnake().getBtnCreateGame()){

            }

        }
    }

    private class DeleteGameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnBack()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());

            }
            else if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnDelete()) {

            }
        }
    }
}
