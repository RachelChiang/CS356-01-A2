package cs356.twitter.userinfo;
import java.util.ArrayList;
import java.util.List;


public abstract class Subject
{
    // list of followers
    private List<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer observer)
    {
        // adding a new follower
        observers.add(observer);
        observer.addToFollowing(this);
    }
    
    public void detach(Observer observer)
    {
        // removing a follower
        observers.remove(observer);
    }
    
    public void notifyObservers()
    {
        for(Observer ob : observers)
        {
            ob.update(this);
        }
    }
}
