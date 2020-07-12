package exceptions;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        boolean argerai = false;
        while(!argerai)
        {
            try {
                input.Ivesk();
                argerai = true;
            } catch (InputMismatchException e) {
                System.out.println("Input Mismatch Exception");
                System.out.println("Bandykite dar karta.");
            }
        }

    }
}

class Input {
    public void Ivesk(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Iveskite sveikaji skaiciu");
        int skaicius = sc.nextInt();
        System.out.println("Jusu ivestas skaicius yra: " + skaicius);


    }

}