
import java.util.*;
public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) wt[i] = sc.nextInt();
        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) val[i] = sc.nextInt();
        System.out.print("Enter capacity: ");
        int W = sc.nextInt();
        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {

                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        // Print DP matrix
        System.out.println("\nDP Matrix:");
        for (int[] row : dp) {
            for (int x : row)
                System.out.print(x + " ");
            System.out.println();
        }
        System.out.println("\nMaximum value: " + dp[n][W]);
        sc.close();
    }
}