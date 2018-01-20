package com.leventozkan.demo.tutorials;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTutorial {
	
	public static void main(String args[]) {
		streamFunctions();
	}
	
	
	public static void streamFunctions() {
	List<String> myList =Arrays.asList("a1", "a2", "b1", "c2", "c1");

		myList
			.stream()
			.filter(s -> s.startsWith("c"))
			.map(String::toUpperCase)
			.sorted()  // map filter and sort are intermediate operations
			.forEach(System.out::println); // this is terminal operation. :: means method reference.
		
		
		myList
	    .stream()
	    .findFirst()
	    .ifPresent(System.out::println);  // a1
		
		
		Stream.of("a1", "a2", "a3")
		.findFirst()
		.ifPresent(System.out::println);
		
		
		IntStream.range(1, 4)
	    .forEach(System.out::println);  	
		// 1
		// 2
		// 3


		Arrays.stream(new int[] {1, 2, 3})
	    .map(n -> 2 * n + 1)
	    .average()
	    .ifPresent(System.out::println);  // 5.0
		
		
		Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);  // 3
		
		
		IntStream.range(1, 4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);
		
			// a1
			// a2
			// a3
		
		
		Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);

			// a1
			// a2
			// a3
		
		// no terminal operator
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    });
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return true;
	    });
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s));

		// map:     d2
		// filter:  D2
		// map:     a2
		// filter:  A2
		// forEach: A2
		// map:     b1
		// filter:  B1
		// map:     b3
		// filter:  B3
		// map:     c
		// filter:  C
		
		
		
		
		class Person {
		    String name;
		    int age;

		    Person(String name, int age) {
		        this.name = name;
		        this.age = age;
		    }

		    @Override
		    public String toString() {
		        return name;
		    }
		}
		
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		List<Person> filtered =
			    persons
			        .stream()
			        .filter(p -> p.name.startsWith("P"))
			        .collect(Collectors.toList());

			System.out.println(filtered);    // [Peter, Pamela]
		
		
			
			Map<Integer, List<Person>> personsByAge = persons
				    .stream()
				    .collect(Collectors.groupingBy(p -> p.age));

				personsByAge
				    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
				// age 18: [Max]
				// age 23: [Peter, Pamela]
				// age 12: [David]
				
				
				Double averageAge = persons
					    .stream()
					    .collect(Collectors.averagingInt(p -> p.age));

					System.out.println(averageAge);     // 19.0
					
					
					
					Arrays.asList("a1", "a2", "b1", "c2", "c1")
				    .parallelStream()
				    .filter(s -> {
				        System.out.format("filter: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return true;
				    })
				    .map(s -> {
				        System.out.format("map: %s [%s]\n",
				            s, Thread.currentThread().getName());
				        return s.toUpperCase();
				    })
				    .forEach(s -> System.out.format("forEach: %s [%s]\n",
				        s, Thread.currentThread().getName()));
		
					
					
					/*Find sum 4 of 5 size array min and max values.*/
		
	}
	
	
}
