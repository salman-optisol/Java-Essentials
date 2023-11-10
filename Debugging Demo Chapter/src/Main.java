public class Main {
    static int method1(int a) {
        if(a == 10) {
            method2();
        }

        return 1000;
    }

    static void method2() {
        int a = 1;
        int b = 2;
        String name = "Salman";

        System.out.println("The First Two numbers are : " + a + " " + b);
        System.out.println("The name of the person is : " + name);
    }
    public static void main(String[] args) {
        int x = 1;

        if(method1(x) > 1000) {
            System.out.println("Yes greater than 1000");
        }
        else {
            System.out.println("No less than 1000");
        }

    }
}