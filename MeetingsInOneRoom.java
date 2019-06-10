import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * @author blackboi
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

What is the maximum number of meetings that can be accommodated in the meeting room?

Input:
The first line of input consists number of the test cases. The description of T test cases is as follows:
The first line consists of the size of the array, second line has the array containing the starting time of all the meetings each separated by a space, i.e., S [ i ]. And the third line has the array containing the finishing time of all the meetings each separated by a space, i.e., F [ i ].

Output:
In each separate line print the order in which the meetings take place separated by a space.

Input:
2
6
1 3 0 5 8 5
2 4 6 7 9 9
8
75250 50074 43659 8931 11273 27545 50879 77924
112960 114515 81825 93424 54316 35533 73383 160252  

Output:
1 2 4 5
6 7 1

 * 
 */

/*Test Case #1
 * Input:2
 * 6
 * 1 3 0 5 8 8
 * 2 4 6 7 9 9 
 * 
 * Output: 1 2 4 5
 * 
 * Test Case #2
 * Input:2
 * 8
 * 75250 50074 43659 43659 8931 11273 27545 50879 77924
 * 112960 114515 81825 93424 54316 35533 73383 160252  
 * 
 * Output: 6 7 1
 * */
public class MeetingsInOneRoom {

	//Creating a sort method for the Two dimensional Array in question
	public static void sortPair(Pair arr[], int a)
	{
		//Calls sort method to act on array
		Arrays.sort(arr, new Comparator<Pair>(){
			//Comparing the dimensions of array to one another
			@Override public int compare(Pair p1, Pair p2)
			{
				return p1.y - p2.y;
			}
		}
		);
	}
	//Finding matching times in input values
	public static int findPair(Pair[] p, int a, int ele) 
	{
		for(int i=0; i<a; i++)
		{
			if(p[i].y==ele) return i+1;
		}
		return -1;
	}
	
	public static void main(String[] args)  throws IOException{
		/*Scanner sc= new Scanner(System.in);
		System.out.println("How many meetings are taking place in this room");
		int n = sc.nextInt();
		
		System.out.println(n+ " Meetings are happening today in this room");
		*/
		
		//Using a Buffer to read lines
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine().trim());
		while(t-->0)
		{
			String inputLine[] =br.readLine().trim().split(" ");
			int a=Integer.parseInt(inputLine[0]);
			Pair[] p= new Pair[a];
			inputLine=br.readLine().trim().split(" ");
			for(int i=0; i<a;i++) {
				p[i]=new Pair();
				p[i].x=Integer.parseInt(inputLine[i]);
			}
			inputLine=br.readLine().trim().split(" ");
			for(int i=0; i<a;i++)
			{
				p[i].y=Integer.parseInt(inputLine[i]);
			}
			Pair[] p2= new Pair[a];
			p2=p.clone();
			sortPair(p, a);
			int last=0;
			for(int i=0; i<a; i++)
			{
				if(p[i].x>last) {
					System.out.print(findPair(p2, a, p[i].y) + " ");
					last=p[i].y;
				}
			}
			System.out.println();
		}
	}

}

	