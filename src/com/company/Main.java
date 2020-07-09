package com.company;

import java.util.Random;

class VaziuoklesIsskleidimoKlaida extends Exception {
    private String priezastis;

    public VaziuoklesIsskleidimoKlaida(String priezastis){
        this.priezastis = priezastis;
    }

    public String getPriezastis() {
        return priezastis;
    }

    public void setPriezastis(String priezastis) {
        this.priezastis = priezastis;
    }
}

class Lektuvas {

    public void iskeistiVaziuokle() {
        try {
            vaziuokle();
            System.out.println("OK : važiuoklė sėkmingai išskleista");
        } catch (VaziuoklesIsskleidimoKlaida e) { // divided by 0
            System.out.println("ERROR : nepavyko isskleisti vaziuokles\n" + e.getPriezastis());
        }
    }

    void vaziuokle() throws VaziuoklesIsskleidimoKlaida {
        Random rand = new Random();
        int x = rand.nextInt(4);
        switch (x) { // new Random().nextInt(10)
            case 0:
                throw new VaziuoklesIsskleidimoKlaida("Neatsidare durys");
            case 1:
                throw new VaziuoklesIsskleidimoKlaida("Nenusileido ratas");
            case 2:
                throw new VaziuoklesIsskleidimoKlaida("Per didelis aukstis");
            case 3:
                throw new VaziuoklesIsskleidimoKlaida("Sugedo variklis");
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
