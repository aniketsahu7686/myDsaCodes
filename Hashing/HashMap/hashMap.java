// for use the hashmap we have to first import the hashMap
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class hashMap{
    public static void main(String[] args) {
        HashMap<String,Integer> hp = new HashMap<>();

        // for adding the key and it value (here key will always be unique  and the value of the keys can differ or can be same)
        // here we will take example of country(key) , population(value)
        hp.put("China", 50);
        hp.put("India", 25);
        hp.put("US", 5);

        System.out.println(hp);

        // this new value will be added 
        hp.put("China", 70);
        System.out.println(hp);


        // to search if the key exist or not
        if (hp.containsKey("China")) {
            System.out.println("key is present in the map");
        }else{
            System.out.println("key is not present in the map ");
        }

        // to know the value of the key 
        System.err.println(hp.get("China"));
        System.out.println(hp.get("US"));



        // to iterate the elements in the hashmap

        // way 1
        // Map.Entry interface in Java provides certain methods to access the entry in the Map. By gaining access to the entry of
        //  the Map we can easily manipulate them.

        for( Map.Entry<String,Integer> e : hp.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }


        // way 2
        Set<String> keys = hp.keySet();
        for(String key  : keys){
            System.out.println(key + " " + hp.get(key));
        }


        // to remove the keys 
        hp.remove("China");

        
    }
}