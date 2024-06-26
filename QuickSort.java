public class QuickSort {
    
    public static void main(String[] args){
        try{
            if(args.length==0){
                System.out.println("FEHLER:Es muss eine ganzzahlige positive Zahl als Parameter angegeben werden!");return;
            }

            //Nur ein Argument darf übergeben werden
            if(args.length>1){
                throw new IllegalArgumentException();
            }

            //Ganze Zahl > 0
            if(!args[0].matches("\\d+")||Integer.parseInt(args[0])==0){
                throw new IllegalStateException();
            }
            int size= Integer.parseInt(args[0]);
            int[]arr = new int[size];
          

            //Befüllen des Array mit random Zahlen
            java.util.Random numberGenerator = new java.util.Random(100);
            for(int i = 0; i<arr.length;i++){

            int zufall = numberGenerator.nextInt(100);
            arr[i] = zufall;
            }
           
            long tStart, tEnd, msecs; 
           // print(arr);           
             tStart = System.currentTimeMillis(); 
             quickSort(arr);
             tEnd = System.currentTimeMillis(); 
             msecs = tEnd -tStart;
             System.out.println("");
           //  print(arr);

             //Fehler falls ARRAY nicht sortiert
              if(!isSorted(arr)){
                 System.out.println("Fehler: Array ist nicht sortiert!");
              }
             System.out.println("Das Sortieren von "+size+" Elementen dauerte "+msecs+"ms");
        }
        catch(IllegalArgumentException e){System.out.println("FEHLER: Es darf nur ein Argument übergeben werden!");}
        catch(IllegalStateException e){System.out.println("Der anzugebende Parameter muss eine positive ganze Zahl sein! größer 0!");}
    }
    public static void quickSort(int[] arr){
        quickSort(arr,0,arr.length-1);
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l<r){
            int i=l;
            int j=r;
            int pivot= ninther(arr,l,r);
            while(i<=j){
                while(arr[i]<pivot){
                    i=i+1;
                }
                while(arr[j]>pivot){
                    j=j-1;
                }
                if(i<=j){
                    int tmp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=tmp;
                    i=i+1;
                    j=j-1;
                }
            }
            
            //mache im linken Teilarray weiter
            quickSort(arr,l,j);

            //mache im rechten Teilarray weiter
            quickSort(arr,i,r);
        }

    }

    public static int med3(int[] arr, int l, int r){
        return median( arr[l], arr[(l+r)/2],arr[r]);
    }

    public static int ninther(int[] arr, int l, int r){
       int  m1=l+(r-l)*1/3;
       int  m2=l+(r-l)*2/3;
        return median(med3(arr,l,m1),med3(arr,m1,m2), med3(arr,m2,r));
    }

    //method was provided ahead
    public static int median(int a, int b, int c){
        if ((a < b && b < c) || (c < b && b < a)){
        return b;
        }

   
       else if ((b < a && a < c) || (c < a && a < b)){ 
         return a;
       } 

        else{
        return c;
        }
    }

    public static boolean isSorted(int[] array){
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]){return false;}

        }
        return true;
    }

    //testmethode
    public static void print(int[] arr){
       int j=0;
        for(int i=0;i<arr.length;i++){
            if(j==5){System.out.println(" ");j=0;}
            System.out.print(arr[i]+" ");j++;
        }
        System.out.println(" ");
    }


}


