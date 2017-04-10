//package ppl;

public class boyHappiness{

    //public void countHappy(String type, int price, int budget, int boyHappiness, int girlHappiness, int girlIntelligence) {
    public void boyHappy(int num_boys, Boys bar[]){
        int i;
        for(i = 0; i < num_boys; i++){
            if(bar[i].status.equals("committed")){
                switch (bar[i].type) {
                    case "Miser":
                        bar[i].budget = bar[i].budget - bar[i].gift.price;
                        bar[i].happiness = bar[i].budget;
                        break;
                    case "Generous":
                        bar[i].budget = bar[i].budget - bar[i].gift.price;
                        bar[i].happiness = bar[i].happiness + bar[i].girlfriend.happiness;
                        break;
                    case "Geek":
                        bar[i].budget = bar[i].budget - bar[i].gift.price;
                        bar[i].happiness = bar[i].happiness + bar[i].girlfriend.intelligence;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}