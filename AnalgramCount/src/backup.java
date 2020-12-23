import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class backup {
	
	
	public static int countAnagrams(String text, String word) 
    { 
        int N = text.length(); 
        int n = word.length(); 
  
        // Initialize result 
        int res = 0; 
  
        for (int i = 0; i <= N - n; i++) { 
  
            String s = text.substring(i, i + n); 
  
            // Check if the word and substring are 
            // anagram of each other. 
            if (araAnagram(word, s)) 
                res++; 
        } 
      
        return res; 
    } 
    
  public static boolean araAnagram(String s1, 
                              String s2) 
    { 
        // converting strings to char arrays 
        char[] ch1 = s1.toCharArray(); 
        char[] ch2 = s2.toCharArray(); 
  
        // sorting both char arrays 
        Arrays.sort(ch1); 
        Arrays.sort(ch2); 
  
        // Check for equality of strings 
        if (Arrays.equals(ch1, ch2)) 
            return true; 
        else
            return false; 
    } 
  
  
  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    String text=s.nextLine().toString();
    int count=0;
   //char inutArray[]= s.nextLine().toCharArray();
   String delimit=" ";
   StringTokenizer st= new StringTokenizer(text,delimit);
   while(st.hasMoreElements()){
     String word=st.nextElement().toString();
     int result = countAnagrams(text,word);
      count=count+result;
   }
System.out.println(count); 
}

}
