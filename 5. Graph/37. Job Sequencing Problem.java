


//     https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1


import java.util.*;
class Solution {

    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    int[] parent;

    int[] JobScheduling(Job arr[], int n) {
        parent = new int[101];

        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int count = 0;
        int profit = 0;

        for (Job j : arr) {
            int empty = find(j.deadline);

            if (empty > 0) {
                count++;
                profit += j.profit;
                parent[empty] = find(empty - 1);
            }
        }

        return new int[] { count, profit };

    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}
