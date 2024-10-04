
import java.util.ArrayList;
import java.util.Collections; 
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer; 

public class IntervalScheduling {


   public static void main(String[] args){
       try{
           if(args.length!=1){throw new IllegalArgumentException();}
           if(args[0].matches("\\d")){throw new IllegalArgumentException();}

           String path = args[0];
           BufferedReader file = new BufferedReader( new FileReader( path ) );
           ArrayList<Interval> input = new ArrayList<Interval>();

           //Solange noch Intervalle eingelesen werden können machen wir das auch
           while(file.ready()){
           
           String zeile = file.readLine();
           StringTokenizer st = new StringTokenizer(zeile,",");
           int start = Integer.parseInt(st.nextToken()); 
           int ende = Integer.parseInt(st.nextToken());
           Interval ivall = new Interval(start, ende);
           input.add(ivall);
           }

           //Wenn die Datei leer ist, abbrechen
           if(input.isEmpty()){
            System.out.println("FEHLER: da ist eine leere Datei am start;");
            file.close();
            return;
            }

           //Kopie des Inputs sortieren
           ArrayList<Interval> array= new ArrayList<Interval>();
            for(int f=0;f<input.size();f++){array.add(input.get(f));}
           Collections.sort(array);

         //Ausgabe mit Inervale + sortierte Intervale + Intervale der Lösung + Leerlaufzeit
         if(input.size()<=50){
           System.out.println(input.toString());
           System.out.println(array.toString());
           System.out.println(intervalScheduling(array).toString());
           System.out.println("Leerlaufzeit: "+idleTime(intervalScheduling(array)));
           file.close();
         }

         //Ausgabe mit Intervale der Lösung + Leerlaufzeit
         else{
             System.out.println(intervalScheduling(array).toString());
             System.out.println("Leerlaufzeit: "+idleTime(intervalScheduling(array)));
             file.close();
         }

       }
       catch(IllegalArgumentException e){System.out.println("FEHLER: Als Eingabe wird genau ein Pfad für eine CSV Datei erwartet!");}
       catch(FileNotFoundException e){System.out.println("FEHLER: So eine Datei existiert nicht!");}

       //Fehler in den Dateien sollen keine Exceptions hervorrufen
       catch(IOException e){}
      

   }
   
    public static ArrayList<Interval> intervalScheduling (ArrayList<Interval> intervals){
       
       
        int n = intervals.size()-1;
        ArrayList<Interval> lul=new ArrayList<Interval>();
        lul.add(intervals.get(0));
        int j=0;
        for(int i=1;i<=n;i++){
            
            //[1-j] und [i-90]
            if(intervals.get(i).getStart()>=intervals.get(j).getEnd()){
                lul.add(intervals.get(i));
                j=i;
            }
        }
        return lul;
    }
     // Wenn [1-3] und [5-8], dann ist leerlaufzeit 2    <- Berechung: 5-3=2
    public static int idleTime(ArrayList<Interval> intervals){
     int leer=0;
     for(int i=0;i<intervals.size()-1;i++){

         if(intervals.get(i).getEnd()!=intervals.get(i+1).getStart()){

             leer=leer+intervals.get(i+1).getStart()-intervals.get(i).getEnd();
         }
     }
       
        return leer;

    }
    
}