/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CenteredLabel implements Widget
{
    private JLabel label;
    
    public CenteredLabel(String name, int x, int y, int width, int height)
    {
        label = new JLabel(name);
        label.setBounds(x, y, width, height);
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    @Override
    public JComponent getJComponent()
    {
        return label;
    }

}
