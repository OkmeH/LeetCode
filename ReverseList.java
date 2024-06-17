import java.util.*;
public class ReverseList {
static ArrayList<Integer> list;
static int l,r;

public static void reverse(List<Integer> lst, int i, int j){
while(i<j){
    int temp = lst.get(i);
    lst.set(i, lst.get(j));
    lst.set(j, temp);
    i++;j--;
  }
 }
 public static void main(String[] args) {
    
   list = new ArrayList<>();
   
   for (int i=0;i<=10;i++){
    list.add(i);
   }
   l=5;
   r=6;
    reverse(list, l, r);
    System.out.println(list.toString());

 }

}
