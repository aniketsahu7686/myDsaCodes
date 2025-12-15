import java.util.*;

public class q7_wordLadder1 {
    // The Pair class should be static because it is being instantiated in a static method.
    static class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int wordLadder(String[] wordList,String startWord,String targetWord){

            // first push all the values in the wordlist into a set to make searching and deletion  easier and in less time complexity
            Set<String> st = new HashSet<String>();
            int length = wordList.length;
            for(int i=0;i<length;i++){
                st.add(wordList[i]);
            }

           // then we will create a  queue to store the words with its count
           Queue<Pair> qt = new LinkedList<>();

           // Bfs traversal works on the basis of values in the queue
           // so first in intially we will push the startword along with its count 1 in the queue
           qt.add(new Pair(startWord, 1));
           // after remove the startword from the set
           st.remove(startWord);

           while (!qt.isEmpty()) {
                String word = qt.peek().first;
                int  steps = qt.peek().second;
                qt.remove();

                // we will return the steps as soon as , we find the targetWord
                if (word.equals(targetWord)==true) {
                    return steps;
                }


                for(int i=0;i<word.length();i++){
                    for(char ch = 'a';ch<='z';ch++){
                        // first we will change the string word to char of Array
                        char[] wordCharArray = word.toCharArray();
                        // then replace one by one position with the alpahbets from a to z
                        wordCharArray[i] = ch;
                        String replacedWord = new String(wordCharArray);


                        // check if the replaceword is exists in the set,if it is add it to the queue and remove it from the set
                        if (st.contains(replacedWord)){
                            st.remove(replacedWord);
                            qt.add(new Pair(replacedWord, steps+1));
                        }                    
                    }
                }
           }
         return 0;
    }
    public static void main(String[] args){
        String[] wordList = {"des","der","dfr","dgt","dfs"};
        String startWord  = "der";
        String endWord = "dfs"; 

        int ans = wordLadder(wordList,startWord,endWord);
        System.out.println(ans);
    }
}



// Time Complexity: O(N * M * 26)
// Where N = size of wordList Array and M = word length of words present in the wordList..
// Note that, hashing operations in an unordered set takes O(1) time, but if you want to use set here, then the time complexity 
// would increase by a factor of log(N) as hashing operations in a set take O(log(N)) time.

// Space Complexity:  O( N ) { for creating an unordered set and copying all values from wordList into it }
// Where N = size of wordList Array.