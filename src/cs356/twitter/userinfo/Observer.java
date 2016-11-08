package cs356.twitter.userinfo;
public interface Observer
{
    public void update(Subject subject);
    
    public void addToFollowing(Subject subject);
}
