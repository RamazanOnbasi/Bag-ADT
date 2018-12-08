public class testBagString
{
    public static void main(String[] args) 
    {
        Bag<String> bag1 = new Bag<>();
        
        if(bag1.isEmpty())
            System.out.println("Bag is empty!");
        
        bag1.add("V");
        
        if(!bag1.isEmpty())
            System.out.println("Bag is NOT empty!");
        
        bag1.add("M");
        bag1.add("M");
        bag1.add("M");
        bag1.add("I");
        bag1.add("I");
        bag1.add("I");
        
        System.out.println("Size of the bag is " +bag1.size());
        
        if(bag1.contains("I"))
            System.out.println("Bag contains \"I\"");
        
        System.out.println("There are " + bag1.elementSize("M") + " Ms");
        
        bag1.clear();
        
        if(!bag1.remove("A"))
            System.out.println("There is no \"A\"");
        
        bag1.add("G");
        bag1.add("A");
        bag1.add("B");
        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        bag1.remove("C");
        
        System.out.println(bag1.toString());
        
        bag1.clear();
        System.out.println(bag1.toString());
        
        bag1.add("A");
        bag1.add("B");
        bag1.add("B");
        bag1.add("C");
        bag1.add("D");
        
        System.out.println("There are " + bag1.distinctSize() + " distinct elements in the Bag");
        System.out.println("Size of the bag is " + bag1.size());
        
        bag1.remove("A");
        bag1.remove("B");
        bag1.remove("B");
        bag1.remove("C");
        bag1.remove("D");
        
        if(bag1.isEmpty())
            System.out.println("Bag is empty!");
    }
}
