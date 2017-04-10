//package Question3;
//package ppl;

public class Geek extends Boys{
    
    public Geek(String name, int intelligence, int attractiveness, int budget, int min_attractiveness, String status) {
        type = "Geek";
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
