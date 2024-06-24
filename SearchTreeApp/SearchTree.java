public class SearchTree {
    private Note content;
    private SearchTree leftChild;
    private SearchTree rightChild;
    private int height;


    public SearchTree(int[] array){
       for(int i=0;i<array.length;i++){
           add(array[i]);
       }
       assert height()>=0:"FEHLER: Höhe ist kleiner 0";
       height=height();
      
    }
    public SearchTree(int a){
        content= new Note(a);
        leftChild=null;
        rightChild=null;
      
    }
    public SearchTree(){
        content = null;
        leftChild=null;
        rightChild=null;
    }
  


    //Methode zum berechnen der Höhe
    public int height(){
        if(isLeaf()){
            return 1;
        }else if(isEmpty()){
            return 0;
        }else{
            if(leftChild.height()>rightChild.height()){
                return leftChild.height()+1;
            }
            else{
                return rightChild.height()+1;
            }
        }
        
    }

    //Hilfsmethode
    public int getHeight(){
        return height;
    }

    //Hilfsmethode
    public boolean isLeaf(){
        return !isEmpty()&&leftChild==null&&rightChild==null;
    }

    //Hilfsmethode
    public boolean isEmpty(){
        return content==null;
    }

    public void add(int value){
        if(isEmpty()){
           content= new Note(value);
           leftChild= new SearchTree();
           rightChild= new SearchTree();
        }
        
       
           else if(content.getContent()>value){
                leftChild.add(value);
            }
            else{
                rightChild.add(value);
            }
        

    }

    //Hilfsmethode
    public int getContent(){
        
        return content.getContent();
    }

    //LeftChild-Node-RightChild
    public void inOrder(){
        if(isLeaf()){
            System.out.print(content.toString()+ " ");
        }
        else if(!isEmpty()){
           
            leftChild.inOrder();
            System.out.print(content.toString()+ " ");
            rightChild.inOrder();
        }
       
        
    }

    //Node-LeftChild-rightChild
    public void preOrder(){
        if(isLeaf()){
            System.out.print(content.toString());
        }
        else if(!isEmpty()){
            System.out.print(content.toString());
            leftChild.preOrder();
            rightChild.preOrder();
        }

    }

    //LeftChild-RightChild-Node
    public void postOrder(){
        if(isLeaf()){
            System.out.print(content+ " ");
        }
        else if(!isEmpty()){
           
            leftChild.postOrder();
            rightChild.postOrder();
            System.out.print(content+ " ");
        }


    }
    public  class Note{ 
       private int content;
     
       public Note(int a){
           content=a;
       }
       public int getContent(){return content;}
       public String toString(){return content+" ";}
    }
}
