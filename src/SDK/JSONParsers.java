package SDK;

import Model.Game;
import Model.Highscore;
import Model.Scores;
import Model.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
    private final ServerConnection sc;



    /**
     * Creates the Constructor.
     *
     */
    public JSONParsers() {

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
        String msg;

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
        String msg = "";

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
     * @param str The JSON from Snake server.
     * @param user1 1st place.
     * @param user2 2nd place.
     * @param user3 3rd place.
     * @param user4 4th place.
     * @param user5 5th place.
     * @return highscore
     */
    public Highscore highscoreParser (String str, User user1,User user2,
                                      User user3, User user4, User user5){

        //Initializes Higscore object and Gson object.
        Highscore highscore = new Highscore();
        Gson gson = new Gson();


        try {

            /*
            Instantiate an Array of type Scores. It is set to contain
            the response from the server, which comes as Json. Gson-method fromJson
            is used and it is defined that the JSON is of type Scores Array.
             */
            Scores[] scores = gson.fromJson(str, Scores[].class);

            /*
            Uses the parameters' user-objects and sets their individual Id's.
            The first user is set to be equal to the first userId in the array.
             */
            user1.setId(Arrays.asList(scores).get(0).getUserId());
            user2.setId(Arrays.asList(scores).get(1).getUserId());
            user3.setId(Arrays.asList(scores).get(2).getUserId());
            user4.setId(Arrays.asList(scores).get(3).getUserId());
            user5.setId(Arrays.asList(scores).get(4).getUserId());

            /*
            Uses highscore object and sets each of its 5 variables by using the setter-methods.
            The values are set by using the Arrays class' method of asList which takes the Array scores
            as the parameter. Thereby it is able to get each of the values presented on each of the first
            five indexes.
             */
            highscore.setH1(Arrays.asList(scores).get(0));
            highscore.setH2(Arrays.asList(scores).get(1));
            highscore.setH3(Arrays.asList(scores).get(2));
            highscore.setH4(Arrays.asList(scores).get(3));
            highscore.setH5(Arrays.asList(scores).get(4));

            //Returns highscore object.
            return highscore;

        }
        //Ref. line 94
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Creates the game parser.
     *
     * @param str The JSON from server.
     * @return the gameName.
     */
    public String createGameParser(String str){

        //Ref. line 54
        JSONParser jsonParser = new JSONParser();

        //Ref. line 150
        String gameName;

        try {

            //Ref. line 61
            Object obj = jsonParser.parse(str);
            //Ref. line 67
            JSONObject jsonObject = (JSONObject) obj;

            //Ref. line 72
            gameName = ((String) jsonObject.get("name"));

            //Returns the gameName.
            return gameName;

        }

        //Ref. line 94
        catch (Exception e){
            e.printStackTrace();
        }

        //Returns null if exception is caught.
        return null;
    }

    /**
     * Open games parser.
     *
     * @param str the JSON
     * @return games[]
     */
    public Game[] openGamesParser(String str){
        try {

            //Ref. line 191
            Gson gson = new Gson();

            //Ref. line 198

            //Returns the array of Game objects.
            return gson.fromJson(str, Game[].class);
        }

        //Ref. line 94
        catch (Exception e){
            e.printStackTrace();
        }

        //Ref. line 272
        return null;
    }



    /**
     * Get game from id parser.
     *
     * @param str The JSON.
     * @return game
     */
    public Game getGame(String str){
        try {

            //Ref. line 191
            Gson gson = new Gson();

            //Ref. line 198

            //Returns the game object.
            return gson.fromJson(str, Game.class);

        }

        //Ref. line 92
        catch (Exception e){
            e.printStackTrace();
        }

        //Ref. line 272
        return null;
    }



    /**
     * Gets the sc.
     *
     * @return the sc
     */
    public ServerConnection getSc() {

        //Returns the ServerConnection.
        return sc;
    }
}
