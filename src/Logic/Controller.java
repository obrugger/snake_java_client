package Logic;
import GUI.Frame;
import Model.Game;
import Model.Gamer;
import Model.User;
import org.omg.PortableServer.THREAD_POLICY_ID;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * The Controller class.
 * The class, in which it is determed what action to perform
 * in the application. The main class in the logic-layer.
 * Connecting the GUI with the methods and SDK.
 *
 * @author Oscar
 * @since 26-10-2015
 *
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    /** The frame. */
    private Frame frame;

    /** The currentUser */
    private User currentUser;

    /** The methods */
    private Methods methods;

    /** The gamer */
    private Gamer gamer;

    /** The game */
    private Game game;

    /**
     * Creates constructor for Controller class.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Controller() throws IOException{

        //Initialize the frame and use setVisible method, with true as parameter.
        frame = new Frame();
        frame.setVisible(true);

        /*
		Injection of action-listeners in panels.
	    The addActionListener methods takes different anonymous classes as parameters.
		 */
        frame.getMainPanel().getLogin().addActionListener(new LoginActionListener());
        frame.getMainPanel().getMenu().addActionListener(new MenuActionListener());
        frame.getMainPanel().getDeleteGame().addActionListener(new DeleteGameActionListener());
        frame.getMainPanel().getHighscore().addActionListener(new HighscoreActionListener());
        frame.getMainPanel().getJoinGame().addActionListener(new JoinGameActionListener());
        frame.getMainPanel().getPlaySnake().addActionListener(new PlaySnakeActionListener());
        frame.getMainPanel().getCreateUser().addActionListener(new CreateUserActionListener());
        frame.getMainPanel().getCreateGame().addActionListener(new CreateGameActionListener());
        frame.getMainPanel().getGameInfo().addActionListener(new GameInfoActionListener());

        //Initializes the declared variables.
        currentUser = new User();
        methods = new Methods();
        gamer = new Gamer();
        game = new Game();
    }

    /**
     * Loading.
     */
    private void loading(){

        /*
        Static object of SwingUtilities class is used to call method
        invokeLater. It takes an anonymous class as parameter, that derives from
        the Runnable class.
        The invokeLater method, adds the object into the eventQueue.
        The thread in the eventQueue will execute the run-method when
        the method is reached in the queue.
         */
        SwingUtilities.invokeLater(new Runnable() {


            //The anonymous class overrides the run-method of the interface runnable.
            @Override
            public void run() {

                try {

                    /*
                    Use show-method in CardLayout and define the contentPane as the MainPanel class,
                    and the JPanel to be showed, is the constant LOADING.
                     */
                    frame.getMainPanel().getC().show(
                            frame.getMainPanel(), frame.getMainPanel().getLOADING()
                    );
                }
                /*
                Catch-block, that catches all exceptions thrown by the try-block.
                Shows JOptionPane if any is caught, and then resets the application,
                that means to return user to the loginscreen, and resetting the currentUser.
                 */
                catch (Exception e){
                    JOptionPane.showMessageDialog(
                            frame, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE
                    );
                    frame.getMainPanel().getC().show(
                            frame.getMainPanel(), frame.getMainPanel().getLOGIN()
                    );
                    currentUser = null;
                }
            }
        });
    }


    /**
     * The listener interface for receiving loginAction events.
     * The class that is interested in processing a loginAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addLoginActionListener<code> method. When
     * the loginAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class LoginActionListener implements ActionListener {

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e) {

            /*
            If the ActionEvent performed equals the btnLogin in the Login-class, then:
             */
            if (e.getSource() == frame.getMainPanel().getLogin().getBtnLogin()) {



                /*
                Initialize new Thread object, open anonymous class.
                 */
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call the loading method.
                        loading();

                        /*
                        Sets currentUser to contain the return from userAuthentication method.
                        userAuthentication method takes frame and currentUser as parameters.
                         */
                        currentUser = methods.userAuthentication(frame, currentUser);

                        /*
                        If the userAuthentication method returns null, then:
                         */
                        if (currentUser == null) {

                            //Shows the LOGIN panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getLOGIN()
                            );
                        }
                        //If userAuthentication method does not return null, then:
                        else {

                            //Show the MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU());
                        }
                    }
                };
                //Start the thread object.
                thread.start();
            }

            //Else if actionEvent equals the btnCreate, then;
            else if(e.getSource() == frame.getMainPanel().getLogin().getBtnCreate()){


                //Show the CREATEUSER panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getCREATEUSER()
                );
            }
        }
    }

    /**
     * The listener interface for receiving createUserAction events.
     * The class that is interested in processing a createUserAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addCreateUserActionListener<code> method. When
     * the createUserAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class CreateUserActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e){

            //If btnCreate is clicked in the JPanel.
            if(e.getSource() == frame.getMainPanel().getCreateUser().getBtnCreate()) {

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call loading method.
                        loading();

                        //If createUser method returns true, then:
                        if (methods.createUser(frame, currentUser)) {

                            //Show confirmation JOptionPane.
                            JOptionPane.showMessageDialog(
                                    frame, "User created!", "Success", JOptionPane.PLAIN_MESSAGE
                            );

                            //Show the LOGIN panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getLOGIN()
                            );
                        }
                        //If createUser returns false, then show the LOGIN panel.
                        else {
                            frame.getMainPanel().getC().show(frame.getMainPanel(),
                                    frame.getMainPanel().getLOGIN());
                        }
                    }
                };

                //Start the thread object.
                thread.start();
            }

            //Else if the btnCancel on CreateUser JPanel is clicked, then:
            else if(e.getSource() == frame.getMainPanel().getCreateUser().getBtnCancel()){

                //Show the LOGIN panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getLOGIN()
                );
                //Call the clearText method, from CreateUser class.
                frame.getMainPanel().getCreateUser().clearText();
            }
        }
    }

    /**
     * The listener interface for receiving menuAction events.
     * The class that is interested in processing a menuAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addMenuActionListener<code> method. When
     * the menuAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class MenuActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(final ActionEvent e){

            //If the actionEvent equals the btnDeleteGame from the MENU, then:
            if (e.getSource() == frame.getMainPanel().getMenu().getBtnDeleteGame()){

                //Show the DELETEGAME panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getDELETEGAME()
                );

            }

            //Else, if the actionEvent equals the btnHighscores, then:
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnHighscores()) {

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call loading method.
                        loading();

                        //If highscores-method returns true, then:
                        if (methods.highscores(frame)) {

                            //Show the HIGHSCORE panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getHIGHSCORE()
                            );
                        }

                        //If highscores method returns false, then:
                        else {

                            //Show the MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                        }
                    }
                };

                //Start the thread.
                thread.start();
            }

            //Else if the actionEvent equals btnLogout, then:
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnLogout()){

                //Set User object currentUser to null.
                currentUser = null;

                //Shows the LOGIN panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getLOGIN()
                );
            }

            //Else if actionEvent equals btnPlaySnake, then:
            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnPlaySnake()){

                //Show the PLAYSNAKE panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE()
                );
            }

            else if (e.getSource() == frame.getMainPanel().getMenu().getBtnGameInfo()){

                Thread thread = new Thread() {

                    public void run() {

                        loading();

                        if (methods.showGamesByUser(frame, currentUser)) {

                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getGAMEINFO()
                            );
                        }
                        else {

                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                        }
                    }
                };
                thread.start();
            }
        }
    }

    /**
     * The listener interface for receiving highscoreAction events.
     * The class that is interested in processing a highscoreAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addHighscoreActionListener<code> method. When
     * the highscoreAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class HighscoreActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e){

            //If the actionEvent equals the btnBack, then:
            if (e.getSource() == frame.getMainPanel().getHighscore().getBtnBack()){

                //Show the MENU panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getMENU()
                );
            }
        }
    }

    /**
     * The listener interface for receiving joinGameAction events.
     * The class that is interested in processing a joinGameAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addJoinGameActionListener<code> method. When
     * the joinGameAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class  JoinGameActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e){

            //If the actionEvent equals the btnBack, then:
            if(e.getSource() == frame.getMainPanel().getJoinGame().getBtnBack()){

                //Show the PLAYSNAKE panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE()
                );

                //Call method clearGames
                frame.getMainPanel().getJoinGame().clearGames();
            }

            //Else if actionEvent equals btnJoinGame
            else if(e.getSource() == frame.getMainPanel().getJoinGame().getBtnJoinGame()){

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call loading method.
                        loading();

                        //If joinGame method returns true, then:
                        if (methods.joinGame(frame, currentUser, gamer, game)) {

                            //Show confirmation Dialog.
                            JOptionPane.showMessageDialog(frame, "Congrats, you won!", "Success!",
                                    JOptionPane.PLAIN_MESSAGE);

                            //Shows the MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                            //Call the clearGames method from JoinGame class.
                            frame.getMainPanel().getJoinGame().clearGames();

                        }
                        //If joinGame method returns false, then:
                        else {

                            //Show loss messageDialog.
                            JOptionPane.showMessageDialog(frame, "You lost!", "Failure",
                                    JOptionPane.WARNING_MESSAGE);

                            //Show the MENU panel
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );

                            //Call clearGames method from JoinGame class.
                            frame.getMainPanel().getJoinGame().clearGames();
                        }
                    }
                };

                //Start thread.
                thread.start();
            }

            //Else if the actionEvent equals the JComboBox, then:
            else if (e.getSource() == frame.getMainPanel().getJoinGame().getComboBox()) {

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Set the game equal to the one returned
                        game = methods.showGameInfo(frame);
                    }
                };
                thread.start();
            }
        }
    }


    /**
     * The listener interface for receiving playSnakeAction events.
     * The class that is interested in processing a playSnakeAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addPlaySnakeActionListener<code> method. When
     * the playSnakeAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class PlaySnakeActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e){


            //If the actionEvent is equal to btnBack, then:
            if(e.getSource() == frame.getMainPanel().getPlaySnake().getBtnBack()){

                //Show the MENU panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getMENU()
                );
            }

            //Else if the actionEvent is equal to btnJoinGame, then:
            else if(e.getSource() == frame.getMainPanel().getPlaySnake().getBtnJoinGame()){

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call loading method.
                        loading();

                        //If showOpenGames returns true, then:
                        if (methods.showOpenGames(frame)) {

                            //Show the JOINGAME panel
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getJOINGAME()
                            );

                        }

                        //If showOpenGames returns false, then:
                        else {

                            //Show error-pane
                            JOptionPane.showMessageDialog(
                                    frame, "Backend issue", "Error", JOptionPane.ERROR_MESSAGE
                            );

                            //Show the MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                        }
                    }
                };
                //Start thread.
                thread.start();
            }

            //Else if actionEvent equals btnCreateGame, then:
            else if (e.getSource() == frame.getMainPanel().getPlaySnake().getBtnCreateGame()){

                //Show the CREATEGAME panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getCREATEGAME()
                );
            }
        }
    }

    /**
     * The listener interface for receiving deleteGameAction events.
     * The class that is interested in processing a deleteGameAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addDeleteGameActionListener<code> method. When
     * the deleteGameAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class DeleteGameActionListener implements ActionListener {

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(ActionEvent e){

            //If actionEvent equals the btnBack, then:
            if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnBack()){

                //Show the MENU panel.
                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getMENU()
                );
            }

            //If actionEvent equals btnDelete, then:
            else if(e.getSource() == frame.getMainPanel().getDeleteGame().getBtnDelete()) {

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //Call loading method.
                        loading();

                        //If deleteGame returns true, then:
                        if (methods.deleteGame(currentUser, frame)) {

                            //Show confirmation dialog.
                            JOptionPane.showMessageDialog(
                                    frame, "Game was deleted!", "Success", JOptionPane.PLAIN_MESSAGE
                            );

                            //Show MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                        }
                        //If deleteGame returns false, tehn:
                        else {

                            //Show DELETEGAME panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getDELETEGAME()
                            );
                        }
                    }
                };

                //Start thread.
                thread.start();
            }
        }
    }

    /**
     * The listener interface for receiving createGameAction events.
     * The class that is interested in processing a createGameAction
     * event implements this interface, and the object created
     * with that class is registered with a component using the
     * component's <code>addCreateGameActionListener<code> method. When
     * the createGameAction event occurs, that object's appropriate
     * method is invoked.
     */
    private class CreateGameActionListener implements ActionListener{

        /**
         * Action Performed.
         *
         * @see ActionEvent
         * @param e
         */
        public void actionPerformed(final ActionEvent e) {

            //If actionEvent equals the btnCreate, then:
            if (e.getSource() == frame.getMainPanel().getCreateGame().getBtnCreate()) {

                //Ref. line 148
                Thread thread = new Thread() {

                    /**
                     * Run.
                     */
                    public void run() {

                        //If createGame returns true, then:
                        if (methods.createGame(frame, gamer, currentUser)) {

                            //Show MENU panel
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );

                            //Call clearTxt method from CreateGame class.
                            frame.getMainPanel().getCreateGame().clearTxt();
                        }

                        //If createGame returns false, then:
                        else {

                            //Show the MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );
                        }
                    }
                };

                //Start thread.
                thread.start();
            }

            //If actionEvent equals btnCancel, then:
            else if (e.getSource() == frame.getMainPanel().getCreateGame().getBtnCancel()){

                //Show PLAYSNAKE panel.
                frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getPLAYSNAKE());

                //Call method clearTxt from CreateGame class.
                frame.getMainPanel().getCreateGame().clearTxt();

            }
        }
    }

    private class GameInfoActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            if(e.getSource() == frame.getMainPanel().getGameInfo().getBtnBack()){

                frame.getMainPanel().getC().show(
                        frame.getMainPanel(), frame.getMainPanel().getMENU()
                );
                frame.getMainPanel().getGameInfo().clearGames();
            }

            else if (e.getSource() == frame.getMainPanel().getGameInfo().getComboBox()){

                Thread thread = new Thread(){

                    public void run(){



                        if (methods.showGamesByID(frame)){



                        }

                        else {

                            //Show MENU panel.
                            frame.getMainPanel().getC().show(
                                    frame.getMainPanel(), frame.getMainPanel().getMENU()
                            );


                        }


                    }
                };
                thread.start();




            }

        }

    }
}
