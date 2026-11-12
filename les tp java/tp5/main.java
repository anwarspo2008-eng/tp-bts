import java.util.Date;

public class main{
    public static void main(String[] args){
        // 1 -dtae et heur actuelle 
        Date d1 = new Date();
        System.out.println("Date actuelle : " +d1);
        
        // 2 - nombre de ms depuis 1970
        long ms = d1.getTime();
        System.out.println("ms depuis 1970 :" + ms);

        //3-print date a partie de ms
        Date d2 = new Date(ms);
        System.err.println("date reconstruit :" +d2);
        
    }
}