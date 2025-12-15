import java.util.HashSet;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();


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
