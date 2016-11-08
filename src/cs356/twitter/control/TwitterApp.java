package cs356.twitter.control;
import java.awt.EventQueue;

public class TwitterApp {

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
