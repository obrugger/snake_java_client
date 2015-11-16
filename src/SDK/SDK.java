package SDK;
import Test.User;

import java.io.DataInputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Created by Oscar on 16-11-2015.
 */
public class SDK {

    private static URL url;

    public SDK(){

        try {
            url = new URL("http://localhost:29399/api/users");
        }
        catch (Exception e){
            e.printStackTrace();
        }


        public void setUser(){
            URLConnection urlCon;
            DataInputStream dis;

            try{

                ArrayList<User> user = new ArrayList<User>();



                urlCon = url.openConnection();
                urlCon.setDoInput(true);
                urlCon.setUseCaches(false);

                dis = new DataInputStream(urlCon.getInputStream());
                String s;

                while((s = dis.readLine()) != null){


    

                }

            }
            catch (Exception e){
                e.printStackTrace();
            }


        }
    }







}
