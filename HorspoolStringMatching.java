import java.util.Scanner;
public class HorspoolStringMatching {

	public static int[] shiftTable(String pattern)
	{
		int m=pattern.length();
		int[] table=new int[256];
		for(int i=0;i<256;i++)
			table[i]=m;
		for(int i=0;i<m-1;i++)
			table[pattern.charAt(i)]=m-i-1;
		return table;
	}
	public static int horspoolSearch(String text,String pattern)
	{
		int n=text.length();
		int m=pattern.length();
		if(m>n)
			return -1;
		int[] table=shiftTable(pattern);
		int i=m-1;
		while(i<n)
		{
			int k=0;
			while(k<m && pattern.charAt(m-1-k)==text.charAt(i-k))
				k++;
			if(k==m)
				return i-m-1;
			else
				i+=table[text.charAt(i)];
		}
		return -1;
	}
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the text:");
		String text=sc.nextLine();
		System.out.print("Enter the pattern:");
		String pattern=sc.nextLine();
		long startTime=System.nanoTime();
		int index=horspoolSearch(text,pattern);
		long endTime=System.nanoTime();
		if(index!=1)
			System.out.print("Pattern found at index "+index);
		else
			System.out.print("Pattern not found");
		double timeElapsed=(endTime-startTime)/1e6;
		System.out.print("Time Taken:"+timeElapsed+"milliseconds");
		sc.close();
	}
}
