public class OuterClass {

    // Unless the inner class use the instance members of the outer class it is better to declare inner class as static
    // Because nonstatic inner class will cause this to have a implicit reference to the outer class also memory overhead
    class InnerClass {

        int x;
        void go() {
            System.out.println("Inner class : " + x);
        }

        void set(int x) {
            this.x = x;
        }

        void display() {
            go();
            OuterClass.this.go();

            // If no go() in innerclass, then go() in outer will execute !
        }
    }

    int name;
    void go() {
        System.out.println("Outer class");
    }

    void display() {
        name = 1000;
        InnerClass inner = new InnerClass();
        InnerClass inner2 = new InnerClass();
        inner.set(10);
        inner2.set(20);

        inner.display();
        inner2.display();

    }
}
