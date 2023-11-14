import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamAPI{ // To perform complex operations on collections
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        // *** filter and map

        Stream<Integer> stream = list.stream()
                .filter((element) -> element % 2 == 0)
                .filter(StreamAPI::filterer)
                .map((element) -> element * element);

        System.out.println("In between streaming and terminal operation...");

        stream.forEach(System.out :: println);
        // So the operations in stream are lazy, and are invoked only during the terminal operation when executed !!
        // There can be only one terminal operation for a stream

        // *** slicing
        list = Arrays.asList(1,1,1,2,2,3,4,5,5,5,6,6,8,8,8,9,9);

        list.stream()
                .distinct()
                .limit(5)
                .skip(2)
                .forEach(System.out :: println);

        // ------------ Terminal operations
        // *** matching operations

        boolean hasFive = list.stream().anyMatch((n) -> n == 5);
        System.out.println("has Five " + hasFive);

        boolean allFive = list.stream().allMatch((n) -> n == 5);
        System.out.println("all Five " + allFive);

        boolean noZero = list.stream().noneMatch((n) -> n == 0);
        System.out.println("No zero " + noZero);


        // *** finding operations

        Optional<Integer> bestFive = list.stream().filter((n) -> n == 5).findAny();  // find any element with the previous filter condition and return the element
        System.out.println("Best five " + bestFive.get()); // always use with optional.isPresent()

        // *** reducing operations

        int sumOfDistinct = list.stream()
                .distinct()
                .reduce(0, (ans, i) -> ans + i);
        System.out.println("Sum value : " + sumOfDistinct);


        // *** collect operations using Collector

        List<Integer> modifiedList = list.stream().distinct().toList();
        Set<Integer> modifiedSet = list.stream().filter((n) -> n % 2 == 0).collect(Collectors.toSet());


    }

    static boolean filterer(Integer element) {
        System.out.println("In filer");
        return element < 10;
    }
}
