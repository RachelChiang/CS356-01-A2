/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

//-----------------------------------imports------------------------------------
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * 
 */
public class TextField implements Widget
{
//-----------------------------------field--------------------------------------
    /**
     * 
     */
    private JTextField textField;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param name
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public TextField(String name,
            int x,
            int y,
            int width,
            int height)
    {
        textField = new JTextField(name);
        textField.setBounds(x, y, width, height);
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    public void clear()
    {
        textField.setText("");
    }
    
    /**
     * 
     */
    public JComponent getJComponent()
    {
        return textField;
    }
    
    /**
     * 
     * @return
     */
    public String getTFText()
    {
        return textField.getText();
    }
}
