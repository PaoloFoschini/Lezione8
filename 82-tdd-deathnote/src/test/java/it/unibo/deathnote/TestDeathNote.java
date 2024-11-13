package it.unibo.deathnote;

import it.unibo.deathnote.api.*;
import it.unibo.deathnote.impl.*;

public class TestDeathNote {
    public static void main(String[] args){
        DeathNote dn = new DeathNoteImplementation();
        // test regole
        for(int i = 1; i < 13; i++){
            System.out.println(dn.getRule(i));
        }
        // test scrittura causa di morte e dettagli prima del nome
        dn.writeDeathCause("Car accident");
        dn.writeDetails("Going too fast");
        // test scrittura nomi
        dn.writeName("");
        dn.writeName("Paolo Foschini"); // da gestire questione di nomi uguali ma scritti in modo differente
        System.out.println(dn.isNameWritten("Paolo Foschini")); 
        System.out.println(dn.isNameWritten(""));
        // test scrittura causa di morte
        dn.writeDeathCause("karting accident");
        System.out.println(dn.getDeathCause("Paolo Foschini"));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dn.writeDeathCause("work accident");
        System.out.println(dn.getDeathCause("Paolo Foschini"));
        // test scrittura di dettagli
        dn.getDeathDetails("Paolo Foschini");
        dn.writeDetails("run for too long");
        System.out.println(dn.getDeathDetails("Paolo Foschini"));
        dn.writeName("Marco Pertegato");
        try {
            Thread.sleep(6100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dn.writeDetails("eat too much");
        System.out.println(dn.getDeathDetails("Paolo Foschini"));
    }
}