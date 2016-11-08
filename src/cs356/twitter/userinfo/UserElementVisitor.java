/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

import java.util.List;

public interface UserElementVisitor
{
    public void visitUser(User user);
    public void visitGroup(UserGroup group);
    public void visitMessage(List<String> messages);
    public void visitPosMessage(List<String> messages);
}
