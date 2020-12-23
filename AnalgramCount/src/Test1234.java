
public class Test1234 {
	
public static void main(String args[]){
	
	adder(1);
}

		static void adder(int N) {
	        int zero=0;
	        int one=1;
	        int two=2;
	        int n=N;

	        if(N==0){
	            System.out.println(N);

	        }
	        if(N==1){
	            adder(n);
	            
	        }
	        if(N==2){
	            adder(n);
	            adder(n-1);
	            
	        }
	        if(N==3){
	            adder(n);
	            adder(n-1);
	            adder(n-2);
	        }
	        if(N>3){
	            
	            adder(n-0);
	            adder(n-1);
	            adder(n-2);
	            adder(n-3);
	        }


	        for(int j=0; j<N; j++){
	            if(N==0){
	                System.out.println(N);
	            }
	            if(N==1){
	                System.out.println(N);
	            }
	            if(N==2){
	                System.out.println(N);
	            
	            }
	            if(N>=3){
	                int result= result(N-1)+result(N-2)+ result(N-3);
	                System.out.println(result);
	            }
	        }
	        
	        
	    }


	    static int result(int q){
	        
	            return q=q-1;
	        
	    }


}
