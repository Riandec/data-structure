
import java.util.Random;

class Tree {

    private Object info = null;
    private Tree left = null;
    private Tree right = null;

    public Tree(Object info, Tree left, Tree right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    public Tree(Object info) {
        this(info, null, null);
    }

    public Tree() {
        this(null, null, null);
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public Object getInfo() {
        return this.info;
    }

    public void setLeft(Tree node) {
        this.left = left;
    }

    public void setRight(Tree node) {
        this.right = right;
    }

    public Tree getLeft() {
        return this.left;
    }

    public Tree getRight() {
        return this.right;
    }

    public void insert(Object inf) {
        if (info == null) {
            info = inf;
        } else if ((int) inf < (int) info) {
            if (left != null) {
                left.insert(inf);
            } else {
                left = new Tree(inf);
            }
        } else {
            if (right != null) {
                right.insert(inf);
            } else {
                right = new Tree(inf);
            }
        }
    }

    public static void printPreOrder(Tree tree) {
        if (tree == null) {
            System.out.print(" - ");
            return;
        }
        System.out.print(" "+tree.getInfo() + " ");
        if(tree.getLeft() != null || tree.getRight() != null){
            System.out.print("[");
            printPreOrder(tree.getLeft());
            printPreOrder(tree.getRight());
            System.out.print("]");
        }
    }

    public static int getHeight(Tree tree) { // aka countNode
        if (tree == null) {
            return 0;
        }
        int countLeft = 1, countRight = 1;
        countLeft += getHeight(tree.getLeft());
        countRight += getHeight(tree.getRight());
        if (countLeft > countRight) {
            return countLeft;
        } else {
            return countRight;
        }
    }

    public Object search(Tree tree, Object find, String s) {
        if (tree != null) {
            if ((int) find < (int) tree.getInfo()) {
                s += "L";
                return search(tree.getLeft(), find, s);
            } else if ((int) find > (int) tree.getInfo()) {
                s += "R";
                return search(tree.getRight(), find, s);
            } else if ((int)find == (int)tree.getInfo()){
                System.out.print("("+s+")");
                System.out.println(" Found!");
                return tree;
            }
        } else if (tree == null || tree != find){
            System.out.print("("+s+")");
            System.out.println(" Not Found!");
            return null;
        }
        return null;
    }
}

public class BstTree {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Random ten = new Random();
        int r1 = ten.nextInt(10) + 10;
        System.out.println("--- Random numbers [" + r1 + "] ---");

        Random fifty = new Random();
        for (int i = 0; i < r1; i++) {
            int r2 = fifty.nextInt(50);
            System.out.print(r2 + " ");
            tree.insert(r2);
        }
        System.out.println("");
        System.out.println("--- Tree (Height=" + (tree.getHeight(tree)-1) + ")---");
        tree.printPreOrder(tree);
        System.out.println("");
        System.out.println("--- Search ---");

        String s = "";
        for(;;){
            Random find = new Random();
            int r3 = find.nextInt(50);
            System.out.print(r3 + ": "); 
            Object check = tree.search(tree, r3, s);
            if(check != null){
                break;
            }
        }
    }
}