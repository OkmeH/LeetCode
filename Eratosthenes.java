import java.util.Arrays;

public class Eratosthenes{

    public static void main(String[] args){
        
        int a = Integer.parseInt(args[0]);
        if(a<0){                                                        //a darf nicht negativ sein da es keine negativen Primzahlen gibt
            System.out.println("Bitte positive ganze Zahl angeben!");
        }
        else{
            if(args.length == 2){                                       //Unterscheidung ob man die Primzahlen explizit aufgelistet haben möchte 
                eratosthenesTwo(a,args[1]);
            }
            else{
                eratosthenes(a);
            }
        }
    }

    public static void eratosthenesTwo(int a, String b){
        
            boolean[] isPrime = new boolean[a+1];
            Arrays.fill(isPrime, true);                              // Zum Beginn wird isPrime mit false initialisiert und mit der Methode auf true gesetzt
            if(b.equals("-o")){                                      // Bei korrektem String werden die Primzahlen ausgegeben 
                int counter = 0;
                for(int i = 2; i<isPrime.length; i++){
                    if(isPrime[i]){
                        counter++;
                        for(int j = i+i; j<isPrime.length; j++){     // Das Array wird nach Vielfachen von i durchsucht da sie keine Primzahlen sein können
                            if(j%i == 0){
                                isPrime[j] = false;
                            }
                        }
                    }
                } 
                System.out.println("Anzahl der Primzahlen:"+ counter); // Ausgabe der Anzahl der Primzahlen
                for(int z = 2; z<isPrime.length; z++){
                    if(isPrime[z]){
                        System.out.print( z +" ");                  // Primzahlen werden explizit ausgegeben
                    }
                } 
                System.out.println();    
            }
            else if(!b.equals("-o")){                               // Bei nicht korrektem String wird dieser ignoriert 
                eratosthenes(a);
            }

    }

    public static void eratosthenes(int a){
        
        boolean[] Prime = new boolean[a+1];
        Arrays.fill(Prime, true);                                  // Zum Beginn wird Prime mit false initialisiert und mit der Methode auf true gesetzt
        int count = 0;
        for(int i = 2; i<Prime.length; i++){
            if(Prime[i]){
                count++;
                for(int j = i+i; j<Prime.length;j++){             // Das Array wird nach Vielfachen von i durchsucht da sie keine Primzahlen sein können
                    if(j%i == 0){
                        Prime[j]=false;                           
                    }
                }
            }
        }
        System.out.println("Anzahl der Primzahlen: "+ count);
    }
}
