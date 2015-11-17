package Run;

import Logic.Controller;

import java.awt.*;
import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutionException;

import SDK.SDK;
import SDK.ServerConnection;
import Test.User;

import javax.swing.*;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Main {

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Controller controller = new Controller();
            }
        });

    }
}
