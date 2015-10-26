package Logic;
import GUI.Frame;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Controller {

    private static Socket socket;
    private static PrintWriter printWriter;
    private static Scanner sc;

    private Frame frame;

    public Controller(){

        frame = new Frame();
        frame.setVisible(true);

    }


    public void socketMethod(){

        try {


            socket = new Socket("localhost", 45782);

            printWriter = new PrintWriter(socket.getOutputStream(),true);
            printWriter.println("Woop WOop");

            sc = new Scanner(System.in);
            printWriter.println("Input: ");
            String string = sc.next();

            printWriter.println(string + " you have written.");

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
