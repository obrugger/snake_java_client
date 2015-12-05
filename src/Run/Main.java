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

        /*
        The static method invokeLater from EventQueue class is called, and in which
        the parameter is an anonymous class that derives from the Runnable class.
        The invokeLater method, adds the object into the eventQueue.
        The thread in the eventQueue will execute the run-method when
        the method is reached in the queue.
         */
        EventQueue.invokeLater(new Runnable() {

            /*
            The anonymous class overrides the run-method of the interface runnable.
             */
            @Override
            public void run() {

                try {

                    /*
                    UIManager class' method setLookAndFeel is instantiated by using
                    the UIManager's method - getSystemLookAndFeelClassName - which
                    gets the current operating system's native look and feel.
                     */
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    /*
                    Config class is called and the method configInit is run.
                     */
                    Config.configInit();

                    //Initializes an object of the Controller class, called controller.
                    Controller controller = new Controller();

                }
                //Catches all exceptions thrown in the try-block.
                catch (Exception e) {

                    //Prints the stack trace.
                    e.printStackTrace();
                }
            }
        });
    }
}
