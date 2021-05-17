/**
 * 
 */
package com.ss.jb.five;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Luis Fernandez
 *
 */
public class StreamsLambdas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// 1.
		List<String> list = Arrays.asList("Cat","Giraffe","Dog","Horse","Fox","Wolf");
		
		System.out.println("No Sorting");
		list.stream().forEach(item -> System.out.println(item));
		
		System.out.println("\nSorting by length");
		Comparator<String> compLen = (itemLen1, itemLen2) -> itemLen1.length() - itemLen2.length();
		list.stream().sorted(compLen).forEach(item -> System.out.println(item));
		
		System.out.println("\nSorting by reversed length");
		Comparator<String> compRevLen = (itemLen1, itemLen2) -> itemLen2.length() - itemLen1.length();
		list.stream().sorted(compRevLen).forEach(item -> System.out.println(item));
		
		System.out.println("\nSorting by Strings with 'e' first");
		List<String> listESorted = Stream
				.concat(list.stream().filter(item -> item.contains("e")),
						list.stream().filter(item -> !item.contains("e")))
				.collect(Collectors.toList());
		listESorted.forEach(item -> System.out.println(item));
		
		System.out.println("\nSorting by alphabetically");
		Collections.sort(list);
		for(String item: list) {
			System.out.println(item);
		}
		
		// 2.
		System.out.println("\nOdd Even String");
		List<Integer> nums = Arrays.asList(3,44,1,22);
		System.out.println(StreamsLambdas.evenOdd(nums));
		
		// 3.
		System.out.println("\nA first 3 letter words");
		List<String> list2 = Arrays.asList("abashed","giraffe","ace","dog","act","Fox","Wolf","ack");
		list2.stream().filter(item -> item.startsWith("a") && item.length() == 3)
			.forEach(item -> System.out.println(item));
	}
	
	public static String evenOdd(List<Integer> list) {
		return list.stream().map(item ->{
			if (item % 2 == 0) {
				return "e" + item;
			}
			else {
				return "o" + item;
			}
		}).collect(Collectors.joining(","));
	}

}
