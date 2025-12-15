package topoSortAndProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class q5_courseSchedule2 {
    public static int[] courseSchedule(int noOfCourses,int noOfPrerequisites,ArrayList<ArrayList<Integer>> prerequisites){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < noOfCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < noOfPrerequisites; i++) {
            adj.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }



        int indegree[] = new int[noOfCourses];
        for (int i = 0; i < noOfCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }


        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < noOfCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }


        int topo[] = new int[noOfCourses];
        int ind = 0;
        // o(v + e)
        while (!q.isEmpty()) {
            int node = q.peek();

            q.remove();
            topo[ind++] = node;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }



        if (ind==noOfCourses) {
            return topo;
        }
        int[] ans = {};
        return ans;
    }
    public static void main(String[] args){
         int noOfCourses= 4;
        int noOfPrerequisites= 3;
        ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
        for (int i = 0; i < noOfCourses; i++) {
            prerequisites.add(i, new ArrayList<>());
        }


        prerequisites.get(0).add(0);
        prerequisites.get(0).add(1);

        prerequisites.get(1).add(1);
        prerequisites.get(1).add(2);

        prerequisites.get(2).add(2);
        prerequisites.get(2).add(3);

        int[] ans = courseSchedule(noOfCourses,noOfPrerequisites,prerequisites);

        for (int task : ans) {
            System.out.print(task + " ");
        }
        System.out.println("");
    }
}
