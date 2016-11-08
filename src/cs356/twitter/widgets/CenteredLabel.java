/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

//-----------------------------------imports------------------------------------
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 */
public class CenteredLabel implements Widget
{
//-----------------------------------field--------------------------------------
    /**
     * 
     */
    private JLabel label;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param name
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public CenteredLabel(String name, int x, int y, int width, int height)
    {
        label = new JLabel(name);
        label.setBounds(x, y, width, height);
        label.setHorizontalAlignment(SwingConstants.CENTER);
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    @Override
    public JComponent getJComponent()
    {
        return label;
    }

}
