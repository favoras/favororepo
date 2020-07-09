package com.company;

import java.util.Random;

class Lektuvas {

    public void iskeistiVaziuokle()
    {
        Random rand = new Random();
        int skaicius = rand.nextInt(6);
        try {
            int bandom = 4 / skaicius;
            if (skaicius == 5)
            {
                "skrendu".charAt(20);
            }
            System.out.println("OK : važiuoklė sėkmingai išskleista");
            } catch (ArithmeticException e) { // divided by 0
            System.out.println("ERROR : nepavyko isskleisti vaziuokles");
            } catch (StringIndexOutOfBoundsException e){
            System.out.println("ERROR : nepavyko išskleisti važiuoklės dėl kitos klaidos");
            } finally {
            System.out.println("INFO: lektuvas skrenda");
            System.out.println("\n");
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Lektuvas lekt = new Lektuvas();
        lekt.iskeistiVaziuokle();
        lekt.iskeistiVaziuokle();
        lekt.iskeistiVaziuokle();
        lekt.iskeistiVaziuokle();
        lekt.iskeistiVaziuokle();

    }
}
