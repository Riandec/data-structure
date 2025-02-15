import java.util.Scanner;

public class TriangleSet {
    private int maxItem = 10;
    private int noItem = 0;
    private Triangle[] triangleArr;
    private String title = "";
    
    public TriangleSet(int max){
        this.maxItem = max;
        triangleArr = new Triangle[max];
    }
    
    public TriangleSet(Triangle tri){
        triangleArr = new Triangle[maxItem];
    }
    
    public TriangleSet(Triangle tri, int max){
        triangleArr = new Triangle[maxItem];
        this.maxItem = max;
    }
    
    public TriangleSet(TriangleSet triSet){
        add(triSet);
    }
    
    public TriangleSet(TriangleSet triSet, int max){
        this.maxItem = max;
        add(triSet);
    }
    
    public TriangleSet(String title){
        this.title = title;
        triangleArr = new Triangle[maxItem];
    }
    
    public TriangleSet(String title, int max){
        this.title = title;
        this.maxItem = max;
        triangleArr = new Triangle[maxItem];
    }
    
    public TriangleSet(){
        triangleArr = new Triangle[maxItem];
    }
    
    public void setTitle(String title){
        this.title = title;
    }
    
    public void add(Triangle tri){
        triangleArr[noItem] = tri;
        noItem++;
    }
    
    public void add(TriangleSet triSet){
        for(int i=0; i<noItem; i++){
            triangleArr[i] = triSet.getItem(i);
        }
        noItem = triSet.getSize();
    }
    
    public void merge(TriangleSet triSet){

    }
    
    public void removeTitle(String title){
        this.title = title;
    }
    
    public void removeItem(int no){
        noItem--;
        triangleArr[no] = triangleArr[noItem];
    }
    
    public void removeAll(){
        triangleArr = new Triangle[maxItem];
        noItem = 0;
    }
    
    public void inputData(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter TriangleSet's title [Current: " + title + ", - <NONE>, Return <Not Change> ] > ");
        String title = sc.nextLine();
        setTitle(title);
        System.out.println();
        
        for (int i=noItem; i<maxItem; i++) {
            System.out.print("[" + (i + 1) + "] " + "Enter triangle's title [Return <NONE>, - <END>] > ");
            String title_tri = sc.nextLine();
            if (title_tri.equals("-")) {
                break;
            }  
            System.out.print("Is it a equilateral triangle (y/n) ? ");
            char equal = sc.next().charAt(0);
            Triangle triangle;
        
            if(equal == 'y'){
                System.out.print("Enter side length > ");
                double side = sc.nextDouble();
                triangle = new Triangle(side,title);
                add(triangle);
            }else{
                System.out.print("Enter base length > ");
                double base = sc.nextDouble();
                System.out.print("Enter height > ");
                double height = sc.nextDouble();
                triangle = new Triangle(base,height,title);
                add(triangle);
            }
            sc.nextLine();
            System.out.println();
        }
    }
    
    public int getSize(){
        return noItem;
    }
    
    public int getMaxSize(){
        return maxItem;
    }
    
    public boolean isAllEquilateral(){
        boolean check = true;
        for(int i=0; i<noItem; i++){
            if(!triangleArr[i].isEquilateral()){
                check = false;
            }
        }
        return check;
    }
    
    public boolean isEmpty(){
        if(noItem == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull(){
        if(noItem == maxItem){
            return true;
        }else{
            return false;
        }
    }
    
    public double getSumArea(){
        double sum = 0;
        for(int i=0; i<noItem; i++){
            sum += triangleArr[i].getArea();
        }
        return sum;
    }
    
    public Triangle getItem(int no){
        return triangleArr[no];
    }
    
    public String getTitle(){
        return title;
    }
    
    public String toString(){
        String s = "";
        for(int i=0; i<noItem; i++){
            s += triangleArr[i];
        }
        return title+" "+maxItem+":"+noItem+"\n"+s;
    }
}
