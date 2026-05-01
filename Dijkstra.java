
import java.util.*;

public class Dijkstra {
	 public static void dijkstra(int[][] graph, int n, int source) {

	        int[] dist = new int[n];       // distance array
	        boolean[] visited = new boolean[n]; // visited array
	        int[] parent = new int[n];     // to store path

	        // Step 1: Initialize
	        for (int i = 0; i < n; i++) {
	            dist[i] = 999;     // infinity
	            parent[i] = -1;
	        }
	        dist[source] = 0;
	        // Step 2: Find shortest paths
	        for (int count = 0; count < n; count++) {
	            // Find minimum distance unvisited node
	            int u = -1;
	            int min = 999;
	            for (int i = 0; i < n; i++) {
	                if (!visited[i] && dist[i] < min) {
	                    min = dist[i];
	                    u = i;
	                }
	            }
	            visited[u] = true;
	            // Step 3: Update neighbors
	            for (int v = 0; v < n; v++) {
	                if (!visited[v] && graph[u][v] != 999) {
	                    if (dist[u] + graph[u][v] < dist[v]) {
	                        dist[v] = dist[u] + graph[u][v];
	                        parent[v] = u;
	                    }
	                }
	            }
	        }
	        // Step 4: Print results
	        System.out.println("\nShortest paths from source " + source + ":");

	        for (int i = 0; i < n; i++) {
	            if (i != source) {
	                System.out.print("Path to " + i + ": ");
	                printPath(i, parent);
	                System.out.println(" | Cost = " + dist[i]);
	            }
	        }
	    }
	    // Recursive path printing
	    public static void printPath(int v, int[] parent) {
	        if (v == -1) return;
	        printPath(parent[v], parent);
	        System.out.print(v + " ");
	    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        System.out.println("Enter adjacency matrix (use 999 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, n, source);

        sc.close();
    }

   
}