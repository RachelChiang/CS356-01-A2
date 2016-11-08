package cs356.twitter.userinfo;

public interface UserElement
{
    public String toString();
    public void accept(UserElementVisitor visitor);
}
