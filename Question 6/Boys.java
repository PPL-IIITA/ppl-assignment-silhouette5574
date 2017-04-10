//package ppl;

public class Boys{
    String name;
    int intelligence;
    int attractiveness;
    int budget;
    int min_attractiveness;
    String type;
    int happiness;
    int compatibility;
    String status;
    Girls girlfriend;
    gifts gift;
    
    //constructor to initialise variables
    public Boys(String name, int intelligence, int attractiveness, int budget, int min_attractiveness, String type, String status) {
        this.name = name;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.budget = budget;
        this.min_attractiveness = min_attractiveness;
        this.type = type;
        this.status = status;
    }
    public String toString(){
        return name;
    }
}
