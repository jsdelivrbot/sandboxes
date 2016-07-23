package demo;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by rockman on 7/8/2016.
 */
public class BlahTest {

	@Test
	public void blah() {
		String[] names = {"Sam","Pamela", "Dave", "Pascal", "Erik"};

		//Stream<Integer> indices = intRange(1, names.length).boxed();
		List<String> nameList = IntStream.range(0, names.length)
				.filter(i -> names[i].length() <= i)
				.mapToObj(i -> names[i])
				.collect(Collectors.toList());
		nameList.forEach(e -> System.out.println(e));
//		List<String> nameList = Stream.of(names)
//				.filter(e -> e.length() <= e.getKey())
//				.map(Map.Entry::getValue)
//				.collect(toList());
	}
}
