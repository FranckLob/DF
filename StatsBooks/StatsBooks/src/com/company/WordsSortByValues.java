package com.company;

import java.util.Comparator;

//on crée une classe qui implémente l'interface Comparator afin d'utiliser des objets de ce type dans la Collections.sort
public class WordsSortByValues implements Comparator {

//adaptation de la methode compare de l'interface comparator à notre cas
    //la méthode renvoie un entier
    // /* https://openclassrooms.com/fr/courses/1826586-java-et-les-collections/2666791-generalites */

    @Override
    public int compare(Object o1, Object o2) {
        //si les références des objets o1 et o2 sont null, ou si les classes ne sont pas de Word alors Exceptions
        //NullPointerException - if an argument is null and this comparator does not permit null arguments
        if (o1 == null || o2 == null) {
            throw new NullPointerException("Arguments should not be null");
        }
        //ClassCastException - if the arguments' types prevent them from being compared by this comparator.
        if (!(o1 instanceof Word) || !(o2 instanceof Word)) {
            throw new ClassCastException("Arguments should be Word");
        }
//sinon
            Word word1 = (Word) o1;
            Word word2 = (Word) o2;
            int occurenceComp1 = word1.getOccurrence();
            int occurenceComp2 = word2.getOccurrence();
            int i = 0;
            if (occurenceComp1 < occurenceComp2) i = 1;
            if (occurenceComp1 > occurenceComp2) i = -1;
            return i;
    }
}