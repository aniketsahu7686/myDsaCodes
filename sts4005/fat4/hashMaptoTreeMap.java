package fat4;

import java.util.*;
class hashMaptoTreeMap {

    public static void main(String args[])
    {
        Map<Integer, String> hashMap = new HashMap<>();

        hashMap.put(1, "Geeks");
        hashMap.put(2, "forGeeks");
        hashMap.put(3, "A computer Portal");

        System.out.println("HashMap: " + hashMap);

        Map<Integer, String> treeMap = new TreeMap<>();
        treeMap.putAll(hashMap);
 
        System.out.println("TreeMap: " + treeMap);
    }
}
