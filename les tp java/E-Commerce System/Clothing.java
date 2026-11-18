public class Clothing extends product{
    private int size;
    public Clothing(String id, String name, int price ,int size ){
        super(id, name, price);
        this.size = size;
    }
    @Override
    public double calculatediscountedprice(double percentage){
        double discount = getprice()*(percentage / 100);
        discount = discount + 0.02;
        return getprice() - discount ;
    }
    @Override
    public String toString(){
        return super.toString() + "the size is =" +size;
    }
    
}