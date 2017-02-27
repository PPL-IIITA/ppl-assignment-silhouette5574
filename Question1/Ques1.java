//package ppl.assignment;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ques1 {
        static Boys bar[] = new Boys[100];
        static Girls gar[] = new Girls[100];

        static void allocate(int b, int g){
            int i, j;
            for(i = 0; i < g; i++){
                for(j = 0; j < b; j++){
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
        
        public static void main(String[] args) throws IOException{
            try{
                //Ques1 obj = new Ques1();
                int b, g;
                String name, type, status;
                int intelligence, attractiveness, min_attractiveness;
                double budget, maintenance;
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
                        budget = Double.parseDouble(parts[3]);
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
                        maintenance = Double.parseDouble(parts[3]);
                        type = parts[4];
                        status = parts[5];
                        gar[g] = new Girls(name, intelligence, attractiveness, maintenance, type, status);
                        g++;
                        str = br2.readLine();
                }
                br2.close();
               
                allocate(b, g);
             
                BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));
                //System.out.println("Following are the Committed couples are:");
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
            }
            catch(IOException e){		
            }
        }
}
