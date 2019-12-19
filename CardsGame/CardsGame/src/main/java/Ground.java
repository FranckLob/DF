public class Ground extends Card {
//    private CardType cardType;
    private GroundColor color;
    private int manaPoints;

    public Ground(GroundColor color, int manaPoints) {
        // le "super" pour appeler le constructeur de la classe abstraite Carte doit être en première position
        super(0);
//        this.cardType = CardType.TERRAIN;
        this.color = color;
        this.manaPoints = manaPoints;
    }

    public GroundColor getColor() {
        return color;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    @Override
    void display() {
        System.out.println("----------------------------------------");
        //System.out.println("Carte de type :  " + CardType.TERRAIN);
        System.out.println("Carte de type :  TERRAIN");
        System.out.println("Couleur :        " + this.color);
        System.out.println("Points de mana : " + this.manaPoints);
        System.out.println("Cout :           0");
        System.out.println("----------------------------------------");

    }

}
