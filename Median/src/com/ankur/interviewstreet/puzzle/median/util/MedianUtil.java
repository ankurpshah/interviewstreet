/**
 * 
 */
package com.ankur.interviewstreet.puzzle.median.util;

/**
 * @author ishi
 * 
 */
public final class MedianUtil {

	private MedianUtil() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isOdd(final int number) {
		boolean result = false;
		if ((number % 2) == 1) {
			result = true;
		}
		return result;
	}
}
