/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

//-----------------------------------imports------------------------------------
import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

/**
 * 
 */
public class ScrollPane implements Widget
{
//-----------------------------------field--------------------------------------
    /**
     * 
     */
    JScrollPane scrollPane;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param x
     * @param y
     * @param width
     * @param height
     * @param view
     */
    public ScrollPane(int x, int y, int width, int height, Component view)
    {
        scrollPane = new JScrollPane();
        scrollPane.setBounds(x, y, width, height);
        scrollPane.setViewportView(view);
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    @Override
    public JComponent getJComponent()
    {
        return scrollPane;
    }

}
