public class PerformanceTest {

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000};
        int trials = 5;

        System.out.println("INSERT OPERATION RESULTS");
        System.out.println("Input Size | Hash Table Insert Avg(ns) | BST Insert Avg(ns)");

        for (int s = 0; s < sizes.length; s++) {

            int size = sizes[s];

            long hashInsertTotal = 0;
            long bstInsertTotal = 0;

            for (int t = 0; t < trials; t++) {

                Contact[] contacts = new Contact[size];

                for (int i = 0; i < size; i++) {
                    contacts[i] = new Contact("Name" + i, "9" + i);
                }

                HashTableContactBook hash = new HashTableContactBook();

                long start = System.nanoTime();

                for (int i = 0; i < size; i++) {
                    hash.add(contacts[i]);
                }

                long end = System.nanoTime();
                hashInsertTotal = hashInsertTotal + (end - start);

                BSTContactBook bst = new BSTContactBook();

                start = System.nanoTime();

                for (int i = 0; i < size; i++) {
                    bst.add(contacts[i]);
                }

                end = System.nanoTime();
                bstInsertTotal = bstInsertTotal + (end - start);
            }

            long hashInsertAverage = hashInsertTotal / trials;
            long bstInsertAverage = bstInsertTotal / trials;

            System.out.println(size + " | " + hashInsertAverage + " | " + bstInsertAverage);
        }

        System.out.println();
        System.out.println("SEARCH OPERATION RESULTS");
        System.out.println("Input Size | Hash Table Search Avg(ns) | BST Search Avg(ns)");

        for (int s = 0; s < sizes.length; s++) {

            int size = sizes[s];

            long hashSearchTotal = 0;
            long bstSearchTotal = 0;

            for (int t = 0; t < trials; t++) {

                HashTableContactBook hash = new HashTableContactBook();
                BSTContactBook bst = new BSTContactBook();

                for (int i = 0; i < size; i++) {
                    Contact c = new Contact("Name" + i, "9" + i);
                    hash.add(c);
                    bst.add(c);
                }

                String target = "Name" + (size - 1);

                long start = System.nanoTime();
                hash.search(target);
                long end = System.nanoTime();
                hashSearchTotal = hashSearchTotal + (end - start);

                start = System.nanoTime();
                bst.search(target);
                end = System.nanoTime();
                bstSearchTotal = bstSearchTotal + (end - start);
            }

            long hashSearchAverage = hashSearchTotal / trials;
            long bstSearchAverage = bstSearchTotal / trials;

            System.out.println(size + " | " + hashSearchAverage + " | " + bstSearchAverage);
        }
    }
}