public class Main {
  public static void main(String[] args) {
      TriangleSet triSet = new TriangleSet("TriSetX");
      Triangle TriA = new Triangle();
      TriA.setBase(4);
      TriA.setHeight(6);
      TriA.setTitle("A");
      
      Triangle TriB = new Triangle(3,5,"B");
      Triangle TriC = new Triangle(TriA.getBase()+TriB.getHeight());
      
      /* if(TriA.isEquilateral() == true){
          System.out.println("TriA is Equilateral");
      }
      if(TriB.isEquilateral() == true){
          System.out.println("TriB is Equilateral");
      }
      if(TriC.isEquilateral() == true){
          System.out.println("TriC is Equilateral");
      }
      
      System.out.println(TriA);
      System.out.println(TriB);
      System.out.println(TriC); */ 
      
      triSet.add(TriA);
      triSet.add(TriB);
      triSet.add(TriC);
      triSet.inputData();
  }
}
