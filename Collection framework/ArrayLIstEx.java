import java.util.ArrayList;
import java.util.*;


public class ArrayLIstEx {
    public static void main(String[] args) {
        // this is an object which will be  available from the java.uti (package)
        ArrayList<Integer> a = new ArrayList<>();

        // functions

        // for adding
        a.add(1);
        a.add(4);
        a.add(8);
        a.add(2);
        a.add(9);

        // for removing
        a.remove(1);  // either index or
        a.remove(Integer.valueOf(8));

        // for clear all the values
        a.clear();


        // to get the file
        System.out.println(a.get(1));

         // when we want to  replace element
         a.set(2, 10);


         // if we want to see if the element contains in the arraylist or not
         // it returns either true or false
         System.out.println(a.contains(8));


         // How to do iteration in arraylist
         // we have three process
         
         // first one : for loop
         for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
         }

         // second one : for each loop (recommended method)
         for(Integer it:a){
            System.out.println(it);
         }

         // third one : Iterator method
         Iterator<Integer> it = a.iterator();
         while (it.hasNext()) {
            System.out.println(it.next());
         }
    }
}