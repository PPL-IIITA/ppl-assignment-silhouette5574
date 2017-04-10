//package Question3;
//package ppl;

public class Choosy extends Girls{
    
    public Choosy(String name, int intelligence, int attractiveness, int maintenance, String status) {
        type = "Choosy";
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
