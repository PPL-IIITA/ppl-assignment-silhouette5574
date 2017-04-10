//package Question3;
//package ppl;

import java.io.*;
import java.util.*;

public class GirlCSV{
    int num_girls;
    
    GirlCSV(int num_girls){
        this.num_girls = num_girls;
    }
    
    void generate(){
        try(FileWriter grand = new FileWriter("fgirl.csv")) {
            int j;
            String s = "";
            Random gr = new Random();
            String girl_type[] = {"Choosy","Normal","Desperate"};
            for(j = 0;j <= num_girls; j++){
                int gtype = gr.nextInt(3);
		s = s + "Girl"+j+","+gr.nextInt(100)+","+gr.nextInt(50)+","+gr.nextInt(5000)+","+girl_type[gtype]+","+"single"+"\n" ;
            }
            grand.write(s);
	}
        catch(IOException e){		
	}
    }
}
