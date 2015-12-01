package SDK;

import Model.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Oscar on 01-12-2015.
 */
public class JSONParsers {



    public JSONParsers(){

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

            return msg;


        }
        catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }


}
