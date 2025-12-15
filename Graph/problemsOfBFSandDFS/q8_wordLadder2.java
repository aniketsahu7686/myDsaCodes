import java.util.*;

// In Java, a Comparator is used to define a custom order for sorting collections. The Comparator interface is part of the 
// java.util package and allows you to create custom comparison logic for objects, especially when you need to sort objects that 
// don't have a natural ordering or when the natural ordering isn't appropriate for the task.

class comp implements Comparator<ArrayList<String>> {
    public int compare (ArrayList<String> a, ArrayList<String> b){
        String x = " ";
        String y = " ";
        for(int i=0;i<a.size();i++){
            x += a.get(i);
        }
        for(int i=0;i<b.size();i++){
            y += b.get(i);
        }

        return x.compareTo(y);
    }
}

public class q8_wordLadder2 {
    // public static ArrayList<ArrayList<String>> findSequences(String[] wordList,String startWord,String targetWord){
    //     // push all the values of the wordlist to set , so that it will be easier for searching and deleting and in less time complexity
    //     Set<String> st = new HashSet<String>();
    //     int length = st.size();
    //     for(int i=0;i<length;i++){
    //         st.add(wordList[i]);
    //     }

    //     // Creating a queue which stores the words in an arraylist in a sequence which is required to reach the targetWord
    //     // after successive transformations.
    //     Queue<ArrayList<String>> qt = new LinkedList<ArrayList<String>>();

    //     ArrayList<String> ls = new ArrayList<>();
    //     ls.add(startWord);
    //     qt.add(ls);

    //     return ls;

    // }
    public static void main(String[] args){
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord  = "der";
        String targetWord = "dfs"; 

        // ArrayList<ArrayList<String>>  ans = findSequences(wordList,startWord,targetWord);

        // for(int i=0;i<ans.size();i++){
        //     for(int j=0;j<ans.get(i).size();j++){
        //         System.out.print(ans.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }
    }
}
