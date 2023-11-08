public class RawType<T>{

    // Raw type are instantiated without type parameter

    T element;

    void set(T element) {
        this.element = element;
    }

    T get() {
        return this.element;
    }
}
