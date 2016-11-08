package cs356.twitter.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import cs356.twitter.userinfo.*;
import cs356.twitter.widgets.*;


public class UserGUI implements ActionListener
{
    private JFrame frame;
    private JPanel contentPane;
    
    private User user;
    private UsersTree usersTree;
    private TextArea mainTextArea;
    
    private List<Widget> widgets;
    private TextField addFollowerTextField;
    private TextField messageTextField;
    private JList<User> following;
    private JList<String> newsFeed;
    
    public UserGUI(User user, UsersTree tree, int winOffset, TextArea textArea)
    {
        this.user = user;
        this.usersTree = tree;
        this.mainTextArea = textArea;
        
        frame = new JFrame("Twitter: " + user.toString());
        frame.setBounds(100 + winOffset, 100 + winOffset, 388, 435);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        frame.setVisible(true);
        
        following = new JList<User>(user.getFollowing());
        newsFeed = new JList<String>(user.getDashboardMessages());
        widgets = new ArrayList<Widget>();
        makeWidgets();
                
        for (Widget w : widgets)
        {
            contentPane.add(w.getJComponent());
        }
    }
    
    private void makeWidgets()
    {
        addFollowerTextField = new TextField("(username)", 10, 11, 230, 30);
        widgets.add(addFollowerTextField);
        widgets.add(new Button("Add Follower", "follow", this, 250, 11, 114, 30));
        messageTextField = new TextField("(message)", 10, 203, 230, 30);
        widgets.add(messageTextField);
        widgets.add(new Button("Post Tweet", "post", this, 250, 203, 114, 30));
        
        widgets.add(new ScrollPane(10, 89, 354, 100, following));
        widgets.add(new ScrollPane(10, 285, 352, 100, newsFeed));
        
        widgets.add(new CenteredLabel("News Feed", 10, 244, 354, 30));
        widgets.add(new CenteredLabel("Following", 10, 48, 354, 30));
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        String command = arg0.getActionCommand();
        
        if (command.equals("follow"))
        {
            if (!(addFollowerTextField.getTFText().equals("")))
            {
                UserElement theOneToFollow = usersTree.findUser(addFollowerTextField.getTFText());
                if (theOneToFollow != null)
                {
                    if (theOneToFollow instanceof User)
                    {
                        if (user != theOneToFollow)
                        {
                            if (!(user.getFollowing().contains(theOneToFollow)))
                            {
                                mainTextArea.addText(user.toString() + " is now following " + theOneToFollow.toString() + "!");
                                ((User) theOneToFollow).attach(user);
                                addFollowerTextField.clear();
                            }
                            else
                            {
                                mainTextArea.addText("ERROR: " + user.toString() + " is already following " + theOneToFollow.toString() + ".");
                            }
                        }
                        else
                        {
                            mainTextArea.addText("ERROR: Users cannot follow themselves.");
                        }
                    }
                    else
                    {
                        mainTextArea.addText("ERROR: Groups cannot be followed.");
                    }
                }
                else
                {
                    mainTextArea.addText("ERROR: No user named " + addFollowerTextField.getTFText() + " exists.");
                }
            }
        }
        else if (command.equals("post"))
        {
            if (!(messageTextField.getTFText().equals("")))
            {
                user.postMessage(messageTextField.getTFText());
                messageTextField.clear();
            }
        }
    }
}
