package calculator;


public class Test {

    public static void main(String[] args) {  
    	
    	String testString="3÷(3÷0)";
    	DoubleStack testStack = new DoubleStack(testString);  
    	testStack.analysisString();  
    	System.out.println(testStack.compute());
    	
    } 
}
