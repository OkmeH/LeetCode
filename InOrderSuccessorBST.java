 class InOrderSuccsessorBST{
    // A Node has data and holds pointer to left-, rughtChild + the parent
   static class Node{
       int data;
       Node leftChild;
       Node rightChild;
       Node Parent;
    }

   static Node findInOrderSuccessor(Node root, Node current){
        //Step 1:
        if(current.rightChild != null){
            return minNode(current.rightChild);
        }
        Node successor = null;

        //start from root and search for the successor
        while(root != null){
            if(current.data < root.data){
                successor = root;
                root = root.leftChild;
            }
            else if(current.data >root.data){
                root = root.rightChild;
            }
            else{
                break;
            }
        }
        return successor;
    }

    //function to hel finding the smallest Node
   static Node minNode(Node node){
        Node current = node;

        //loop down to find the leaf on the most left
        while(current.leftChild != null){
            current = current.leftChild;
        }
        return current;
    }
    //function for a new Node
   static Node newNode(int data){
        Node node = new Node();
        node.data=data;
        node.leftChild = null;
        node.rightChild = null;
        node.Parent = null;
        return node;
    }

    //inserts a new Node and returns a pointer to root, whitch the caller then uses
   static Node insert(Node node, int data){
        //if BST is empty return a new Node
        if(node ==null){
            return newNode(data);
        }
        else{
            Node temp;

            //search down the tree to find corrent place
            if(data <= node.data){
                temp = insert(node.leftChild, data);
                node.leftChild = temp;
                temp.Parent = node;
            }
            else{
                temp = insert(node.rightChild, data);
                node.rightChild = temp;
                temp.Parent= node;
            }
            //return unchanged node
            return node;
        }
    }
    
    public static void main(String[] args) {
        Node root =null;
        Node temp = null;
        Node succ = null;

        //building Tree from exercise
        root = insert(root,10);
        root = insert(root,5);
        root = insert(root,30);
        root = insert(root,22);
        root = insert(root,35);
        temp = root.rightChild.leftChild;

        //function call
        succ = findInOrderSuccessor(root, temp);
        if(succ != null){
            System.out.println(temp.data +" "+succ.data);
        }
        else{System.out.println("cant find succ");}
    }
}