
import java.util.*; 
import java.io.*;

public class CountAnalgram {
	

	
	  
	  public static void main(String[] args)
	    {
	          Scanner s = new Scanner(System.in);
	    String stringEntered=s.nextLine().toString();
	         
	         int count=0;
	   //char inutArray[]= s.nextLine().toCharArray();
	   String delimit=" ";
	   StringTokenizer st= new StringTokenizer(stringEntered,delimit);
	   while(st.hasMoreElements()){
	     String word=st.nextElement().toString();
	     if(checkAnagram(stringEntered,word)){
	      count=count+1;
	     }
	        
	   }  
	   System.out.println(count); 
	       // scanner.close();
	    }
	    
	    public static boolean checkAnagram(String stringEntered, String s2)
	    {
	        // Remove all the white space
	        //s1 = s1.replaceAll("\\s", "");
	        //s2 = s2.replaceAll("\\s", "");
	        String delimit=" ";
	   StringTokenizer st= new StringTokenizer(stringEntered,delimit);
	   while(st.hasMoreElements()){
	     String s1=st.nextElement().toString();
	     
	        // Check if both length matches
	        if(s1.length() != s2.length())
	            return false;
	        else
	        {
	            // Convert both Strings into lower case and into Character Array
	            char[] arr1 = s1.toLowerCase().toCharArray();
	            char[] arr2 = s2.toLowerCase().toCharArray();
	            
	            // Sort both Character Array
	            Arrays.sort(arr1);
	            Arrays.sort(arr2);
	            
	            // Check if both arrays are equal
	            return (Arrays.equals(arr1, arr2));
	        }
	    }
	   return false;
	    }

	
}


	  



