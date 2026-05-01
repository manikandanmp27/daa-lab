
import java.util.*;

public class TSP {
    static int minCost = Integer.MAX_VALUE;

    public static void tsp(int node, int count, int cost, boolean[] visited, int[][] w, int n) {
        // Base case: all cities visited
        if (count == n) {
            cost += w[node][0]; // return to start
            minCost = Math.min(minCost, cost);
            return;
        }
        // Try all cities
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;

                tsp(i, count + 1, cost + w[node][i], visited, w, n);

                visited[i] = false; // backtrack
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        // Input weights
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    System.out.print("Enter cost from " + (i + 1) + " to " + (j + 1) + ": ");
                    w[i][j] = sc.nextInt();
                }
            }
        }
        boolean[] visited = new boolean[n];
        visited[0] = true; // start from city 0
        tsp(0, 1, 0, visited, w, n);
        System.out.println("Minimum cost: " + minCost);
        sc.close();
    }
}