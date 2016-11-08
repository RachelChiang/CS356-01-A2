package cs356.twitter.userinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserElementCounter implements UserElementVisitor
{
    private int usersCounter;
    private int groupsCounter;
    private int messagesCounter;
    private double positiveMessagesCounter;
    private List<String> positiveWords;
    
    public UserElementCounter()
    {
        usersCounter = 0;
        groupsCounter = 0;
        messagesCounter = 0;
        positiveMessagesCounter = 0;
        populatePositiveList();
    }
    
    @Override
    public void visitUser(User user)
    {
        ++usersCounter;
    }

    @Override
    public void visitGroup(UserGroup group)
    {
        ++groupsCounter;
    }
    
    @Override
    public void visitMessage(List<String> messages)
    {
        for (String m : messages)
        {
            ++messagesCounter;
        }
    }
    
    @Override
    public void visitPosMessage(List<String> messages)
    {
        for (String m : messages)
        {
            if (isPositive(m))
            {
                ++positiveMessagesCounter;
            }
        }
    }
    
    private boolean isPositive(String message)
    {
        for (String w : positiveWords)
        {
            if (message.contains(w))
            {
                return true;
            }
        }
        return false;
    }
    
    private void populatePositiveList()
    {
        String[] niceWords = {"good", "great", "excellent", "fantastic", 
                ":D", ":)", ":3", ":]", "happy", "fine", "fabulous", "fun",
                "delicious", "beautiful", "lovely", "awesome", "Good", "Great", "Excellent", "Fantastic", "Happy", "Fine", "Fabulous", "Fun",
                "Delicious", "Beautiful", "Lovely", "Awesome"};
        positiveWords = Arrays.asList(niceWords);
    }
    
    public int getUsersCounter()
    {
        return usersCounter;
    }
    
    public int getGroupsCounter()
    {
        return groupsCounter;
    }
    
    public int getMessagesCounter()
    {
        return messagesCounter;
    }
    
    public double getPositivePercentage()
    {
        if (messagesCounter == 0)
        {
            return 0;
        }
        return ((positiveMessagesCounter / messagesCounter) * 100);
    }
}
