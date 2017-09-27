package calculator;


public class Main {

	 /**
     * 主函数入口
     */
    public static void main(String[] args) {  
    	
    	String testString="3/4+1/5÷2/3×1/2";
    	DoubleStack testStack = new DoubleStack(testString);  
    	testStack.analysisString();  
    	System.out.println(testStack.compute());
    } 
}
