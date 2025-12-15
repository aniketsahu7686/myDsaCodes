import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetEx {
    public static void main(String[] args) {
        // here everything will be same as hashset but the property changes
        // it will implement the property of set and it will also implement the propety of linkedlist
        // means the elements will be in it will be in the order we will add them
        // and everytime we print it , it will not change the order like hashset and 
        // will be printed in the same order which shows the property of linkedlist where order will be maintained
      Set<Integer> set = new LinkedHashSet<>();
      
      
      set.add(45);
      set.add(85);
      set.add(97);
      set.add(78);
      set.add(26);


      // the set will no contains the duplicate elements and the set will be print in different order everytime
      // hasing is used in the set
      System.out.println(set);

      set.remove(54);

      System.out.println(set);

      System.out.println(set.contains(85)); // return true or false


      System.out.println(set.isEmpty());

      System.out.println(set.size());


      set.clear();

      System.out.println(set);
    }
}
