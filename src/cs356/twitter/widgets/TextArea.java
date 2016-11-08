/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

//-----------------------------------imports------------------------------------
import javax.swing.JComponent;
import javax.swing.JTextArea;

/**
 * 
 */
public class TextArea implements Widget
{
//-----------------------------------fields-------------------------------------
    /**
     * 
     */
    private JTextArea textArea;
    
    /**
     * 
     */
    private String text;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param text
     * @param editable
     */
    public TextArea(String text, boolean editable)
    {
        textArea = new JTextArea();
        this.text = text + "\n";
        textArea.setText(this.text);
        textArea.setEditable(false);
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     * @param text
     */
    public void addText(String text)
    {
        this.text += text + "\n";
        textArea.setText(this.text);
    }
    
    /**
     * 
     */
    @Override
    public JComponent getJComponent()
    {
        return textArea;
    }

}
