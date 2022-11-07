public class BST implements BSTInterface{
    private Node root;
    private int size=0;
    private class Node{
        int data=0;
        Node left=null;
        Node right=null;

        public Node(int d){
            this.data=d;
        }
    }
    @Override
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        if(this.size==0){
            return true;
        }
        else{
            return false;
        }
    }
    public void insert(int value){
        this.root=add(this.root, value);
        size++;
    }
    //adds a node to the list
    private Node add(Node node, int value){
        if(node==null){
            return new Node(value);
        }
        else if(value==node.data){
            throw new IllegalArgumentException("You already have this value in your tree. No duplicates are allowed.");
        }
        if(value<node.data){
            node.left=add(node.left, value);
        }
        else{
            node.right=add(node.right, value);
        }
        return node;
    }

    public boolean has(int value){
        return find(this.root, value);
    }
    // finds if the value is in the list
    public boolean find(Node node, int value){
        if(value==node.data){
            return true;
        }
        else if(value<node.data){
            return find(node.left, value);
        }
        else{
            return find(node.right, value);
        }
    }

    //removes a node from the list

    @Override
    public String toString(){
        return inOrder(this.root);
    }

    public String inOrder(){
        return inOrder(this.root);
    }

    private String inOrder(Node node){
        String nodes="";
        if(node==null){
            return nodes;
        }

        nodes+=inOrder(node.left);
        nodes+=node.data;
        nodes+=inOrder(node.right);

        return nodes;
    }
    //puts the list in least to greatest
    public String preOrder(){
        return preOrder(this.root);
    }

    private String preOrder(Node node){
        String nodes="";
        if(node==null){
            return nodes;
        }

        nodes+=node.data;
        nodes+=preOrder(node.left);
        nodes+=preOrder(node.right);

        return nodes;
    }

    public String postOrder(){
        return postOrder(this.root);
    }

    private String postOrder(Node node){
        String nodes="";
        if(node==null){
            return nodes;
        }

        nodes+=postOrder(node.left);
        nodes+=postOrder(node.right);
        nodes+=node.data;

        return nodes;
    }
    @Override
    public void clear(){
        this.root=deleteAll(this.root);
    }
    public Node deleteAll(Node node){
        if(node==null){
            return null;
        }

        node.left=deleteAll(node.left);
        node.right=deleteAll(node.right);
        size--;

        return null;
    }

    @Override
    public void remove(int num){
        this.root=delete(this.root, num);
        size--;
    }

    private Node delete(Node node, int num){
        if(node==null){
            throw new IllegalArgumentException ("This value doesn't exist in the tree.");
        }
        else if(node.data==num){
            return getReplacement(node);
        }
        if(node.data<num){
            node.right=delete(node.right, num);
        }
        else{
            node.left=delete(node.left, num);
        }
        return node;
    }

    private Node getReplacement(Node deletedNode){
        if(deletedNode.left==null && deletedNode.right==null){
            return null;
        }
        else if(deletedNode.left==null && deletedNode.right!=null){
            deletedNode.right=getReplacement(deletedNode.right);
        }
        else if(deletedNode.left!=null && deletedNode.right==null){
            deletedNode.left=getReplacement(deletedNode.left);
        }
        //next case: two children
        int predecessorValue=inOrderPredecessor(deletedNode).data;
        deletedNode.left=delete(deletedNode.left, predecessorValue);
        Node replacement=new Node(predecessorValue);
        replacement.right=deletedNode.right;
        replacement.left=deletedNode.left;

        return replacement;
    }
    private Node inOrderPredecessor(Node node){
        Node predecessor=node.left;
        while(predecessor.right!=null){
            predecessor=predecessor.right;
        }
        return predecessor;
    }
}
