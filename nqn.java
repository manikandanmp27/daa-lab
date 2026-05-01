
import java.util.Arrays;
import java.util.Scanner;

public class nqn {
	public static void Nqs(int n,int row,int[] col) {
		if(row == n) {
			System.out.println("\n"+Arrays.toString(col));
			displayboard(col,n);
			}
		for(int i = 0;i<n;i++) {
			boolean safe = true;
			for(int r = 0;r<row;r++)
				if(col[r]==i || Math.abs(col[r]-i ) == row-r)
					safe = false;
			if(safe) {
				col[row] = i;
				Nqs(n,row+1,col);
				}
			}
		}
	public static void displayboard(int[] board,int N) {
		for(int i = 0;i < N; i++) {
			for(int j = 0;j < N ; j++) {
				
				if(board[i]==j)
					System.out.print(" Q ");
				else
					System.out.print(" _ ");
				}
			System.out.println();
				
		}
}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter the value of N: ");
		int N = sc.nextInt();
		int []c = new int[N];
		Arrays.fill(c,-1);
		Nqs(N,0,c);
		sc.close();
	}

}