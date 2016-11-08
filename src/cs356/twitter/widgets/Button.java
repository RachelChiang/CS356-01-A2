/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;


public class Button implements Widget
{
    private JButton button;
    
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

    @Override
    public JComponent getJComponent()
    {
        return button;
    }
}
