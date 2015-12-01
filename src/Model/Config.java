package Model;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Oscar on 01-12-2015.
 */
public class Config {

    private static String url;
    private static String serverPort;

    public Config(){


    }

    public static void configInit() throws IOException{


        JSONParser jsonParser = new JSONParser();

        try {


            FileReader json = new FileReader("src/config.json");
            Object obj = jsonParser.parse(json);

            JSONObject jsonObject = (JSONObject) obj;

            setUrl((String) jsonObject.get("url"));
            setServerPort((String) jsonObject.get("serverport"));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void setServerPort(String serverPort) {
        Config.serverPort = serverPort;
    }

    public static void setUrl(String url) {
        Config.url = url;
    }

    public static String getServerPort() {
        return serverPort;
    }

    public static String getUrl() {
        return url;
    }
}
