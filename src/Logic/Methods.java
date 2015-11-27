package Logic;

import GUI.Frame;
import Model.Game;
import Model.Gamer;
import Model.Highscore;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oscar on 23-11-2015.
 */
public class Methods {

    private ServerConnection sc;


    public Methods(){

        sc = new ServerConnection();

    }

    public boolean createUser(Frame frame, User currentUser){

        try {


            String username = frame.getMainPanel().getCreateUser().getUsername();
            String password = frame.getMainPanel().getCreateUser().getPassword();
            String firstname = frame.getMainPanel().getCreateUser().getFirstName();
            String lastname = frame.getMainPanel().getCreateUser().getLastName();
            String email = frame.getMainPanel().getCreateUser().getEmail();
            int type = 1;


            if(!username.equals("")&& !password.equals("") && !firstname.equals("")
                    && !lastname.equals("") && !email.equals("")){

                User user = new User();
                user.setType(type);
                user.setStatus("active");
                user.setPassword(password);
                user.setUsername(username);
                user.setFirst_name(firstname);
                user.setLast_name(lastname);
                user.setEmail(email);

                String json = new Gson().toJson(user);

                String msg = messageParser(sc.send(json, "users/", frame));

                if (msg.equals("User was created")){

                    currentUser = user;
                    frame.getMainPanel().getCreateUser().clearText();
                    return true;
                }
                else if (msg.equals("Username or email already exists")){

                    JOptionPane.showMessageDialog(frame, "Username or email already exists",
                            "Error",JOptionPane.ERROR_MESSAGE );
                }
                else if (msg.equals("Error in JSON")){

                    JOptionPane.showMessageDialog(frame, "Backend issue",
                            "Error",JOptionPane.ERROR_MESSAGE );
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public boolean deleteGame(User currentUser, Frame frame){

        try{
            int gameId = frame.getMainPanel().getDeleteGame().getGameId();

            if ( gameId != 0){

                String msg = messageParser(sc.delete("games/" + gameId));

                if (msg.equals("Game was deleted")){

                    return true;
                }
                else if (msg.equals("Failed. Game was not deleted")){

                    JOptionPane.showMessageDialog(frame, "Wrong Game ID",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Backend error",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

   public boolean createGame(Frame frame, Gamer gamer, User currentUser){

       try {

           String gameName = frame.getMainPanel().getCreateGame().getGamename();
           int mapSize = frame.getMainPanel().getCreateGame().getMapsize();
           String gameControls = frame.getMainPanel().getCreateGame().getControls();

           if (!gameName.equals("") && mapSize != 0 && !gameControls.equals("")){



               Game game = new Game();

               gamer.setId(currentUser.getId());
               gamer.setControls(gameControls);
               game.setName(gameName);
               game.setMapSize(mapSize);
               game.setHost(gamer);

               String json = new Gson().toJson(game);

               String msg = createGameParser(sc.send(json, "games/", frame));

               if (msg.equals(game.getName())){

                   JOptionPane.showMessageDialog(frame, "Game was created!\nIt's called "
                           + game.getName(), "Success!", JOptionPane.ERROR_MESSAGE);

                   return true;

               }


               else if (msg.equals("Error in JSON") || msg.equals("something went wrong")){
                   JOptionPane.showMessageDialog(frame, "Check input",
                           "Error", JOptionPane.ERROR_MESSAGE);
               }
               else System.out.println("Parseren gik galt.");
           }
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return false;
   }

    public void highscores(Frame frame){

        try{

            Highscore highscore = highscoreParser(sc.get("scores/"));

            frame.getMainPanel().getHighscore().getLbl1score().setText(String.valueOf(highscore.getH1()));
            frame.getMainPanel().getHighscore().getLbl2score().setText(String.valueOf(highscore.getH2()));
            frame.getMainPanel().getHighscore().getLbl3score().setText(String.valueOf(highscore.getH3()));
            frame.getMainPanel().getHighscore().getLbl4score().setText(String.valueOf(highscore.getH4()));
            frame.getMainPanel().getHighscore().getLbl5score().setText(String.valueOf(highscore.getH5()));

        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Issue in HTTP",
                    "Error", JOptionPane.ERROR_MESSAGE);
            frame.getMainPanel().getC().show(frame.getMainPanel(), frame.getMainPanel().getMENU());
        }
    }

    public Game[] getOpenGames(Frame frame, User currentUser, Gamer gamer){

        try {
            String controls = frame.getMainPanel().getJoinGame().getControls();

            Game[] games = openGamesParser(sc.get("games/open/"));

            for (Game gm : games){

                frame.getMainPanel().getJoinGame().getComboBox().addItem(gm.getName());
            }

            if (!controls.equals("")){


                Game game = new Game();

                gamer.setId(currentUser.getId());
                gamer.setControls(controls);
                game.setOpponent(gamer);

                String json = new Gson().toJson(game);

                String msg = messageParser(sc.put("games/join/", json));



            }



            return games;

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean joinGame(Frame frame, User currentUser, Gamer gamer){

        try {

            if (!controls.equals("")) {

                Game game = new Game();

                gamer.setId(currentUser.getId());
                gamer.setControls(controls);
                game.setOpponent(gamer);

                String json = new Gson().toJson(game);

                String msg = messageParser(sc.put("games/join/", json));

                if (msg.equals("Game was joined")){

                    JOptionPane.showMessageDialog(frame, "Game was joined!",
                            "Success", JOptionPane.PLAIN_MESSAGE);
                    return true;
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
        catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public String loginParser(String str, User user){

        JSONParser parser = new JSONParser();
        String msg = new String();
        int id = 0;

        try{

            Object objMsg = parser.parse(str);
            JSONObject jsonObjectMsg = (JSONObject) objMsg;

            msg = ((String) jsonObjectMsg.get("message"));
            user.setId((long) jsonObjectMsg.get("userid"));


        }
        catch (Exception e){
            e.printStackTrace();
        }

        return msg;
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

    public ServerConnection getSc() {
        return sc;
    }
}
