package com.company;

import java.util.*;

public class Book {
    private String path;
    private ArrayList<Word> listOfWords;

    public Book(String path, ArrayList<Word> listOfWords) {
        this.path = path;
        this.listOfWords = listOfWords;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ArrayList<Word> getListOfWords() {
        return listOfWords;
    }

    //fonction (= méthode d'instance ici) qui permet d'afficher les n premiers mots d'une arrayliste de word d'un book = version 2
    public void printTopOfWords(int number) {
        //valeur maxi (uniquement pour manipuler une constante)- ici pas constante de classe car pas de static
         final int MAX=50;
         if (number>MAX) {number=MAX;}
        // tri par valeur des mots
        WordsSortByValues wordsSortByValues = new WordsSortByValues();
        Collections.sort(listOfWords, wordsSortByValues);
        printListOfWords(number);
        //
    }

    //fonction qui affiche les mots et leurs occurences ; affichage du nombre de mots en argument
    //utilisee dans printTopOfWords pour au final avoir une seule méthode appelée (cf. main version 2 pour cette fonctionnalite)
    public void printListOfWords(int number) {
        Iterator<Word> iter = listOfWords.iterator();
        for (int i = 0; iter.hasNext() && i != number; ++i) {
            Word word = iter.next();
            System.out.println("Mot : " + word.getContents() + " présent " + word.getOccurrence() + " fois");
        }
    }

    //fonction qui crée un set de String à partir d'une liste de Word
    // ci-dessous version 2 : on en a fait une méthode d'instance
    public HashSet<String> listToSetOfString() {
        HashSet<String> hashSet = new HashSet<String>();
        ListIterator<Word> listIterator = listOfWords.listIterator();
        while (listIterator.hasNext()) {
            hashSet.add(listIterator.next().getContents());
        }
        return hashSet;
    }

    //parcours de l'arraylist pour avoir la somme des valeurs associées à chaque contents
    //iteration sur la liste
    // ci-dessous version 2 : on en a fait une méthode d'instance
    public int sumValuesInArrayList() {
        Iterator<Word> iter = listOfWords.iterator();
        int i = 0;
        while (iter.hasNext()) {
            i = i + iter.next().getOccurrence();
        }
        return i;
    }


}
