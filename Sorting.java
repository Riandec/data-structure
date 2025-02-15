import java.util.Random;

class SArr{
    private int[] arr;
    
    public SArr(int n){
        arr = new int[n];
    }

    public void ranVal(int m){
        Random r = new Random();
        int minus = -m;
        for(int i=0; i<arr.length; i++){
            arr[i] = r.nextInt(m-minus+1)+minus; // (max-min+1)+min
        }
    }
    
    public void insertSort(){
        int i, j, tmp;
        for(i=1; i<arr.length; i++){
            tmp = arr[i];
            for(j=i; j>0 && arr[j-1] > tmp; j--){
                arr[j] = arr[j-1];
            }
            arr[j] = tmp;
        }
    }
    
    public void selectionSort(){
        int i, j, minIndex, tmp;
        int n = arr.length;
        for(i=0; i<n-1; i++){
            minIndex = i;
            for(j=i+1; j<n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }
    
    public void bubbleSort(){
        boolean swapped = true;
        int j=0;
        int tmp;
        while(swapped){
            swapped = false;
            j++;
            for(int i=0; i<arr.length-j; i++){
                if(arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }
    
    public void shellSort(){
        int j;
        for(int gap=arr.length/2; gap>0; gap/=2){
            for(int i=gap; i<arr.length; i++){
                int tmp = arr[i];
                for(j=i; j>=gap && tmp<(arr[j-gap]); j-= gap){
                    arr[j] = arr[j-gap];
                }
                arr[j] = tmp;
            }
        }
    }
    
    public void printVal(){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
}

public class Sorting {
    public static void main(String[] args) {
        Random r = new Random();
        int n = r.nextInt(11)+10; // 10-20
        int m = r.nextInt(41)+10; // 10-50
        SArr s1 = new SArr(n);
        s1.ranVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        s1.printVal();
        s1.insertSort();
        System.out.println("Insertion Sort :");
        s1.printVal();
        System.out.println("------------------------------");
        
        n = r.nextInt(11)+10;
        m = r.nextInt(41)+10;
        SArr s2 = new SArr(n);
        s2.ranVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        s2.printVal();
        s2.selectionSort();
        System.out.println("Selection Sort :");
        s2.printVal();
        System.out.println("------------------------------");
        
        n = r.nextInt(11)+10;
        m = r.nextInt(41)+10;
        SArr s3 = new SArr(n);
        s3.ranVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        s3.printVal();
        s3.bubbleSort();
        System.out.println("Bubble Sort :");
        s3.printVal();
        System.out.println("------------------------------");
        
        n = r.nextInt(11)+10;
        m = r.nextInt(41)+10;
        SArr s4 = new SArr(n);
        s4.ranVal(m);
        System.out.println("Random "+n+" numbers [-"+m+".."+m+"] :");
        s4.printVal();
        s4.shellSort();
        System.out.println("Shell Sort :");
        s4.printVal();
        System.out.println("------------------------------");
    }
}
