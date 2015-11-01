package com.ankur.interviewstreet.puzzle.median;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ankur.interviewstreet.puzzle.median.util.MedianUtil;

public class Median {
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
		if (MedianUtil.isOdd(list.size())) {
			result = list.get(list.size() / 2).toString();
		} else {
			int firstIndex = ((list.size() - 2) / 2);
			int total = list.get(firstIndex) + list.get(firstIndex + 1);
			result = String.valueOf(total / 2);
			if (MedianUtil.isOdd(total)) {
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
		} else {
			list.add(value);
		}
		return result;
	}
}
