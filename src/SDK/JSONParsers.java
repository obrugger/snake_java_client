package SDK;

import Model.Game;
import Model.Highscore;
import Model.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Oscar on 01-12-2015.
 */
public class JSONParsers {

    private ServerConnection sc;



    public JSONParsers(){

        sc = new ServerConnection();

    }

    public String loginParser(String str, User user){

        JSONParser parser = new JSONParser();
        String msg = new String();
        int id = 0;

        try{

            Object objMsg = parser.parse(str);
            JSONObject jsonObjectMsg = (JSONObject) objMsg;

            msg = ((String) jsonObjectMsg.get("message"));

            if (msg.equals("Login successful")) {
                user.setId((long) jsonObjectMsg.get("userid"));
            }

            return msg;


        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public String messageParser(String str){
        JSONParser parser = new JSONParser();
        String msg = new String();

        try {
            Object obj = parser.parse(str);
            JSONObject jsonObject = (JSONObject) obj;

            msg = ((String) jsonObject.get("message"));

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return msg;
    }



    public Highscore highscoreParser (String str){

        JSONParser parser = new JSONParser();
        long h1;
        long h2;
        long h3;
        long h4;
        long h5;

        try {
            Object obj = parser.parse(str);
            JSONObject jsonObject = (JSONObject) obj;

            h1 = ((long) jsonObject.get("h1"));
            h2 = ((long) jsonObject.get("h2"));
            h3 = ((long) jsonObject.get("h3"));
            h4 = ((long) jsonObject.get("h4"));
            h5 = ((long) jsonObject.get("h5"));

            Highscore highscore = new Highscore();

            highscore.setH1(h1);
            highscore.setH2(h2);
            highscore.setH3(h3);
            highscore.setH4(h4);
            highscore.setH5(h5);

            return highscore;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

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



    public ServerConnection getSc() {
        return sc;
    }
}
