public class LambdaDemo {
    void method() {
        String day = "Sunday";

        FunInterface fun = name -> "Today is " + day + " , by " + name;
        System.out.println(fun.display("Salman"));

//        day = "Tuesday";   // We can't do this, because the variable in lambda must be final or effectively final
        // Becoz the lambda will capture the values of variables from enclosing scope while creating lambda so it should not change
    }
    public static void main(String[] args) {
        FunInterface fun = name -> "Hello Mr." + name;
        System.out.println(fun.display("Salman"));


    }
}

@FunctionalInterface
interface FunInterface {
    String display(String name);
}
