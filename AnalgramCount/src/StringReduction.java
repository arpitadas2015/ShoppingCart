import java.util.Scanner;

import java.util.*; 
import java.io.*;

public class StringReduction {
	 public static String StringReduction(String str) { 
	// code goes here   
    /* Note: In Java the return type of a function and the 
       parameter types being passed are defined, so this return 
       call must match the return type of the function.
       You are free to modify the return type. */
			 String newString="";
	       String repaceCharFirst="ab";
	       String firstReplaceTo="c";
	        String repaceCharSecond="bc";
	       String secondReplaceTo="a";
	        String repaceCharThird="ca";
	       String thirdReplaceTo="b";
	       
	       String subsrting=str.substring(0,2);
	       if(subsrting.equalsIgnoreCase(repaceCharFirst)){
	    	   newString="c"+ str.substring(3,str.length());
	       }
	       if(subsrting.equalsIgnoreCase(repaceCharSecond)){
	    	   newString="c"+ str.substring(3,str.length());
	       }
	       
	       if(subsrting.equalsIgnoreCase(repaceCharThird)){
	    	   newString="c"+ str.substring(3,str.length());
	       }
	       
	       if(newString.isEmpty()){
	    	   return str;
	       }
	       
	    return newString;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.println("Eneter");
    int count=0;
    String resultString="";
    String inputString=s.nextLine().toString();
   // System.out.print(StringReduction(s.nextLine())); 
    while(inputString.length()>2 && (inputString.length()!= resultString.length())){
    	if(count==0){
    	 resultString=StringReduction(inputString);
    	 count++;
    	}
    	 if(count==1){
    		 resultString=StringReduction(resultString);
    	 }
    	 inputString=resultString;
    	 
    }
    System.out.print(resultString.length());
  }   
  
}
