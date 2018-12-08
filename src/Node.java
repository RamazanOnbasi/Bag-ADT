public class Node<T extends Comparable<T>>
{
    private T data;
    private Node<T> left;
    private Node<T> right;
    private int number_of_instances;
    
    public Node()
    {
        data = null;
        left = null;
        right = null;
        number_of_instances = 0;
    }
    
    public Node(T d)
    {
        data = d;
        left = null;
        right = null;
        number_of_instances = 1;
    }
    
    public void decreaseNOI()
    {
        --number_of_instances;
    }
    
    public T getData() 
    { 
        return data; 
    }
    
    public Node<T> getLeft() 
    {
        return left; 
    }
    
    public int getNOI()
    {
        return number_of_instances;
    }
    
    public Node<T> getRight() 
    {
        return right; 
    }
    
    public boolean hasLeft()
    {
        return left != null;
    }
    
    public boolean hasRight()
    {
        return right != null;
    }
    
    public void increaseNOI()
    {
        ++number_of_instances;
    }
    
    public void setData(T newData)
    {
        data = newData;
    }
    
    public void setLeft(Node<T> newLeft) 
    {
        left = newLeft; 
    }
    
    public void setRight(Node<T> newRight) 
    {
        right = newRight; 
    }
    
}