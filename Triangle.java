public class Triangle {
    private double base = 1;
    private double height = 1;
    private String title = "";
    private boolean equalSide = false;
    
    //constructor
    public Triangle(double base, double height, String title){
        this.base = base;
        this.height = height;
        this.title = title;
    }   
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    } 
    public Triangle(double side, String title){
        this.base = side;
        this.title = title;
        equalSide = true;
    }
    public Triangle(double side){
        this.base = side;
        equalSide = true;
    }
    public Triangle(){
        
    }
    
    //method set
    public void setBase(double base){
        this.base = base;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setSide(double side){
        this.base = side;
    }
    public void setTitle(String title){
        this.title = title;
    }
    
    //method get
    public double getBase(){
        return base;
    }
    public double getHeight(){
        return height;
    }
    public double getSide(){
        return base;
    }
    public String getTitle(){
        return title;
    }
    
    //method other
    public String toString(){
        if(equalSide == false){
            return title+"["+base+":"+height+"=>"+getArea()+"]";
        }else{
            return title+"["+base+"=>"+getArea()+"]";
        }
    }
    public boolean isEquilateral(){
        return equalSide;
    }
    public double getArea(){
        if(equalSide == false){
            return (1.0/2.0)*base*height;
        }else{
            return (Math.sqrt(3)/4)*(base*base); // parameter only (double side), no height
        }
    }
}
