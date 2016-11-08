/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

//-----------------------------------imports------------------------------------
import java.util.List;

/**
 * 
 */
public interface UserElementVisitor
{
//-----------------------------------methods------------------------------------
    /**
     * 
     * @param user
     */
    public void visitUser(User user);
    
    /**
     * 
     * @param group
     */
    public void visitGroup(UserGroup group);
    
    /**
     * 
     * @param messages
     */
    public void visitMessage(List<String> messages);
    
    /**
     * 
     * @param messages
     */
    public void visitPosMessage(List<String> messages);
}
