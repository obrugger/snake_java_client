package SDK;

import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

/**
 * Created by Oscar on 16-11-2015.
 */
public class ServerConnection {


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

    public void send(String str){

        establishConnection();

        byte[] encrypted = encrypt(str);

        try{
            outToServer.write(encrypted);
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

            String answer =decrypt(modifiedSentence.getBytes());

            return answer;


        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "null";
    }

    public byte[] encrypt(String str){

        byte[] input = str.getBytes();
        byte key = (byte) 123456;

        byte[] encrypted = input;

        for(int i = 0; i < encrypted.length; i++){
            encrypted[i] = (byte) (encrypted[i] ^ key);
        }

        return encrypted;

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
    }
}
