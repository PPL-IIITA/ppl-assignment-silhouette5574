//package ppl;

public class Girls{
    String name;
    int intelligence;
    int attractiveness;
    int maintenance;
    String type;
    int happiness;
    int compatibility;
    String status;
    Boys boyfriend;
    gifts gift;
    
    //constructor to initialise variables
    public Girls(String name, int intelligence, int attractiveness, int maintenance, String type, String status) {
        this.name = name;
        this.intelligence = intelligence;
        this.attractiveness = attractiveness;
        this.maintenance = maintenance;
        this.type = type;
        this.status = status;
    }
    
    public String toString(){
        return name;
    }
}
