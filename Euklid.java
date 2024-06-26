public class Euklid{
    
    public static void main(String[] args){
        try{
            if(args.length != 2){                                       //Es wird geprüft ob zwei Parameter vorhanden sind
                throw new IllegalArgumentException();
            }
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);

            if(a>=0 &&b>=0){                                           //Es wird geprüft ob beide Parameter positiv sind da sonst kein ggT exsistiert
                System.out.println(euclid(a,b));
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalArgumentException e){                             //Mitteilung bei falscher Eingabe
            System.out.println("Zwei positive ganze Zahlen angeben!");
        }
    }
    
    public static int euclid(int a, int b){
        if(b==0){                                                      // sobald die Bedingung erfüllt ist, ist a der ggT
            return a;
        }
        else{
            return euclid(b,a%b);                                      
        }
    }
}