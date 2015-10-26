package Logic;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Main {

    private static Socket socket;
    private static PrintWriter printWriter;
    private static Scanner sc;


    public Main(){


    }
    public static void main(String[] args) {

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
