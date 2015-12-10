package SDK;

import GUI.Frame;
import Model.Config;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.servlet.http.HttpSession;
import javax.swing.*;


/**
 * The ServerConnection class.
 * Handles the HTTP methods and connectivity to the Snake-server.
 * Contains post-, get-, delete- and put-methods.
 *
 * @author Oscar
 * @since 16-11-2015
 *
 * Created by Oscar on 16-11-2015.
 */
public class ServerConnection {

    /** The url */
    private static String url;

    /** The serverPort */
    private static int serverPort;

    /**
     * The ServerConnection constructor.
     * Instantiates both variables declared.
     */
    public ServerConnection() {

        //Instantiates url to contain Config.getUrl method.
        url = Config.getUrl();

        /*
        Instantiates serverPort to contain Config.getServerPort,
        which is parsed to an integer through being the parameter
        in method parseInt from Integer class.
         */
        serverPort = Integer.parseInt(Config.getServerPort());
    }


    /**
     * The HTTP Post-method.
     *
     * @param json
     * @param path
     * @param frame
     * @return output, if successful.
     */
    @SuppressWarnings("AccessStaticViaInstance")
    public String post(String json, String path, Frame frame){

        try{

            //Initialize new client-object of Client-class' create-method.
            Client client = new Client().create();

            /*
            Instantiate WebResource object to contain the client object' resource-method,
            with the parameter being the particular URL and serverport generated from the
            Config-class.
            Uses one parameter; path.
             */
            WebResource webResource = client.resource(url + ":" + serverPort + "/api/" + path);

            /*
            Instantiate ClientResponse object to contain the webResource object' type-method,
            with the parameter being "application/json", which means that we expect JSON in return.
            We then use the post-method to define the type of HTTP-method we are using.
            It takes the ClientResponse-class and parameter json, as parameter.
             */
            ClientResponse clientResponse = webResource.type("application/json").post(ClientResponse.class, json);

            /*
            Instantiates a String object to contain the clientResponse object' getEntity-method,
            with the parameter being the String-class.
             */

            //Returns the String object; output.
            return clientResponse.getEntity(String.class);

        }

        //Catch-block that catches all exceptions thrown from the try-block.
        catch (Exception e){

            //Prints the stacktrace in the console.
            e.printStackTrace();

            //Shows an OptionPane in the Frame, with an error message.
            JOptionPane.showMessageDialog(frame, "HTTP Failed", "Error", JOptionPane.ERROR_MESSAGE);
        }

        //Return null, if any exception is caught.
        return null;
    }

    /**
     * The HTTP Get-method.
     *
     * @param path
     * @return output, if successful.
     */
    public String get(String path){

        try{
            //Ref. line 56
            Client client = Client.create();

            //Ref. line 59
            WebResource webResource = client.resource(url + ":" + serverPort + "/api/" + path);

            /* Ref. line 68
            Same principle as post-method, except that it uses get-method.
            It does not take a json-parameter, as it is only getting an entity from the server.
             */
            ClientResponse clientResponse = webResource.type("application/json").get(ClientResponse.class);

            //Ref. line 76

            return clientResponse.getEntity(String.class);
        }

        //Ref. line 86-97
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * The HTTP Delete-method.
     *
     * @param path
     * @return output, if successful.
     */
    public String delete(String path){

        try {

            //Ref. line 56
            Client client = Client.create();

            //Ref. line 59
            WebResource webResource = client.resource(url + ":" + serverPort + "/api/" + path);

            /*Ref. line 115
            Same principle as the get-method, uses the delete-method instead.
            Deletes an already exsisting entitiy on the server.
             */
            ClientResponse clientResponse = webResource.type("application/json").delete(ClientResponse.class);

            //Ref. line 76

            return clientResponse.getEntity(String.class);
        }

        //Ref line 86-97
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * The HTTP Put-method.
     *
     * @param path
     * @param json
     * @return output, if successful.
     */
    public String put(String path, String json){
        try {

            //Ref. line 56
            Client client = Client.create();

            //Ref. line 59
            WebResource webResource = client.resource(url + ":" + serverPort + "/api/" + path);

            /* Ref. line 68
            Uses put-method instead of post method. Updates an already exsisting entity
            on the server.
             */
            ClientResponse clientResponse = webResource.type("application/json").put(ClientResponse.class, json);

            //Ref. line 76

            return clientResponse.getEntity(String.class);

        }

        //Ref. line 86-97
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}