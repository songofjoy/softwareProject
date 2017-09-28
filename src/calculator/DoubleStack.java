package calculator;

import java.util.ArrayList;
import java.util.Stack;  

/**
 * 高级软件工程
 * @author Song
 *
 */
public class DoubleStack {  

	private ArrayList<String> testString=new ArrayList<>(); 
    private Stack<String> stack = null;  
    private ArrayList<String> createStrings=new ArrayList<>(); 
    
    public DoubleStack(String testString) {  
        this.testString = string2array(testString);  
        this.stack = new Stack<String>();  
    }  
    /**
     * 打印逆波兰表达式和
     */
    public void printCreString(){
    	System.out.println(createStrings);
    }
    /**
     * 根据逆波兰表达式计算值
     */
    public String compute(){
    	
    	String ERRORINFO="The Function Is Wrong!";
    	try{
        	if(createStrings==null||createStrings.size()==0){
        		return ERRORINFO;
        	}
        	while(createStrings.size()!=1){
        		int i;
        		for(i=0;i<createStrings.size();i++){
        			if(ComputeController.isSign(createStrings.get(i))){
        				if(i-2<0){return ERRORINFO;}
        				String compute=ComputeController.exec(createStrings.get(i-2), createStrings.get(i-1), createStrings.get(i));
        				createStrings.set(i-2, compute);
        				createStrings.remove(i);
        				createStrings.remove(i-1);
        				break;
        			}
        			else if(i==createStrings.size()-1){return ERRORINFO;}
        		}
        	}
    	}
    	catch(Exception e){
    		return ERRORINFO;
    	}
    
    	return createStrings.get(0);
    }
    /**
     * 逆波兰 双栈
     */
    public ArrayList<String> analysisString() {  
        for (int i = 0; i < testString.size(); i++) {  
            String c = testString.get(i);  
            if (c.equals("+") || c.equals("-")) {  
                if (stack.isEmpty() || stack.peek().equals("(")) {  
                    stack.push(c);  
                } else {  
                    while (!stack.isEmpty()  
                            && (stack.peek().equals("×") || stack.peek().equals("÷")  
                                    || stack.peek().equals("+") || stack.peek().equals("-"))) {  
                    	createStrings.add(stack.pop());
                    }  
                    stack.push(c);  
                }  
            } else if (c.equals("×")|| c.equals("÷")) {  
                if (stack.isEmpty() || stack.peek().equals("+")
                        || stack.peek().equals("-") || stack.peek().equals("(")) {  
                    stack.push(c);  
                } else {  
                    while (!stack.isEmpty()  
                            && (stack.peek().equals("÷") || stack.peek().equals("×"))) {  
                     	createStrings.add(stack.pop());
                    }  
                    stack.push(c);  
                }  
            } else if (c.equals("(")) {  
                stack.push(c);  
            } else if (c.equals(")") ){  
                String temp = "";  
                while (!(temp = stack.pop()).equals("(")) {  
                 	createStrings.add(temp);
                }  
            } else {  
            	createStrings.add(c);
            }  
        }  
        if (!stack.isEmpty()) {  
            while (!stack.isEmpty()) {  
            	createStrings.add(stack.pop());
            }  
        }  
        return createStrings;
    }  
    /**
     * string转array
     * @param input
     * @return
     */
    public static ArrayList<String> string2array(String input){
    	
    	String curString="";
    	ArrayList<String> strings=new ArrayList<>();
    	for(int i=0;i<input.length();i++){
    		char curchar=input.charAt(i);
    		if(curchar<58&&curchar>47||curchar=='/'){curString+=curchar;}
    		else{
    			if(!curString.equals("")){strings.add(curString);}
    			strings.add(""+curchar);curString="";
    		}
    	}
    	if(strings.get(0).equals("+")||strings.get(0).equals("-")){strings.add(0, "0");}
    	if(!curString.equals("")) {strings.add(curString);}
    	
    	return strings;
    }
    
  
}  