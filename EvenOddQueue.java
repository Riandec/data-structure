import java.util.Random;

class Node {

    private int info;
    private Node link;

    public Node(int info, Node link) {
        this.info = info;
        this.link = link;
    }

    public Node(int info) {
        this(info, null);
    }

    public Node() {
        this(0, null);
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public int getInfo() {
        return info;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public Node getLink() {
        return link;
    }
}

class Queue {

    private Node frontqueue = null, backqueue = null;
    private int amount = 0;

    public void enQueue(int newInfo) {
        Node newNode = new Node(newInfo);
        if (amount == 0) {
            frontqueue = newNode;
            backqueue = newNode;
            amount++;
        } else {
            backqueue.setLink(newNode);
            backqueue = newNode;
            amount++;
        }
    }

    public int deQueue() {
        int num = frontqueue.getInfo();
        frontqueue = frontqueue.getLink();
        if (frontqueue == null) {
            backqueue = null;
        }
        amount--;
        return num;
    }

    public int front() {
        return frontqueue.getInfo();
    }

    public int back() {
        return backqueue.getInfo();
    }

    public int getSize() {
        return amount;
    }

    public boolean isEmptyQueue() {
        return (amount == 0);
    }

    public String toString() {
        Node trav = frontqueue;
        String str = "";
        str = str + "[ ";
        for (int i = 0; i < amount; i++) {
            str = str + (trav.getInfo() + " ");
            trav = trav.getLink();
        }
        str = str + "]";
        return str;
    }
}

public class EvenOddQueue {

    public static void main(String[] args) {
        Queue even = new Queue();
        Queue odd = new Queue();

        Random ten = new Random();
        int r1 = ten.nextInt(10, 20);
        System.out.println("--- Random numbers [" + r1 + "] ---");

        Random hundred = new Random();
        for (int i = 0; i < r1; i++) {
            int r2 = hundred.nextInt(1, 100);
            System.out.print(r2 + " ");
            if (r2 % 2 == 0) {
                even.enQueue(r2);
            } else {
                odd.enQueue(r2);
            }
        }
        System.out.println("");
        System.out.println("--- Even Queue [" + even.getSize() + "] ---");
        System.out.println(even);
        System.out.println("--- Odd Queue [" + odd.getSize() + "] ---");
        System.out.println(odd);

        int countRound = 0, countEven = 0, countOdd = 0;
        for (;;) {
            if (even.front() > odd.front()) {
                even.deQueue();
                odd.enQueue(odd.front());
                odd.deQueue();
                countEven++;
            } else {
                odd.deQueue();
                even.enQueue(even.front());
                even.deQueue();
                countOdd++;
            }
            countRound++;

            if (even.isEmptyQueue()) {
                System.out.println("===> Winner is Even!");
                break;
            }
            if (odd.isEmptyQueue()) {
                System.out.println("===> Winner is Odd!");
                break;
            }
        }
        System.out.print("Round=" + countRound + ", Win=(E:" + countEven + ",O:" + countOdd + "), ");
        if (even.getSize() > 0) {
            System.out.println("Even Left=" + even.getSize());
        } else {
            System.out.println("Odd Left=" + odd.getSize());
        }
    }
}
