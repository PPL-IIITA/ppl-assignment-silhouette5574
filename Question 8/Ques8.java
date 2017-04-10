//package Question3;
//package ppl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Ques8 {
        static Boys bar[] = new Boys[100];
        static Girls gar[] = new Girls[100];    
    
        static void bubbleSort(int arr[], int index[]){  
            int n = arr.length;  
            int temp = 0;  
            int temp2 = 0;
            for(int i = 0; i < n; i++){  
                for(int j = 1; j < (n-i); j++){  
                    if(arr[j-1] < arr[j]){      //Descending order
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

        static int allocate(int b, int g, int gc, Girls gar[], Boys bar[]){
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
        
        static void allocateGifts(int g, gifts gtar[], Girls gar[]){
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
                        
                        if(type.equals("Miser")){
                            //Miser bar[] = new Miser[100];
                            bar[b] = new Miser(name, intelligence, attractiveness, budget, min_attractiveness, status);
			}
			else if(type.equals("Generous")){
                            //Generous bar[] = new Generous[100];
                            bar[b] = new Generous(name, intelligence, attractiveness, budget, min_attractiveness, status);
                        }
			else if(type.equals("Geek")){
                            //Geek bar[] = new Geek[100];
                            bar[b] = new Geek(name, intelligence, attractiveness, budget, min_attractiveness, status);
			}					
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
                        if(type.equals("Choosy")){
                            //Choosy gar[] = new Choosy[100];
                            gar[g] = new Choosy(name, intelligence, attractiveness, maintenance, status);
                        }
			else if(type.equals("Normal")){
                            //Normal gar[] = new Normal[100];
                            gar[g] = new Normal(name, intelligence, attractiveness, maintenance, status);
			}
                       	else if(type.equals("Desperate")){
                            //Desperate gar[] = new Desperate[100];
                            gar[g] = new Desperate(name, intelligence, attractiveness, maintenance, status);
			}
                        g++;
                        str = br2.readLine();
                }
                br2.close();
               
                gc = allocate(b, g, gc, gar, bar);
                
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
                        
						if(type.equals("Essential")){
							//Essential gtar[] = new Essential[gc];
							gtar[i] = new gifts(type, price, value);
						}
						else if(type.equals("Luxury")){
							//Luxury gtar[] = new Luxury[gc];
							gtar[i] = new gifts(type, price, value);
						}
						else if(type.equals("Utility")){
							//Utility gtar[] = new Utility[gc];
							gtar[i] = new gifts(type, price, value);
						}
                        i++;
                        str = br3.readLine();
                }
                br3.close();
                
                allocateGifts(g, gtar, gar);
                
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
            }
            catch(IOException e){		
            }
        }
}
