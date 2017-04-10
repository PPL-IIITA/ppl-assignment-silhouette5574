//package Question3;
//package ppl;

public class Normal extends Girls{
    
    public Normal(String name, int intelligence, int attractiveness, int maintenance, String status) {
        type = "Normal";
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
