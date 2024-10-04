

public class Interval implements Comparable<Interval>{
    private int start;
    private int end;
    public Interval(int a, int b){
        
        // [3-7] beschreibt das Gleiche Intervall wie [7-3]
        if(b<a){
            start=b;
            end=a;
        }else{
        start=a;
        end=b;
        }
    }
    public int getStart(){return start;}
    public int getEnd(){return end;}
    public String toString(){return "["+start+","+end+"]";}

     //überschriebende Object Methode
    public int compareTo(Interval other){
        if(other.getEnd()>getEnd()){return -1;}
        else if(other.getEnd()==getEnd()){return 0;}
        else{return 1;}
    }
}