package calculator;


/**
 * 加减乘除计算
 * 冒号：表示一个分数，左边是分子，右边是分母
 * 
 * @author Song
 *
 */
public class ComputeController {
	
	/**
	 * 执行计算
	 * @param data1
	 * @param data2
	 * @param sign
	 * @return
	 */
	public static String exec(String a1,String a2,String sign){
		
		String retString="";
		switch (sign) {
		case "+":retString=add(a1, a2);break;
		case "-":retString=substract(a1, a2);break;
		case "×":retString=mutiply(a1, a2);break;
		case "÷":retString=devide(a1, a2);break;
		}
		return retString;
		
	}

	/**
	 * 是否是加减乘除运算符
	 * @param string
	 * @return
	 */
	public static boolean isSign(String string){
		
		if(string.equals("+")||string.equals("-")||
				string.equals("×")||string.equals("÷")){
			return true;
		}
		return false;
	}
	/**
	 * 化简分数并转化为String格式
	 * @param fac
	 * @return
	 */
	public static String simplify(int [] fac){
		
		if(fac[0]==0){return "0";}
		if(fac[0]%fac[1]==0){return String.valueOf(fac[0]/fac[1]);}
		int gcd=gcd(fac[0],fac[1]);
		fac[0]/=gcd;
		fac[1]/=gcd;
		if(fac[1]<0){
			fac[1]*=-1;
			fac[0]*=-1;
		}
		return fac[0]+"/"+fac[1];
	}
	/**
	 * 求最大公约数
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static int gcd(int a1,int a2){
		
		if(a1==0||a2==0){System.out.println("Error:the data is zero.");}
		int min=a1;
		int max=a1;
		if(a1<a2){
			max=a2;
		}
		else{
			min=a2;
		}
		if(max%min==0){
			return min;
		}
		int temp=max%min;
		max=min;
		min=temp;
		while(max%min!=0){
			temp=max%min;
			max=min;
			min=temp;
		}
		return min;
	}
	/**
	 * 求最小公倍数
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static int lcm(int a1,int a2){
		
		if(a1==0||a2==0){System.out.println("Error:the data is zero.");}
		int gcd=gcd(a1,a2);
		
		return a1/gcd*a2;
	}
	/**
	 * stringdata转化为分数的表示形式
	 * @param data
	 * @return
	 */
	public static int [] string2fac(String data){
		int [] retfac=new int[2];
		if(data.contains("/")){
			String strings[]=data.split("/");
			retfac[0]=Integer.valueOf(strings[0]);
			retfac[1]=Integer.valueOf(strings[1]);
		}
		else{
			int integer=Integer.valueOf(data);
			retfac[0]=integer;
			retfac[1]=1;
		}
		return retfac;
	}
	/**
	 * 加法
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static String add(String a1,String a2){
		
		if(!a1.contains("/")&&!a2.contains("/")){
			int a1int=Integer.valueOf(a1);
			int a2int=Integer.valueOf(a2);
			return String.valueOf(a1int+a2int);
		}
		int []a1fac=string2fac(a1);
		int []a2fac=string2fac(a2);
		//分母化同并实现运算
		a1fac[0]=a1fac[0]*a2fac[1]+a1fac[1]*a2fac[0];
		a1fac[1]=a1fac[1]*a2fac[1];
		return simplify(a1fac);
	}
	/**
	 * 减法
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static String substract(String a1,String a2){
		
		if(!a1.contains("/")&&!a2.contains("/")){
			int a1int=Integer.valueOf(a1);
			int a2int=Integer.valueOf(a2);
			return String.valueOf(a1int-a2int);
		}
		int []a1fac=string2fac(a1);
		int []a2fac=string2fac(a2);
		//分母化同并实现运算
		a1fac[0]=a1fac[0]*a2fac[1]-a1fac[1]*a2fac[0];
		a1fac[1]=a1fac[1]*a2fac[1];
		return simplify(a1fac);
	}
	/**
	 * 乘法
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static String mutiply(String a1,String a2){
		
		if(!a1.contains("/")&&!a2.contains("/")){
			int a1int=Integer.valueOf(a1);
			int a2int=Integer.valueOf(a2);
			return String.valueOf(a1int*a2int);
		}
		int []a1fac=string2fac(a1);
		int []a2fac=string2fac(a2);
		//分母化同并实现运算
		a1fac[0]=a1fac[0]*a2fac[0];
		a1fac[1]=a1fac[1]*a2fac[1];
		return simplify(a1fac);
	}
	/**
	 * 除法
	 * @param a1
	 * @param a2
	 * @return
	 */
	public static String devide(String a1,String a2){
		
		if(!a1.contains("/")&&!a2.contains("/")){
			int []aint=new int[2];
			aint[0]=Integer.valueOf(a1);
			aint[1]=Integer.valueOf(a2);
			return simplify(aint);
		}
		int []a1fac=string2fac(a1);
		int []a2fac=string2fac(a2);
		//分母化同并实现运算
		a1fac[0]=a1fac[0]*a2fac[1];
		a1fac[1]=a1fac[1]*a2fac[0];
		return simplify(a1fac);
	}
}
