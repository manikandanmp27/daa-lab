
import java.util.*;
public class SimplePrims {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        int[][] w = new int[n][n];
        System.out.println("Enter weighted graph (use 999 for no edge):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                w[i][j] = sc.nextInt();
        System.out.print("Enter source vertex: ");
        int s = sc.nextInt();
        boolean[] selected = new boolean[n];
        selected[s] = true;
        int edges = 0, totalCost = 0;
        System.out.println("\nEdges in MST:");
        while (edges < n - 1) {
            int min = 999, u = -1, v = -1;
            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    for (int j = 0; j < n; j++) {
                        if (!selected[j] && w[i][j] < min) {
                            min = w[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            selected[v] = true;
            totalCost += min;
            edges++;
            System.out.println(u + " -> " + v + " = " + min);
        }
        System.out.println("Cost of MST = " + totalCost);
        sc.close();
    }
}