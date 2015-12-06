package Run;

import Logic.Controller;
import Model.Config;

import javax.swing.UIManager;
import java.awt.EventQueue;

/**
 * The Main class.
 * Contains the main-method which is used to start
 * the application.
 *
 * @author Oscar
 * @since 26-10-2015
 *
 * Created by Oscar on 26-10-2015.
 */
class Main {

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

                    //Initialize Controller class.
                    new Controller();

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
