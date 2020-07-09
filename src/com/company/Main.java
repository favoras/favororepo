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

class LaikinaKlaida extends VaziuoklesIsskleidimoKlaida{

    public LaikinaKlaida(String priezastis) {
        super(priezastis);
    }
}

class SvarbiKlaida extends  VaziuoklesIsskleidimoKlaida{

    public SvarbiKlaida(String priezastis) {
        super(priezastis);
    }
}

class Lektuvas {

    public void iskeistiVaziuokle() {
        try {
            vaziuokle();
            System.out.println("OK : važiuoklė sėkmingai išskleista");
        } catch (LaikinaKlaida e) {
            System.out.println("ERROR : nepavyko isskleisti vaziuokles\n" + "Priezastis: " + e.getPriezastis());
            System.out.println("Svarbumas: Laikina...\n");
        } catch (SvarbiKlaida e) {
            System.out.println("ERROR : nepavyko isskleisti vaziuokles\n" + "Priezastis: " + e.getPriezastis());
            System.out.println("Svarbumas: SVARBU!!!...\n");
        } catch (VaziuoklesIsskleidimoKlaida e) {
            System.out.println("ERROR : nepavyko isskleisti vaziuokles\n" + "Priezastis: " + e.getPriezastis());
            System.out.println("Svarbumas: Nezinoma...\n");
        }
    }

    void vaziuokle() throws VaziuoklesIsskleidimoKlaida {
        Random rand = new Random();
        int x = rand.nextInt(10);
        switch (x) { // new Random().nextInt(10)
            case 0:
                throw new SvarbiKlaida("Neatsidare durys");
            case 1:
                throw new SvarbiKlaida("Nenusileido ratas");
            case 2:
                throw new LaikinaKlaida("Per didelis aukstis");
            case 3:
                throw new SvarbiKlaida("Sugedo variklis");
            case 4:
                throw new VaziuoklesIsskleidimoKlaida("Nezinoma priezastis");
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
