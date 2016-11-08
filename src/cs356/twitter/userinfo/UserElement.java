/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

public interface UserElement
{
//-----------------------------------methods------------------------------------
    public String toString();
    public void accept(UserElementVisitor visitor);
}
