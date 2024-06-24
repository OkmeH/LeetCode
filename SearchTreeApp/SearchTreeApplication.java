
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class SearchTreeApplication {
    

    public static void main(String[] args){
        try{
            if(args.length==0){throw new IllegalArgumentException();}
            if(args.length>2){System.out.println("FEHLER: Das Erste Argument muss ein Pfad einer CVS Datei sein und optional ein Zweites für pre-/in-/post-Order");return;}
            if(args.length==2){
                if(!args[1].equals("in") &&!args[1].equals("pre")&& !args[1].equals("post")){
                    System.out.println("FEHLER: Das optionale Zweite Argument muss in,post oder pre sein!");return;}
            }
            String path = "data.cvs";
            //args[0];
            BufferedReader file = new BufferedReader( new FileReader( path ) );
            
            //Solange noch Zahlen eingelesen werden können machen wir das auch
            while(file.ready()){
              
              String zeile = file.readLine();
              String[] sa = zeile.split(",");
              int[] arr = new int[sa.length];
              for (int i = 0; i < sa.length; i++) { 

                assert sa[i].trim()!=null:"FEHLER: konnte nicht getrimmt werden ";
                sa[i] = sa[i].trim(); 

                if (sa[i].matches("[-|+]?[0-9]{1,}")) { 
                    try { 
                        arr[i] = Integer.parseInt(sa[i]); 
                    } catch (NumberFormatException nfe) { 
                        System.out.println("FEHLER: Formatfehler im File!");
                    } 
                }else{
                    file.close();
                    throw new NumberFormatException();}
            }
            // print(arr);

            //default ist  inOrder
            String option ="in";

            if(args.length==2){option=args[1];}
            SearchTree data = new SearchTree(arr);

            assert data.getHeight()>0: "FEHLER: Es gibt keine Elemente";
            System.out.println("Höhe: "+data.getHeight());

            //Abfrage des optionalen Parameter
            if(option.equals("pre")){

                //AUsgabe
                data.preOrder(); 
                System.out.println("");}

            else if(option.equals("post")){

                //Ausgabe
                data.postOrder(); 
                System.out.println("");}

            else{

                //Ausgabe
                data.inOrder();
                 System.out.println("");}
            }

            //Datei wieder closen
             file.close();

        }
        catch(FileNotFoundException e){System.out.println("FEHLER: So eine Datei existiert nicht!");}

        catch(IOException e){System.out.println("FEHLER: Fehler in der Datei!");}

        catch(NumberFormatException e){System.out.println("FEHLER: Formatfehler im File!");}

        catch(IllegalArgumentException e){System.out.println("FEHLER: Als Eingabe wird  ein Pfad für eine CSV Datei erwartet!");}
    }

    //Testmethode
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }System.out.println(" ");
    }
}