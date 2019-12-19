public class Creature extends Card {
    private String name;
    private int damagesPoints;
    private int lifePoints;

    //Dans les constructeurs de la classe dérivée, la première chose à faire est d'appeler un constructeur de la classe parente avec un appel à super(/*liste d'arguments éventuels*/)//
    public Creature(int cost, String name, int damagesPoints, int lifePoints) {
        super(cost);
        this.name = name;
        this.damagesPoints = damagesPoints;
        this.lifePoints = lifePoints;
    }

    public String getName() {
        return name;
    }

    public int getDamagesPoints() {
        return damagesPoints;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    @Override
    void display() {
        System.out.println("----------------------------------------");
        System.out.println("Carte de type :    CREATURE");
        System.out.println("Nom :              " + this.name);
        System.out.println("Points de dégâts : " + this.damagesPoints);
        System.out.println("Points de vie :    " + this.lifePoints);
        System.out.println("Cout :             " + this.cost);
        System.out.println("----------------------------------------");
    }

}
