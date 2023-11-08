import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Main {

    static void fun(List list) {
        list.add("Salman");
        list.add(23.434);

        // This is why we should avoid raw types
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        fun(list);

        System.out.println(list);
        /*
        Excellent use case of Generics is Collections framework
         */
        Calculator<String> stringCalculator = new Calculator<>("Jackie", "Bheema");
        Calculator<Integer> integerCalculator = new Calculator<>(100, 200);

        stringCalculator.display();
        integerCalculator.display();

        GenericInterface<String> stringGenericInterface = new GenericInterfaceImpl<>();
        stringGenericInterface.set("Salman");
        System.out.println(stringGenericInterface.get());

//      Raw Type example

        RawType r = new RawType();
        r.set(23);

        int receivedElement = (int) r.get();
        System.out.println(receivedElement);

//        r.set("salman");
//        receivedElement = (int) r.get();

    }
}