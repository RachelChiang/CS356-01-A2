/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.control;
import java.awt.EventQueue;

public class Driver {

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                try
                {
                    MainGUI adminWindow = MainGUI.getInstance();
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
        );
    }
}
