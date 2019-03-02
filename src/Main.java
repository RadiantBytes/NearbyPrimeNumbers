/**
 * Nearby Prime Numbers. This program will take a number as input from a user,
 * and will then find the nearest prime number less than the input and greater
 * than the input
 * 
 * If the input itself is prime, output '[input] is a prime number!'
 *
 * @author Thomas Lynaugh
 * 
 * Last Modified: June 30, 2018
 */

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		long input = scan.nextLong();

		boolean inputPrime = true;

		// Check if input is prime or not
		for (long i = 2; i < input; i++) {

			// If input is not prime
			if (input % i == 0) {
				inputPrime = false;
			}

		}

		// If input is not prime, then find nearest numbers
		if (inputPrime == false) {

			long greaterThan = findPrimeMoreThan(input);
			long lessThan = findPrimeLessThan(input);

			System.out.println(lessThan + " < " + input + " < " + greaterThan);
		}
		// Else, if input is prime, only print the statement
		else {

			System.out.println(input + " is a prime number!");
		}

	}

	/**
	 * 
	 * @param input
	 *            - User inputted int
	 * 
	 * @return The next highest prime number
	 */
	private static long findPrimeMoreThan(long input) {
		for (long i = input + 1; i > input; i++) {

			if (findPrime(i) == false) {
				return i;
			}
		}

		return input;

	}

	/**
	 * 
	 * @param input
	 *            - User inputted int
	 * 
	 * @return The next lowest prime number
	 */
	private static long findPrimeLessThan(long input) {
		for (long i = input - 1; i < input; i--) {

			if (findPrime(i) == false) {
				return i;
			}
		}

		return input;

	}

	/**
	 * 
	 * @param input
	 *            - User inputted int
	 * 
	 * @return True - input is not prime False - input is prime
	 */
	private static boolean findPrime(long input) {
		boolean notPrime = false;

		long d = 2;
		while (!notPrime) {

			if (input % d == 0) {
				notPrime = true;
			}

			// If input has been prime up to input - 1, then it must be prime
			if (d == input - 1) {
				return false;
			}
			d++;

		}

		return notPrime;
	}
}
