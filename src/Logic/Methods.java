package Logic;

import GUI.Frame;
import SDK.ServerConnection;
import Model.User;
import com.google.gson.Gson;
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

    public boolean userAuthentication( User currentUser, Frame frame){

        try{

            String username = frame.getMainPanel().getLogin().getUsername();
            String password = frame.getMainPanel().getLogin().getPassword();

            if(!username.equals("") && !password.equals("")) {

                User user = new User();
                user.setPassword(password);
                user.setUsername(username);

                String json = new Gson().toJson(user);

                String msg = loginParser(sc.send(json, "login/", frame), user);

                if(msg.equals("Login successful")){


                    currentUser = user;

                    sc.parser(sc.get("users/" + currentUser.getId() + "/"), currentUser);

                    frame.getMainPanel().getMenu().getLblhelloUser().
                            setText("Hello " + currentUser.getFirst_name() + "!");

                    frame.getMainPanel().getLogin().clearLogin();

                    return true;
                }
                else if(msg.equals("Wrong username or password")){
                    JOptionPane.showMessageDialog(frame, "Wrong username or password",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if (msg.equals("Error in JSON")){
                    JOptionPane.showMessageDialog(frame, "Backend issue",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(frame, "Recheck spelling",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;

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

                Model.User user = new User();
                user.setType(type);
                user.setStatus("active");
                user.setPassword(password);
                user.setUsername(username);
                user.setFirst_name(firstname);
                user.setLast_name(lastname);
                user.setEmail(email);

                String json = new Gson().toJson(user);

                String msg = messageParser((sc.send(json, "users/", frame)));

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
}
