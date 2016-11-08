package cs356.twitter.userinfo;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;


public class User extends Subject implements UserElement, Observer
{
    private String username;
    private DefaultListModel<String> newsFeed;
    private List<String> userMessages;
    private String message;
    private DefaultListModel<User> following;
    
    public User(String username)
    {
        this.username = username;
        newsFeed = new DefaultListModel<String>();
        userMessages = new ArrayList<String>();
        message = "";
        following = new DefaultListModel<User>();
    }
    
    @Override
    public void addToFollowing(Subject subject)
    {
        following.addElement((User) subject);
    }
    
    public void postMessage(String message)
    {
        userMessages.add(message);
        this.message = message;
        newsFeed.addElement(this.toString() + ": " + message);
        notifyObservers();
    }
    
    public String getPostedMessage()
    {
        return message;
    }
    
    public DefaultListModel<String> getDashboardMessages()
    {
        return newsFeed;
    }
    
    public DefaultListModel<User> getFollowing()
    {
        return following;
    }
    
    public List<String> getUserMessages()
    {
        return userMessages;
    }
    
    @Override
    public String toString()
    {
        return username;
    }

    @Override
    public void update(Subject subject)
    {
        newsFeed.addElement(((User) subject).toString() + ": " + ((User) subject).getPostedMessage());
    }

    @Override
    public void accept(UserElementVisitor visitor)
    {
        visitor.visitUser(this);
        visitor.visitMessage(userMessages);
        visitor.visitPosMessage(userMessages);
    }
}
