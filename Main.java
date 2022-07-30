class Main {
  public static void main(String[] args) {
    BST bst1=new BST();
    bst1.insert(1);
    bst1.insert(2);
    bst1.insert(0);
    bst1.insert(5);
    System.out.println(bst1.inOrder());
  }
}