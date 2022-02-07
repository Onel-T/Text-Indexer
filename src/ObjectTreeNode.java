/**
 * ObjectTreeNode Class
 * Description: Contains methods in order to create Tree node
 * @author Onel Toma
 * @version 05/18/20
 */

public class ObjectTreeNode implements ObjectTreeNodeInterface{
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * Constuctor for the tree node
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * Constructor takes in an object for info in node 
     * @param o object to be placed in info
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * Setter for info field
     * @param o Object being set in info
     */
    public void setInfo(Object o) {
        info = o;
    }
    
    /**
     * Getter for the info field
     * @return info field in node
     */
    public Object getInfo() {
        return info;
    }
    
    /**
     * Setter for left child of node
     * @param p left child of node
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**
     * Getter for left child  of node
     * @return left child
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**
     * Setter for right child of node
     * @param p right child
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**
     * Getter for right of node
     * @return right child
     */
    public ObjectTreeNode getRight() {
        return right;
    }
}
