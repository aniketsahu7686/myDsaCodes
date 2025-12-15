import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionClass {
    public static void main(String[] args) {
         List<Integer> list = new ArrayList<>();
         list.add(34);   
         list.add(45); 
         list.add(78); 
         list.add(79); 
         list.add(10); 
         list.add(89); 
         list.add(92); 
         list.add(54); 
         list.add(77);  
         list.add(10); 
         
         // min element
         System.out.println(Collections.min(list));
         // max element
         System.out.println(Collections.max(list));

         // count the frequency of a number
         System.out.println(Collections.frequency(list, 10));


         // can sort any classed
         Collections.sort(list);

         // if it should be in reverse order , then pass a comparator inside it
         Collections.sort(list,Comparator.reverseOrder());
    }
}
