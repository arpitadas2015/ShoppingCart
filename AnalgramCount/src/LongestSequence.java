
public class LongestSequence {
	public static int LongestIncreasingSequence(int[] arr) { 
		  
	    // code goes here   
	    /* Note: In Java the return type of a function and the 
	       parameter types being passed are defined, so this return 
	       call must match the return type of the function.
	       You are free to modify the return type. */
	       
	      int count=0;
	      int finalCount=0;
	      
	for(int j=0;j<arr.length;j++){
	        for(int i=j+1;i<arr.length;i++){
	          int fisrtNumber=arr[j];
	       int secondNumber=arr[i];
	       if(secondNumber>=fisrtNumber){
	         count++;
	       }
	       
	       }
	        
	        
	       
	}   
	if(count>0){
        finalCount=finalCount+1;
      }
	    return finalCount;
	    
	  } 
	  
	  public static void main (String[] args) {  
	    // keep this function call here     
	    //Scanner s = new Scanner(System.in);
	    System.out.print(LongestIncreasingSequence(new int[] {9, 9, 4, 2})); 
	  }   
	  
}
