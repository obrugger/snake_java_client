package SDK;

import GUI.Frame;
import Model.Config;
import Model.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.io.IOException;


/**
 * Created by Oscar on 16-11-2015.
 */
public class ServerConnection {

    private String url;
    private int serverPort;


    public ServerConnection() throws IOException{

        this.url = Config.getUrl();
        this.serverPort = Integer.parseInt(Config.getServerPort());
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


    public String get(String path){

        try{

            Client client = Client.create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").get(ClientResponse.class);


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

    public String put(String path, String json){
        try {

            Client client = Client.create();

            WebResource webResource = client.resource(getUrl() + ":" + getServerPort() + "/api/" + path);
            ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, json);

            System.out.println("\nOutput from server ....\n");
            String output = clientResponse.getEntity(String.class);
            System.out.println(output);

            return output;

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
