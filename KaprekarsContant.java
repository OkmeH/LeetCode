import java.util.Scanner;
import java.util.Arrays;
public class KaprekarsContant {

    static int steps=0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       String number = input.nextLine();
      input.close();
      char[] digits = number.toCharArray();
      solving(digits);

      
    }
    static void solving(char[] val){  
        Integer zahl =0;
        char[] temp = val;
        Arrays.sort(temp);
        System.out.println(Arrays.toString(temp));
        char[] temp2 = temp;
        for(int i=0;i<4;i++){
            temp2[i] = temp[3-i];
        }
        System.out.println(Arrays.toString(temp2));
      String num1 = String.valueOf(temp);
       int val1 = Integer.parseInt(num1);
       System.out.println(val1);
       
       String num2 =String.valueOf(temp2);
       int val2 = Integer.parseInt(num2);
       System.out.println(val2);

        zahl = val2 -val1;
        System.out.println(zahl);
        steps++; 
        if(zahl!=6174){
           String Zahl = zahl.toString();
            solving(Zahl.toCharArray());

        }else{
            System.out.println("It took "+steps+" steps to get there");
        }
      
        
            
    }
    
}
