import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.display();

        Comparator<Integer> myComp = AnonymousClass.method();
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(34);
        list.add(3);
        list.add(23);
        list.add(36);

        list.sort(myComp);

        System.out.println(list);

    }
}