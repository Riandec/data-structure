/*
NO: xx
ID: 650710572
GROUP: x
CODE: xxxx
SEAT: xx
IP: N.N.N.N
*/

import java.util.Scanner;

public class RevQ {

    public static void inputQ(Queue q) {
        Scanner keyboard = new Scanner(System.in);
        int data;
        try{
            do {
                data = keyboard.nextInt();
                if(data>=0)
                    q.enQueue(data);
            } while(data>=0);
        } catch(Exception e) {}
    } 

    public static void showQ(Queue q) {
        try{
            int size = q.getSize();
            for(int i=0; i<size; i++){
                int de = q.deQueue();
                q.enQueue(de);
                System.out.print(de+" ");
            }
        }catch(Exception e){}
    }

    public static void reverseOddQ(Queue q) {
        try{
            Stack s = new Stack();
            int size = q.getSize();
            for(int i=0; i<size; i++){
                int de = q.deQueue();
                if(de%2 != 0){
                    s.push(de);
                }
                q.enQueue(de);
            }
            for(int i=0; i<size; i++){
                int de = q.deQueue();
                if(de%2 != 0){
                    q.enQueue(s.pop());
                }else{
                    q.enQueue(de);
                }
            }
        } catch(Exception e){}
    }
    
    public static void main(String[] args) {
        Queue q=new Queue();
        inputQ(q);
        reverseOddQ(q);
        showQ(q);
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

// 5 8 1 9 2 6 7 4 3 0 -99