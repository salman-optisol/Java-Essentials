import java.util.Comparator;

public class AnonymousClass {

    static Comparator<Integer> method() {

        // this is anonymous class;

        return new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };
    }
}
