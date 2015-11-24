package Logic;

import SDK.ServerConnection;
import Test.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Oscar on 23-11-2015.
 */
public class Methods {

    ServerConnection sc;

    public Methods(){

        sc = new ServerConnection();

    }
    /*
    public boolean userAuthentication(String username, String password, User user){

        if(!username.equals("") && !password.equals("")) {

            user.setPassword(password);
            user.setUsername(username);

            String json = new Gson().toJson(user);

            messageDigester(sc.send(json, "login/"));


                messageDigester(sc.get("users/" + user.getId() + "/"));
                return true;

            }

        }
        return false;

    }
    public void messageDigester(String str){

        JSONParser parser = new JSONParser();
        String msg = new String();

        try{

            Object obj = parser.parse(str);
            JSONObject jsonObject = (JSONObject) obj;

            msg = ((String) jsonObject.get("message"));

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }*/
}
