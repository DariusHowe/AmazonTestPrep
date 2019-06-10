import java.util.*;
public class SubClass {
/*Given an unsorted array A of size N of non-negative integers, find a continuous sub-array
 *  which adds to a given number S.
Input:
The first line of input contains an integer T denoting the number of test cases.
 Then T test cases follow. Each test case consists of two lines. 
 The first line of each test case is N and S, where N is the size of array and S is the sum. 
 The second line of each test case contains N space separated integers denoting the array elements.

Output:
For each testcase, in a new line, print the starting and ending positions(1 indexing) of first 
such occuring subarray from the left if sum equals to subarray, else print -1.

Constraints:
1 <= T <= 100
1 <= N <= 107
1 <= Ai <= 1010
*/
	public static void main(String[] args)
	{
		//Create a scanner to read input for size of array
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		
		//set restrictions on edges of array
		for( int i=0; i< t;i++)
		{
			//n is size of array
			int n=sc.nextInt();
			//s is sum of elements in array
			int s=sc.nextInt();
			
			//Create array of size n
			int m[]=new int[n];
			for (int j=0; j<n;j++)
			{
				m[j]=sc.nextInt();
			}
			findSubArray(n,s,m);
		}
	}
	public static void findSubArray(int n, int s, int [] m)
	{
		int first=0;
		int end=0;
		
		long result=m[first];
		
		//Creating cases for testing various inputs
		while(result!=s)
		{
			if(result>s)
			{
				if(first==end)
				{
					end++;
					first++;
					if(end>=n)
						break;
					result=m[first];
				}
				else {
					result-=m[first];
					first++;
				}
			}
			else {
				end++;
				if(end<n)
				{
					result+=m[end];
					
				}
				else {
					break;
				}
			}
		}
		if(result!=s)
		{
			System.out.println(-1);
		}
		
		else {
			System.out.println((first +1) + " " + (end +1));
		}
		
	}
}
