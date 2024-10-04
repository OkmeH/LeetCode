public class AVLTree_Neu {
    private Note content;
    private AVLTree_Neu leftChild;
    private AVLTree_Neu rightChild;
    private int height;


    public AVLTree_Neu(int[] array){
       for(int i=0;i<array.length;i++){
           add(array[i]);
       }
       assert height()>=0:"FEHLER: Höhe ist kleiner 0";
       height=height();
      
    }
    public AVLTree_Neu(int a){
        content= new Note(a);
        leftChild=null;
        rightChild=null;
      
    }
    public AVLTree_Neu(){
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
           leftChild= new AVLTree_Neu();
           rightChild= new AVLTree_Neu();
           System.out.println("Fuege "+value+" in AVL-Baum ein.");
        }
        
       
           else if(content.getContent()>value){
                leftChild.add(value);
            }
            else{
                rightChild.add(value);
            }

             //Um den Unterschied der Höhen beider Teilbäume zu ermitteln
            assert getBalance()>-2 && getBalance()<2:"";rebalance();
            

    }

    public void rebalance() {

        updateHeight();

        //Um den Unterschied der Höhen beider Teilbäume zu ermitteln
        int balance = getBalance();
        if(balance > 1) {

            //Vorgabe für Ausgabe
           System.out.println("Linker Teilbaum von "+content+" hat Hoehe " +leftChild.height()+" Rechter Teilbaum hat Hoehe " +rightChild.height());

            if(rightChild.height() > leftChild.height()) {

                //Vorgabe für Ausgabe
                System.out.println("Fuehre Links-Rotaion durch");

                rotateLeft();

            }else{

                //Vorgabe für Ausgabe
                System.out.println("Fuehre Rechts-Links-Rotaion durch");

                rotateRight();
                rotateLeft();
             
            }

        }else if(balance < -1){

            //Vorgabe für AUsgabe
            System.out.println("Linker Teilbaum von "+content+" hat Hoehe " +leftChild.height()+" Rechter Teilbaum hat Hoehe " +rightChild.height());

            if (leftChild.leftChild.height() > leftChild.rightChild.height()){

                System.out.println("Fuehre Rechts-Rotaion durch");
                rotateRight();
            }else{
                System.out.println("Fuehre Links-Rechts-Rotaion durch");
                leftChild.rotateLeft();
                rotateRight();
            }
        }
    }
    private void rotateRight() {
      
        AVLTree_Neu y = new AVLTree_Neu(getContent());
        y.leftChild=leftChild;
        y.rightChild=rightChild;
        AVLTree_Neu x = leftChild;
        AVLTree_Neu z = rightChild;
        x.rightChild = y;
        y.leftChild = z;
        y.updateHeight();
        x.updateHeight();
        
    }



    private void rotateLeft() {
        AVLTree_Neu y = new AVLTree_Neu(getContent());
        y.leftChild=leftChild;
        y.rightChild=rightChild;
        AVLTree_Neu x = y.rightChild;
        AVLTree_Neu z = x.leftChild;
        x.leftChild = y;
        y.rightChild = z;
        y.updateHeight();
        x.updateHeight();
        
    }



    private void updateHeight(){
         
        height = height();
    }

    public int getBalance(){

        return (content == null) ? null : rightChild.height() - leftChild.height();
    }

    //Hilfsmethode
    public int getContent(){
        
        return content.getContent();
    }

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
