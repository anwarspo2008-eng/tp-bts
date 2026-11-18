public class Electronics extends product {
    
    private int warrantyMonths;

    public Electronics(String id, String name, int price, int warrantyMonths) {
        super(id, name, price); 
        this.warrantyMonths = warrantyMonths;
    }
    @Override
    public double calculatediscountedprice(double percentage)
    {
            double discount = getprice()*(percentage /100);
            return getprice() - discount; 
    }

    @Override
    public String toString(){
        return super.toString() + " [Warranty=" + warrantyMonths + " months]";
    }
    
}
