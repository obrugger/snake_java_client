package Logic;

import GUI.Frame;
import Model.*;
import SDK.JSONParsers;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.IOException;

/**
 * The Methods class.
 * Contains the methods, which is used in the controller.
 * Its methods are only called from the Controller class,
 * while it only uses the JSONParsers object.
 *
 * @author Oscar
 * @since 23-11-2015
 *
 * Created by Oscar on 23-11-2015.
 */
public class Methods {

    /** The JSONParsers variable. */
    private JSONParsers jp;


    /**
     * Creates the Methods constructor.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public Methods() throws IOException{

        //Initializes the jp variable.
        jp = new JSONParsers();

    }

    /**
     * User authentication.
     *
     * @param frame
     * @param currentUser
     * @return the currentUser.
     */
    public User userAuthentication(Frame frame, User currentUser){

        try{

            /*
            Instantiates objects of type String in which the text
            from the two JTextFields are stored.
             */
            String username = frame.getMainPanel().getLogin().getUsername();
            String password = frame.getMainPanel().getLogin().getPassword();

            //If neither of the textfields are empty, then:
            if(!username.equals(null) && !password.equals(null)) {

                //Initializes a object of User.
                User user = new User();

                /*
                Sets the password and username in user-object,
                to be equal to the username and password stored in
                the two String objects.
                 */
                user.setPassword(password);
                user.setUsername(username);

                /*
                Initializes a String object, named json.
                It contains an object of Gson, where it parses the user
                object, into JSON.
                 */
                String json = new Gson().toJson(user);

                /*
                Instantiates a String object, msg, in which the global jp-object is
                called, and uses its loginParser method, that takes the post-method from
                ServerConnection as its parameter.
                The post-method takes the parameters:
                  - json, which contains the JSON, in which the server communicates.
                  - The String login/, which defines the path, in which the login
                    function lies on the server.
                  - frame, which is a parameter.
                The loginParser method also takes the user-object as a parameter.
                 */
                String msg = jp.loginParser(jp.getSc().post(json, "login/", frame), user);

                /*
                If the msg object contains the String equal to "Login successful", then:
                 */
                if(msg.equals("Login successful")){

                    //Sets the currentUser parameter, to be identical to the user-object.
                    currentUser = user;

                    /*
                    Calls the jp-object, and uses its parser-method. It takes the ServerConnection
                    get-method as its parameter. The get method takes the path as a parameter.
                    It is defined by a String, users/, and then gets the specifik id, from the
                    currentUser. The parser method, also takes the currentUser object, as a
                    parameter.
                     */
                    jp.parser(jp.getSc().get("users/" + currentUser.getId() + "/"), currentUser);

                    /*
                    Uses the frame-parameter, to set the text in the JLabel.
                    The setText-method takes a parameter which is a String.
                    It is a welcoming message, which gets the currentUser's firstName.
                     */
                    frame.getMainPanel().getMenu().getLblhelloUser().
                            setText("Hello " + currentUser.getFirst_name() + "!");

                    //Uses the clearLogin method from the Login-class.
                    frame.getMainPanel().getLogin().clearLogin();

                    //Returns the currentUser object.
                    return currentUser;
                }


                /*
                If the message on the other hand equals to the String "Wrong username or
                password" or the String equals to "Error in JSON", then:
                 */
                else if(msg.equals("Wrong username or password") ||
                        msg.equals("Error in JSON")){

                    /*
                    Shows a messageDialog in the Frame, informing the user
                    of any errors in the application.
                     */
                    JOptionPane.showMessageDialog(frame, "Wrong username or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //Catches every exception thrown by the try-block.
        catch (Exception e){

            //Ref. line 132.
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        //Returns null if exception is caught.
        return null;
    }

    /**
     * Creates the user.
     *
     * @param frame
     * @param currentUser
     * @return true, if successful
     */
    public boolean createUser(Frame frame, User currentUser){

        try {

            //Ref. line 51-53
            String username = frame.getMainPanel().getCreateUser().getUsername();
            String password = frame.getMainPanel().getCreateUser().getPassword();
            String firstname = frame.getMainPanel().getCreateUser().getFirstName();
            String lastname = frame.getMainPanel().getCreateUser().getLastName();
            String email = frame.getMainPanel().getCreateUser().getEmail();

            //Instantiates type object of type integer, to be equal to 1.
            int type = 1;



            //Ref. line 58
            if(!username.equals("")&& !password.equals("") && !firstname.equals("")
                    && !lastname.equals("") && !email.equals("")){

                //Initializes a User objects.
                User user = new User();

                //Sets every variable in the user.
                user.setType(type);
                user.setStatus("active");
                user.setPassword(password);
                user.setUsername(username);
                user.setFirst_name(firstname);
                user.setLast_name(lastname);
                user.setEmail(email);

                //Ref. line 73.
                String json = new Gson().toJson(user);

                //Ref. line 80-88
                String msg = jp.messageParser(jp.getSc().post(json, "users/", frame));

                //Ref. line 93
                if (msg.equals("User was created")){

                    //Ref. line 97.
                    currentUser = user;

                    //Use clearText method from CreateUser-class.
                    frame.getMainPanel().getCreateUser().clearText();

                    //Returns true.
                    return true;
                }

                //Ref. line 126
                else if (msg.equals("Username or email already exists") ||
                         msg.equals("Error in JSON")){

                    //Ref. line 133
                    JOptionPane.showMessageDialog(frame, "Username or email already exists",
                            "Error",JOptionPane.ERROR_MESSAGE );
                }
            }
        }

        //Ref. line 142-149
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        //Return false, if it fails.
        return false;
    }

    /**
     * Delete game.
     *
     * @param currentUser
     * @param frame
     * @return true, if successful
     */
    public boolean deleteGame(User currentUser, Frame frame){

        try{

            /*
            Instantiates Integer object called gameId, with the number from
            the textfield.
             */
            int gameId = frame.getMainPanel().getDeleteGame().getGameId();

            //If the number is not 0.
            if ( gameId != 0){

                //Ref. line 80-88
                String msg = jp.messageParser(jp.getSc().delete("games/" + gameId));

                //If the msg object equals to "Game was deleted", then:
                if (msg.equals("Game was deleted")){

                    //Returns true.
                    return true;
                }

                //Else if msg object equals "Failed. Game was not deleted", then:
                else if (msg.equals("Failed. Game was not deleted")){

                    //Ref. line 133
                    JOptionPane.showMessageDialog(frame, "Wrong Game ID",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        //Ref line 224-231
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Creates the game.
     *
     * @param frame
     * @param gamer
     * @param currentUser
     * @return true, if successful
     */
    public boolean createGame(Frame frame, Gamer gamer, User currentUser){

        try {

            //Ref. line 51-53
            String gameName = frame.getMainPanel().getCreateGame().getGamename();
            int mapSize = frame.getMainPanel().getCreateGame().getMapsize();
            String gameControls = frame.getMainPanel().getCreateGame().getControls();

            //Ref. line 58
            if (!gameName.equals("") && mapSize != 0 && !gameControls.equals("")){

                //Initializes new object of Game.
                Game game = new Game();

                //Sets every game variable.
                gamer.setId(currentUser.getId());
                gamer.setControls(gameControls);
                game.setName(gameName);
                game.setMapSize(mapSize);
                game.setHost(gamer);

                //Ref. line 72-76
                String json = new Gson().toJson(game);

                //Ref. line 80-88
                String msg = jp.createGameParser(jp.getSc().post(json, "games/", frame));

                //If the msg object equals to the name of the game-object, then:
                if (msg.equals(game.getName())){

                    //Show confirmation dialog.
                    JOptionPane.showMessageDialog(frame, "Game was created!\nIt's called "
                            + game.getName(), "Success!", JOptionPane.ERROR_MESSAGE);

                    //Returns true.
                    return true;
                }

                //Ref. line 126-128
                else if (msg.equals("Error in JSON") || msg.equals("something went wrong")){
                    JOptionPane.showMessageDialog(frame, "Check input",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Ref. line 224-231
        catch(Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    /**
     * Highscores.
     *
     * @param frame the frame
     */
    public boolean highscores(Frame frame){

        try{

            User user1 = new User();
            User user2 = new User();
            User user3 = new User();
            User user4 = new User();
            User user5 = new User();

            Highscore highscore = jp.highscoreParser(jp.getSc().get("scores/"),
                    user1, user2, user3, user4, user5);

            jp.parser(jp.getSc().get("users/" + user1.getId() + "/"), user1);
            jp.parser(jp.getSc().get("users/" + user2.getId() + "/"), user2);
            jp.parser(jp.getSc().get("users/" + user3.getId() + "/"), user3);
            jp.parser(jp.getSc().get("users/" + user4.getId() + "/"), user4);
            jp.parser(jp.getSc().get("users/" + user5.getId() + "/"), user5);



            frame.getMainPanel().getHighscore().getLbl1score().setText(String.valueOf(
                    highscore.getH1().getScore()) + " scored by " + user1.getFirst_name());

            frame.getMainPanel().getHighscore().getLbl2score().setText(String.valueOf(
                    highscore.getH2().getScore()) + " scored by " + user2.getFirst_name());

            frame.getMainPanel().getHighscore().getLbl3score().setText(String.valueOf(
                    highscore.getH3().getScore()) + " scored by " + user3.getFirst_name());

            frame.getMainPanel().getHighscore().getLbl4score().setText(String.valueOf(
                    highscore.getH4().getScore()) + " scored by " + user4.getFirst_name());

            frame.getMainPanel().getHighscore().getLbl5score().setText(String.valueOf(
                    highscore.getH5().getScore()) + " scored by " + user5.getFirst_name());

            return true;


        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Issue in HTTP",
                    "Error", JOptionPane.ERROR_MESSAGE);
            frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
        }
        return false;
    }

    /**
     * Show game info.
     *
     * @param frame the frame
     * @return the game
     */
    public Game showGameInfo(Frame frame){


        try {

            String msg = frame.getMainPanel().getJoinGame().getComboBox().getSelectedItem().toString();

            Game game = jp.getGame(jp.getSc().get("game/" + msg + "/"));

            frame.getMainPanel().getJoinGame().getLblGameName().setText("Game name: " + game.getName());

            return game;
        }
        catch (Exception e){
            e.printStackTrace();
            //JOptionPane.showMessageDialog(frame, "Error in methods",
              //      "Error", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Show open games.
     *
     * @param frame the frame
     * @param game the game
     */
    public boolean showOpenGames(Frame frame){

        try {

            Game[] games = jp.openGamesParser(jp.getSc().get("games/open/"));

            for (Game gm : games) {

                frame.getMainPanel().getJoinGame().getComboBox().addItem(gm.getGameId());

                System.out.println(gm.getGameId() + ":\t" + gm.getName());
            }
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Join game.
     *
     * @param frame the frame
     * @param currentUser the current user
     * @param gamer the gamer
     * @param game the game
     * @return true, if successful
     */
    public boolean joinGame(Frame frame, User currentUser, Gamer gamer, Game game){

        Gson gson;


        try {

            gson = new Gson();


            String controls = frame.getMainPanel().getJoinGame().getControls();

            if (!controls.equals("")) {

                System.out.println(game.getGameId());
                gamer.setId(currentUser.getId());
                gamer.setControls(controls);
                game.setOpponent(gamer);

                String json = gson.toJson(game);

                String msg = jp.messageParser(jp.getSc().put("games/join/", json));

                if (msg.equals("Game was joined")){


                    Game game1 = jp.getGame(jp.getSc().put("games/start/", json));

                    System.out.println(game1.getWinner());

                    if (game1.getWinner().isWinner()){
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else if (msg.equals("Game closed")){
                    JOptionPane.showMessageDialog(frame, "Game closed",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (msg.equals("Error in JSON")){
                    JOptionPane.showMessageDialog(frame, "Error in JSON",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Gets the jp.
     *
     * @return the jp
     */
    public JSONParsers getJp() {
        return jp;
    }
}
