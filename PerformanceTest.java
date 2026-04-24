public class PerformanceTest {

    public static void main(String[] args) {

        int[] sizes = {100, 500, 1000, 5000};
        int trials = 5;

        System.out.println("Input Size | Hash Table Search Avg(ns) | BST Search Avg(ns)");

        for (int size : sizes) {

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
                hashSearchTotal += (end - start);

                start = System.nanoTime();
                bst.search(target);
                end = System.nanoTime();
                bstSearchTotal += (end - start);
            }

            long hashAverage = hashSearchTotal / trials;
            long bstAverage = bstSearchTotal / trials;

            System.out.println(size + " | " + hashAverage + " | " + bstAverage);
        }
    }
}