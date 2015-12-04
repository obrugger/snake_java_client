package Run;

import Logic.Controller;
import Model.Config;

import java.awt.*;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * Created by Oscar on 26-10-2015.
 */
public class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    Config.configInit();
                    Controller controller = new Controller();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });

    }
}
