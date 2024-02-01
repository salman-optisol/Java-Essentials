import java.util.*;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {5,8,7,5,4,8,5,6,9,8,2, 3, 4, 45, 4};
        List<Integer> list = new ArrayList<>();

        Arrays.stream(arr).forEach(list::add);

        list.stream().sorted(Comparator.comparingInt(a -> (50 - a)));

        System.out.println(list);
    }
}
