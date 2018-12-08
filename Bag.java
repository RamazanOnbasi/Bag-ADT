public class Bag<T extends Comparable<T>>
{
    private Node<T> root;
    private int distinct_element_size;
    private int size;
    
    public Bag()
    {
        root = null;
        distinct_element_size = 0;
        size = 0;
    }
    
    public Bag(T d)
    {
        root = new Node<>(d);
        distinct_element_size = 1;
        size = 1;
    }

    //Uses iteration rather than recursion.
    public void add(T item)
    {
        if(contains(item))
            getNode(item).increaseNOI();
        
        else
        {
            if(isEmpty())
                root = new Node<>(item);
            
            else
            {
                Node<T> newNode = new Node<>(item);
                Node<T> tempNode = root;
                
                while(tempNode != null)
                {
                    if(tempNode.getData().compareTo(item)>0)
                    {
                        if(!tempNode.hasLeft())
                        {
                            tempNode.setLeft(newNode);
                            break;
                        }
                        
                        else
                            tempNode = tempNode.getLeft();
                    }
                    
                    else if(tempNode.getData().compareTo(item)<0)
                    {
                        if(!tempNode.hasRight())
                        {
                            tempNode.setRight(newNode);
                            break;
                        }
                        
                        else
                            tempNode = tempNode.getRight(); 
                    }
                } 
            }
          ++distinct_element_size;
        }         
      ++size;
    }
    
    public void clear()
    {
        root = null;
        distinct_element_size = 0;
        size = 0;
    }
    
    public boolean contains(T item)
    {
        if(isEmpty())
            return false;
        
        else
            {
                Node tempNode = root;
            
                while(tempNode != null)
                {
                    if(tempNode.getData().equals(item))
                        return true;
            
                    else if(tempNode.getData().compareTo(item)>0)
                        tempNode = tempNode.getLeft();
            
                    else if(tempNode.getData().compareTo(item)<0)
                        tempNode = tempNode.getRight();  
                } 
            }
        
        return false;
    }
    
    public int distinctSize()
    {
        return distinct_element_size;
    }
    
    public int elementSize(T item)
    {
        if(!contains(item))
            return 0;
        
        else
            return getNode(item).getNOI();
    }
    
    public Node<T> findGreatest(Node<T> node)
    {  
        while(node.hasRight())
            node = node.getRight();
        
        return node;
    }
    
    protected Node<T> findSecondGreatest(Node<T> greatestNode, Node<T> tempNode)
    {
        while(!tempNode.getRight().getData().equals(greatestNode.getData()))
            tempNode = tempNode.getRight();
        
        return tempNode;
    }
    
    protected Node<T> findSecondSmallest(Node<T> smallestNode, Node<T> tempNode)
    {
        while(!tempNode.getLeft().getData().equals(smallestNode.getData()))
            tempNode = tempNode.getLeft();
        
        return tempNode;
    }
    
    public Node<T> findSmallest(Node<T> node)
    {
        while(node.hasLeft())
            node = node.getLeft();
        
        return node;
    } 
    
    protected Node<T> getNode(T item)
    {
            Node tempNode = root;
            
            while(tempNode != null)
            {
                if(tempNode.getData().equals(item))
                break;
            
                else if(tempNode.getData().compareTo(item)>0)
                tempNode = tempNode.getLeft();
            
                else if(tempNode.getData().compareTo(item)<0)
                tempNode = tempNode.getRight();
            }
        
        return tempNode;
    }
    
    public boolean isEmpty()
    {
        return root == null;
    }

    //Uses iteration rather than recursion.
    public boolean remove(T item)
    {
        if(!contains(item))
            return false;
        
        else
        {
            if(elementSize(item)>1)
                getNode(item).decreaseNOI();
            
            else
            {
                Node<T> tempNode = getNode(item);
                
                if(tempNode.hasLeft() && tempNode.hasRight())
                {
                    if(!tempNode.getLeft().hasRight() && !tempNode.getRight().hasLeft())
                    {
                        tempNode.setData(tempNode.getRight().getData());
                        tempNode.setRight(tempNode.getRight().getRight());
                    }
                        
                    else if(tempNode.getRight().hasLeft())   
                    {
                        tempNode.setData(findSmallest(tempNode.getRight()).getData());
                        findSecondSmallest(findSmallest(tempNode.getRight()), tempNode).setLeft(findSmallest(tempNode.getRight()).getRight());
                    }
                    
                    else
                    {
                        tempNode.setData(findGreatest(tempNode.getLeft()).getData());
                        findSecondGreatest(findGreatest(tempNode.getLeft()), tempNode).setRight(findGreatest(tempNode.getLeft()).getLeft());
                    }
                }
                
                else
                {
                    if(root.getData().equals(item))
                    {
                        if(root.hasLeft())
                        {
                            root.setData(root.getLeft().getData());
                            root.setLeft(root.getLeft().getLeft());
                            root.setRight(root.getLeft().getRight());       
                        }
                            
                        else if(root.hasRight())
                        {
                            root.setData(root.getRight().getData());
                            root.setLeft(root.getRight().getLeft());
                            root.setRight(root.getRight().getRight());  
                        }
                            
                        else
                            root = null;
                    }
                    
                    else
                    {
                        Node<T> tempNode2 = root;
                    
                        while(!tempNode2.getData().equals(item))
                        {
                            if(tempNode2.hasLeft() && tempNode2.hasRight())
                            {
                                if(!tempNode2.getLeft().getData().equals(item) && !tempNode2.getRight().getData().equals(item))
                                {
                                    if(tempNode2.getData().compareTo(item)>0)
                                        tempNode2 = tempNode2.getLeft();
                        
                                    else if(tempNode2.getData().compareTo(item)<0)
                                        tempNode2 = tempNode2.getRight();
                                }
                            }
                            
                            else if(tempNode2.hasLeft() && !tempNode2.hasRight())
                            {
                                if(!tempNode2.getLeft().getData().equals(item))
                                    if(tempNode2.getData().compareTo(item)>0)
                                        tempNode2 = tempNode2.getLeft();
                            }
                            
                            else
                            {
                                if(!tempNode2.getRight().getData().equals(item))
                                    if(tempNode2.getData().compareTo(item)<0)
                                        tempNode2 = tempNode2.getRight();
                            }   
                            
                            if(tempNode2.hasLeft())
                                if(tempNode2.getLeft().getData().equals(item))
                                    break;
                      
                            if(tempNode2.hasRight())
                                if(tempNode2.getRight().getData().equals(item))
                                    break;               
                        }
                    
                        if(tempNode2.hasLeft())
                        {
                            if(tempNode2.getLeft().getData().equals(item))
                            {
                                if(!tempNode.hasLeft() && !tempNode.hasRight())
                                    tempNode2.setLeft(null);
                    
                                else if(!tempNode.hasLeft() || !tempNode.hasRight())
                                {
                                    if(!tempNode.hasLeft())
                                        tempNode2.setLeft(tempNode.getRight());                            
                        
                                    else
                                        tempNode2.setLeft(tempNode.getLeft());
                                }
                            }
                        }

                        else if(tempNode2.hasRight())
                        {
                            if(tempNode2.getRight().getData().equals(item))
                            {
                                if(!tempNode.hasLeft() && !tempNode.hasRight())
                                    tempNode2.setRight(null);
                    
                                else if(!tempNode.hasLeft() || !tempNode.hasRight())
                                {
                                    if(!tempNode.hasLeft())
                                        tempNode2.setRight(tempNode.getRight());                            
                        
                                    else
                                        tempNode2.setRight(tempNode.getLeft());
                                }
                            }    
                        }
                    }
                }
              --distinct_element_size;
            }
          --size;
          return true;
        } 
    }
    
    public int size()
    {
        return size;
    }
    
    @Override
    public String toString()
    {     
        if (isEmpty())
            return "Bag is empty!";
        
        else
        {
            String bag = "";
            Node<T> tempNode, tempNode2;
            
            tempNode = root;
            
            while (tempNode != null) 
            {
                if (!tempNode.hasLeft()) 
                {
                    for(int i=0; i<tempNode.getNOI(); ++i)
                    {
                        bag += tempNode.getData() + " ";
                    }
                
                    tempNode = tempNode.getRight();
                }
                
                else
                {
                    tempNode2 = tempNode.getLeft();
                    
                    while (tempNode2.hasRight() && !tempNode2.getRight().equals(tempNode))
                    {
                        tempNode2 = tempNode2.getRight();
                    }
                    
                    if (!tempNode2.hasRight()) 
                    {
                        tempNode2.setRight(tempNode);
                        tempNode = tempNode.getLeft();
                    } 
                
                    else
                    {
                        tempNode2.setRight(null);
                    
                        for(int i=0; i<tempNode.getNOI(); ++i)
                        {
                            bag += tempNode.getData() + " ";
                        }

                        tempNode = tempNode.getRight();
                    }
                }
            }
          return bag;
        }
    }
    
}