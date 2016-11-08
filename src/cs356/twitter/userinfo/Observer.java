/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

public interface Observer
{
    public void update(Subject subject);
    
    public void addToFollowing(Subject subject);
}
