/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

/**
 * 
 */
public class UserGroup implements UserElement
{
//-----------------------------------fields-------------------------------------
    /**
     * 
     */
    private String groupName;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     * @param name
     */
    public UserGroup(String name)
    {
        this.groupName = name;
    }
    
//-----------------------------------methods------------------------------------
    /**
     * 
     */
    @Override
    public String toString()
    {
        return groupName;
    }
    
    /**
     * 
     */
    @Override
    public void accept(UserElementVisitor visitor)
    {
        visitor.visitGroup(this);
    }
}
