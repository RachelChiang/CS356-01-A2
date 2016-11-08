/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

//-----------------------------------imports------------------------------------
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

/**
 * This class represents a User, which is a {@link Subject}, {@link Observer],
 * and a {@link UserElement}. The user has many functions, which it inherits 
 * from the Subject class and which it must implement from the UserElement and
 * Observer classes.
 */
public class User extends Subject implements UserElement, Observer
{
//-----------------------------------fields-------------------------------------
    /**
     * 
     */
    private String username;
    
    /**
     * 
     */
    private String message;
    
    /**
     * 
     */
    private List<String> userMessages;
    
    /**
     * 
     */
    private DefaultListModel<String> newsFeed;
    
    /**
     * 
     */
    private DefaultListModel<User> following;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param username
     */
    public User(String username)
    {
        this.username = username;
        newsFeed = new DefaultListModel<String>();
        userMessages = new ArrayList<String>();
        message = "";
        following = new DefaultListModel<User>();
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    @Override
    public void update(Subject subject)
    {
        newsFeed.addElement(((User) subject).toString() + ": " + 
                            ((User) subject).getPostedMessage());
    }
    
    @Override
    public void addToFollowing(Subject subject)
    {
        following.addElement((User) subject);
    }

    @Override
    public void accept(UserElementVisitor visitor)
    {
        visitor.visitUser(this);
        visitor.visitMessage(userMessages);
        visitor.visitPosMessage(userMessages);
    }
    
    @Override
    public String toString()
    {
        return username;
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
}
