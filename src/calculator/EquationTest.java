package calculator;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import calculator.Equation;

public class EquationTest {


	@Test
	public void testGetIndexofBra() {
		StringBuffer sb=new StringBuffer("2874((");
		Assert.assertEquals("4#5#", Equation.getIndexofBra(sb, '(').toString());
	}

	@Test
	public void testCalBra() {
		StringBuffer sb=new StringBuffer("(afjlk)(");
		Assert.assertEquals(2, Equation.calBra(sb, '('));
	}

	@Test
	public void testDelred() {
		StringBuffer sb=new StringBuffer("((3+7)+(6)×9=");
		StringBuffer sb1=new StringBuffer("(3+7)+(6)×9=");
		StringBuffer sb2=new StringBuffer("((3+7+(6)×9=");
		Assert.assertEquals("(3+7)+(6)×9=", Equation.delred(sb).toString());
		Assert.assertEquals("(3+7)+(6)×9=", Equation.delred(sb1).toString());
		Assert.assertEquals("3+7+(6)×9=", Equation.delred(sb2).toString());
		
	}

	@Test
	public void testMatch() {
		StringBuffer sb=new StringBuffer(" (3+7)+(6)×9=");
		StringBuffer sb1=new StringBuffer(" (3+(7-6)×9)×8=");
		StringBuffer sb2=new StringBuffer(" 3+(7+(6×9)-1)=");
		StringBuffer sb3=new StringBuffer(" (3+7+6×9)=");
		StringBuffer sb4=new StringBuffer(" (3+7-6)÷9=");
		Assert.assertEquals(" 3+7+6×9=", Equation.match(sb).toString());
		Assert.assertEquals(" (3+(7-6)×9)×8=", Equation.match(sb1).toString());
		Assert.assertEquals(" 3+7+6×9-1=", Equation.match(sb2).toString());
		Assert.assertEquals(" 3+7+6×9=", Equation.match(sb3).toString());
		Assert.assertEquals(" (3+7-6)÷9=", Equation.match(sb4).toString());
		
	}

	@Test
	public void testIsValid() {
		Assert.assertEquals(0,Equation.isValid("+(3+4)+",15));
		Assert.assertEquals(0,Equation.isValid("+(3+4)-",15));
		Assert.assertEquals(1,Equation.isValid("+(3+4)÷",15));
		Assert.assertEquals(1,Equation.isValid("+(3+4)×",15));
		Assert.assertEquals(0,Equation.isValid(" (3+4)+",15));
		Assert.assertEquals(0,Equation.isValid(" (3+4)-",15));
		Assert.assertEquals(1,Equation.isValid(" (3+4)÷",15));
		Assert.assertEquals(1,Equation.isValid(" (3+4)×",15));
		Assert.assertEquals(0,Equation.isValid(" (3+4)=",6));
		Assert.assertEquals(1,Equation.isValid("-(3+4)-",15));
		Assert.assertEquals(1,Equation.isValid("-(3-4)÷",15));
		Assert.assertEquals(0,Equation.isValid("-(3×4)×",15));
		Assert.assertEquals(0,Equation.isValid("-(3÷4)×",15));
		Assert.assertEquals(1,Equation.isValid("-(3÷(4+6)-2)×",15));
		Assert.assertEquals(1,Equation.isValid("÷(3+(4+6)-2)×",15));
		Assert.assertEquals(1,Equation.isValid("+(3÷(4+6)-2)×",15));
		Assert.assertEquals(1,Equation.isValid("×(3+(4+6)-2)×",15));
		Assert.assertEquals(0,Equation.isValid("×(3×4)×",15));
		Assert.assertEquals(1,Equation.isValid("×(3+4)×",15));	
	}

}
