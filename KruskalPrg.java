import java.util.Scanner;

public class KruskalPrg {

    static int[] parent;  // 👈 moved here

    static int find(int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent[i]);
    }

    static void union(int x, int y) {
        int xset = find(x);
        int yset = find(y);
        parent[xset] = yset;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        parent = new int[n];  // 👈 initialize here
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int edges = 0, cost = 0;

        while (edges < n - 1) {
            int min = Integer.MAX_VALUE;
            int u = -1, v = -1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] < min && graph[i][j] != 0) {
                        min = graph[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int setU = find(u);
            int setV = find(v);

            if (setU != setV) {
                System.out.println((u + 1) + "->" + (v + 1) + "=" + min);
                cost += min;
                union(setU, setV);
                edges++;
            }

            graph[u][v] = graph[v][u] = Integer.MAX_VALUE;
        }

        System.out.println("Minimum cost=" + cost);
        sc.close();
    }
}