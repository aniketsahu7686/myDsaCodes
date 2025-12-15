package topoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q4_courseSchedule1 {
    public static boolean courseSchedule(int noOfCourses,int noOfPrerequisites,ArrayList<ArrayList<Integer>> prerequisites){
        //first form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<noOfCourses;i++){
            adj.add(new ArrayList<>());
        }


        // Fill the adjacency list with prerequisites
        for(int i=0;i<noOfPrerequisites;i++){
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }



        // Now we will check if the graph made is a topological sort
        int indegree[] = new int[noOfCourses];
        for(int i=0;i<noOfCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++; 
            }
        }

        
        Queue<Integer> qt = new LinkedList<Integer>();
        for(int i=0;i<noOfCourses;i++){
            if (indegree[i]==0) {
                qt.add(i);
            }
        }

        
       List<Integer> topo = new ArrayList<Integer>();
        int ind = 0;

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


        if (topo.size()==noOfCourses) {
            return true;
        }
        else{
            return false;
        }



    }
    public static void main(String[] args){
        int noOfCourses = 4;
        int noOfPrerequisites = 3;

        ArrayList<ArrayList<Integer>>  prerequisites = new ArrayList<>();
        for(int i=0;i<noOfCourses;i++){
            prerequisites.add(i, new ArrayList<>());
        } 


        prerequisites.get(0).add(1);
        prerequisites.get(0).add(0);

        prerequisites.get(1).add(2);
        prerequisites.get(1).add(1);

        prerequisites.get(2).add(3);
        prerequisites.get(2).add(2);


        boolean ans = courseSchedule(noOfCourses,noOfPrerequisites,prerequisites);

        System.out.println(ans);
    }
}



//*********************************WHY poll IS BETTER THAN peek and remove***************************************
// Using poll() is generally better than using peek() followed by remove() in a queue because it is more concise, efficient, 
// and less error-prone. Here’s a detailed explanation:

// poll(): This method retrieves and removes the head of the queue in one operation.
// peek() and remove(): This requires two operations: one to retrieve the head (peek()) and one to remove it (remove()).





//****************** */ MEANING OF THIS LINE OF CODE ***********************************************************
// for(int i=0;i<noOfPrerequisites;i++){
//     adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
// }


// This loop is responsible for populating the adjacency list adj with the prerequisites.

// Variables
// m is the number of prerequisite pairs.
// prerequisites is an ArrayList of ArrayLists, where each inner ArrayList represents a prerequisite pair [a, b], 
//  meaning course a must be taken after course b.
// Loop Function
// For each prerequisite pair [a, b] in prerequisites, the code does the following:

// prerequisites.get(i).get(1): Retrieves course b, which is the prerequisite.
// prerequisites.get(i).get(0): Retrieves course a, which depends on course b.
// adj.get(b).add(a): Adds course a to the list of courses that depend on course b.
// Example
// Let's consider an example with 4 courses (0, 1, 2, 3) and 3 prerequisite pairs:

// Inputs
// n = 4 (number of courses)
// m = 3 (number of prerequisite pairs)
// prerequisites = [[1, 0], [2, 1], [3, 2]]
// Step-by-Step Execution
// Initialize the Adjacency List:

// java
// Copy code
// ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
// for (int i = 0; i < n; i++) {
//     adj.add(new ArrayList<>());
// }
// This creates adj as [[], [], [], []], an empty list for each course.

// Process Each Prerequisite Pair:

// For i = 0, prerequisites.get(0) is [1, 0]:

// prerequisites.get(0).get(1) is 0
// prerequisites.get(0).get(0) is 1
// adj.get(0).add(1): Add course 1 to the list for course 0
// Resulting adj: [[1], [], [], []]
// For i = 1, prerequisites.get(1) is [2, 1]:

// prerequisites.get(1).get(1) is 1
// prerequisites.get(1).get(0) is 2
// adj.get(1).add(2): Add course 2 to the list for course 1
// Resulting adj: [[1], [2], [], []]
// For i = 2, prerequisites.get(2) is [3, 2]:

// prerequisites.get(2).get(1) is 2
// prerequisites.get(2).get(0) is 3
// adj.get(2).add(3): Add course 3 to the list for course 2
// Resulting adj: [[1], [2], [3], []]