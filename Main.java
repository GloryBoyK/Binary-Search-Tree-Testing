class Main {
    public static void main(String[] args) {
        BST bst1=new BST();
        bst1.insert(7);
        bst1.insert(10);
        bst1.insert(8);
        bst1.insert(5);
        bst1.insert(6);
        bst1.insert(2);
        bst1.insert(12);
        System.out.println(bst1.postOrder());
        System.out.println(bst1.size());
        bst1.clear();
        System.out.println(bst1.size());
        System.out.println(bst1.postOrder());
    }
}
