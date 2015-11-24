package Logic;
import GUI.Frame;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    private Frame frame;

    ServerConnection sc = new ServerConnection();
    User currentUser = new User();
    Gson gson = new GsonBuilder().create();
    Methods methods;


    public Controller(){

        frame = new Frame();
        frame.setVisible(true);

        frame.getMainPanel().getLogin().addActionListener(new LoginActionListener());
        frame.getMainPanel().getMenu().addActionListener(new MenuActionListener());
        frame.getMainPanel().getDeleteGame().addActionListener(new DeleteGameActionListener());
        frame.getMainPanel().getHighscore().addActionListener(new HighscoreActionListener());
        frame.getMainPanel().getJoinGame().addActionListener(new JoinGameActionListener());
        frame.getMainPanel().getPlaySnake().addActionListener(new PlaySnakeActionListener());
        frame.getMainPanel().getCreateUser().addActionListener(new CreateUserActionListener());


        methods = new Methods();


    }

    private class LoginActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){



            if (e.getSource() == frame.getMainPanel().getLogin().getBtnLogin()){

                if (methods.userAuthentication(currentUser, frame)) {

                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());

                }
            }
            else if(e.getSource() == frame.getMainPanel().getLogin().getBtnCreate()){
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getCREATEUSER());
            }
        }
    }


    private class CreateUserActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getCreateUser().getBtnCreate()){

            }

            else if(e.getSource() == frame.getMainPanel().getCreateUser().getBtnCancel()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getLOGIN());

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
/*
    public boolean userAuthentication() {

        try {

            String userName = frame.getMainPanel().getLogin().getUsername();
            String password = frame.getMainPanel().getLogin().getPassword();

            if (!userName.equals("") && !password.equals("")) {

                User user = new User();
                user.setPassword(password);
                user.setUsername(userName);

                String json = new Gson().toJson(user);

                sc.send(json, "login/");

                currentUser = user;

                System.out.println("Current id is " + currentUser.getId());
                //parser(sc.get("users/" + currentUser.getId() + "/"));
                sc.parser(sc.get("users/" + currentUser.getId() + "/"), currentUser);

                System.out.print(currentUser.getFirst_name());

                return true;
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Recheck spelling", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }*/

}
