//6174 is the Kaprekar Constant. This number is special as we always get this number 
//for any four digit number such that all digits of number are not same, i.e., all four digit numbers excluding (0000, 1111, …)
import java.util.Scanner;
import java.util.Arrays;
public class KaprekarsContant {

    static int steps=0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       String str = input.nextLine();
      input.close();
      int number = Integer.parseInt(str);
       solving(number);

      
    }
    static void solving(int num){

        int prev =0;
         solving(num,prev);
    }
    static void solving(int num, int prev){

        prev = num;

        //get the digits
        int[] digits = new int[4];
        for(int i=0;i<4;i++){
            digits[i] = num%10;
            num = num/10;
        }
        //sort in ascending order
        Arrays.sort(digits);
        int asc = 0;
        for(int i=0;i<4;i++){
            //number for math
            asc= asc*10 + digits[i];
        }
        //invert digits for descending number
        int desc = 0;
        for(int i=3;i>=0;i--){
            //second number for math
            desc = desc*10 +digits[i];
        }
        //because the descending number is always bigger
        int result = desc -asc;
        steps++;
        System.out.println(result);
        if(result==6174){
            System.out.println(" It took "+ steps+" steps for "+result);
        }
        else{
            solving(result, prev);
        }
    }
}