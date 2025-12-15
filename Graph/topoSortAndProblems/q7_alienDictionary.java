package topoSortAndProblems;

import java.util.*;

public class q7_alienDictionary {
    // this is the normal toposort function whic h return the elements in the topological sort
    public static List<Integer> topoSort(int V,List<List<Integer>> adj){
        int[] indegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> qt = new LinkedList<>();
        for(int i=0;i<V;i++){
            if (indegree[i]==0) {
                qt.add(i);
            }
        }


        List<Integer> topo = new ArrayList<>();
        while (!qt.isEmpty()) {
            int node = qt.poll();
            topo.add(node);

            for(int it:adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0) {
                    qt.add(it);
                }
            }
        }
        return topo;
    }
    
    // function to find the order of characters for the alien dictionary 
    public static String findOrder(String[] dict,int N,int K){
        // first we will make a directed graph from the dictionary we have given,
        // so that further we can find the alien character order by using topo sort
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }


        // here we will compare two words at a time and assign the letter in the nummerical form at the graph
        for(int i=0;i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int ptr = 0;ptr < len; ptr++){
                if (s1.charAt(ptr)!=s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K,adj);
        String ans = " ";
        // here in ans we have to add the letter one by one in the order of list of characters (alien order) 
        // it: This is likely an integer variable that represents an index or a value.
        // (int)('a'): This casts the character 'a' to its corresponding ASCII (or Unicode) integer value. The ASCII value of 'a' 
        // is 97. So, (int)('a') equals 97.
        // (char)(it + (int)('a')): This expression converts the integer result of it + 97 back to a character.
        // ans = ans + (char)(it + (int)('a')): This appends the character resulting from the above computation to the string ans.
        for(int it:topo){
            ans = ans + (char)(it + (int)('a'));  
        }


        return ans;
    }

    public static void main(String[] args) {
        int N = 5,K = 4;
        String[] dict = {"baa","abcd","abca","cab","cad"};

        String ans = findOrder(dict, N, K);
        for(int i=0;i<ans.length();i++){
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println();
    }
}



// Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary, ‘len’ is the length up to the index where 
//                  the first inequality occurs, K = no. of nodes, and E = no. of edges.

// Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure used in 
//                   BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.