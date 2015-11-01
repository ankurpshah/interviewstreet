package com.ankur.interviewstreet.puzzle.median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution {
	private static final String ADD = "a";
	private static final String REMOVE = "r";
	private List<Integer> list = new ArrayList<Integer>();

	private void sortNumbers() {
		Collections.sort(list);
	}

	/**
	 * @param operation
	 * @param value
	 * @return
	 */
	public String getAverage(final String operation, final int value) {
		String result = "Wrong!";
		boolean success = performOperation(operation, value);
		if ((list.size() > 0) && success) {
			sortNumbers();
			result = getResult();
		}
		return result;
	}

	private String getResult() {
		String result = "Wrong!";
		if (isOdd(list.size())) {
			result = list.get(list.size() / 2).intValue() + "";
		} else {
			int firstIndex = ((list.size() - 2) / 2);
			int total = list.get(firstIndex) + list.get(firstIndex + 1);
			result = String.valueOf(total / 2);
			if (isOdd(total)) {
				result += ".5";
			}
		}
		return result;
	}

	private boolean performOperation(final String operation, final int value) {
		boolean result = true;
		if (REMOVE.equals(operation)) {
			int index = list.indexOf(value);
			if (index > -1) {
				list.remove(index);
			} else {
				result = false;
			}
		} else if (ADD.equals(operation)) {
			list.add(value);
		} else {
			result = false;
		}
		return result;
	}

	private boolean isOdd(final int number) {
		boolean result = false;
		if ((number % 2) == 1) {
			result = true;
		}
		return result;
	}

	public static void main(String args[]) {

		Solution median = new Solution();
		StringBuilder sb = new StringBuilder();
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		int N;
		N = in.nextInt();

		if (N > 0) {
			String s[] = new String[N];
			int x[] = new int[N];

			for (int i = 0; i < N; i++) {
				s[i] = in.next();
				x[i] = in.nextInt();
				sb.append(median.getAverage(s[i], x[i])).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}
