
import java.util.Random;

class Value {

    private int arr[];
    private int count = 0;

    public Value(int n) {
        arr = new int[n];
    }

    public void randVal(int n) {
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int hundred = r.nextInt(101) + 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] == hundred) {
                    count++;
                }
            }
            arr[i] = hundred;
        }
    }

    public void printVal() {
        System.out.println("--- Random Numbers [" + (arr.length - count) + "] ---");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    System.out.print("!");
                    break;
                }
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public int[] getArr() {
        int[] a = new int[arr.length - count];
        int p = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean boo = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    boo = false;
                }
            }
            if (boo) {
                a[p] = arr[i];
                p++;
            }
        }
        return a;
    }
}

class Hash {

    private int arr[];
    private boolean check[];

    public Hash() {
        arr = new int[101];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -1;
        }
        check = new boolean[101];
    }

    public void put(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int key = a[i] % (2 * a.length);
            if (arr[key] != -1) {
                int p = key;
                while (arr[p] != -1) {
                    p++;
                }
                arr[p] = a[i];
                check[p] = true;
            } else {
                arr[key] = a[i];
            }
        }
    }

    public int getLength() {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                length++;
            }
        }
        return length;
    }

    public void search() {
        int count = 0;
        int total = 0;
        System.out.println("--- Finding Match ---");
        Random r = new Random();
        for (;;) {
            if (count == 3) {
                break;
            }
            boolean b = false;
            int hundred = r.nextInt(101) + 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 1) {
                    if (hundred + arr[i] == 100) {
                        b = true;
                        arr[i] = -1;
                        break;
                    }
                }
            }
            if (b) {
                count++;
            } else {
                System.out.print("!");
            }
            System.out.print(hundred + " ");
            total++;
        }
        System.out.println("");
        System.out.println("Total Finding: " + total);
    }

    public void printHash() {
        System.out.println("--- Hash Table [" + getLength() + "] ---");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                System.out.print(i + ":" + arr[i]);
                if (check[i] == true) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
}

public class Searching {

    public static void main(String[] args) {
        Random r1 = new Random();
        int twenty = r1.nextInt(11) + 10;
        //System.out.println("--- Random Numbers ["+twenty+"] ---");
        Value value = new Value(twenty);
        Hash hash = new Hash();
        value.randVal(twenty);
        value.printVal();
        hash.put(value.getArr());
        hash.printHash();
        hash.search();
        hash.printHash();
    }
}
