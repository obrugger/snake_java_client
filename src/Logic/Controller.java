package Logic;
import GUI.Frame;
import Model.Gamer;
import Model.User;
import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    private Frame frame;

    User currentUser = new User();
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
        frame.getMainPanel().getCreateGame().addActionListener(new CreateGameActionListener());


        methods = new Methods();


    }

    private class LoginActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){



            if (e.getSource() == frame.getMainPanel().getLogin().getBtnLogin()){

                if (userAuthentication()) {

                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
                    System.out.println(currentUser.getId());


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

                if(methods.createUser(frame, currentUser)){

                    JOptionPane.showMessageDialog(frame, "User created!", "Success", JOptionPane.PLAIN_MESSAGE);

                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getLOGIN());
                }
            }

            else if(e.getSource() == frame.getMainPanel().getCreateUser().getBtnCancel()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getLOGIN());
                frame.getMainPanel().getCreateUser().clearText();

            }
        }
    }

    private class MenuActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if (e.getSource() == frame.getMainPanel().getMenu().getBtnDeleteGame()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getDELETEGAME());

            }
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnHighscores()){

                methods.highscores(frame);
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getHIGHSCORE());

            }
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnLogout()){


                userAuthentication() = false;
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
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE());
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


                methods.getOpenGames(frame);
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getJOINGAME());

            }
            else if (e.getSource() == frame.getMainPanel().getPlaySnake().getBtnCreateGame()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getCREATEGAME());

            }

        }
    }

    private class DeleteGameActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnBack()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());

            }
            else if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnDelete()) {

                if (methods.deleteGame(currentUser, frame)){

                    JOptionPane.showMessageDialog(frame, "Game was deleted!",
                            "Success", JOptionPane.ERROR_MESSAGE);

                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());

                }
                else {
                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getDELETEGAME());
                }
            }
        }
    }
    private class CreateGameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == frame.getMainPanel().getCreateGame().getBtnCreate()) {

                Gamer gamer = new Gamer();
                //Gamer gamer = (Gamer) currentUser;

                if (methods.createGame(frame, gamer, currentUser)){
                    System.out.println("Fungerer hele vejen igennem");
                    frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
                }



            }
            else if (e.getSource() == frame.getMainPanel().getCreateGame().getBtnCancel()){

                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE());

            }
        }
    }

    public boolean userAuthentication(){

        try{

            String username = frame.getMainPanel().getLogin().getUsername();
            String password = frame.getMainPanel().getLogin().getPassword();

            if(!username.equals("") && !password.equals("")) {

                User user = new User();
                user.setPassword(password);
                user.setUsername(username);

                String json = new Gson().toJson(user);

                String msg = methods.loginParser(methods.getSc().send(json, "login/", frame), user);

                if(msg.equals("Login successful")){


                    currentUser = user;

                    methods.getSc().parser(methods.getSc()
                            .get("users/" + currentUser.getId() + "/"), currentUser);

                    frame.getMainPanel().getMenu().getLblhelloUser().
                            setText("Hello " + currentUser.getFirst_name() + "!");

                    frame.getMainPanel().getLogin().clearLogin();

                    return true;
                }
                else if(msg.equals("Wrong username or password")){
                    JOptionPane.showMessageDialog(frame, "Wrong username or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (msg.equals("Error in JSON")){
                    JOptionPane.showMessageDialog(frame, "Backend issue",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }
}
