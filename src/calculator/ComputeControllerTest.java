package calculator;

import org.junit.Assert;
import org.junit.Test;

import calculator.ComputeController;

public class ComputeControllerTest {

	@Test
	public void testExec() {
		Assert.assertEquals("3", ComputeController.exec("1", "2", "+"));
		Assert.assertEquals("-1", ComputeController.exec("1", "2", "-"));
		Assert.assertEquals("2", ComputeController.exec("1", "2", "×"));
		Assert.assertEquals("1/2", ComputeController.exec("1", "2", "÷"));
	}

	@Test
	public void testIsSign() {
		Assert.assertTrue(ComputeController.isSign("+"));
		Assert.assertFalse(ComputeController.isSign("1"));
		Assert.assertFalse(ComputeController.isSign("/"));
	}

	@Test
	public void testSimplify() {
		int[] fac=new int[]{2,1};
		Assert.assertEquals("2", ComputeController.simplify(fac));
		int[] fac1=new int[]{-1,2};
		Assert.assertEquals("-1/2", ComputeController.simplify(fac1));
		int[] fac2=new int[]{1,2};
		Assert.assertEquals("1/2", ComputeController.simplify(fac2));
		int[] fac3=new int[]{1,-2};
		Assert.assertEquals("-1/2", ComputeController.simplify(fac3));
		int[] fac4=new int[]{0,2};
		Assert.assertEquals("0", ComputeController.simplify(fac4));
		
	}

	@Test
	public void testGcd() {
		Assert.assertEquals(1, ComputeController.gcd(2, 3));
		Assert.assertEquals(1, ComputeController.gcd(3, 2));
		Assert.assertEquals(2, ComputeController.gcd(4, 2));
		Assert.assertEquals(2, ComputeController.gcd(2, 4));
		Assert.assertEquals(-2, ComputeController.gcd(-2, 4));
		Assert.assertEquals(-2, ComputeController.gcd(-2, -4));
		Assert.assertEquals(2, ComputeController.gcd(2, -4));
		Assert.assertEquals(0, ComputeController.gcd(3, 0));
		Assert.assertEquals(0, ComputeController.gcd(0, 3));
		
	}

	@Test
	public void testLcm() {
		Assert.assertEquals(4, ComputeController.lcm(2, 4));
		Assert.assertEquals(6, ComputeController.lcm(2, 3));
		Assert.assertEquals(0, ComputeController.lcm(0, 4));
		Assert.assertEquals(0, ComputeController.lcm(2, 0));
		Assert.assertEquals(4, ComputeController.lcm(-2, 4));
		Assert.assertEquals(-6, ComputeController.lcm(-2, 3));
	}

	@Test
	public void testString2fac() {
		int a[]=new int[]{1,2};
		Assert.assertArrayEquals(a, ComputeController.string2fac("1/2"));
	}

	@Test
	public void testAdd() {
		Assert.assertEquals("5/6", ComputeController.add("1/2", "1/3"));
		Assert.assertEquals("4/3", ComputeController.add("1", "1/3"));
		Assert.assertEquals("3", ComputeController.add("1", "2"));
		Assert.assertEquals("5/2", ComputeController.add("3/4", "7/4"));
		Assert.assertEquals("1", ComputeController.add("2/3", "1/3"));
		Assert.assertEquals("1/6", ComputeController.add("1/2", "-1/3"));
		Assert.assertEquals("-5/6", ComputeController.add("-1/2", "-1/3"));
		Assert.assertEquals("-1/6", ComputeController.add("-1/2", "1/3"));
		
		
	}

	@Test
	public void testSubstract() {
		Assert.assertEquals("1/6", ComputeController.substract("1/2", "1/3"));
		Assert.assertEquals("-1", ComputeController.substract("1", "2"));
		Assert.assertEquals("-1/6", ComputeController.substract("1/3", "1/2"));
		Assert.assertEquals("2/3", ComputeController.substract("7/6", "1/2"));
		Assert.assertEquals("1", ComputeController.substract("4/3", "1/3"));
		Assert.assertEquals("5/6", ComputeController.substract("1/2", "-1/3"));
		Assert.assertEquals("-1/6", ComputeController.substract("-1/2", "-1/3"));
		Assert.assertEquals("-5/6", ComputeController.substract("-1/2", "1/3"));
	}

	@Test
	public void testMutiply() {
		Assert.assertEquals("1/6", ComputeController.mutiply("1/2", "1/3"));
		Assert.assertEquals("-1/6", ComputeController.mutiply("-1/2", "1/3"));
		Assert.assertEquals("-1/6", ComputeController.mutiply("1/2", "-1/3"));
		Assert.assertEquals("6", ComputeController.mutiply("2", "3"));
		Assert.assertEquals("2/3", ComputeController.mutiply("2", "1/3"));
		Assert.assertEquals("1/3", ComputeController.mutiply("1/2", "2/3"));
		
	}

	@Test
	public void testDevide() {
		Assert.assertEquals("3/2", ComputeController.devide("1/2", "1/3"));
		Assert.assertEquals("-3/2", ComputeController.devide("1/2", "-1/3"));
		Assert.assertEquals("-3/2", ComputeController.devide("-1/2", "1/3"));
		Assert.assertEquals("6", ComputeController.devide("2", "1/3"));
		Assert.assertEquals("1/6", ComputeController.devide("1/2", "3"));
		Assert.assertEquals("2/3", ComputeController.devide("2", "3"));
		
	}

}
