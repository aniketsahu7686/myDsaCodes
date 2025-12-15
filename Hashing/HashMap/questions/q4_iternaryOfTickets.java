package questions;

import java.util.HashMap;

public class q4_iternaryOfTickets {

    public static String getStart(HashMap<String,String> map){
        // this will be the reverse Map in which the values of the keys of the map will appear as keys and keys as values 
        // this is used to find the starting city
        HashMap<String,String> revMap = new HashMap<>();

        // advance loop for making the reverse loop 
        for(String key:map.keySet()){
            revMap.put(map.get(key), key); 
        }

        // now check the keys of the map in the reverse map if it not there return the starting point otherwise return null 
        for(String key:map.keySet()){
            if (!revMap.containsKey(key)) {
                // return the starting city 
                return key;
            }
        }

        return null;

    }
    public static void main(String[] args) {
        HashMap<String,String> mp = new HashMap<>();
        mp.put("Chennai", "Bengaluru");
        mp.put("Mumbai", "Delhi");
        mp.put("Goa", "Chennai");
        mp.put("Delhi", "Goa");

        // set the start for the mp
        String start =  getStart(mp);

        // now we will check if the mp conatains the start or not , if it contains we will print it 
        while (mp.containsKey(start)) {
            System.out.print(start + "->");
            // and update the start to the value of the key city as we moving from one city to another
            start = mp.get(start);
        }
        // this one is for the last start
        System.out.println(start);
    }
}
