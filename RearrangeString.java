
import java.util.*;
 
class KeyComparator implements Comparator<Key> {
 
    //Overwriteing compare()method
    public int compare(Key k1, Key k2)
    {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}
 
class Key {
 
    int freq; //frequency of character
    char ch;
    Key(int val, char c)
    {
        freq = val;
        ch = c;
    }
}
 
class RearrangeString {
    static int MAX_CHAR = 26;
 
    // Function to rearrange character of a string so that no char repeat twice
    static void rearrangeString(String str)
    {
        int n = str.length();
 
        // Store frequencies of all characters in string, in arr
        int[] count = new int[MAX_CHAR];
 
        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;
 
        // Insert all chars with their freq into a pq
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0){
                pq.add(new Key(count[val], c));
            }
        }
 
        // 'str' that will store resultant value
        str = "";
 
        // work as the previous visited element, init with default val

        Key prev = new Key(-1, '#');
 
        // traverse queue
        while (pq.size() != 0) {
 
            // pop top element from queue and add it to string.
            Key k = pq.peek();
            pq.poll();
            str = str + k.ch;
 
            // If frequency of previous character is less than zero == useless
            if (prev.freq > 0){
                pq.add(prev);
            }
 
            // make current character as the previous 'char' decrease frequency by 'one'
            (k.freq)--;
            prev = k;
        }
 
        // If length of the resultant string
        // and original is not the same, the string is not valid
        if (n != str.length())
            System.out.println("No rearrangement possible!");
        else
            System.out.println(str);
    }
 
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
 
        
        rearrangeString(str);
    }
}