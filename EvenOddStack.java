import java.util.Random;

class Stack {
    Node head = null;
    
    public void push(int newInfo){
        Node newNode = new Node(newInfo);
        newNode.setLink(head);
        head = newNode;
    }
    
    public int pop(){
        int num = head.getInfo();
        head = head.getLink();
        return num; 
    }
    
    public int peek(){
        return head.getInfo();
    }
    
    public int getInfo(int index){
        if(index == 0){
            return head.getInfo();
        }
        Node trav = head;
        for(int i=0; i<index; i++){
            trav = trav.getLink();
        }
        return trav.getInfo();
    }
    
    public int getSize(){
        Node trav = head;
        int count = 0;
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
    
    public boolean isEmpty(){
        if(getSize() == 0){
            return true;
        }
        return false;
    }
    
    public void printInfo(){
        for(int i=0; i<getSize(); i++){
            System.out.print(getInfo(i) +" ");
        }
        System.out.println();
    }
}

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

    public int getInfo() {
        return this.info;
    }

    public Node getLink() {
        return this.link;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setLink(Node link) {
        this.link = link;
    }

    public String toString() {
        return "" + this.info;
    }
}

public class EvenOddStack{
    public static void main(String[] args) {
        Stack even = new Stack();
        Stack odd = new Stack();
        
        Random ten = new Random();
        int r1 = ten.nextInt(10,20);
        System.out.println("--- Random Numbers [" +r1+"] ---");
        
        Random hundred = new Random();
        for(int i=0;i<r1;i++){
            int r2 = hundred.nextInt(1,100);
            System.out.print(r2 +" ");
            if(r2%2 == 0){
                even.push(r2);
            }else{
                odd.push(r2);
            }
        }
        System.out.println("");
        
        System.out.println("--- Even Stack [" +even.getSize()+ "] ---");
        even.printInfo();
        System.out.println("--- Odd Stack [" +odd.getSize()+ "] ---");
        odd.printInfo();
        for(;;){
            if(even.isEmpty()){
                System.out.println("===> Even is the winner!");
                break;
            }
            if(odd.isEmpty()){
                System.out.println("===> Odd is the winner!");
                break;
            }
            
            if(even.peek() > odd.peek()){
                even.pop();
            }else{
                odd.pop();
            }
        }
    }
}