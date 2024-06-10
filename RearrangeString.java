
import java.util.*;
class KeyComarator implements Comparator<Key> {
    //overwrite compare() method
    public int compare(Key k1, Key k2){
        if(k1.freq < k2.freq){
            return 1;
        }else if(k1.freq > k2.freq){
            return -1;
        }
        else{
            return 0;
        }
    }
}
class Key{
    int freq;// stores the frequency of the char
    char ch;
    Key(int val, char c){
        freq = val;
        ch=c;
    }
}
class Rearrange{
    static int MAX_CHAR = 26;// there are 26 character in the normal alphabet

    //function to rearrange chars of a String so no char repeats twice
    static void rearrangeString(String str){
        int length = str.length();

        //Store freq of all chars, of the str, in an arr
        int[] count = new int[MAX_CHAR];

        for(int i=0;i<length;i++){
            count[str.charAt(i) - 'a']++;
        }
    
    //Insert all characters with their frequencies in the PQ
    PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComarator());
    for(char c ='a';c<='z';c++){
        int val = c -'a';
        if(count[val]>0){
            pq.add(new Key(count[val],c));
        }
        //store the resultant string
        String result ="";

        // prev Key, initail values as defult
        Key prev = new Key(-1, '#');

        //traverse pq
        while (pq.size()!=0){

            //pop top ele frome queue and ad it to the result string
            Key k = pq.peek();
            pq.poll();
            result = result + k.ch;

            //If frequency of prev char is less than 0 , its useless
            if(prev.freq >0){
                pq.add(prev);
            }

            // make current char as prev char and decrease freq by 'one'
            (k.freq)--;
            prev=k;
        }

        //if result length isnt equal to the original string, a rearrangement cant be found
        if(length != result.length()){
            System.out.println("No possible rearrangement!");
        }
        else{
            System.out.println(result);
        }
    }

}
public static void main(String args[]){
    Scanner input = new Scanner(System.in);

    String str= input.nextLine();
    input.close();
    //System.out.println(str);
    rearrangeString(str);

}
}