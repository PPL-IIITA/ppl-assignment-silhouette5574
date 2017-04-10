//package ppl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ques4 {
        static Boys bar[] = new Boys[100];
        static Girls gar[] = new Girls[100];
        
        static void bubbleSort(int arr[], int index[]){  
            int n = arr.length;  
            int temp = 0;  
            int temp2 = 0;
            for(int i = 0; i < n; i++){  
                for(int j = 1; j < (n-i); j++){  
                    if(arr[j-1] > arr[j]){        //Ascending order
                        temp = arr[j-1];  
                        arr[j-1] = arr[j];  
                        arr[j] = temp;  
                        
                        temp2 = index[j-1];  
                        index[j-1] = index[j];  
                        index[j] = temp2;
                    }        
                 }
            }
        }

        static int allocate(int b, int g, int gc){
            int i, j;
            for(i = 0; i < g; i++){
                for(j = 0; j < b; j++){
                    if(gar[i].status.equals("single") && gar[i].maintenance <= bar[j].budget && bar[j].status.equals("single") && gar[i].attractiveness >= bar[j].min_attractiveness){
                        gar[i].boyfriend = bar[j];
                        bar[j].girlfriend = gar[i];
                        gar[i].status = "committed";
                        bar[j].status = "committed";
                        gc++;
                        break;
                    }
                }
            }
            return gc;
        }
        
        static void reallocation(int b, int g){
            int i, j;
            for(i = 0; i < g; i++){
                for(j = b-1; j >= 0; j--){
                    if(gar[i].status.equals("single") && gar[i].maintenance <= bar[j].budget && bar[j].status.equals("single") && gar[i].attractiveness >= bar[j].min_attractiveness){
                        gar[i].boyfriend = bar[j];
                        bar[j].girlfriend = gar[i];
                        gar[i].status = "committed";
                        bar[j].status = "committed";
                        break;
                    }
                }
            }
        }
        
        static void allocateGifts(int g, gifts gtar[]){
            int i, j = 0;
            for(i = 0; i < g; i++){
                    if(gar[i].status.equals("committed")){
                        gar[i].gift = gtar[j];
                        //System.out.println(gar[i] + "  " + gar[i].gift);
                        gar[i].boyfriend.gift = gtar[j];
                        j++;
                    }
            }
        }
        
        public static void main(String[] args) throws IOException{
            try{
                //Ques1 obj = new Ques1();
                int b, g, gc = 0;
                String name, type, status;
                int intelligence, attractiveness, min_attractiveness, price, value;
                int budget, maintenance;
                Random rr = new Random();
                int num_boys, num_girls;
                num_boys = rr.nextInt(25) + 25;
                num_girls = num_boys + 10;
                GirlCSV rb = new GirlCSV(num_girls);
                BoyCSV rg = new BoyCSV(num_boys);
                rb.generate();
                rg.generate();
                
                File fboy = new File("fboy.csv");
                BufferedReader br= new BufferedReader(new FileReader(fboy));
                String str;
                str = br.readLine();
                b = 0;
                while(str != null){
                        String parts[] = str.split(",");
                        name = parts[0];
                        intelligence = Integer.parseInt(parts[1]);
                        attractiveness = Integer.parseInt(parts[2]);
                        budget = Integer.parseInt(parts[3]);
                        min_attractiveness = Integer.parseInt(parts[4]);
                        type = parts[5];
                        status = parts[6];
                        bar[b] = new Boys(name, intelligence, attractiveness, budget, min_attractiveness, type, status);
                        b++;
                        str = br.readLine();
                }
                br.close();
                
                g=0;
                File fgirl=new File("fgirl.csv");
                BufferedReader br2 = new BufferedReader(new FileReader(fgirl));
                str = br2.readLine();
                while(str != null){
                        String parts[] = str.split(",");
                        name = parts[0];
                        intelligence = Integer.parseInt(parts[1]);
                        attractiveness = Integer.parseInt(parts[2]);
                        maintenance = Integer.parseInt(parts[3]);
                        type = parts[4];
                        status = parts[5];
                        gar[g] = new Girls(name, intelligence, attractiveness, maintenance, type, status);
                        g++;
                        str = br2.readLine();
                }
                br2.close();
               
                gc = allocate(b, g, gc);
                
                BufferedWriter bw = new BufferedWriter(new FileWriter("couples.csv"));
                int i;
                for(i = 0; i < g; i++){
                    if(gar[i].status.equals("committed")){
                        
                        String ts1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                        String ts2 = new SimpleDateFormat("hh.mm.ss").format(new Date());
                        str =  gar[i].name + " is committed to " + gar[i].boyfriend.name + " on " + ts1 + " at " + ts2;
                        bw.write(str + "\r\n");
                        bw.flush();
                    }
                }
               
                //System.out.println(gc);
                gc++;
                
                gifts gtar[] = new gifts[gc];  //gift array
                giftsCSV gt = new giftsCSV(gc);
                gt.generate();
                
                File fgift = new File("fgifts.csv");
                BufferedReader br3 = new BufferedReader(new FileReader(fgift));
                str = br3.readLine();
                i = 0;
                while(i != gc){
                        String parts[] = str.split(",");
                        type = parts[0];
                        price = Integer.parseInt(parts[1]);
                        value = Integer.parseInt(parts[2]);
                        gtar[i] = new gifts(type, price, value);
                        i++;
                        str = br3.readLine();
                }
                br3.close();
                
                allocateGifts(g, gtar);
                
                BufferedWriter bw2 = new BufferedWriter(new FileWriter("gifts.csv"));
                for(i = 0; i < g; i++){
                    
                    if(gar[i].status.equals("committed")){
                        //System.out.println(gar[i] + "  " + gar[i].gift);
                        String ts1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                        String ts2 = new SimpleDateFormat("hh.mm.ss").format(new Date());
                        str =  gar[i].boyfriend.name + " gave " + gar[i].gift.gtype + " gift to " + gar[i].name + " on " + ts1 + " at " + ts2;
                        bw2.write(str + "\r\n");
                        bw2.flush();
                    }
                }
                                
                girlHappiness ghp = new girlHappiness();
                boyHappiness bhp = new boyHappiness();
                ghp.girlHappy(g, gar);
                bhp.boyHappy(b, bar);
                
                int happiness[] = new int[gc];
                int index2[] = new int[gc];
                for (i = 0; i < gc; i++) {
                    happiness[i] = 0;
                    index2[i] = 0;
                }
                int j = 0;
                for(i = 0; i < g; i++){
                    if(gar[i].status.equals("committed")){
                        happiness[j] = (int)(gar[i].happiness + gar[i].boyfriend.happiness);
                        index2[j] = i;
                        j++;
                    }
                }
                
                bubbleSort(happiness, index2);
                
                int k = rr.nextInt(gc-1) % 10 + 5;      // K taken randomly
                System.out.println(k);
                
                BufferedWriter bw3 = new BufferedWriter(new FileWriter("leastHappy.csv"));
                str = "Least " + k + " Happiest Couples are :";
                bw3.write(str + "\r\n");
                bw3.flush();
                for(i = 0; i < k; i++){
                        str = gar[index2[i]] + " and " + gar[index2[i]].boyfriend/* + " --> " + happiness[i]*/;
                        gar[index2[i]].status = "single";
                        gar[index2[i]].boyfriend.status = "single";
                        bw3.write(str + "\r\n");
                        bw3.flush();
                }
                
                reallocation(b, g);   // reallocate after breakup
                
                BufferedWriter bw4 = new BufferedWriter(new FileWriter("new_couples.csv"));
                for(i = 0; i < g; i++){
                    if(gar[i].status.equals("committed")){
                        
                        String ts1 = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
                        String ts2 = new SimpleDateFormat("hh.mm.ss").format(new Date());
                        str =  gar[i].name + " is committed to " + gar[i].boyfriend.name + " on " + ts1 + " at " + ts2;
                        bw4.write(str + "\r\n");
                        bw4.flush();
                    }
                }
            }
            catch(IOException e){		
            }
        }
}
