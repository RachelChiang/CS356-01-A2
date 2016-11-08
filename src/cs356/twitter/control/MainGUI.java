package cs356.twitter.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import cs356.twitter.widgets.*;
import cs356.twitter.userinfo.*;
 
public class MainGUI extends JPanel 
                    implements ActionListener
    {
    
    protected static MainGUI instance;
    
    private JFrame mainframe;
    private JPanel contentPane;
    private UsersTree treePanel;
    private TextField addUserTextField;
    private TextField addGroupTextField;
    private TextArea statsTextArea;
    private List<Widget> widgets;
    
    private int xyOffset;
    
    private MainGUI()
    {
        xyOffset = 10;
        
        mainframe = new JFrame("Twitter (Admin)");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainframe.setBounds(100, 100, 700, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainframe.setContentPane(contentPane);
        contentPane.setLayout(null);
        mainframe.setVisible(true);
        
        treePanel = new UsersTree();
        populateTree(treePanel);
        statsTextArea = new TextArea("Greetings!", false);
        widgets = new LinkedList<Widget>();
        makeWidgets();
        
        for (Widget w : widgets)
        {
            contentPane.add(w.getJComponent());
        }
    }
    
    public static MainGUI getInstance()
    {
        if (instance == null)
        {
            instance = new MainGUI();
        }
        return instance;
    }
    
    private void makeWidgets()
    {
        widgets.add(new ScrollPane(10, 11, 300, 289, treePanel.getTree()));
        widgets.add(new Button("Add User", "add user", this, 560, 10, 114, 30));
        widgets.add(new Button("Make Group", "make group", this, 560, 51, 114, 30));
        addUserTextField = new TextField("(new username)", 320, 10, 230, 30);
        widgets.add(addUserTextField);
        addGroupTextField = new TextField("(new group name)", 320, 51, 230, 30);
        widgets.add(addGroupTextField);
        widgets.add(new ScrollPane(320, 92, 354, 85, statsTextArea.getJComponent()));
        widgets.add(new Button("Open User View", "open user", this, 320, 188, 354, 30));
        widgets.add(new Button("User Total", "show users", this, 320, 229, 170, 30));
        widgets.add(new Button("Group Total", "show groups", this, 505, 229, 169, 30));
        widgets.add(new Button("Messages Total", "show messages", this, 320, 270, 170, 30));
        widgets.add(new Button("Positive Percentage", "show percentage", this, 505, 270, 170, 30));
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();
        
        if (command.equals("add user"))
        {
            addUser();
        }
        else if (command.equals("make group"))
        {
            makeGroup();
        }
        else if (command.equals("open user"))
        {
            openUserView();
        }
        else if (command.equals("show users"))
        {
            statsTextArea.addText("Total Number of Users: " + makeVisitor().getUsersCounter());
        }
        else if (command.equals("show groups"))
        {
            statsTextArea.addText("Total Number of Groups: " + makeVisitor().getGroupsCounter());
        }
        else if (command.equals("show messages"))
        {
            statsTextArea.addText("Total Number of Messages: " + makeVisitor().getMessagesCounter());
        }
        else if (command.equals("show percentage"))
        {
            statsTextArea.addText("Message Positivity: " + (Math.round(makeVisitor().getPositivePercentage())) + "%");
        }
    }
    
    private void addUser()
    {
        String name = ((JTextField) addUserTextField.getJComponent()).getText();
        if (!(name.equals("")))
        {
            if (treePanel.addObject(new User(name)) != null)
            {
                addUserTextField.clear();
            }
            else
            {
                statsTextArea.addText("ERROR: Username must be unique. Only groups may have children.");
            }
        }
        else
        {
            statsTextArea.addText("ERROR: No username given.");
        }
    }
    
    private void makeGroup()
    {
        String name = ((JTextField) addGroupTextField.getJComponent()).getText();
        if (!(name.equals("")))
        {
            if (treePanel.addObject(new UserGroup(name)) != null)
            {
                addGroupTextField.clear();
            }
            else
            {
                statsTextArea.addText("ERROR: Group name must be unique.");
            }
        }
        else
        {
            statsTextArea.addText("ERROR: No group name given.");
        }
    }
    
    private void openUserView()
    {
        DefaultMutableTreeNode selectedElement = treePanel.getSelected();
        if (selectedElement != null)
        {
            if (selectedElement.getUserObject() instanceof User)
            {
                statsTextArea.addText("Opening " + selectedElement.getUserObject().toString() + "'s user view.");
                UserGUI userView = new UserGUI((User) selectedElement.getUserObject(), treePanel, xyOffset+=10, statsTextArea);
                if (xyOffset >= 170)
                {
                    xyOffset = 0;
                }
            }
        }
        else
        {
            statsTextArea.addText("ERROR: A user has not been selected.");
        }
    }
    
    private UserElementCounter makeVisitor()
    {
        UserElementCounter uec = new UserElementCounter();
        treePanel.accept(uec);
        return uec;
    }
    
    private void populateTree(UsersTree treePanel)
    {
        String p1Name = new String("Humans");
        String p2Name = new String("Animal Companions");
        String c1Name = new String("Danny");
        String c2Name = new String("Rae");
 
        DefaultMutableTreeNode p1, p2;
 
        p1 = treePanel.addObject(null, new UserGroup(p1Name));
        p2 = treePanel.addObject(null, new UserGroup(p2Name));
 
        treePanel.addObject(p1, new User(c1Name));
        treePanel.addObject(p1, new User(c2Name));
 
        treePanel.addObject(p2, new User("Mickey"));
        treePanel.addObject(p2, new User("Winston"));
        treePanel.addObject(p2, new User("Sheepy"));
        treePanel.addObject(p2, new User("Osiris"));
    }
}