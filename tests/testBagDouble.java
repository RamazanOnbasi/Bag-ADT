public class testBagDouble
{
    public static void main(String[] args)
    {
        Bag<Double> bag1 = new Bag<>();
        
        if(bag1.isEmpty())
            System.out.println("Bag is empty!");
        
        bag1.add(1.1);
        
        if(!bag1.isEmpty())
            System.out.println("Bag is NOT empty!");
        
        bag1.add(2.2);
        bag1.add(2.2);
        bag1.add(2.2);
        bag1.add(3.3);
        bag1.add(4.4);
        bag1.add(4.4);
        
        System.out.println("Size of the bag is " +bag1.size());
        
        if(bag1.contains(4.4))
            System.out.println("Bag contains \"4.4\"");
        
        System.out.println("There are " + bag1.elementSize(2.2) +  " 2.2s");
        
        bag1.clear();
        
        if(!bag1.remove(5.5))
            System.out.println("There is no \"5.5\"");
        
        bag1.add(6.6);
        bag1.add(5.5);
        bag1.add(7.7);
        bag1.add(7.7);
        bag1.add(8.8);
        bag1.add(9.9);
        bag1.remove(8.8);
        
        System.out.println(bag1.toString());
        
        bag1.clear();
        System.out.println(bag1.toString());
        
        bag1.add(5.5);
        bag1.add(7.7);
        bag1.add(7.7);
        bag1.add(8.8);
        bag1.add(9.9);
        
        System.out.println("There are " + bag1.distinctSize() + " distinct elements in the Bag");
        System.out.println("Size of the bag is " + bag1.size());
        
        bag1.remove(5.5);
        bag1.remove(7.7);
        bag1.remove(7.7);
        bag1.remove(8.8);
        bag1.remove(9.9);
        
                if(bag1.isEmpty())
            System.out.println("Bag is empty!");
    } 
}