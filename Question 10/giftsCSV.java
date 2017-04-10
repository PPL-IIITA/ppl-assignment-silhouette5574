//package Question3;
//package ppl;

import java.io.*;
import java.util.*;

public class giftsCSV{
    int num_gifts;
    
    giftsCSV(int num_gifts){
        this.num_gifts = num_gifts;
    }
    
    void generate(){
        try(FileWriter grand = new FileWriter("fgifts.csv")) {
            int j, value, price;
            Random gr = new Random();
            String gift_type[] = {"Essential","Luxury","Utility"};
            String s = "";
            for(j = 0; j <= num_gifts; j++){
                int gtype = gr.nextInt(3);
				s = s + gift_type[gtype] + "," + gr.nextInt(100) + "," + gr.nextInt(100) + "\n";
            }
            grand.write(s);
		}
        catch(IOException e){		
		}
    }
}