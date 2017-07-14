import java.util.Stack;

public class RpnClaculator {
	Stack st = new Stack();
	
	public static void main(String agrs[]) {
		RpnClaculator rpnClaculator = new RpnClaculator();
		try {
			//rpnClaculator.rpnCalc("5 2");
			//rpnClaculator.rpnCalc("2 sqrt clear 9 sqrt");
			//rpnClaculator.rpnCalc("5 2 - clear");
			//rpnClaculator.rpnCalc("5 4 3 2 undo undo *");
			//rpnClaculator.rpnCalc("7 12 2 /");
			//rpnClaculator.rpnCalc("1 2 3 4 5 * * * *");
			 rpnClaculator.rpnCalc("1 2 3 * 5 + * * 6 5");
			//rpnClaculator.rpnCalc("3 4 *");
		} catch(Exception ex){
			System.out.println(ex.getMessage());
		}

	}
	
	private void rpnCalc(String strRpn) throws Exception {
		String input = strRpn;
		String[] elements = input.split(" ");
		for(int i=0;i<elements.length;i++) {
			String value = elements[i];
			try {
				Integer valueInt = Integer.parseInt(value);
				createStatck(valueInt.toString());
			}catch(NumberFormatException nfex){
				//if not number then operation
				String operation = returnOperation(value);
				if(st.isEmpty()) {
					throw new Exception("Stack is empty");
				}
				if(st.size()<2){
					throw new Exception("operator <"+operation+"> "
							+ "(position: <"+st.indexOf(value)+">): insufficient parameters");
				}
				if(operation.contentEquals("+")){
					try{
					Integer int1 = Integer.parseInt((String) st.pop());
					Integer int2 = Integer.parseInt((String) st.pop());
					Integer result = int1+int2;
					st.push(result.toString());
					System.out.println("stack:: " + st.toString());
					}catch(NumberFormatException nfrmex){
						throw new NumberFormatException("stack value :: " + st.toString());
					}
				}
				if(operation.contentEquals("-")){
					try{
					Integer int1 = Integer.parseInt((String) st.pop());
					Integer int2 = Integer.parseInt((String) st.pop());
					Integer result = int2-int1;
					st.push(result.toString());
					System.out.println("stack:: " + st.toString());
					}catch(NumberFormatException nfrmex){
						throw new NumberFormatException("stack value :: " + st.toString());
					}
				}
				if(operation.contentEquals("*")){
					try{
					Integer int1 = Integer.parseInt((String) st.pop());
					Integer int2 = Integer.parseInt((String) st.pop());
					Integer result = int1 * int2;
					st.push(result.toString());
					System.out.println("stack:: " + st.toString());
					}catch(NumberFormatException nfrmex){
						throw new NumberFormatException("stack value :: " + st.toString());
					}
				}
				if(operation.contentEquals("/")){
					try{
					Integer int1 = Integer.parseInt((String) st.pop());
					Integer int2 = Integer.parseInt((String) st.pop());
					Integer result = int2/int1;
					st.push(result.toString());
					System.out.println("stack:: " + st.toString());
					}catch(NumberFormatException nfrmex){
						throw new NumberFormatException("stack value :: " + st.toString());
					}
				}
				if(operation.contentEquals("sqrt")){
					try{
					Integer int1 = Integer.parseInt((String) st.pop());
					Double result = Math.sqrt(int1.doubleValue());
					st.push(result.toString());
					System.out.println("stack:: " + st.toString());
					}catch(NumberFormatException nfrmex){
						throw new NumberFormatException("stack value :: " + st.toString());
					}
				}
				if(operation.contentEquals("popOne")){
						st.pop();
					    System.out.println("stack:: " + st.toString());
				}
				if(operation.contentEquals("popAll")){
					for(int j=0;j<st.size();j++){
						st.pop();
					}
				    System.out.println("stack:: " + st.toString());
			}
			}
		}
		System.out.println("stack:: " + st.toString());
	}
	
	/**
	 * Available operators are +, -, *, /, sqrt, undo, clear,
	 * The 'undo' operator undoes the previous operation. 
	 * "undo undo" will undo the previous two operations.
	 * Note - Considering only previous 2 undo.
	 * 
	 * @param oprValue
	 * @return operation
	 */
	private String returnOperation(String oprValue) {
		if(oprValue.equalsIgnoreCase("+")){
			return "+";
		}
		if(oprValue.equalsIgnoreCase("-")) {
			return "-";
		}
		if(oprValue.equalsIgnoreCase("*")){
			return "*";
		}
		if(oprValue.equalsIgnoreCase("/")){
			return "/";
		}
		if(oprValue.equalsIgnoreCase("sqrt")){
			return "sqrt";
		}
		if(oprValue.equalsIgnoreCase("undo")){
			return "popOne";
		}
		if(oprValue.equalsIgnoreCase("clear")){
			return "popAll";
		}
		return null;
		
	}
	
	private void createStatck(String str){ 
		 st.push(str);
	}
	

}
