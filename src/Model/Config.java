package Model;


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
        FileReader json = new FileReader("src/config.json");
        



    }






}
