package edu.globant.day3.functional;

import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.List;

public class LambdaExpressions {

	public static void main(String[] args) {
		List<String> listNoLambda = asList("Pedro", "Mario", "Luis", "Andrea", "Rocío");
		System.out.println(listNoLambda);
		listNoLambda.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return -s1.compareTo(s2);
			}
		});
		System.out.println(listNoLambda);

		System.out.println("----------------------------------------------------------");

		List<String> listWithLambda = asList("Pedro", "Mario", "Luis", "Andrea", "Rocío");
		System.out.println(listWithLambda);
		listWithLambda.sort((s1, s2) -> -s1.compareTo(s2));
		System.out.println(listWithLambda);
	}
}
