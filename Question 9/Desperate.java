//package Question3;
//package ppl;

public class Desperate extends Girls{
    
    public Desperate(String name, int intelligence, int attractiveness, int maintenance, String status) {
        type = "Desperate";
        this.name = name;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.maintenance = maintenance;
        this.status = status;
    }
    
    public String toString(){
        return name;
    }
}
