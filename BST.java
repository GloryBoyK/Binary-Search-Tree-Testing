public class BST implements BSTInterface{
  //WRITE YOUR CODE HERE:
  //NOTE: this class won't compile until you override all the methods in the interface
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
    public void remove(int value){
      return;
    }
    
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
    //
  
}