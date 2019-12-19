public class Spell extends Card {
    private String name;
    private String explanation;

    public Spell(int cost, String name, String explanation) {
        super(cost);
        this.name = name;
        this.explanation = explanation;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    @Override
    void display() {
        System.out.println("----------------------------------------");
        System.out.println("Carte de type : SORTILEGE");
        System.out.println("Nom :           " + this.name);
        System.out.println("Explication :   " + this.explanation);
        System.out.println("Cout :          " + this.cost);
        System.out.println("----------------------------------------");
    }
}

