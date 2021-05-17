/**
 * 
 */
package com.ss.jb.wk1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luisherre
 *
 */
public class FunctionalPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Assignment 2
		System.out.println("Return a List of right most digits.");
		List<Integer> l1 = Arrays.asList(1, 22, 93);
		List<Integer> l2 = Arrays.asList(16, 8, 886, 8, 1);
		List<Integer> l3 = Arrays.asList(10, 0);

		FunctionalPractice.rightMost(l1).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.rightMost(l2).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.rightMost(l3).forEach(item -> System.out.print(item + " "));
		System.out.println("\n");

		// Assignment 3
		System.out.println("Return a List of values times two.");
		List<Integer> l4 = Arrays.asList(1, 2, 3);
		List<Integer> l5 = Arrays.asList(6, 8, 6, 8, -1);
		List<Integer> l6 = Arrays.asList();

		FunctionalPractice.timesTwo(l4).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.timesTwo(l5).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.timesTwo(l6).forEach(item -> System.out.print(item + " "));
		System.out.println("\n");

		// Assignment 4
		System.out.println("Return a List of Strings while removing the 'x' character.");
		List<String> ls1 = Arrays.asList("ax", "bb", "cx");
		List<String> ls2 = Arrays.asList("xxax", "xbxbx", "xxcx");
		List<String> ls3 = Arrays.asList("x");

		FunctionalPractice.noX(ls1).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.noX(ls2).forEach(item -> System.out.print(item + " "));
		System.out.println();
		FunctionalPractice.noX(ls3).forEach(item -> System.out.print(item + " "));
		System.out.println("\n");

	}

	// A2
	public static List<Integer> rightMost(List<Integer> list) {
		List<Integer> result = list.stream().map(item -> item % 10).collect(Collectors.toList());
		return result;
	}

	// A3
	public static List<Integer> timesTwo(List<Integer> list) {
		List<Integer> result = list.stream().map(item -> item * 2).collect(Collectors.toList());
		return result;
	}

	// A4
	public static List<String> noX(List<String> list) {
		List<String> result = list.stream().map(item -> item.replace("x", "")).collect(Collectors.toList());
		return result;
	}

}
