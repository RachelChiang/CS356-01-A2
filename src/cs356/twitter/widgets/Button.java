/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

//-----------------------------------imports------------------------------------
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;

/**
 * 
 */
public class Button implements Widget
{
//-----------------------------------field--------------------------------------
    /**
     * 
     */
    private JButton button;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param name
     * @param command
     * @param listener
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public Button(String name,
            String command,
            ActionListener listener,
            int x,
            int y,
            int width,
            int height)
    {
        button = new JButton(name);
        button.setActionCommand(command);
        button.addActionListener(listener);
        button.setBounds(x, y, width, height);
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    @Override
    public JComponent getJComponent()
    {
        return button;
    }
}
