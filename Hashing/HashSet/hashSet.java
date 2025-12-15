// so for creating a hashset we have to first import the hashset
import java.util.HashSet;
// for using the iterator 
import java.util.Iterator;

public class hashSet{
    public static void main(String[] args){
        // creating a hashset
        HashSet<Integer> hs = new HashSet<>();

        // for inserting the elements in hashset
        hs.add(1);  
        hs.add(2);
        hs.add(3);
        hs.add(1);
        

        // if the elements contains in hashset or not
        if (hs.contains(1)) {
            System.out.println("contains");
        }
        if (!hs.contains(1)) {
            System.out.println("doesn't contains");
        }


        // for deleting the element
        hs.remove(1);

        // to know the size of the set
        System.out.println(hs.size());


        //to print all the elements 
        System.err.println(hs);



        // in hashset   and hashmap  we are having a special iterator to iterate all the elements , to use it first we have to import
        //  the Iterator 

        // This iterator has two functions:
        // one is * hasNext (it.hasNext--> true or false)
        // second is * next ( it.next--> 1  , it.next-->2 , it.next-->3)
        // NOTE : the element which we will iterate through will have no guarantee that it will iterate in the same order as we have
        //        inserted in the Hashset , it can be jumbled , it can be in soreted order or something else
        Iterator it = hs.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}