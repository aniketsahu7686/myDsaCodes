import java.util.*;

// this code is to explain the logic or implementation of hashmap otherwise use the inbuilt hashmap 
public class hashFunctions{
    static class HashMap<K,V>{ // generics : means in hashmap we can have K(key) and V(value) in any types such as int long bool as we dont know it so simply write the generics there , where generics means the general type which means there will be some type as of now we dont know which type it will 
       // this class will define the nodes of the ll ,as every linkedlist node will be having a key and a value
       private class Node{
        K key;
        V value;

        public Node(K key, V value){
            this.key = key;
            this.value = value; 
        }
       }   

       private int n;  // n - total no of nodes 
       private int N;  // N - totol no of buckets
       private LinkedList <Node> buckets[];  // N - buckets.length



       @SuppressWarnings("unchecked");
    public HashMap(){
        this.N = 4;
        this.buckets = new LinkedList[4];
        for(int i=0;i<4;i++){
            this.buckets[i] = new LinkedList<>();
        }
    }

    public void put(K key,V value){
        // for the put function 
        // first find the bucket index
        //this will be my hashfunction which is my black box which will return the index (bucket index)  of the input key 
        int bi = hashFunction(key);
        // then check which index it contains 
        // now when we got the bucket index , we will see in every node that if my key exist there or not
        int di = searchInLL(key, bi); // will return the  data index 


        if (di==-1) { // key doesn't exist 
            // add the new key 
            buckets[bi].add(new Node(key, value));
            // and then increment 
            n++;
        }else{ // key exists
            Node node = buckets[bi].get(di);
            node .value = value;
        }

        double lambda = (double)n/N;
        if (lambda>2.0) {
            //rehasing
        }
    }

    //this function will take the key as input and return the bucket index 
    private int  hashFunction(K key){   // bucket index should be between 0 to n-1

        // here key.hashCode will change the key form and return the hash value
        int bi = key.hashCode();

        // this function can change the negative value to positive in java
        return Math.abs(bi)%N;

    }


    // this function is to search in the linked list 
    private int searchInLL(K key,int bi){
        LinkedList<Node> ll = buckets[bi];
        int di = 0;
        for(int i=0;i<ll.size();i++){
            if (ll.get(i).key == key) {
                return i; // di
            }
        }
        return -1;
    }

    private void rehash(){
        LinkedList<Node> oldBucket[] = buckets;
        buckets  = new LinkedList[N*2];

        for(int i=0;i<N*2;i++){
            buckets[i] = new LinkedList<>();
        }

        for(int i=0;i<oldBucket.length;i++){
            LinkedList<Node> ll = oldBucket[i];
            Node node = ll.get(i);
            put(node.key,node.value);
        }
    }


    // this function will return the value of the key asked
    public V get(K key){
         int bi = hashFunction(key);

        int di = searchInLL(key, bi); // will return the  data index 
        if (di==-1) { 
            return null;
        }else{ 
            Node node = buckets[bi].get(di);
            return node.value;
        }
    }
    }  
    
    
    // this function will return boolean if the key is present or not
    public boolean containsKey(K key){
        int bi = hashFunctions(key);
        int di = searchInLL(key,bi);

        if (di==-1) { // key doesn't exist
            return false;
        }else{ // key exists 
            return true;
        }
    }

    public V remove(K key){
        int bi = hashFunctions(key);
        int di = searchInLL(key,bi);

        if (di==-1) { // key doesn't exist
            return false;
        }else{ // key exists 
            Node node = bucket[bi].remove[di];
            return node.value;
        }
        return null; 
    }


    public ArrayList<K> keySet(){
        ArrayList<K> keys = new ArrayList<>();
            for(int i=0; i<buckets.length; i++) { //bi
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size(); j++) { //di
                Node node = ll.get(j);
                keys.add(node.key);
            }

        return keys;
    }
    }
    public boolean isEmpty(){
        return n==0; 
    }

    public static void main(String[] args) {
        // this object is from the class which we have created now 
        HashMap<String,Integer> map = new HashMap();
        map.put("India", 190);
        map.put("China", 200);
        map.put("US", 50);

        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }

        map.remove("India");
        System.out.println(map.get("India")); 
    }
}