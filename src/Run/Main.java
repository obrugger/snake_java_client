package Run;

import Logic.Controller;

import java.awt.*;

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
