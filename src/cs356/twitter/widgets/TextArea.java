/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.widgets;

import javax.swing.JComponent;
import javax.swing.JTextArea;

public class TextArea implements Widget
{
    private JTextArea textArea;
    private String text;
    
    public TextArea(String text, boolean editable)
    {
        textArea = new JTextArea();
        this.text = text + "\n";
        textArea.setText(this.text);
        textArea.setEditable(false);
    }
    
    public void addText(String text)
    {
        this.text += text + "\n";
        textArea.setText(this.text);
    }
    
    @Override
    public JComponent getJComponent()
    {
        return textArea;
    }

}
