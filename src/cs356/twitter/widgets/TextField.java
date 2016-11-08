package cs356.twitter.widgets;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextField implements Widget
{
    private JTextField textField;
    
    public TextField(String name,
            int x,
            int y,
            int width,
            int height)
    {
        textField = new JTextField(name);
        textField.setBounds(x, y, width, height);
    }
    
    public void clear()
    {
        textField.setText("");
    }
    
    public JComponent getJComponent()
    {
        return textField;
    }
    
    public String getTFText()
    {
        return textField.getText();
    }
}
