import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class store {
    public static void main(String[] args)
    {
        Electronics e1 = new Electronics("p123" , "zbaga pro" , 12000 , 12);
        Electronics e2 = new Electronics("p132" , "s3idi pro" , 13000 , 12);
        Clothing c1 = new Clothing("p159", "calsson", 120, 52);
        Clothing c2 = new Clothing("p155", "jacket", 150, 50);
        Electronics test = new Electronics("p123" , "18 pro" , 12000 , 12);

        System.out.println(e1.equals(test));
        List<product> inventory = new ArrayList<>();    
        inventory.add(e1);
        inventory.add(e2);
        inventory.add(c1);
        inventory.add(c2);

        Collections.sort(inventory);
        for(product item : inventory){
            System.out.println(item);
        }
        for(product item : inventory){
            item.calculatediscountedprice(10);
        }
        


    }
}