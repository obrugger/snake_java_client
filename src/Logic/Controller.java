package Logic;
import GUI.Frame;
import SDK.ServerConnection;
import Test.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
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

                String userName = frame.getMainPanel().getLogin().getUsername();
                String password = frame.getMainPanel().getLogin().getPassword();

                if(!userName.equals("") && !password.equals("")) {

                    User user = new User();
                    user.setPassword(password);
                    user.setUsername(userName);


                    String json = new Gson().toJson(user);

                    sc.send(json, "login/");

                    currentUser = user;

                    System.out.println("Current id is " + currentUser.getId());

                    messageParser(sc.get("users/" + currentUser.getId() + "/"));

                    System.out.println(currentUser.getFirst_name());



                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
                }
            }
        }
    }

    public void messageParser(String json){

        JSONParser jsonParser = new JSONParser();

        String message = "";

        try{

            Object obj  = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            currentUser.setEmail((String) jsonObject.get("email"));
            currentUser.setFirst_name((String) jsonObject.get("firstName"));
            currentUser.setLast_name((String) jsonObject.get("lastName"));
            currentUser.setStatus((String) jsonObject.get("status"));
           // currentUser.setType((String) jsonObject.get("type"));

        }catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
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
