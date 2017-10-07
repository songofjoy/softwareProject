package calculator;

//import java.io.IOException;

public class Equation {

	//创建算式
	public static  StringBuffer createEquation()  {
		
		StringBuffer s = new StringBuffer(" ");
		while(true){
			int i,p=(int)(Math.random()*9)+2;//p表示随机生成的数的个数
			int[] fac=new int[2]; 
			boolean flag=true; //判断运算符是否为“÷”
			s = new StringBuffer(" ");
			for(i=0;i<p;i++)
			{
				if((int)(Math.random()*2)==0)
					s.append("(");
				if(flag){
					if((int)(Math.random()*2)==1)
						s.append((int)(Math.random()*100));//随机生成一个100以内的整数
					else{  //随机生成一个真分数
						fac[1]=(int)(Math.random()*10)+1;  //随机生成一个不为0的小于10的分母
						fac[0]=(int)(Math.random()*fac[1]);  
						s.append(ComputeController.simplify(fac));
					}
					if(calBra(s,'(')>calBra(s,')'))
					{
						if((int)(Math.random()*2)==0)
							s.append(")");
					}
					if(i<p-1){
						switch((int)(Math.random()*4))
						{
							case 0:s.append("+");break;
							case 1:s.append("-");break;
							case 2:s.append("×");break;
							case 3:s.append("÷");flag=false;break;
						}
					}
					else
						s.append("=");
				}
				else{
					if((int)(Math.random()*2)==1)
						s.append((int)(Math.random()*99)+1);//随机生成一个100以内不为0的整数
					else{  //随机生成一个真分数
						fac[0]=0;
						while(fac[0]==0){
							fac[1]=(int)(Math.random()*10)+1;  //随机生成一个不为0的小于10的分母
							fac[0]=(int)(Math.random()*fac[1]); 
						}
						s.append(ComputeController.simplify(fac));
					}
					if(i<p-1){
						switch((int)(Math.random()*4))
						{
							case 0:s.append("+");break;
							case 1:s.append("-");break;
							case 2:s.append("×");break;
							case 3:s.append("÷");flag=false;break;
						}
					}
					else
						s.append("=");
				}
			}
			s=delred(match(s));
			System.out.println(s.deleteCharAt(0));
			String temps=s.substring(0,s.length()-1);
			DoubleStack testStack = new DoubleStack(temps);  
	    	testStack.analysisString();  
	    	
	    	//检验生成式，如果不合法重新生成
	    	if(!testStack.compute().toString().equals(DoubleStack.ERRORINFO)){
				break;
	    	}
		}
		
		return s;
		
	}
	public static StringBuffer getIndexofBra(StringBuffer s,char c)
	{
		StringBuffer sb=new StringBuffer("");
		int i;
		for(i=0;i<s.length();i++){
			if(s.charAt(i)==c)
				sb.append(i+"#");
		}
		return sb;
	}
	public static int calBra(StringBuffer s,char c){ //计算括号个数
		int i,sum=0;
		for(i=0;i<s.length();i++)
		{
			if(s.charAt(i)==c)
				sum++;
		}
		return sum;
	}
	public static StringBuffer delred(StringBuffer s){  //删除多余的左括号
		int i,j;
		StringBuffer sb1=new StringBuffer(getIndexofBra(s,'('));
		StringBuffer sb2=new StringBuffer(getIndexofBra(s,')'));
		String[] str1=sb1.toString().split("#");	
		String[] str2=sb2.toString().split("#");
		if(sb2.length()>0&&sb1.length()>sb2.length()){
			for(i=0;i<str2.length&&str1.length-i+1>str2.length;i++){
				for(j=0;j<str1.length-i&&Integer.parseInt(str1[j])<Integer.parseInt(str2[i]);j++);
				while(j<str1.length-i)
					str1[j-1]=str1[j++];	
			}
			for(i=0;i<(str1.length-str2.length);i++)
				s.deleteCharAt(Integer.parseInt(str1[i])-i);
		}	
		if(sb2.length()==0&&sb1.length()>0){
			for(i=0;i<str1.length;i++)
				s.deleteCharAt(Integer.parseInt(str1[i])-i);
		}
		return s;
	}
	public static StringBuffer match(StringBuffer s){  //对括号进行匹配
		int i=0,j;
		StringBuffer sb1=new StringBuffer(getIndexofBra(s,'('));	
		StringBuffer sb2=new StringBuffer(getIndexofBra(s,')'));
		String[] str1=sb1.toString().split("#");
		String[] str2=sb2.toString().split("#");
		if(sb1.length()!=0)
		{
			while(i<calBra(s,')')){
				for(j=0;j<calBra(s,'(')&&Integer.parseInt(str1[j])<Integer.parseInt(str2[i]);j++);
				if(s.substring(Integer.parseInt(str1[j-1]), Integer.parseInt(str2[i])+1).contains(")")){  //判断括号是否重叠
					StringBuffer sb3=new StringBuffer(s.substring(Integer.parseInt(str1[j-1]), Integer.parseInt(str2[i])+1));
					while(calBra(sb3,'(')!=calBra(sb3,')')){
						j--;
						sb3=new StringBuffer(s.substring(Integer.parseInt(str1[j-1]), Integer.parseInt(str2[i])+1));
					}
				}
				if(isValid(s.substring(Integer.parseInt(str1[j-1])-1, Integer.parseInt(str2[i])+2),s.length())==0)
				{
					s.deleteCharAt(Integer.parseInt(str2[i]));	
					s.deleteCharAt(Integer.parseInt(str1[j-1]));
					sb1=new StringBuffer(getIndexofBra(s,'('));
					sb2=new StringBuffer(getIndexofBra(s,')'));
					str1=sb1.toString().split("#");
					str2=sb2.toString().split("#");
				}
				else
					i++;		
			}	
		}
		return s;
		
	}
	public static int isValid(String s,int length){   //判断括号是否有效
		int i;
		String s1=s.substring(2, s.length()-2);
		StringBuffer s2=new StringBuffer(s1);
		while(s2.toString().contains("("))
			s2.replace(s2.indexOf("("), s2.indexOf(")"), "1");
		while(s2.toString().contains(")"))
			s2.deleteCharAt(s2.indexOf(")"));
		if(s.length()==length)
			return 0;
		else if(!s1.contains("+")&&!s1.contains("-")&&!s1.contains("×")&&!s1.contains("÷"))
			return 0;
		else{
			if(s.charAt(0)=='+'||s.charAt(0)==' ')
			{
				if(s.charAt(s.length()-1)=='-'||s.charAt(s.length()-1)=='+'||s.charAt(s.length()-1)=='=')
					return 0;
				else
				{
					for(i=0;i<s2.length();i++)
					{
						if(s2.charAt(i)=='+'||s2.charAt(i)=='-')
							return 1;
					}
				}		
			}
			else if(s.charAt(0)=='-')
			{
				for(i=0;i<s2.length();i++)
				{
					if(s2.charAt(i)=='+'||s2.charAt(i)=='-')
						return 1;
				}
			}
			else if(s.charAt(0)=='×')
			{
				for(i=0;i<s2.length();i++)
				{
					if(s2.charAt(i)=='+'||s2.charAt(i)=='-')
						return 1;
				}
			}
			else
				return 1;
		}
		return 0;
		
	}
}
		

//