package _13유용한클래스;

import java.math.BigDecimal;
import java.math.BigInteger;

public class _04빅데시멀 {
	public static void main(String[] args) {
		
		int maxInt = Integer.MAX_VALUE;
		System.out.println(maxInt);
		long maxLong = Long.MAX_VALUE;
		System.out.println(maxLong);
		long longNum = 9223372036854775807L;
		
		BigInteger bigNum1 = new BigInteger("9555555555545454542181");
		BigInteger bigNum2 = new BigInteger("9555555555545542181");
		System.out.println(bigNum1.add(bigNum2));
		System.out.println(bigNum1.subtract(bigNum2));
		System.out.println(bigNum1.multiply(bigNum2));
		System.out.println(bigNum1.divide(bigNum2));
		
		double num1 = 0.1;
		BigDecimal num2 = new BigDecimal("0.0");
		
		for(int i=0; i<1000; i++) {
			num1+=0.1;
			BigDecimal num3 = new BigDecimal("0.1");
			num2 = num2.add(num3);
		}
		
		System.out.println(num1);
		System.out.println(num2);
	}
}
