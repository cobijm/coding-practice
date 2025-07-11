package math;

import java.math.BigInteger;

public class CountPrimes {

	public static int countPrimes(int n) {
		int numPrimes = 0;
		for(int i = n - 1; i > 0; i--) {
			BigInteger b = new BigInteger(String.valueOf(i));
			if(b.isProbablePrime(i)) {
				numPrimes++;
			}
		}
		return numPrimes;
	}
	public static void main(String[] args) {
		System.out.println(countPrimes(10));

	}

}
