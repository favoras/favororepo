package com.company;

import java.util.Random;

class Lektuvas {

    public void iskeistiVaziuokle()
    {
        Random rand = new Random();
        int skaicius = rand.nextInt(10);
        int bandom = 5 / skaicius;
        System.out.println("OK: važiuoklė sėkmingai išskleista");

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
