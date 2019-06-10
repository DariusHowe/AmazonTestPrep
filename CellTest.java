
/**There is a grouping of houses, 8, all in a straight line.
 * Each day every cell competes with its adjacent cells(neighbor). 
 * Each day, for each cell, if its neighbors are both active or both inactive, the cell becomes inactive the next day.
 * Otherwise, it becomes active the next day.
 * The two cells on the ends have single adjacent cell, so the other adjacent cell can be assumed to be always inactive.
 * Even after updating the cell state, consider its previous state for updating the state of other cells.
 * Update the cell information of all cells simultaneously.
 * Write a function cellComplete which takes one 9-element array of integer cells and one integer days representing the number of days to simulate.
 * An integer value of 1 represents an active cell and value of 0 represents an inactive cell.
 * @author blackboi
 */
/*Test cAses
 * TestCase1:
 * Input {1,0,0,0,0,1,0,0}, 1
 * Output {0,1,0,0,1,0,1,0"
 * 
 * TestCase2:
 * Input{1,1,1,0,1,1,1,1}, 2
 * Output{0,0,0,0,0,1,1,0}
 * */
import java.util.*;
import java.util.stream.Collectors;
public class CellTest {

	private List<Integer> finalStates=new ArrayList<>();
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int arr[] = {1,0,0,0,0,1,0,0};
		int days=1;
		CellTest eightHousePuzzle = new CellTest();
		int day2=2;
		int arr2[]= {1,1,1,0,1,1,1,1};
		System.out.println("Input Values tested are: " + Arrays.toString(arr) + " after " + days + " days");
		System.out.println(eightHousePuzzle.cellCompete(arr,days));
		System.out.println("Input Values to be Tested are: " + Arrays.toString(arr2) + " after " + day2 + " days");
		System.out.println(eightHousePuzzle.cellCompete(arr2,day2));
	}
	
	public List<Integer> cellCompete(int[] states, int days)
	{
		List<Integer> currentCellStates=Arrays.stream(states).boxed().collect(Collectors.toList());
		return getCellStateAfterNDays(currentCellStates,days);
	}
	
	private List<Integer> getCellStateAfterNDays(List<Integer> currentCellStates, int days)
	{
		List<Integer> changedCellStates= new ArrayList<>();
		int stateEmpty =0;
		if(days!=0)
		{
			for(int i=0; i<currentCellStates.size();i++)
			{
				if(i==0)
				{
					changedCellStates.add(calculateCellState(stateEmpty, currentCellStates.get(i+1)));
				}
				else if(i==7)
				{
					changedCellStates.add(calculateCellState(currentCellStates.get(i-1),stateEmpty));
				}
				else
				{
					changedCellStates.add(calculateCellState(currentCellStates.get(i-1), currentCellStates.get(i+1)));
				}
			}	
		}
		if(days==1)
		{
			finalStates= new ArrayList<>(changedCellStates);
			return finalStates;
		}
		days=days-1;
		getCellStateAfterNDays(changedCellStates, days);
		return finalStates;
	}
	private int calculateCellState(int previousL, int previousR)
	{
		if((previousL==0 && previousR==0) ||(previousL==1 && previousR==1))
		{
			return 0;
		}
		return 1;
	}
}
