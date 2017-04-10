//package ppl;

public class gifts {
    String gtype;
    int price;
    int value;
    
    //constructor to initialise variables

    /**
     *
     * @param type
     * @param price
     * @param value
     */
    public gifts(String gtype, int price, int value) {
        this.gtype = gtype;
        this.price = price;
        this.value = value;
    }
    public String toString(){
        return gtype;
    }
}
