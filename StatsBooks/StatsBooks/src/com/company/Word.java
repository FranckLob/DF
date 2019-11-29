package com.company;

import java.util.Objects;

public class Word {
    private String contents;
    private int occurrence;

    public Word(String contents, int occurrence) {
        this.contents = contents;
        this.occurrence = occurrence;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(int occurrence) {
        this.occurrence = occurrence;
    }

    //on redéfinit un equals spécifique à cette classe, on redéfinit le equals de la classe Object qui a une seule instance en paramètre
    //permet aussi de gérer le cas null
    //va nous permettre d'utiliser indexOf laquelle utilise une méthode equals de type Object
    public boolean equals(Object o) {
        //si la référence de l'objet o est null, ou si les classes sont différentes (obtenues avec le getClass de Object)
        if (o == null || getClass() != o.getClass()) return false;
        //(Word) pour caster l'objet o en type Word
        Word word = (Word) o;
        //on peut aussi utiliser la méthode de la classe Objects qui compare 2 instances
        return this.contents.equals(word.contents);
    }

    //surcharge de la méthode equals
    public boolean equals(String contents) {
        if (this.contents != null) {
            return this.contents.equals(contents);
        } else {
            return (contents == null);
        }
    }
}
