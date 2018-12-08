public class testBagInteger 
{

    public static void main(String[] args)
    {
        Bag<Integer> bag1 = new Bag<>();
        
        if(bag1.isEmpty())
            System.out.println("Bag is empty!");
        
        bag1.add(1);
        
        if(!bag1.isEmpty())
            System.out.println("Bag is NOT empty!");
        
        //The figure in the report is based on these datas.
        bag1.add(15);
        bag1.add(20);
        bag1.add(36);
        bag1.add(13);
        bag1.add(5);
        bag1.add(27);
        bag1.add(16);
        bag1.add(28);
        bag1.add(37);
        bag1.add(3);
        bag1.add(4);
        bag1.add(4);
        bag1.add(5);
        bag1.add(7);
        bag1.add(9);
        bag1.add(10);
	bag1.add(7);
	bag1.add(7);
	bag1.add(7);
        bag1.add(10);
	bag1.add(37);
	bag1.add(27);
        
        System.out.println("Size of the bag is " + bag1.size());
        System.out.println("There are " + bag1.distinctSize() + " distinct elements in the Bag");
        
        if(bag1.contains(4))
            System.out.println("Bag contains \"4\"");
        
        System.out.println("There are " + bag1.elementSize(2) + " 2s");
        System.out.println("There are " + bag1.elementSize(7) + " 7s");
        
        bag1.clear();
        
        if(!bag1.remove(5))
            System.out.println("There is no \"5\"");
        
        bag1.add(6);
        bag1.add(5);
        bag1.add(7);
        bag1.add(7);
        bag1.add(8);
        bag1.add(9);
        bag1.remove(8);
        
        System.out.println(bag1.toString());
        
        bag1.clear();
        System.out.println(bag1.toString());
        
        bag1.add(5);
        bag1.add(7);
        bag1.add(7);
        bag1.add(8);
        bag1.add(9);
        
        System.out.println("There are " + bag1.distinctSize() +" distinct elements in the Bag");
        System.out.println("Size of the bag is " + bag1.size());
        
        bag1.remove(5);
        bag1.remove(7);
        bag1.remove(7);
        bag1.remove(8);
        bag1.remove(9);
        
        if(bag1.isEmpty())
            System.out.println("Bag is empty!");
    }
    
}
