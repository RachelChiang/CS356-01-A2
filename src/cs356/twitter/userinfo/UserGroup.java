/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

public class UserGroup implements UserElement
{
    private String groupName;
    
    public UserGroup(String name)
    {
        this.groupName = name;
    }
    
    @Override
    public String toString()
    {
        return groupName;
    }

    @Override
    public void accept(UserElementVisitor visitor)
    {
        visitor.visitGroup(this);
    }
}
