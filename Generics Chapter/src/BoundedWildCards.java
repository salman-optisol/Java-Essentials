import java.util.ArrayList;
import java.util.List;

class A {

}

class B extends A {

}
public class BoundedWildCards {
/*
    display(List<Object> list) -> not possible as it demands List<Object>

    Okay but not best:
    ------------------
    display(List<?> list)
    <T> void display(List<T> list)

    Best ones:
    ----------
    static void display(List<? extends A> list )
 */

    static <T extends A> void display(List<T> list){ // Upper bound methods
        A o = list.get(0);

//        Not possible :
//        --------------
//        list.add(new A());
//        list.add(new B());
    }

    static void work () {
        List<A> a = new ArrayList<>();
        List<B> b = new ArrayList<>();

        display(a);
        display(b);

        show(a);

        // show(b) not possible

    }

    static void show(List<? super A> list ) {  // Lower bound methods
        list.add(new A());
        list.add(new B());


    }

}
