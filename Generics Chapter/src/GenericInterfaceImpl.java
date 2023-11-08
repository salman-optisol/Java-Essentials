public class GenericInterfaceImpl<T> implements GenericInterface<T>{
    private T element;
    @Override
    public void set(T element) {
        this.element = element;
    }

    @Override
    public T get() {
        return element;
    }
}
