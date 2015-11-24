package Logic;

import GUI.Frame;
import SDK.ServerConnection;
import Test.User;
import com.google.gson.Gson;
import com.sun.codemodel.JOp;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;

/**
 * Created by Oscar on 23-11-2015.
 */
public class Methods {

    ServerConnection sc;

    public Methods(){

        sc = new ServerConnection();

    }

    public boolean userAuthentication( User user, Frame frame){

        try{

            String username = frame.getMainPanel().getLogin().getUsername();
            String password = frame.getMainPanel().getLogin().getPassword();

            if(!username.equals("") && !password.equals("")) {

                User user1 = new User();
                user1.setPassword(password);
                user1.setUsername(username);

                String json = new Gson().toJson(user);

                sc.send(json, "login/");

                user = user1;

                System.out.println("Current userid is " + user.getId());

                sc.parser(sc.get("users/" + user.getId() + "/"), user);

                System.out.print(user.getFirst_name());


                return true;
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling", "Error", JOptionPane.ERROR_MESSAGE);
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
    }
}
