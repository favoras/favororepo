package exceptions;


public class Main {
    public static void main(String[] args) {

        A a = new A();

        try {
            a.a1();
        } catch (StackOverflowError e) {
            System.out.println("Stack Overflow Error");
        }
    }
}

class A {
    public void a1() {
        B b = new B();
        b.metodas1();
    }

}

class B {
    public void metodas1(){
        C c = new C();
        c.metodas2();
    }

}

class C {
    public void metodas2(){
        metodas2();
    }
}
