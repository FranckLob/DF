package com.company;

public class TestStatic {
//attribut static = attribut de classe
    //par ex compteur global sur la classe
    //aucun impact si passé en paramètre
    //dans un main :
    //si testStatic1 est une instance de la classe : System.out.println(testStatic1.compteurStatic);
    //ou sinon : System.out.println(TestStatic.getCompteurStatic());
    public static int compteurStatic = 0;
    public int compteurNonStatic;

    public TestStatic(int compteurNonStatic) {
        this.compteurNonStatic = compteurNonStatic;
    }

    public static int getCompteurStatic() {
        return compteurStatic;
    }

    public static void setCompteurStatic(int compteurStatic) {
        TestStatic.compteurStatic = compteurStatic;
    }
}
