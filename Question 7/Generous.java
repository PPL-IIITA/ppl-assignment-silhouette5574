//package Question3;
//package ppl;

public class Generous extends Boys{
    
    public Generous(String name, int intelligence, int attractiveness, int budget, int min_attractiveness, String status) {
        type = "Generous";
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
