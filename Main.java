public class Main {

    public static void main(String[] args) {

        System.out.println("Contact Management System");
        System.out.println("By: Alzain Aljoury & Fatma\n");

        HashTableContactBook hash = new HashTableContactBook();
        BSTContactBook bst = new BSTContactBook();

        Contact c1 = new Contact("Sara", "9999");
        Contact c2 = new Contact("Ahmad", "8888");
        Contact c3 = new Contact("Mariam", "7777");

        hash.add(c1);
        hash.add(c2);
        hash.add(c3);

        bst.add(c1);
        bst.add(c2);
        bst.add(c3);


        System.out.println("Hash Table:");
        hash.display();

        System.out.println("\nBST (Sorted):");
        bst.display();


        System.out.println("\nSearch Sara:");
        System.out.println("Hash: " + hash.search("Sara"));
        System.out.println("BST: " + bst.search("Sara"));

        hash.delete("Ahmad");
        System.out.println("\nAfter deleting Ahmad (Hash):");
        hash.display();
    }
}