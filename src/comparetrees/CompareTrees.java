package comparetrees;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Performs insertions and searches, using the same data set,on a binary search
 * tree and an AVL tree to compare the empirically compare the performance of
 * these operations on the trees.qq
 *
 * @author Jun Lin
 * @SEE AVLTree, AVLTreeException, BSTree, BSTreeException, WordStat
 * @since 03/15/2017
 */
public class CompareTrees {

    public static void title(int num, String tree, String fName, String order) {
        System.out.printf("Table %d:%s Tree [%s]\n", num, tree, fName);
        System.out.printf("%s Traversal\n", order);
        System.out.println("====================================");
        System.out.printf("%s%18s\n", "Word", "Frequency");
        System.out.println("------------------------------------");
    }

    /**
     * @param args the command line arguments
     * @throws AVLTreeException
     * @throws BSTreeException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws AVLTreeException, BSTreeException, IOException {
        AVLTree<WordStat> avl = new AVLTree();
        BSTree<WordStat> bst = new BSTree();
        Function<WordStat, PrintStream> print = x -> System.out.printf("%-16s %-10d\n", x.getWord(), x.getCount());
        try (Scanner file = new Scanner(new FileReader(args[0]))) {
            while (file.hasNext()) {
                WordStat w = new WordStat(file.next().toUpperCase(), 1);
                if (avl.inTree(w)) {
                    avl.retrieve(w);
                    w.updateCount(1);
                    avl.insert(w);
                    bst.insert(w);
                }
                avl.insert(w);
                bst.insert(w);
            }
        }

        String order[] = {"In-order", "Level-order"};
        int count = 0;
        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 2; j++) {
                if (j % 2 == 1) {
                    count++;
                    title(count, "Binary Search", args[0], order[i - 1]);
                    bst.traverse(print);
                    System.out.println("-----------------------------------");
                    System.out.println("");
                } else {
                    count++;
                    title(count, "AVL", args[0], order[i - 1]);
                    bst.traverse(print);
                    System.out.println("-----------------------------------");
                    System.out.println("");
                }
            }
        }
        System.out.println("Table 5 : Number of Nodes vs Height");
        System.out.printf("Using Data in [%s]\n", args[0]);
        System.out.println("===================================");
        System.out.printf("Tree %14s %10s\n", "# Nodes", "Height");
        System.out.println("-----------------------------------");
        System.out.printf("BST %9d %11d\n", bst.size(), bst.height());
        System.out.printf("AVL %9d %11d\n", avl.size(), avl.height());
        System.out.println("-----------------------------------");
        System.out.println();
       
        System.out.println("Table 6 : Total Number of Nodes Accessed");
        System.out.printf("Searching for all the Words in [%s]\n", args[0]);
        System.out.println("========================================");
        System.out.printf("Tree %21s\n", "# Nodes");
        System.out.println("----------------------------------------");
        int bstC=0;
        int avlC=0;
        try (Scanner file2 = new Scanner(new FileReader(args[0]))) {
            while(file2.hasNext()){
                WordStat w = new WordStat(file2.next().toUpperCase(), 1);
                bstC+= bst.depth(w)+1;
                avlC+= avl.depth(w)+1;
            }
        }
        System.out.printf("BST %16d\n",bstC);
        System.out.printf("AVL %16d\n",avlC);
        System.out.println("----------------------------------------");
        System.out.println();
    }

}
