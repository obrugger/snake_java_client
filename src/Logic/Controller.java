package Logic;
import GUI.Frame;
import Model.Gamer;
import Model.User;

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

                if(methods.createUser(frame,currentUser)){

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
}
