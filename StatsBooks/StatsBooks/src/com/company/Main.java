package com.company;

import java.io.*;
import java.util.*;

// version 1 du code entre try et catch
// suite à  printTopOfWords(book1.getListOfWords(), 2); la ligne suivante a été demandée.
// import static com.company.Book.printTopOfWords;
// normal car en l'état le compilateur ne sait pas où trouver la méthode
// par ailleurs cette méthode est au niveau de la classe Book
// il faudrait donc Book.printTopOfWords
//
// initialement on a : public static void printTopOfWords(ArrayList<Word> arrayToStudy, int number) qui est une méthode de classe
// on la rend méthode d'instance book.printTopOfWords(int number) avec book qui est une instance de Book

public class Main {

    public static void main(String[] args) {
        // write your code here
        //
        //
// DEV POUR ATTRIBUT STATIC - Debut
        ////TestStatic.setCompteurStatic(5);

        ////TestStatic testStatic1 = new TestStatic(0);
        ////TestStatic testStatic2 = new TestStatic(2);
        //// System.out.println("TestStatic avant : ");
        ////System.out.println(TestStatic.getCompteurStatic());
        ////for (int i = 0; i != 5; ++i) {
        ////    ++testStatic1.compteurNonStatic;
        ////    ++testStatic1.compteurStatic;
        ////    ++testStatic2.compteurNonStatic;
        ////    ++testStatic2.compteurStatic;
        ////}
        ////System.out.println("testStatic1 : ");
        ////System.out.println(testStatic1.compteurNonStatic);
        ////System.out.println(testStatic1.compteurStatic);
        ////System.out.println("testStatic2 : ");
        ////System.out.println(testStatic2.compteurNonStatic);
        ////System.out.println(testStatic2.compteurStatic);
        ////System.out.println("TestStatic apres : ");
        ////System.out.println(TestStatic.compteurStatic);
        ////testStatic1.compteurStatic = testStatic1.compteurNonStatic;
        ////System.out.println(testStatic1.compteurStatic);
        ////System.out.println(TestStatic.getCompteurStatic());
        // DEV POUR ATTRIBUT STATIC - Fin
        //
        //
        // création d'un treeset à partir des fichiers passés en argument
        // ce set contiendra l'ensemble des livres, il sera modifiable
        TreeSet<Book> library = new TreeSet<Book>();
        for (int i = 0; i != args.length; ++i) {
            Book book = new Book(args[i], fillArrayList(args[i]));
            library.add(book);
        }
        //
        //La boucle pour valoriser la treeset remplace :
        String path1 = "/Users/admin/Documents/FichiersDeTest/abcd.txt";
        Book book1 = new Book(path1, fillArrayList(path1));
        //
        String path2 = "/Users/admin/Documents/FichiersDeTest/abc.txt";
        Book book2 = new Book(path2, fillArrayList(path2));
        //

        // EN COURS DEBUT
        //choix de l'utilisateur
        //int choice = 0;
        //
        //do {
        //menu: hashMap à afficher
        //switch pour les choix : liste, add, remove, stats (1, 2, 50mots, ...), quitter
        //    printPrincipalMenu();
        //
        // prise en compte et traitement du choix de l'utilisateur
        //    Scanner sc = new Scanner(System.in); // lecture depuis l'entrée standard (clavier)
        //    choice = sc.nextInt();
        //    switch (choice) {
        //
        // choix 1 : liste des fichiers
        //        case 1: {
        //            if (library.isEmpty()) {
        //                System.out.println("La liste est vide.");
        //            }
        //            else{
        //                Iterator<Book> iter = library.iterator();
        //                while (iter.hasNext()) {
        //                    System.out.println(iter.next().getPath());
        //                    break;
        //                }
        //            }
        //        }
        //        case 2: {

//                }
        //          }
        //}
        //while (choice != 5);
        // EN COURS FIN

        //Affichage du nombre total de mots
        System.out.println("Nombre total de mots : " + book1.sumValuesInArrayList());
        //Affichage du nombre total de mots différents
        System.out.println("Nombre de mots différents = " + book1.getListOfWords().size());
        //
        //code qui fonctionne ; utilisé pour vérification
        //Iterator<Word> iter = book1.getListOfWords().iterator();
        //while (iter.hasNext()){
        //System.out.println(iter.next().getContents());}
        //
        try {
            // version 1 en utilisant : 1) le sort de façon indépendante 2) une méthode de classe
            //v1 //Tri en utilisant Collections.sort(public static <T> void sort(List<T> list, Comparator<? super T> c)
            //v1 ArrayList<Word> filledArrayList = book1.getListOfWords();
            //v1 WordsSortByValues wordsSortByValues = new WordsSortByValues();
            //v1 Collections.sort(filledArrayList, wordsSortByValues);
            //v1 //Appel de la fonction "TOP 50"
            //v1 Book.printTopOfWords(book1.getListOfWords(), 2);
            //
            // version 2 en utilisant : 1) une seule méthode pour tout 2) une méthode d'instance
            book1.printTopOfWords(2);
            //
        } catch (NullPointerException e) {
            System.out.println("Erreur sur le tri " + e.getLocalizedMessage());
        } catch (ClassCastException e) {
            System.out.println("Erreur sur le tri " + e.getLocalizedMessage());
        }
        //
        //code qui fonctionne ; utilisé pour vérification
        //Iterator<Word> iterbis = book1.getListOfWords().iterator();
        //while (iterbis.hasNext()) {
        //    System.out.println(iterbis.next().getContents());
        //}
        //
        //version 1 en utilisant une méthode de classe
        //HashSet<String> hashSet1 = listToSetOfString(book1.getListOfWords());
        //version 2 en utilisant une méthode d'instance
        HashSet<String> hashSet1 = book1.listToSetOfString();
        System.out.println("SET1 = " + hashSet1);
        //
        //version 1 en utilisant une méthode de classe
        //HashSet<String> hashSet2 = listToSetOfString(book2.getListOfWords());
        //version 2 en utilisant une méthode d'instance
        HashSet<String> hashSet2 = book2.listToSetOfString();
        System.out.println("SET2 = " + hashSet2);
        //
        HashSet<String> hashSetIntersection = setIntersectionResult(hashSet1, hashSet2);
        System.out.println("Intersection = " + hashSetIntersection);
        HashSet<String> hashSetNoIntersection = setNoIntersectionResult(hashSet1, hashSet2);
        System.out.println("noIntersection = " + hashSetNoIntersection);

        System.out.println("Le % des mots de " + hashSet1 + " présents dans " + hashSet2 + " est " + percentage(hashSet1, hashSet2) + "%.");

        //AUTRE EXERCICE AVEC DES FICHIERS
        // test 1 fichier : basique ; avec io.File
        File f = new File("test.txt");
        //try {
        //    System.out.println("Chemin du fichier " + f + " : " + f.getAbsolutePath());
        //}
        // test 2 fichier : avec BufferedInpuStream
        try {
            BufferedReader fi = new BufferedReader(new FileReader("/Users/admin/IdeaProjects/StatsBooks/src/com/company/Test.txt"));
            System.out.println(fi.readLine());
            PrintStream fo = new PrintStream(new FileOutputStream("/Users/admin/IdeaProjects/StatsBooks/src/com/company/Test2.txt"));
            fo.println("squat;30;30");
        } catch (IOException e) {
            System.out.println("Fichier non trouvé");
        }
    }


    ////////////////////////////////////////////////////////////////////////////////
    //FONCTIONS
/////////////////////////////////////////////////////////////////   ///////////////
    //
    //remplissage de l'arraylist pour un book
    public static ArrayList<Word> fillArrayList(String path) {
        ArrayList<Word> arrayFilled = new ArrayList<Word>();
        try {
            Scanner sc = new Scanner(new File(path));
            for (int i = 0; sc.hasNextLine(); ++i) {

                // 1 mot à traiter : traiter = stocker quelque part; quelque part = liste de mot;
                // Stocker dans 1 liste de mot
                // 1°) regarder si le mot est présent dans la liste
                // 2.a) si le mot n'est pas présent, alors stocker (mot, occurrence=1) == nouvelle instance de word
                // 2.b) si le mot est présent, alors modifier le stockage actuel du mot en stockant (mot, occurrence actuelle+1)

                String wordToAddContents = sc.nextLine();
                ////Word wordToAdd = new Word(wordToAddContents,1);
                ////if (isContentsInArrayList(arrayFilled, wordToAdd)>0) {
                //              wordToAdd.setOccurrence(wordToAdd.getOccurrence() + 1);
                ////    wordToAdd.setOccurrence(isContentsInArrayList(arrayFilled,wordToAdd) + 1);
                //ajout à une position précise dans la liste; l'utilisation de indexOf nécessite une redéfinition de equals
                //arrayFilled.add(arrayFilled.indexOf(wordToAdd), wordToAdd);
                ////} else {
                //ajout à la fin de la liste
                ////    arrayFilled.add(wordToAdd);
                ////}
                Word wordToUpdate = getWordFromArrayList(wordToAddContents, arrayFilled);
                if (wordToUpdate == null) {
                    Word wordToAdd = new Word(wordToAddContents, 1);
                    arrayFilled.add(wordToAdd);
                } else {
                    wordToUpdate.setOccurrence(wordToUpdate.getOccurrence() + 1);
                }
            }
            //pour vérif :
            //System.out.println(getWordFromArrayList("b", arrayFilled).getContents());
            //
            // fichier non trouvé
        } catch (FileNotFoundException e) {
            System.out.println("Erreur sur le fichier " + e.getLocalizedMessage());
        }
        return arrayFilled;
    }

    //parcours de l'arraylist pour savoir si un mot lu est déjà dans la liste
    //iteration sur la liste
    //NE SERT PAS; remplacee par getWordFromArrayList(wordToAddContents,arrayFilled)
    //public static boolean isContentsInArrayList(ArrayList<Word> arrayToStudy, Word word) {
    //public static int isContentsInArrayList(ArrayList<Word> arrayToStudy, Word word) {
    //    Iterator<Word> iter = arrayToStudy.iterator();
    //    while (iter.hasNext()) {
    //        if (word.equals(iter.next()) == true) {
    //            return true;
    //        }
    //        ;
    //if (word.equals(iter.next())==true) {return iter.next().getOccurrence();} ;
    //    }
    //    return false;
    //return 0;
    //}

    //parcours de l'arraylist pour avoir la somme des valeurs associées à chaque contents
    //iteration sur la liste
    // ci-dessous version 1 : on va essayer d'en faire une méthode d'instance : cf. Book méthode en version 2
    //public static int sumValuesInArrayList(ArrayList<Word> arrayToStudy) {
    //    Iterator<Word> iter = arrayToStudy.iterator();
    //    int i = 0;
    //    while (iter.hasNext()) {
    //        i = i + iter.next().getOccurrence();
    //    }
    //    return i;
    //}

    //parcours de l'arraylist pour savoir si un contents lu est déjà dans la liste
    //iteration sur la liste
    //on renvoie un objet de type Word si trouvé , un null si non trouvé
    public static Word getWordFromArrayList(String content, ArrayList<Word> wordsList) {
        Iterator<Word> iter = wordsList.iterator();
        while (iter.hasNext()) {
            //if (word.equals(iter.next())==true) {return true;} ;
            Word word = iter.next();
            if (content.equals(word.getContents()) == true) {
                return word;
            }
        }
        //return false;
        return null;
    }

    //fonction qui permet d'afficher les n premiers mots d'une arrayliste de word -- DEPLACEE dans la classe Book
    //public static void printTopOfWords(ArrayList<Word> arrayToStudy, int number) {
    //    System.out.println("TOP " + number + " des mots les plus utilisés : ");
    //Iterator<Word> iter = arrayToStudy.iterator();
    //    for (int i = 0; iter.hasNext() && i != number; ++i) {
    //        Word word = iter.next();
    //        System.out.println("Mot : " + word.getContents() + " présent " + word.getOccurrence() + " fois");
    //    }
    //}

    //fonction qui crée un set de String à partir d'une liste de Word
    // ci-dessous version 1 : on va essayer d'en faire une méthode d'instance : cf. Book méthode en version 2
    //public static HashSet<String> listToSetOfString(ArrayList<Word> arrayListToConvert) {
    //    HashSet<String> hashSet = new HashSet<String>();
    //    ListIterator<Word> listIterator = arrayListToConvert.listIterator();
    //    while (listIterator.hasNext()) {
    //        hashSet.add(listIterator.next().getContents());
    //    }
    //    return hashSet;
    //}

    //fonction qui renvoie un set qui est une intersection entre deux sets
    public static HashSet<String> setIntersectionResult(HashSet<String> hashSet1, HashSet<String> hashSet2) {
        HashSet<String> hashSetInter = new HashSet<String>();
        //on crée une deep copy du set 1 (pas de shallow copie car il faut contenus différents à la fin) et on va travailler sur cette copie
        //ainsi le retainAll va altérer la copie pas l'original
        hashSetInter.addAll(hashSet1);
        hashSetInter.retainAll(hashSet2);
        return hashSetInter;
    }

    //fonction qui renvoie un set qui contient les éléments n'appartenant pas à un autre set
    public static HashSet<String> setNoIntersectionResult(HashSet<String> hashSet1, HashSet<String> hashSet2) {
        HashSet<String> hashSetNoInter = new HashSet<String>();
        hashSetNoInter.addAll(hashSet1);
        //
        HashSet<String> hashSetInter = new HashSet<String>();
        hashSetInter = setIntersectionResult(hashSet1, hashSet2);
        //
        hashSetNoInter.removeAll(hashSetInter);
        //
        return hashSetNoInter;
    }

    //fonction qui renvoie le % de mots du fichier 1 présents dans le fichier 2
    public static int percentage(HashSet<String> hashSet1, HashSet<String> hashSet2) {
        //abcd et abcde => 100
        //abcd et bcdef => 80
        // % = ( intersection (s1 et S2) / taille s1 ) * 100
        if (hashSet1.size() == 0) return 0;
        System.out.println(setIntersectionResult(hashSet1, hashSet2).size());
        System.out.println(hashSet1.size());
        return (100 * setIntersectionResult(hashSet1, hashSet2).size() / hashSet1.size());
    }

    //fonction de gestion et d'affichage du menu principal
    public static void printPrincipalMenu() {
        HashMap<Integer, String> principalMenu = new HashMap<Integer, String>();
        principalMenu.put(1, "Lister les fichiers");
        principalMenu.put(2, "Ajouter un fichier");
        principalMenu.put(3, "Supprimer un fichier");
        principalMenu.put(4, "Afficher des informations sur un livre");
        principalMenu.put(5, "Quitter");
        for (int i : principalMenu.keySet()) {
            System.out.println(i + ". " + principalMenu.get(i));
        }
    }

}