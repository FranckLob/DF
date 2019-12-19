public abstract class Card {
    //on est obligé de mettre une portée public ou package pour que les classes filles puissent "voir" cet attribut
    //package ici donc
    int cost;

    public Card(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    abstract void display();

}
