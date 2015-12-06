package Model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * The Config class.
 * Reads from the config.json document located
 * in the src folder in the project.
 *
 * @author Oscar
 * @since 01-12-2015
 *
 * Created by Oscar on 01-12-2015.
 */
public class Config {

    /** The url. */
    private static String url;
    
    /** The server port. */
    private static String serverPort;

    /**
     * Static configInit-method. Is called in Main method,
     * and only run once.
     *
     */

    public static void configInit() {

        //Instantiates jsonParser object of type JSONParser class.
        JSONParser jsonParser = new JSONParser();

        try {

            /*
            Initializes FileReader object as json.
            It reads from the config.json document located in the src folder.
            The path to the document is used as a String parameter.
             */
            FileReader json = new FileReader("src/config.json");

            /*
            Instantiates obj of type Object to contain the json,
            which is parsed from the config.json document.
             */
            Object obj = jsonParser.parse(json);

            /*
            Instantiates jsonObject of type JSONObject to contain
            the obj variable, which is cast to be of type JSONObject.
             */
            JSONObject jsonObject = (JSONObject) obj;

            /*
            Uses setUrl method and takes the jsonObject.get method as parameter.
            The method is cast to be of type String.
            It reads what the url variable contains, in the json document.
             */
            setUrl((String) jsonObject.get("url"));

            //Same principle as setUrl method. Reads and sets serverport instead.
            setServerPort((String) jsonObject.get("serverport"));
        }

        //Catches all the exceptions thrown by the try-block.
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Sets the server port.
     *
     * @param serverPort the new server port
     */
    private static void setServerPort(String serverPort) {
        Config.serverPort = serverPort;
    }

    /**
     * Sets the url.
     *
     * @param url the new url
     */
    private static void setUrl(String url) {
        Config.url = url;
    }

    /**
     * Gets the server port.
     *
     * @return the server port
     */
    public static String getServerPort() {
        return serverPort;
    }

    /**
     * Gets the url.
     *
     * @return the url
     */
    public static String getUrl() {
        return url;
    }
}
