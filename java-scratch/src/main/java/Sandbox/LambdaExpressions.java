package Sandbox;

import java.util.Comparator;


/**
 * Created by dustinstanley on 2/20/15.
 */
public class LambdaExpressions {

	public static void main(String[] args) {
		System.out.println("Main called");
		runLambdas();
	}

	static void runLambdas() {
		Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());
		System.out.println("Comparing 'blah' and 'blahhhhhh': " + comparator.compare("blah", "blahhhhhh"));
	}
}
