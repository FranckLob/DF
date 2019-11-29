import java.util.ArrayList;
import java.util.List;

public class MainJeu {
        public static void main(String args[]){
            //création de 4 cartes
            Ground groundCard1 = new Ground(GroundColor.BLANC,31);
            Ground groundCard2 = new Ground(GroundColor.BLEU,32);
            Creature creatureCard1 = new Creature(444, "Creature1",41,141);
            Creature creatureCard2 = new Creature(444, "Creature2",42,142);
            Spell spellCard1 = new Spell(555,"Sortilege1","parler sans arrêt");
            //création d'un jeu de cartes
            List<Card> cardsList = new ArrayList<Card>();
            Game cardsGame = new Game(cardsList);
            //on pioche
            cardsGame.draw(groundCard1);
            cardsGame.draw(groundCard2);
            cardsGame.draw(creatureCard1);
            cardsGame.draw(spellCard1);
            //on joue
            cardsGame.play(groundCard1);
            cardsGame.play(groundCard2);
            //la carte creatureCard2 n'existe pas*/
            cardsGame.play(creatureCard2);
            cardsGame.play(creatureCard1);
            cardsGame.play(spellCard1);
            //on essaie d'ajouter une carte alors que les cart  es ont été jouées
            cardsGame.play(spellCard1);
            //on affiche le jeu
            cardsGame.display();
        }
}