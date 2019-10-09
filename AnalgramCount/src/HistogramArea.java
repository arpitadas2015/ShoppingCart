import java.util.Arrays;
import java.util.Scanner;

public class HistogramArea {
	 public static int HistogramArea(int[] arr) { 
		  
		    // code goes here   
		    /* Note: In Java the return type of a function and the 
		       parameter types being passed are defined, so this return 
		       call must match the return type of the function.
		       You are free to modify the return type. */
		 arr=new int[] {6, 3, 1, 4, 12, 4};
	Arrays.sort(arr);
	 Arrays.sort(arr);
     int value=0;
      int getMax=arr[0];
      int getSecondMax=arr[1];
		       int areaCount=0;
		       int maxArearCount=0;
		       int perviousArearCount=0;
		       for(int i=0;i<arr.length;i++){
		    	   if(i==0){
		    		   perviousArearCount=0; 
		    	   }
		    	   if(i==1){
		    		   perviousArearCount=arr[1]+arr[2];
		    	   }
		    	   maxArearCount=arr[i]+arr[i+1];
		    	   if(maxArearCount>perviousArearCount){
		    		   perviousArearCount=maxArearCount;
		    	   }
		    	   
		       }
		       
		    return perviousArearCount*1;
		    
		  } 
		  
		  public static void main (String[] args) {  
		    // keep this function call here     
			  HistogramArea(new int[] {6, 3, 1, 4, 12, 4});
		    Scanner s = new Scanner(System.in);
		   // System.out.print(new int[]{)); 
		    
		  }   
		  
}
