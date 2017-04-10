//package ppl;

import java.io.*;
import java.util.*;

public class BoyCSV{
    int num_boys;
    
    BoyCSV(int num_boys){
        this.num_boys = num_boys;
    }
    
    void generate(){
        try(FileWriter brand = new FileWriter("fboy.csv")) {
            int j;
            Random br = new Random();
            String boy_type[] = {"Miser","Generous","Geek"};
            String s = "";
            for(j = 0; j <= num_boys; j++){
		int btype = br.nextInt(3);
		s = s + "Boy"+j+","+br.nextInt(100)+","+br.nextInt(50)+","+br.nextInt(5000)+","+br.nextInt(40)+","+boy_type[btype]+","+"single"+"\n";
            }
            brand.write(s);
	}
        catch(IOException e){		
	}
    }
}