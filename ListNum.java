public class ListNum {

    private Node head = null;
    private int size;
    private Node sorted;

    public ListNum() {
        this.head = head;
    }

    public void addNode(int newInfo) {
        Node newNode = new Node(newInfo);
        newNode.setLink(head); // n.next = head.next
        head = newNode;
        size++;
    }
    
    public Node addNode(Node temp, int newInfo){
        Node newNode = new Node(newInfo);
        newNode.setLink(temp);
        temp = newNode;
        return temp;
    }

    public void addLast(int newInfo) {
        Node newNode = new Node(newInfo);
        Node temp = head;
        while (temp.getLink() != null) {
            temp = temp.getLink();
        }
        temp.setLink(newNode);
        size++;
    }

    public void addSort(int newInfo) {
        addNode(0);
        addNode(newInfo);
        Node temp = null;
        int s = size, i = 1;
        while(i <= s){
            i++;
            Node trav1 = head;
            int max = Integer.MIN_VALUE;
            for(;;){
                if(trav1 != null){
                    max = Math.max(max, trav1.getInfo());
                    trav1 = trav1.getLink();
                }else{
                    break;
                }
            }
            temp = addNode(temp, max);
            Node trav = head, prev = null;
            for(;;){
                boolean isfound = false;
                if(trav != null && trav.getInfo() == max){
                    if(trav == head){
                        removeFirst();
                        isfound = true;
                    }else if(trav.getLink() == null){
                        removeLast();
                        isfound = true;
                    }else{
                        Node next = trav.getLink();
                        prev.setLink(next);
                        isfound = true;
                    }
                }else if(trav != null){
                    prev = trav;
                    trav = trav.getLink();
                }
                if(isfound){
                    break;
                }
            }
        }
        Node T = temp.getLink();
        head = T;
        size = getSize();
    } 
    
    

    public void removeFirst() {
        if (head != null) {
            head = head.getLink();
            size--;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.getLink() == null) {
                head = null;
            } else {
                Node temp = head;
                while (temp.getLink().getLink() != null) {
                    temp = temp.getLink();
                }
                temp.setLink(null);
            }
            size--;
        }
    }

    public void removeNode(int number) {
        Node temp = head, prev = null;
        if (temp != null && temp.getInfo() == number) {
            head = temp.getLink();
            return;
        }
        while (temp != null && temp.getInfo() != number) {
            prev = temp;
            temp = temp.getLink();
        }
        if (temp == null) {
            return;
        }
        prev.setLink(temp.getLink());
        size--;
    }

    public int findInfo(int number) {
        Node temp = head;
        int found = 0, i = 0;
        while (temp != null) {
            i++;
            if (temp.getInfo() == number) {
                found++;
                break;
            }
            temp = temp.getLink();
        }
        if (found == 1) {
            return i;
        } else {
            return 0;
        }
    }

    public String toString() {
        Node trav = head;
        String str = "";
        while (trav != null) {
            str = str.concat(trav.toString());
            //str=str.concat(""+trav.getInfo());
            trav = trav.getLink();
            if (trav != null) {
                str = str.concat(" | ");
            }
        }
        return str;
    }

    public int getSize() {
        int count = 0;
        Node trav = head;
        for(;;){
            if(trav != null){
                count++;
                trav = trav.getLink();
            }else{
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ListNum listNum1 = new ListNum();
        System.out.println("1. find size");
        listNum1.addNode(10);
        listNum1.addNode(20);
        listNum1.addNode(30);
        System.out.println(listNum1);
        System.out.println("size = " +listNum1.getSize());
        System.out.println("");
        
        System.out.println("2. add last node");
        System.out.println("before : " +listNum1);
        listNum1.addLast(40);
        listNum1.addLast(50);
        listNum1.addLast(60);
        System.out.println("after : " +listNum1);
//        System.out.println("size = " +listNum1.getSize());
        System.out.println("");

        System.out.println("3. add node by sort");
        System.out.println("before : " +listNum1);
        listNum1.addSort(55);
        System.out.println("after : " +listNum1);
//        System.out.println("size = " +listNum1.getSize());
        System.out.println("");

        System.out.println("4. remove first node");
        System.out.println("before : " +listNum1);
        listNum1.removeFirst();
        System.out.println("after : " +listNum1);
        System.out.println("");
        
        System.out.println("5. remove last node");
        System.out.println("before : " +listNum1);
        listNum1.removeLast();
        System.out.println("after : " +listNum1);
        System.out.println("");

        System.out.println("6. find number in linked list");
        System.out.println(listNum1);
        System.out.println("found 40 at index = " +listNum1.findInfo(40));
        System.out.println("");
        
        System.out.println("7. remove number in linked list");
        System.out.println("remove 30");
        System.out.println("before : " +listNum1);
        listNum1.removeNode(30);
        System.out.println("after : " +listNum1);
//        System.out.println("size = " +listNum1.getSize());
        System.out.println("");
    }
}

// finished 1, 2, 3, 4, 5, 6, 7 of total 7
