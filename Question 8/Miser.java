//package Question3;
//package ppl;

public class Miser extends Boys{
    
    public Miser(String name, int intelligence, int attractiveness, int budget, int min_attractiveness, String status) {
        type = "Miser";
        this.name = name;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.budget = budget;
        this.min_attractiveness = min_attractiveness;
        this.status = status;
    }
    public String toString(){
        return name;
    }
}
