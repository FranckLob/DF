import java.util.Collection;

public class Game {

    //on essaie de faire le plus générique possible : on utilise Collection
    private Collection<Card> cardsGame;

    //nombre de cartes dans le jeu fixé à 4 pour l'instant
    private static final int NUMBER = 4;

    public Game(Collection<Card> cardsGame) {
        this.cardsGame = cardsGame;
    }

    public void draw(Card card) {
        //tentative d'écrire un opérateur ternaire mais ne marche pas car on ne fait pas le même type de traitement dans les 2 cas
        if (this.cardsGame.size() == NUMBER) {
            System.out.println("Plus de cartes à piocher ...");
        } else {
            //add est une méthode de l'interface Collection donc c'est bon ci-dessous
            //ici on ajoute la carte au jeu
            this.cardsGame.add(card);
        }
    }

    public void play(Card card) {
        if (card == null || !this.cardsGame.contains(card)) {
            System.out.println("========================================");
            System.out.println("CARTE NON JOUABLE : ");
            System.out.println("========================================");
            card.display();
            System.out.println("========================================");
        } else {
            //on fait un remove pour supprimer la carte du jeu
            this.cardsGame.remove(card);
        }
    }

    public void display() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("JEU DE CARTES");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        if (this.cardsGame.isEmpty()) {
            System.out.println("Plus de carte à jouer ...");
        } else {
            for (Card card : this.cardsGame) {
                if (card != null) {
                    card.display();
                }
            }
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

}
