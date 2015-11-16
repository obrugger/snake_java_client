package Run;

import Logic.Controller;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;
import Test.User;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Main {

    public static void main(String[] args) {

        Socket socket;
        DataOutputStream outToServer;
        InputStream inputStream;
        URLConnection connection;
        User user;

        try {


            connection = url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-type", "application/json");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write();

            socket = new Socket("localhost", 29399);



            Controller contr = new Controller();
            contr.run();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
