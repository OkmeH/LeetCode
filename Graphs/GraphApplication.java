import java.io.IOException;

public class GraphApplication {
    
    public static void main(String[] args){
        try{
            //Anzahl der Argumente prüfen, alles andere wird durch fromFile behandelt
            if(args.length!=1){throw new IllegalArgumentException();}
            Graph graph= new Graph();
           String filepath= args[0];

           //Dateibedingte Fehlerbehandlungen sind in der Methode fromFile behandelt
          assert graph.fromFile(filepath) !=null :"FEHLER: beim Einlesen der Datei";
            System.out.println(graph.toString());

        }catch(IllegalArgumentException e){System.out.println("FEHLER: Als Eingabe wird nur ein pfad zu deiner graph Datei akzeptiert");}
        catch(IOException e){System.out.println("FEHLER: beim Einlesen der datei");}
    }
}