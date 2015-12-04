package SDK;

import Model.Game;
import Model.Highscore;
import Model.Scores;
import Model.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Arrays;


/**
 * The JSONParsers class.
 * Handles the JSON returned from HTTP methods
 * used in the ServerConnection class.
 * All the methods are called from the Methods class.
 *
 * @author Oscar
 * @since 01-12-2015
 *
 * Created by Oscar on 01-12-2015.
 */
public class JSONParsers {

    /** The sc. */
    private ServerConnection sc;



    /**
     * Creates the Constructor.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public JSONParsers() throws IOException{

        //Initializes the sc variable.
        sc = new ServerConnection();

    }

    /**
     * Login JSON parser.
     *
     * @param str the str
     * @param user the user
     * @return the string
     */
    public String loginParser(String str, User user){

        //Initializes the JSONParser object as parser.
        JSONParser parser = new JSONParser();

        //Initializes the String object as msg.
        String msg = new String();

        try{
            /*
            Instantiates objMsg to contain the result of
            parse method, with the parameter str as parameter.
             */
            Object objMsg = parser.parse(str);

            /*
            Instantiates JSONObject to contain cast objMsg.
             */
            JSONObject jsonObjectMsg = (JSONObject) objMsg;

            /*
            Set variable msg to contain the jsonObjectMsg method of get, which
            has parameter message as a String. The jsonObjectMsg is cast to String.
             */
            msg = ((String) jsonObjectMsg.get("message"));


            //If-statement; if msg variable equals the String Login successful, then:
            if (msg.equals("Login successful")) {

                /*
                Sets the user-parameter's Id to be equal the parsed JSON-value
                of userid.
                 */
                user.setId((long) jsonObjectMsg.get("userid"));
            }

            //Returns msg variable.
            return msg;


        }
        //Catches all exceptions thrown from try-block
        catch (Exception e) {

            //Prints the stacktrace.
            e.printStackTrace();
        }
        //returns null if exception is thrown.
        return null;
    }

    /**
     * Parser.
     *
     * @param json
     * @param user
     */
    public void parser(String json, User user){

        //Ref. line 54
        JSONParser jsonParser = new JSONParser();

        try{

            //Ref. line 61-69
            Object obj  = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            /*
            Uses the user-parameter's setters, to set email, firstname, lastname, status and created.
            The jsonObject get-method gets cast to a String type.
             */
            user.setEmail((String) jsonObject.get("email"));
            user.setFirst_name((String) jsonObject.get("firstName"));
            user.setLast_name((String) jsonObject.get("lastName"));
            user.setStatus((String) jsonObject.get("status"));
            user.setCreated((String) jsonObject.get("created"));


        }
        //Ref. line 94
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Message parser.
     *
     * @param str
     * @return msg
     */
    public String messageParser(String str){

        //Ref. line 54
        JSONParser parser = new JSONParser();

        //Initializes new message String.
        String msg = new String();

        try {

            //Ref. line 61-69.
            Object obj = parser.parse(str);
            JSONObject jsonObject = (JSONObject) obj;

            /*
            Sets msg to contain the JSON object message.
             */
            msg = ((String) jsonObject.get("message"));

        }

        //Ref. line 94
        catch (Exception e){
            e.printStackTrace();
        }

        //Returns the msg.
        return msg;
    }



    /**
     * Highscore parser.
     *
     * @param str the str
     * @param user1 the user1
     * @param user2 the user2
     * @param user3 the user3
     * @param user4 the user4
     * @param user5 the user5
     * @return the highscore
     */
    public Highscore highscoreParser (String str, User user1,User user2,
                                      User user3, User user4, User user5){

        //Initializes Higscore object and Gson object.
        Highscore highscore = new Highscore();
        Gson gson = new Gson();


        try {

            //
            Scores[] scores = gson.fromJson(str, Scores[].class);

            System.out.println(Arrays.asList(scores).get(0).getScore() + "\n"
                    + Arrays.asList(scores).get(0).getUserId());

            user1.setId(Arrays.asList(scores).get(0).getUserId());
            user2.setId(Arrays.asList(scores).get(1).getUserId());
            user3.setId(Arrays.asList(scores).get(2).getUserId());
            user4.setId(Arrays.asList(scores).get(3).getUserId());
            user5.setId(Arrays.asList(scores).get(4).getUserId());


            highscore.setH1(Arrays.asList(scores).get(0));
            highscore.setH2(Arrays.asList(scores).get(1));
            highscore.setH3(Arrays.asList(scores).get(2));
            highscore.setH4(Arrays.asList(scores).get(3));
            highscore.setH5(Arrays.asList(scores).get(4));

            return highscore;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates the game parser.
     *
     * @param str the str
     * @return the string
     */
    public String createGameParser(String str){

        JSONParser jsonParser = new JSONParser();
        String gameName = new String();

        try {

            Object obj = jsonParser.parse(str);
            JSONObject jsonObject = (JSONObject) obj;

            gameName = ((String) jsonObject.get("name"));

            Game game = new Game();

            game.setName(gameName);

            return gameName;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Open games parser.
     *
     * @param str the str
     * @return the game[]
     */
    public Game[] openGamesParser(String str){
        try {
            Gson gson = new Gson();
            Game[] games = gson.fromJson(str, Game[].class);

            return games;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Gets the game.
     *
     * @param str the str
     * @return the game
     */
    public Game getGame(String str){
        try {

            Gson gson = new Gson();

            Game game = gson.fromJson(str, Game.class);

            return game;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }



    /**
     * Gets the sc.
     *
     * @return the sc
     */
    public ServerConnection getSc() {
        return sc;
    }
}
