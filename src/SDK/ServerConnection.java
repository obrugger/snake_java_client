package SDK;

import GUI.Frame;
import Model.Game;
import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import sun.org.mozilla.javascript.internal.json.JsonParser;
import sun.swing.StringUIClientPropertyKey;


import javax.swing.*;
import java.lang.reflect.Array;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Oscar on 16-11-2015.
 */
public class ServerConnection {

    private String url;
    private int serverPort;


    public ServerConnection(){
        this.url = "http://localhost";
        this.serverPort = 29399;

    }

    public int getServerPort() {
        return serverPort;
    }

    public String getUrl() {
        return url;
    }

    public String send (String json, String path, Frame frame){

        try{
            Client client = new Client().create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, json);


            System.out.println("\nOutput from Server .... \n");
            String output = clientResponse.getEntity(String.class);
            System.out.println(output);

            if(clientResponse != null) {
                return  output;

            }

        }
        catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "HTTP Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return "";
    }

    public JSONArray getJsonArray(String path){

        try {


            Client client = Client.create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").get(ClientResponse.class);

            //TypeToken<List<Game>> token = new TypeToken<List<Game>>(){};
            //List<Game> games = new Gson().fromJson(clientResponse.getEntity(String.class), token.getType());
           // ArrayList<Game> arrayList = clientResponse.getEntity(ArrayList.class);
            //System.out.println(arrayList);

            /*JSONArray jsonArray = clientResponse.getEntity(JSONArray.class);
            System.out.println(jsonArray);
            return jsonArray;*/
            ArrayList<Game> games = clientResponse.getEntity(new GenericType<ArrayList<Game>>(){});



            //return arrayList;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String get(String path){

        try{

            Client client = Client.create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").get(ClientResponse.class);

            /*
            if (clientResponse.getStatus() != 200){
                throw new RuntimeException("HTTP errorcode: " + clientResponse.getStatus());
            }*/

            System.out.println("\nOutput from Server .... \n");
            String output = clientResponse.getEntity(String.class);
            System.out.println(output);

            return output;

        }
        catch (Exception e){
            e.printStackTrace();
            return "null";
        }
    }

    public String delete(String path){

        try {

            Client client = Client.create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").delete(ClientResponse.class);

            System.out.println("\nOutput from server ....\n");
            String output = clientResponse.getEntity(String.class);
            System.out.println(output);

            return output;


        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void parser(String json, User user){

        JSONParser jsonParser = new JSONParser();

        try{

            Object obj  = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            user.setEmail((String) jsonObject.get("email"));
            user.setFirst_name((String) jsonObject.get("firstName"));
            user.setLast_name((String) jsonObject.get("lastName"));
            user.setStatus((String) jsonObject.get("status"));
            user.setCreated((String) jsonObject.get("created"));

        }catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }





    /*
    private DataOutputStream outToServer;
    private Socket socket;

    public void establishConnection(){

        try{

            socket = new Socket("localhost", 29399);
            outToServer = new DataOutputStream(socket.getOutputStream());



        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public void send(String gsonstr){

        establishConnection();

        //byte[] encrypted = encrypt(str);
        byte[] input = gsonstr.getBytes();


        try{
            outToServer.write(input);
            outToServer.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }

    public String receive(){

        BufferedReader inFromServer = null;

        try{

            inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String modifiedSentence = inFromServer.readLine();

            //String answer =decrypt(modifiedSentence.getBytes());

            //return answer;

            System.out.println(modifiedSentence);

            return modifiedSentence;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "null";
    }

    public byte[] encrypt(String str){

        byte[] input = str.getBytes();
        /*
        byte key = (byte) 123456;

        byte[] encrypted = input;

        for(int i = 0; i < encrypted.length; i++){
            encrypted[i] = (byte) (encrypted[i] ^ key);
        }

        return encrypted;
        return input;

    }

    public String decrypt(byte[] b){

        String crypKey = "123456";
        double keyAsDouble  = Double.parseDouble(crypKey);
        byte ff = (byte) keyAsDouble;

        for (int i = 0; i < b.length; i++){

            b[i] = (byte)(b[i]^ff);
        }

        String dencrypted = new String(b).trim();

        return dencrypted;
    }*/



}
