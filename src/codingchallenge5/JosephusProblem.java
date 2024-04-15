package codingchallenge5;

import java.util.*;

public class JosephusProblem {

    public static void main(String[] args) {
    	
    	//Declare and initialize variables for no. of people, elimination interval & starting index
    	int N = 0;
    	int K = 0;
    	int S = 0;
    	
        Scanner scan = new Scanner(System.in);
        
        	//Prompts the user to input the values.
        	N = getUserInput("Number of People (N): ", scan, false);			//False - Won't accept zero values
        	K = getUserInput("Elimination Interval (K): ", scan, false);		//False - Won't accept zero values
        	S = getUserInput("Starting index (S): ", scan, true);				//True - Will accept zero values
        
        
        //Create an arraylist to store the number of people in the queue.
        List<Integer> people = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) 	//Populates the arraylist using the value of N.
        {
            people.add(i);
        }
        
        int currentindex = S;		//Initializes the list index to the starting value (to keep track of current position in the list).
        
        while (people.size() > 1) 
        {															//Calculates the index that should be eliminated.
            currentindex = (currentindex + K - 1) % people.size();		//The % ensures that currentindex wraps around to the beginning of the list when list size is exceeded.
            people.remove(currentindex);								//Removes the index from the list.
        }
        
        System.out.println("Position of the last person remaining: " + people.get(0));		//Prints out last index left in the list.
        
    }
    
    
    //Method to determine the validity of the user input.
    private static int getUserInput(String message, Scanner scan, boolean allowZero) 
    {
    	//Declare and initialize variables.
        int userinput = 0;				
        boolean isValid = false;	
        
        do {
            try 
            {
                System.out.print(message);		//Prints prompt messages.
                userinput = scan.nextInt();		//Accepts user input.
                
                /**
                 * In the Josephus problem, the Number of People (N) and the Elimination Index (K) should NOT be zero, 
                 * so the user should NOT be allowed to enter 0 for this value.
                 *
                 * It's fine if the Starting Index (S) is zero though, so zero values should be accepts for this input.
                 * 
                 * The if statement below will deal with this.
                 */
                
                if (!allowZero && userinput <= 0) 	//Checks if the user has entered a negative number OR a zero value where it's not allowed.
                {
                    System.out.println("Invalid input. Please enter a number greater than 0.");		//Prompts user to re-enter a non-zero/non-negative integer.
                } 
                else 
                {
                    isValid = true;
                }
            } catch (InputMismatchException e) {		//Catches any other type of invalid user input (non-integer values)
                System.out.println("Invalid input. Please enter an integer");	//Prompts user to re-enter the value.
                scan.next();
            }
        } while (!isValid);		//Will repeat constantly until the user enter valid input.
        
        return userinput;
    }


}




/**
 * 									OUTPUT:
 * 		TEST CASE #1: 		(when the user inputs something that's not an integer, like words or characters)
 * 
 * 		Number of People (N): five
		Invalid input. Please enter an integer
		Number of People (N): 5
		Elimination Interval (K): four?
		Invalid input. Please enter an integer
		Elimination Interval (K): 4
		Starting index (S): zero!
		Invalid input. Please enter an integer
		Starting index (S): 0
		Position of the last person remaining: 1
		
		
		
		TEST CASE #2:		(when the user inputs 0 where it's not allowed) (not allowed for N and K)
		
		Number of People (N): 0
		Invalid input. Please enter a number greater than 0.
		Number of People (N): 5
		Elimination Interval (K): 0
		Invalid input. Please enter a number greater than 0.
		Elimination Interval (K): 4
		Starting index (S): 0
		Position of the last person remaining: 1
 * 
 * 
 * 		TEST CASE #3:		(regular input)
 * 
 * 		Number of People (N): 5
		Elimination Interval (K): 4
		Starting index (S): 0
		Position of the last person remaining: 1
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
