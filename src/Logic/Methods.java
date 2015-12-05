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

                /*
                Ref. line 80-88.
                Uses HTTP delete-method instead of post.
                 */
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
     * @return true, if succesful
     */
    public boolean highscores(Frame frame){

        try{

            //Initializes 5 instances of User object.
            User user1 = new User();
            User user2 = new User();
            User user3 = new User();
            User user4 = new User();
            User user5 = new User();

            /*
            Instantiates Highscore object with the method highscoreParser from jp object.
            The parameter in the method is the ServerConnection method, get. Where the
            parameter is the path. The five objects of User, is parameters in the
            highscore parser method.
             */
            Highscore highscore = jp.highscoreParser(jp.getSc().get("scores/"),
                    user1, user2, user3, user4, user5);

            /*
            Uses the parser-method for every object of User, to define each of the
            variables for each User object.
             */
            jp.parser(jp.getSc().get("users/" + user1.getId() + "/"), user1);
            jp.parser(jp.getSc().get("users/" + user2.getId() + "/"), user2);
            jp.parser(jp.getSc().get("users/" + user3.getId() + "/"), user3);
            jp.parser(jp.getSc().get("users/" + user4.getId() + "/"), user4);
            jp.parser(jp.getSc().get("users/" + user5.getId() + "/"), user5);


            /*
            Uses the setText method from JLabels on the five different JLabels,
            in the GUI.Highscore class.
            It defines the score from the five different users and gets their firstName.
             */
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

            //Returns true.
            return true;


        }
        //Catches all exceptions thrown by the try-block
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Backend error.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
        }
        //Returns false, if any exception is caught.
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

            /*
            Instantiates the String object, gameId, to contain the value of
            the select item in the JComboBox, which is parsed to a String.
            To get the selected itme, the method getSelectedItem is uset. To parse it
            from type Object to type String, method toString is used.
             */
            String gameId = frame.getMainPanel().getJoinGame().getComboBox().getSelectedItem().toString();

            /*
            Ref. line 365-368.
            Uses the getGame method from jp-object instead of highscoreParser.
             */
            Game game = jp.getGame(jp.getSc().get("game/" + gameId + "/"));

            //Ref. line 110-112
            frame.getMainPanel().getJoinGame().getLblGameName().setText("Game name: " + game.getName());

            //Returns the game.
            return game;
        }
        //Ref. line 409
        catch (Exception e){

            frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
        }
        //Returns null, if any exception is caught.
        return null;
    }

    /**
     * Show open games.
     *
     * @param frame
     */
    public boolean showOpenGames(Frame frame){

        try {

            /*
            Instantiates an Array of type Game, called games. It contains the
            games returned by the openGamesParser, called from the jp-object.
            The parser takes the ServerConnection-method, get, as parameter.
             */
            Game[] games = jp.openGamesParser(jp.getSc().get("games/open/"));

            /*
            Uses enhanced for-statement to read through the Games Array, games.
            And then for every object of Game, then:
             */
            for (Game gm : games) {

                /*
                Uses the JComboBox method, addItem, to add every gameId located in the games object.
                It takes the gm-variable's gameId as parameter.
                 */
                frame.getMainPanel().getJoinGame().getComboBox().addItem(gm.getGameId());

            }
            //Returns true.
            return true;
        }
        //Catches any exception thrown by try-block.
        catch (Exception e) {

        }
        //If exception is caught, then return false.
        return false;
    }


    /**
     * Join game.
     *
     * @param frame
     * @param currentUser
     * @param gamer
     * @param game
     * @return true, if successful
     */
    public boolean joinGame(Frame frame, User currentUser, Gamer gamer, Game game){

        //Declares local variable gson, of type Gson.
        Gson gson;


        try {

            //Initializes gson variable.
            gson = new Gson();

            //Ref. line 51-53
            String controls = frame.getMainPanel().getJoinGame().getControls();

            //Ref. line 58
            if (!controls.equals("")) {

                //Sets the variables for game object.
                gamer.setId(currentUser.getId());
                gamer.setControls(controls);
                game.setOpponent(gamer);

                //Ref. line 73-76
                String json = gson.toJson(game);

                /*
                Ref. line 80-88
                Uses HTTP method put, instead of post.
                 */
                String msg = jp.messageParser(jp.getSc().put("games/join/", json));

                //Ref. line 93
                if (msg.equals("Game was joined")){


                    /*
                    Instantiates a game object, game1, to contain the Game returned by jp-method
                    getGame. The method takes the path and json object as parameters.
                     */
                    Game game1 = jp.getGame(jp.getSc().put("games/start/", json));

                    System.out.println(game1);

                    //TODO: Ændr server og gamer klaase, lav winner til int i stedet for boolean
                    //If the value of get-winner is true, then:
                    if (game1.getWinner().getId() == currentUser.getId()){

                        //Return true
                        return true;
                    }
                    else {
                        //If not, then show JOptionpane.
                        JOptionPane.showMessageDialog(frame, "You lost!",
                                "Failure", JOptionPane.ERROR_MESSAGE);
                    }
                }

                //If msg instead equals either "Game closed" or "Error in JSON", then:
                else if (msg.equals("Game closed") ||
                         msg.equals("Error in JSON")){

                    //Show JOptionPane.
                    JOptionPane.showMessageDialog(frame, "Game closed",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Ref. line 490
        catch (Exception e) {
            frame.getMainPanel().getC().show(
                    frame.getMainPanel(), frame.getMainPanel().getMENU()
            );
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Gets the jp.
     *
     * @return jp
     */
    public JSONParsers getJp() {
        return jp;
    }
}
