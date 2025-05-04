package P_streams;

import java.util.*;
import java.util.stream.Collectors;

/*
A stream pipeline has three parts:
- exactly one source, such as a collection
- any number of intermediate operations
- exactly one terminal operation

We use streams to construct a "pipeline" through which elements flow
- from the source
- through the intermediate operations
- to the terminal operation.

A stream does not modify the contents of the source.

A stream does not store elements. Instead, it moves elements from a source through a pipeline and processes them.

Each intermediate operation returns a new Stream, so operations can be chained.

Some intermediate operations: filter, map, mapToInt, distinct, sorted

Some terminal operations: count, max, toList, average, sum, forEach, findAny, collect

The elements of a stream are not processed until a terminal operation is invoked.
At that point, the source produces the necessary elements, the intermediate operations are
performed, and the terminal operation returns a result.
This allows for the source of a stream to be potentially infinite.
For example, new Random().ints() creates an infinite stream. But no elements are
actually generated until the terminal operation is invoked. So, for example,
    new Random().ints().distinct().limit(10).boxed().toList()
creates a List<Integer> containing 10 distinct random integers, and it does not
take infinite time to complete.

An Optional object: an object that is either empty or contains a value.
Like a collection that contains at most 1 element.
Used as the return type of methods like max that can't always
return a value, since the stream might be empty.

Stream is a generic interface, so we can have Stream<String>, Stream<Person>, Stream<Integer>.

There are also primitive specializations for int, long and double: IntStream, LongStream, and DoubleStream.

Just as there are primitive specializations for Stream<Integer>, etc., so too are there
primitive specializations for Optional<Integer> etc.: OptionalInt, OptionalLong, OptionalDouble.

Creating a Stream<T> from a source:
- Stream.of(T... values) returns a Stream<T>
- Arrays.stream(T[] array) returns a Stream<T>
- If coll is a Collection<E>, coll.stream() returns a Stream<E> of the collection's elements
- If filename is the name of a file, Files.lines(Paths.get(filename)) returns a Stream<String> of all the lines in the file
- Stream.iterate(initial, unaryOperator)

Creating an IntStream from a source:
- IntStream.of(int... values)
- Arrays.steam(int[] array)
- IntStream.range(int startInclusive, int endExclusive)
- If rand refers to a Random object:
    - rand.ints() returns an infinite stream of random ints
    - rand.ints(min, max) returns an infinite stream of random ints between min (inclusive) and max (exclusive)

Intermediate stream operations of all streams:
- filter(predicate)
- map(function)
- distinct()
- sorted()
- limit(size)

Intermediate operations specific to Stream<T>:
- sorted(comparator)
- mapToInt(function) [returns an IntStream]
- mapToDouble(function) [returns a DoubleStream]
- mapToLong(function) [returns a LongStream]

Intermediate operations specific to IntStream, DoubleStream, and LongStream:
- boxed() [returns a Stream<Integer> for an IntStream, a Stream<Double> for a DoubleStream, or a Stream<Long> for a LongStream]
- mapToObj(function) [returns a Stream]

Terminal operations of all streams:
- count()
- forEach(consumer)
- reduce(initial, binaryOperator)
- reduce(binaryOperator) [returns an optional]
- findAny() [returns an optional]
- toArray()

Terminal operations specific to Stream<T>:
- toList()
- min(comparator) [returns an optional]
- max(comparator) [returns an optional]
- collect(collector)

Terminal operations specific to IntStream, DoubleStream, and LongStream:
- sum()
- average() [returns an optional]
- min() [returns an optional]
- max() [returns an optional]

The collect method takes a Collector specifying how the elements of the stream should be collected.
To easily create a Collector, we can use the following methods of the Collectors class:
- toList() [.collect(Collectors.toList()) is equivalent to .toList()]
- toSet()
- joining() [concatenates the elements into a String]
- joining(String delimiter) [like joining(), but places delimiter between elements]
- groupingBy(function) [returns a Map<K, List<T>>, using the function to classify the elements]

Some terminal operations return an Optional (or OptionalInt, OptionalDouble, or OptionalLong).
Here are some methods of all optionals:
orElse(other)
orElseThrow()
ifPresent(consumer)
 */

public class StreamDemos {
    public static void main(String[] args) {
        List<String> list = List.of(
                "chocolate", "coffee", "tea", "", "biscuit",
                "muffin", "doughnut", "tea", "cookie"
        );

        // print each distinct string
        list.stream()
                .distinct()
                .forEach(System.out::println);

        // print number of distinct strings
        System.out.println("number of distinct strings: " + list.stream().distinct().count());

        // count strings starting with 'c'
        long numStartingWithC = list.stream() // Stream<String>
                .filter(s -> s.startsWith("c"))  // Stream<String>
                .count(); // long
        System.out.println("numStartingWithC = " + numStartingWithC);

        // print in uppercase each string starting with 'c'
        list.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // print strings sorted by length, then alphabetically
        list.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);

        // get sorted list of distinct strings with length <= 6
        List<String> shortDistinctSortedStrings = list.stream()
                .filter(s -> s.length() <= 6)
                .distinct()
                .sorted()
                .toList();
        System.out.println("shortDistinctSortedStrings = " + shortDistinctSortedStrings);

        // get sorted list of distinct first characters of the strings
        List<Character> firstCharacters = list.stream()
                .filter(s -> !s.isEmpty()) // Stream<String>, no empty Strings
                .map(s -> s.charAt(0))
                .distinct() // Stream<Character>, but without duplicates
                .sorted() // Stream<Character>, but now sorted
                .toList(); // List<Character>
        System.out.println("firstCharacters = " + firstCharacters);

        // find any longest string; print if present
        Optional<String> longestString = list.stream() // Stream<String>
                .max(Comparator.comparing(String::length)); // Optional<String>
        longestString.ifPresent(System.out::println); // will print the max if there is one, otherwise does nothing

        // print any longest string, if present
        list.stream()
                .max(Comparator.comparing(String::length))
                .ifPresent(System.out::println);

        // find any longest string starting with 'c'
        Optional<String> longestStringStartingWithC = list.stream() // Stream<String>
                .filter(s -> s.startsWith("c")) // Stream<String>
                .max(Comparator.comparing(String::length));
        System.out.println(longestStringStartingWithC.orElse("no longest string starting with 'c' available"));

        // print any string of length 6. if there are multiple ones, print any;
        // if there are none, print nothing
        list.stream()
                .filter(s -> s.length() == 6) // Stream<String>
                .findAny()
                .ifPresent(System.out::println);

        // get sum of lengths of all strings
        long sumOfLengths = list.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("sumOfLengths = " + sumOfLengths);

        // find length of the longest string
        OptionalInt lengthOfLongestString = list.stream() // Stream<String>
                // .map(String::length) // Stream<Integer>, but we want to be able to call no-arg max method
                .mapToInt(String::length) // IntStream
                .max();
        System.out.println("lengthOfLongestString = " + lengthOfLongestString.orElseThrow());

        // get average length of strings that start with 'c'
        OptionalDouble averageLengthOfStringsStartingWithC = list.stream()
                .filter(s -> s.startsWith("c")) // Stream<String>
                .mapToInt(String::length)
                .average();
        averageLengthOfStringsStartingWithC.ifPresent(System.out::println);

        // group the strings into lists by their lengths:
        // have one List of Strings of length 0,
        // another List of Strings of length 6, etc.
        Map<Integer, List<String>> map1 = list.stream()
                .collect(Collectors.groupingBy(String::length));
        map1.forEach((len, wordList) -> System.out.println(len + ": " + wordList));

        // OPTIONAL:
        // group the strings into sets by their lengths
        Map<Integer, Set<String>> map2 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        map2.forEach((len, wordSet) -> System.out.println(len + ": " + wordSet));

        // OPTIONAL:
        // create a map from string lengths to the number of strings of those lengths (for length 6 there are 3 strings, etc.)
        Map<Integer, Long> map3 = list.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map3.forEach((len, count) -> System.out.println(len + ": " + count));
    }
}
