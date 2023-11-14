import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class StandardInterfaces {
    public static void main(String[] args) {
        String page1 = "GodFather 1";
        String page2 = "Inception      movie";
        String page3 = "Interstellar       movie";
        String page4 = "Infinity war       ";

        String[] pages = {page1, page2, page3, page4};

        Function<String, String> transformerFun =  p -> p.replaceAll("movie", "").trim(); // can also store in variable
        // BiFunction<Par1Type, Par2Type, ReturnType> for two parameters with different types

        for(String page : pages) {
            boolean startsWithI = salluFilter(page, p -> p.startsWith("I"));
            if(startsWithI) {
                String trimmed = salluTransformer(page, transformerFun);
                System.out.println(trimmed);
            }
        }

        List<String> names = Arrays.asList("Salman", "Stark", "Parker", "Rogers", "Thor");
        Consumer<String> printer = name -> System.out.println("The hero here is " + name);
        names.forEach(printer);

        Supplier<String> supplier = () -> "IronMan";
        System.out.println("The best superhero is " + salluSupplier(supplier));

        // Method references
        Consumer<String> consumerMethodRef = MethodRefClass :: salluConsumer; // ClassName :: staticMethodName
        BiFunction<String, String, Boolean> functionMethodRef = String :: contains;

        // Also can be done as --- ObjectRef :: instanceMethodName

        names.forEach(System.out :: println);


        // Constructor references
        // Consider we create a supplier which produces a new String when requested

        Supplier<String> produceNewString;
        produceNewString = String :: new;
//        produceNewString = () -> new String(); // instead of this use above line


    }

    static boolean salluFilter(String page, Predicate<String> filter) {
        return filter.test(page); // standard method for filtering as it returns boolean
    }

    static String salluTransformer(String page, Function<String, String> transformer) {
        return transformer.apply(page);  //standard interface for applying some transformation
    }

    static String salluSupplier(Supplier<String> supplier) {
        return supplier.get();
    }
}
