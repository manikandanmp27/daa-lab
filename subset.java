
import java.util.*;
public class subset {
	public static void calcsubset(int []set,int target,int i, List<Integer> cur) {
		if(target==0)
		{
			System.out.println(cur);
			return;
		}
		if(i==set.length ||target<0)
			return;
		cur.add(set[i]);
		calcsubset(set,target-set[i],i+1,cur);

		cur.remove(cur.size()-1);
		calcsubset(set,target,i+1,cur);
	}
	public static void main(String[] args) {
		try (Scanner sc = new Scanner (System.in)) {
			System.out.print("Enter size of set: ");
			int n=sc.nextInt();
			int set[]=new int[n];
			System.out.print("Enter elements of set: ");
			for(int i=0;i<n;i++)
				set[i]=sc.nextInt();
			System.out.print("Enter target: ");
			int t=sc.nextInt();
			List<Integer> current = new ArrayList<>();
			calcsubset(set,t,0,current);
		}
 	}
}