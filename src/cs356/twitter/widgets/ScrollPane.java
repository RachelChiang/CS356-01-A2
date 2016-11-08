/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

public class ScrollPane implements Widget
{
    JScrollPane scrollPane;
    
    public ScrollPane(int x, int y, int width, int height, Component view)
    {
        scrollPane = new JScrollPane();
        scrollPane.setBounds(x, y, width, height);
        scrollPane.setViewportView(view);
    }
    @Override
    public JComponent getJComponent()
    {
        return scrollPane;
    }

}
