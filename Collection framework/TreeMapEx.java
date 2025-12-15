import java.util.TreeMap;
import java.util.Map;

public class TreeMapEx {
    public static void main(String[] args) {
        // here in TreeMap the elements will work on keys
        // they will be in sorted order
         Map<String,Integer> num = new TreeMap<>();

        num.put("One", 1);
        num.put("two", 2);
        num.put("three", 3);

        System.out.println(num);
        // it will just replace the value
        num.put("two",22);

        System.out.println(num);

        // for removing any key
        num.remove("one");

        // see this same behaviour
        // first
        if (!num.containsKey("two")) {
             num.put("two", 20);
        }
        // second
        num.putIfAbsent("two", 20);


        // check if the value present in the map or not
        System.out.println(   num.containsValue(26));

        // for empty or not
        System.out.println(num.isEmpty());


        // iteration

        for(Map.Entry<String,Integer> e: num.entrySet()){
            // we can print the entries
            System.out.println(e);

            // when we want to print only the keys
            System.out.println(e.getKey());

            // when we want to print only the values
            System.out.println(e.getValue());
        }

        // when we want to print only the keys set
        for(String key:num.keySet()){
            System.out.println(key);
        }

        // when we want to print only the value set
        for(Integer value :num.values()){
            System.out.println(value);
        }


            // for clearing the map
            num.clear();
    }
}
