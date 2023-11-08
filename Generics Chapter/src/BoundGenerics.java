import java.util.List;

public class BoundGenerics<T extends List> {
    T list;

    public int getSize() {
        return list.size();
    }

    /*

    If we didn't extend list, then we can't use the methods of the list inside the class(size())
    To use that we need to extend in the type parameter

    If we need to extend more than one Bound, we can have it with & separated between

    BoundGenerics<T extends List & Serializable>

     */
}
