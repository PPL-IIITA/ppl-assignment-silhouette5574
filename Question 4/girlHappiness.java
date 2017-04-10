//package ppl;

public class girlHappiness{
 
    //public void happy(String type, String giftType, int value, int price, int girlHappiness, int maintenance) {
    public void girlHappy(int num_girls, Girls gar[]){
        int i;
        for(i = 0; i < num_girls; i++){
            if(gar[i].status.equals("committed")){
                if (gar[i].type.equals("Choosy")) {
                    if (gar[i].gift.gtype.equals("Essential") || gar[i].gift.gtype.equals("Utility")) {
                        gar[i].maintenance  = gar[i].maintenance - gar[i].gift.price;
                        gar[i].happiness = gar[i].happiness + (int)Math.log(gar[i].gift.price);
                    }
                    else if (gar[i].gift.gtype.equals("Luxury")) {
                        gar[i].maintenance  = gar[i].maintenance - gar[i].gift.price;
                        gar[i].happiness = gar[i].happiness + (int)Math.log(2 * (gar[i].gift.price));
                    }
                }
                else if (gar[i].type.equals("Normal")) {
                    gar[i].maintenance  = gar[i].maintenance - gar[i].gift.price;
                    gar[i].happiness = gar[i].happiness + gar[i].gift.price + gar[i].gift.value;
                }
                else if (gar[i].type.equals("Desperate")) {
                    gar[i].maintenance  = gar[i].maintenance - gar[i].gift.price;
                    gar[i].happiness = gar[i].happiness + (int)Math.exp(gar[i].gift.price);
                }
            }
        }
    }
}
