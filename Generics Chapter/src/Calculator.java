public class Calculator<T>{
    T a, b;

    public Calculator(T a, T b) {
        this.a = a;
        this.b = b;
    }

    public void display() {
        System.out.println("The items in the class are a : " + a + " b : " + b);
    }
}
