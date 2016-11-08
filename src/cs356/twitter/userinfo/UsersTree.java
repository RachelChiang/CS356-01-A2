/**
 * Rachel Chiang
 * CS 356-01
 * Assignment 2: Mini Twitter
 */
package cs356.twitter.userinfo;

//-----------------------------------imports------------------------------------
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
 
/**
 * 
 */
public class UsersTree extends JPanel
{
//-----------------------------------fields-------------------------------------
    /**
     * 
     */
    private DefaultMutableTreeNode rootNode;
    
    /**
     * 
     */
    private DefaultTreeModel treeModel;
    
    /**
     * 
     */
    private JTree tree;
    
//---------------------------------constructor----------------------------------
    /**
     * 
     */
    public UsersTree()
    {
        setLayout(null);
         
        rootNode = new DefaultMutableTreeNode(new UserGroup("(root)"));
        treeModel = new DefaultTreeModel(rootNode);
        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);
    }
    
//-----------------------------------methods------------------------------------
    /** Add child to the currently selected node. */
    public DefaultMutableTreeNode addObject(UserElement child)
    {
        DefaultMutableTreeNode parentNode = getParentNode();
 
        return addObject(parentNode, child);
    }
    
    /**
     * 
     * @param parent
     * @param child
     * @return
     */
    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            UserElement child)
    {
        if (exists(child.toString()))
        {
            return null;
        }

        DefaultMutableTreeNode childNode = 
                new DefaultMutableTreeNode(child);

        if (parent == null)
        {
            parent = rootNode;
        }

        if (parent.getUserObject() instanceof UserGroup)
        {
            treeModel.insertNodeInto(childNode, parent, 
                    parent.getChildCount());

            tree.scrollPathToVisible(new TreePath(childNode.getPath()));

            return childNode;
        }
        else
        {
            return null;
        }
    }
    
    /**
     * 
     * @param visitor
     */
    public void accept(UserElementVisitor visitor)
    {
        DefaultMutableTreeNode current = rootNode.getNextNode();
        while (current != null)
        {
            ((UserElement) current.getUserObject()).accept(visitor);
            current = current.getNextNode();
        }
    }
    
    /**
     * 
     * @return
     */
    public JTree getTree()
    {
        return tree;
    }
    
    /**
     * 
     * @return
     */
    public DefaultMutableTreeNode getSelected()
    {
        DefaultMutableTreeNode node = getParentNode();
        if (node.getUserObject() instanceof UserGroup)
        {
            return null;
        }
        else
        {
            return node;
        }
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public UserElement getUser(String name)
    {
        DefaultMutableTreeNode current = rootNode;
        UserElement desired = null;
        while (current != null)
        {
            if (current.getUserObject().toString().equalsIgnoreCase(name))
            {
                desired = (UserElement) current.getUserObject();
            }
            current = current.getNextNode();
        }
        
        return desired;
    }
    
    /**
     * 
     * @return
     */
    private DefaultMutableTreeNode getParentNode()
    {
        TreePath parentPath = tree.getSelectionPath();
        
        DefaultMutableTreeNode parentNode = null;
        
 
        if (parentPath == null)
        {
            parentNode = rootNode;
        }
        else
        {
            parentNode = (DefaultMutableTreeNode)
                         (parentPath.getLastPathComponent());
        }
        return parentNode;
    }
    
    /**
     * 
     * @param name
     * @return
     */
    private boolean exists(String name)
    {
        if (getUser(name) == null)
        {
            return false;
        }
        return true;
    }
}
