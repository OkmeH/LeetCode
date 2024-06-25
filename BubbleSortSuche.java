
public class BubbleSortSuche {

    public static void main(String[] args){
        try{
            if(args.length!=1){throw new IllegalStateException();}

            //prüfe, ist der Parameter eine Zahl
            if( args[0].matches("\\d+([.]{0,1}\\d+){0,1}")){
              float limit=Float.parseFloat(args[0]);
              limit=limit*1000;
             int arrSize=1000;
              
              search(arrSize,limit);
            }
            else{
                throw new IllegalArgumentException();
            }
        }
        catch(IllegalStateException e){
            System.out.println("FEHLER:Du must Einen Parameter angeben, welcher die Zeit angibt!");
        }
        catch(IllegalArgumentException e){
            System.out.println("FEHLER: Der Parameter muss eine positive Zahl sein!");
        }
    }
    //BUUBLESORT
    public static double bubbleSort(int[] arr){
        double secs;
        long tStart,tEnd;
        tStart = System.currentTimeMillis();

        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                int temp;
                if(arr[i]>arr[j]){
                   temp = arr[i];
                   arr[i]=arr[j];
                   arr[j]=temp;
                }
            }

        }
        tEnd = System.currentTimeMillis();
        secs=tEnd-tStart;
        return secs;

    }
    //MEthode zum suchen 
    public static void search(int size, float limit){
          int[] arr = new int[size];
         double  msecs=bubbleSort(arr);
         //ist man zu weit unterm limit, sucht man einfach mit einer erhöten Größe weiter
          if(limit-msecs>100){
              System.out.println("Size: "+size+", Time: "+msecs);
              search(size*2,limit);
          }
          //ist man über das limit gekommen und die Differenz ist >100ms, wird die tertiäre Suche gestartet
          else if(msecs>limit&& limit-msecs<-100){
            System.out.println("Size: "+size+", Time: "+msecs);

            //hier wird die tertiäre Suche gestartet
              deeperSearch(limit,size/2,size);
          }
          //Ansonsten befindet man sich im TolezanzIntervall von 100ms und kann abbrechen
          else{
              System.out.println("Size: "+size+", Time: "+msecs);
              return;
          }
    }
    public static void deeperSearch(float limit, int leftB,int rightB){
        int mid=(leftB+rightB/2);
        int[] arr = new int[mid];
        double  msecs=bubbleSort(arr);

         //Ist man noch nicht nah genug an limit sucht man in der größeren Hälfte weiter
         if(limit-msecs>100){
             System.out.println("Size: "+leftB+", Time: "+msecs);
             deeperSearch(limit,mid,rightB);
         }

         //Ist man noch überm limit sucht man in der kleineren Hälfte weiter
         else if(msecs>limit){
            System.out.println("Size: "+leftB+", Time: "+msecs);
             deeperSearch(limit,leftB,mid);
         }
         //Ansonsten ist man imj ToleranzIntervall von 100ms und kann abbrechen
         else{
             System.out.println("Size: "+leftB+", Time: "+msecs);
             return;
         }


    }
   
}